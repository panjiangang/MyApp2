package panjiangang.bwie.com.myapp2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import panjiangang.bwie.com.myapp2.R;
import panjiangang.bwie.com.myapp2.bean.CaiPuBean;


public class SearchShowActivity extends AppCompatActivity {

    @BindView(R.id.searchshow_imgbtn_return)
    ImageButton searchshowImgbtnReturn;
    @BindView(R.id.searchshow_edit_sousuo)
    EditText searchshowEditSousuo;
    @BindView(R.id.searchshow_btn_sousuo)
    Button searchshowBtnSousuo;
    @BindView(R.id.searchshow_xRecyclerView)
    XRecyclerView searchshowXRecyclerView;
    String menu;
    private Gson gson = new Gson();
    private int num = 10;
    String path;
    private List<CaiPuBean.ResultBean.DataBean> list = new ArrayList<>();
    boolean ss = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_show);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        menu = intent.getStringExtra("name");
        searchshowEditSousuo.setText(menu);
        Toast.makeText(SearchShowActivity.this, "" + menu, Toast.LENGTH_SHORT).show();
        LinearLayoutManager manager = new LinearLayoutManager(SearchShowActivity.this);
        searchshowXRecyclerView.setLayoutManager(manager);
        try {
            //http://apis.juhe.cn/cook/query?key=c89083f1fc9b411484fd290386335510&menu=%E8%82%89&rn=10&pn=1
            path = "http://apis.juhe.cn/cook/query?key=c89083f1fc9b411484fd290386335510&menu=" + URLEncoder.encode(menu, "utf-8") + "&rn=" + num + "&pn=1";
            if (menu.equals("")) {
                Toast.makeText(SearchShowActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
            } else {
                new My().execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class My extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            String string = "";
            try {
                URL url = new URL(path);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                int code = con.getResponseCode();
                if (code == 200) {
                    InputStream is = con.getInputStream();
                    byte[] b = new byte[1024];
                    int length = 0;
                    while ((length = is.read(b)) != -1) {
                        String str = new String(b, 0, length);
                        string += str;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return string;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            CaiPuBean fromJson = gson.fromJson((String) o, CaiPuBean.class);
            list = fromJson.getResult().getData();
            final MyAdapter showAdapter = new MyAdapter();
            searchshowXRecyclerView.setAdapter(showAdapter);
            searchshowXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    showAdapter.notifyDataSetChanged();
                    searchshowXRecyclerView.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    num++;
                    new My().execute();
                    Toast.makeText(SearchShowActivity.this, "num = " + num, Toast.LENGTH_SHORT).show();
                    showAdapter.notifyDataSetChanged();
                    searchshowXRecyclerView.loadMoreComplete();
                }
            });
        }
    }


    @OnClick({R.id.searchshow_imgbtn_return, R.id.searchshow_btn_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.searchshow_imgbtn_return:
                Intent intent1 = new Intent(SearchShowActivity.this, SearchActivity.class);
                startActivity(intent1);
                break;
            case R.id.searchshow_btn_sousuo:
                String s = searchshowEditSousuo.getText().toString().trim();
                isGB2312(s);
                if (ss) {
                    Intent intent = new Intent(SearchShowActivity.this, SearchShowActivity.class);
                    intent.putExtra("name", s);
                    startActivity(intent);
                }
                break;
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    SearchShowActivity.this).inflate(R.layout.item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.te.setText(list.get(position).getTitle());
            holder.te1.setText(list.get(position).getTags());

            Uri uri = Uri.parse(list.get(position).getAlbums().get(0));
//            RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
//            roundingParams.setRoundAsCircle(true);
//            holder.img.getHierarchy().setRoundingParams(roundingParams);
            holder.img.setImageURI(uri);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView te, te1;
            SimpleDraweeView img;

            public MyViewHolder(View itemView) {
                super(itemView);
                te = itemView.findViewById(R.id.item_te);
                te1 = itemView.findViewById(R.id.item_te1);
                img = itemView.findViewById(R.id.item_img);
            }
        }
    }

    public Boolean isGB2312(String str) {
        for (int i = 0; i < str.length(); i++) {
            String bb = str.substring(i, i + 1);
// 生成一个Pattern,同时编译一个正则表达式,其中的u4E00("一"的unicode编码)-\u9FA5("龥"的unicode编码)
            boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);
            if (cc == false) {
                Toast.makeText(SearchShowActivity.this, "请输入中文", Toast.LENGTH_SHORT).show();
                return cc;
            } else {
                ss = true;
            }
        }
        return true;

    }
}

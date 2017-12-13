package panjiangang.bwie.com.myapp2.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import panjiangang.bwie.com.myapp2.IInterface;
import panjiangang.bwie.com.myapp2.MainActivity;
import panjiangang.bwie.com.myapp2.R;
import panjiangang.bwie.com.myapp2.bean.Bean;
import panjiangang.bwie.com.myapp2.bean.ClassifyBean;
import panjiangang.bwie.com.myapp2.bean.ClassifyClassifyBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by lenovo on 2017/12/02.
 */

public class Classify extends Fragment {

    ListView lv;
    ListView lv1;
    private List<ClassifyBean.DataBean.CategoryBean.ChildrenBean> list = new ArrayList<>();
    private List<ClassifyClassifyBean.DataBean> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_classify, null);
        lv = view.findViewById(R.id.classify_lv);
        lv1 = view.findViewById(R.id.classify_lv1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://m.yunifang.com")
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IInterface iInterface = retrofit.create(IInterface.class);
        Call<ClassifyBean> call = iInterface.get3();

        call.enqueue(new Callback<ClassifyBean>() {
            @Override
            public void onResponse(Call<ClassifyBean> call, Response<ClassifyBean> response) {
                ClassifyBean bean = response.body();
                System.out.println(Thread.currentThread().getName());
                list = bean.getData().getCategory().get(1).getChildren();
                System.out.println(list.toString());

                MyAdapter adapter = new MyAdapter();
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String id1 = list.get(position).getId();
                        //Toast.makeText(getActivity(), ""+id1, Toast.LENGTH_SHORT).show();
                        if (id1.equals("38")) {
                            Toast.makeText(getActivity(), "该类暂时没有商品", Toast.LENGTH_SHORT).show();
                        } else {
                            gethttp(id1);
                        }

                    }
                });
            }

            @Override
            public void onFailure(Call<ClassifyBean> call, Throwable t) {
                System.out.println("失败");
            }
        });
    }

    private void gethttp(String s) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://m.yunifang.com")
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IInterface iInterface = retrofit.create(IInterface.class);
        //http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=9
        Call<ClassifyClassifyBean> call = iInterface.get4(91873, "68301f6ea0d6adcc0fee63bd21815d69", s);
        call.enqueue(new Callback<ClassifyClassifyBean>() {
            @Override
            public void onResponse(Call<ClassifyClassifyBean> call, Response<ClassifyClassifyBean> response) {
                ClassifyClassifyBean bean = response.body();
                System.out.println("data:" + Thread.currentThread().getName());
//                if (bean.getData().get(0)==null) {
//                    Toast.makeText(getActivity(), "该条目没有数据", Toast.LENGTH_SHORT).show();
//                } else {
                data = bean.getData();
                System.out.println("data:" + data.toString());
                MyAdapter1 adapter = new MyAdapter1();
                lv1.setAdapter(adapter);
//                }

            }

            @Override
            public void onFailure(Call<ClassifyClassifyBean> call, Throwable t) {
                System.out.println("失败");
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Hand hand;
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.layout_text, null);
                hand = new Hand();
                hand.te = convertView.findViewById(R.id.text_te);
                convertView.setTag(hand);
            } else {
                hand = (Hand) convertView.getTag();
            }

            hand.te.setText(list.get(position).getCat_name());
            return convertView;
        }
    }

    class Hand {
        TextView te;
    }

    class MyAdapter1 extends BaseAdapter {

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Hand1 hand;
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.item, null);
                hand = new Hand1();
                hand.te = convertView.findViewById(R.id.item_te);
                hand.te1 = convertView.findViewById(R.id.item_te1);
                hand.img = convertView.findViewById(R.id.item_img);
                convertView.setTag(hand);
            } else {
                hand = (Hand1) convertView.getTag();
            }

            hand.te.setText(data.get(position).getGoods_name());
            hand.te1.setText(data.get(position).getEfficacy());

            Uri uri = Uri.parse(data.get(position).getGoods_img());
            hand.img.setImageURI(uri);
            return convertView;
        }
    }

    class Hand1 {
        TextView te, te1;
        SimpleDraweeView img;
    }

}






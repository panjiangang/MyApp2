package panjiangang.bwie.com.myapp2.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import panjiangang.bwie.com.myapp2.R;
import panjiangang.bwie.com.myapp2.activity.WebActivity;
import panjiangang.bwie.com.myapp2.bean.Bean;

/**
 * @author ddy
 */
public class MyAdapter extends RecyclerView.Adapter {

    private List<Bean.DataBean.SubjectsBean> subjects;
    Context context;

    public MyAdapter(List<Bean.DataBean.SubjectsBean> subjects, Context context) {
        this.subjects = subjects;
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_lunbo, null);
            return new ViewHolder(view);

        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_huodong, null);
            return new ViewHolder1(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            List<String> images = new ArrayList<>();
            for (int i = 0; i < subjects.size(); i++) {
                images.add(subjects.get(i).getImage());
            }
            ((ViewHolder) holder).banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    //用fresco加载图片简单用法，记得要写下面的createImageView方法
                    Uri uri = Uri.parse((String) path);
                    imageView.setImageURI(uri);
                }

                //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
                @Override
                public ImageView createImageView(Context context) {
                    //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
                    return new SimpleDraweeView(context);
                }
            }).setImages(images).start();

        } else if (holder instanceof ViewHolder1) {
            ((ViewHolder1) holder).hdSdv.setImageURI(subjects.get(position - 1).getImage());

            List<Bean.DataBean.SubjectsBean.GoodsListBeanX> goodsList = subjects.get(position - 1).getGoodsList();
            ((ViewHolder1) holder).itemRv.setLayoutManager(new GridLayoutManager(holder.itemView.getContext(), 2));
            ((ViewHolder1) holder).itemRv.setAdapter(new RvAdapter(goodsList));
        }
    }

    @Override
    public int getItemCount() {
        return subjects.size() + 1;
    }


    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.hd_sdv)
        SimpleDraweeView hdSdv;
        @BindView(R.id.item_rv)
        RecyclerView itemRv;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;
        @BindView(R.id.read)
        Button read;
        @BindView(R.id.music)
        Button music;
        @BindView(R.id.movie)
        Button movie;
        @BindView(R.id.newlist)
        Button newlist;
        @BindView(R.id.yule)
        Button yule;
        @BindView(R.id.meishi)
        Button meishi;
        @BindView(R.id.lvyou)
        Button lvyou;
        @BindView(R.id.baidu)
        Button baidu;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            read.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳到阅读页面
                    Intent read = new Intent(context, WebActivity.class);
                    read.putExtra("url", "https://yuedu.baidu.com/");
                    context.startActivity(read);
                }
            });
            music.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳到音乐页面
                    Intent music = new Intent(context, WebActivity.class);
                    music.putExtra("url", "http://music.baidu.com/tag/%E6%B5%81%E8%A1%8C");
                    context.startActivity(music);
                }
            });
            movie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳到电影页面
                    Intent movie = new Intent(context, WebActivity.class);
                    movie.putExtra("url", "http://v.baidu.com/movie/list/filter-true+order-hot+pn-1+channel-movie");
                    context.startActivity(movie);
                }
            });
            newlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newlist = new Intent(context, WebActivity.class);
                    newlist.putExtra("url", "http://jian.news.baidu.com/");
                    context.startActivity(newlist);
                }
            });
            yule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent yule = new Intent(context, WebActivity.class);
                    yule.putExtra("url", "http://top.baidu.com/buzz?b=618&c=9");
                    context.startActivity(yule);
                }
            });
            meishi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent meishi = new Intent(context, WebActivity.class);
                    meishi.putExtra("url", "http://jingyan.baidu.com/meishi/");
                    context.startActivity(meishi);
                }
            });
            lvyou.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent lvyou = new Intent(context, WebActivity.class);
                    lvyou.putExtra("url", "https://lvyou.baidu.com/luguhu/local/");
                    context.startActivity(lvyou);
                }
            });
            baidu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent baidu = new Intent(context, WebActivity.class);
                    baidu.putExtra("url", "https://www.baidu.com/");
                    context.startActivity(baidu);
                }
            });
        }
    }
}

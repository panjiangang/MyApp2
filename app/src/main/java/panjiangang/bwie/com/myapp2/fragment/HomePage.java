package panjiangang.bwie.com.myapp2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.List;

import panjiangang.bwie.com.myapp2.R;
import panjiangang.bwie.com.myapp2.activity.SearchActivity;
import panjiangang.bwie.com.myapp2.bean.Bean;
import panjiangang.bwie.com.myapp2.presenter.MainMyPresenter;
import panjiangang.bwie.com.myapp2.view.MyAdapter;


public class HomePage extends Fragment implements MainMyPresenter.MVInterface {

    XRecyclerView xRecyclerView;
    RecyclerView rv;
    private MainMyPresenter mainPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_homepage, null);
        xRecyclerView = view.findViewById(R.id.xRecyclerView);
        ImageView camera = view.findViewById(R.id.homepage_iv_camera);
        ImageView shaoyishao = view.findViewById(R.id.homepage_iv_shaoyishao);
        EditText search = view.findViewById(R.id.homepage_bt_search);
        mainPresenter = new MainMyPresenter(this);
        mainPresenter.getHttp(true);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                getActivity().startActivityForResult(intent, 1);
            }
        });

        shaoyishao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
            }
        });
        return view;
    }

    @Override
    public void getHttpHC(List<Bean.DataBean.SubjectsBean> subjects) {
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        xRecyclerView.setAdapter(new MyAdapter(subjects, getActivity()));
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainPresenter.destroy();
        mainPresenter = null;
    }
}

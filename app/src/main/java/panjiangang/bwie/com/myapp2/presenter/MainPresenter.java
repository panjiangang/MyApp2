package panjiangang.bwie.com.myapp2.presenter;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import panjiangang.bwie.com.myapp2.bean.liebiaoBean;
import panjiangang.bwie.com.myapp2.model.MainModle;


public class MainPresenter implements MainModle.Modleinterface {

    private final MainModle mainModle;
    Preinterface preinterface;

    public MainPresenter(Preinterface preinterface) {
        this.preinterface = preinterface;
        mainModle = new MainModle(this);
    }

    public void setstatus(String i) {
        if (i != null) {
            mainModle.setstatu(i);
        } else {
            mainModle.get();
        }
    }

    public void setdingdan(int orderid, int status) {
        mainModle.setdd(orderid, status);
    }


    public void getstatus(TextView status, Button dingdan, int i) {
        if (i == 0) {
            preinterface.status0(status, dingdan);
        } else if (i == 1) {
            preinterface.status1(status, dingdan);
        } else if (i == 2) {
            preinterface.status2(status, dingdan);
        }
    }

    public void setpage(boolean b) {
        if (b) {
            mainModle.fresh();
        } else {
            mainModle.load();
        }
    }

    //huidiao
    @Override
    public void gethc(List<liebiaoBean.DataBean> data) {
        preinterface.gethcc(data);
    }

    @Override
    public void ddhc(String msg) {
        preinterface.dingdanhc(msg);
    }

    public interface Preinterface {
        void gethcc(List<liebiaoBean.DataBean> data);

        void status0(TextView status, Button dingdan);

        void status1(TextView status, Button dingdan);

        void status2(TextView status, Button dingdan);

        void dingdanhc(String msg);
    }
}

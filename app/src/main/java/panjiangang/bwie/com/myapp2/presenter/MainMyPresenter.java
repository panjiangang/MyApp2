package panjiangang.bwie.com.myapp2.presenter;



import java.util.List;

import panjiangang.bwie.com.myapp2.bean.Bean;
import panjiangang.bwie.com.myapp2.model.MainMyModel;

/**
 * @author ddy
 */
public class MainMyPresenter implements MainMyModel.MPInterface {

    private MVInterface mvInterface;
    private MainMyModel mainModel;

    public MainMyPresenter(MVInterface mvInterface) {
        this.mvInterface = mvInterface;
        mainModel = new MainMyModel(this);
    }

    public void getHttp(boolean b) {
        if (b){
            mainModel.getReterfit();
        }else {
            mainModel.getOkHttp();
        }
    }

    @Override
    public void getHC(List<Bean.DataBean.SubjectsBean> subjects) {
        mvInterface.getHttpHC(subjects);
    }

    public void destroy() {
        mvInterface = null;
        mainModel = null;
    }

    public interface MVInterface {

        void getHttpHC(List<Bean.DataBean.SubjectsBean> subjects);
    }
}

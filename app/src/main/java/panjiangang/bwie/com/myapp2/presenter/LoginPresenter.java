package panjiangang.bwie.com.myapp2.presenter;

import panjiangang.bwie.com.myapp2.model.LoginModel;

/**
 * Created by lenovo on 2017/11/07.
 */

public class LoginPresenter {

    MainPresenter mainPresenter;
    private LoginModel loginModel;

    public LoginPresenter(MainPresenter mainPresenter){
        this.mainPresenter = mainPresenter;
        loginModel = new LoginModel();
    }

    public void loginClick(String wz,String phone,String password){
        loginModel.Login(wz,phone,password, new LoginModel.ModelCallPresenter() {
            @Override
            public void success(String msg) {
                mainPresenter.lClick(msg);
            }
        });
    }

    public void regClick(){
        mainPresenter.rClick();
    }

    public interface MainPresenter{
        void lClick(String msg);
        void rClick();
    }
}

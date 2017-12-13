package panjiangang.bwie.com.myapp2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import panjiangang.bwie.com.myapp2.R;
import panjiangang.bwie.com.myapp2.activity.LoginSuccessActivity;
import panjiangang.bwie.com.myapp2.presenter.LoginPresenter;
import panjiangang.bwie.com.myapp2.view.RegActivity;


/**
 * Created by lenovo on 2017/12/02.
 */

public class Person extends Fragment implements LoginPresenter.MainPresenter {

    private Tencent mTencent;
    private String APP_ID = "222222";
    private IUiListener loginListener;
    private String SCOPE = "all";
    private Button login, QQlogin, register;
    private EditText username, password;
    private LoginPresenter loginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_person, null);
        login = view.findViewById(R.id.login);
        QQlogin = view.findViewById(R.id.QQlogin);
        register = view.findViewById(R.id.register);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        register = view.findViewById(R.id.register);
        loginPresenter = new LoginPresenter(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.loginClick("login", username.getText().toString(), password.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.regClick();
            }
        });

        QQlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initQqLogin();
                mTencent.login(getActivity(), SCOPE, loginListener);
            }
        });

    }

    @Override
    public void lClick(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        if (msg.equals("登录成功")) {
            Intent intent = new Intent(getActivity(), LoginSuccessActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void rClick() {
        startActivity(new Intent(getActivity(), RegActivity.class));
    }

    //初始化QQ登录分享的需要的资源
    private void initQqLogin() {
        mTencent = Tencent.createInstance(APP_ID, getActivity());
        //创建QQ登录回调接口
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后回调该方法
                Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
                Log.e("LoginError:", uiError.toString());
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                Toast.makeText(getActivity(), "取消登录", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//  官方文档上面的是错误的
//        if(requestCode == Constants.REQUEST_API) {
//            if(resultCode == Constants.RESULT_LOGIN) {
//                mTencent.handleLoginData(data, loginListener);
//            }
//  resultCode 是log出来的，官方文档里给的那个属性是没有的

        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
            }
        }
    }

}


package panjiangang.bwie.com.myapp2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import panjiangang.bwie.com.myapp2.R;
import panjiangang.bwie.com.myapp2.activity.Main2Activity;
import panjiangang.bwie.com.myapp2.fragment.Person;
import panjiangang.bwie.com.myapp2.presenter.LoginPresenter;


/**
 * Created by lenovo on 2017/11/07.
 */

public class RegActivity extends AppCompatActivity implements LoginPresenter.MainPresenter{

    private EditText rphone,rpassword;
    private Button lreg;
    private LoginPresenter loginPresenter;
    private EditText phone,password;
    private Button login,reg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        rphone = (EditText) findViewById(R.id.rphone);
        rpassword = (EditText) findViewById(R.id.rpassword);
        lreg = (Button) findViewById(R.id.lreg);
        loginPresenter = new LoginPresenter(this);

        lreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.loginClick("reg", rphone.getText().toString(), rpassword.getText().toString());
            }
        });
    }

    @Override
    public void lClick(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (msg.equals("注册成功")){
            Intent intent = new Intent(this, Main2Activity.class);
            boolean a=true;
            intent.putExtra("reg",a);
            startActivity(intent);
        }
    }

    @Override
    public void rClick() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

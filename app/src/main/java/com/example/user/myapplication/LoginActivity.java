package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    EditText uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button login=(Button) findViewById(R.id.button1);
            uname= (EditText)findViewById(R.id.stime);
          pass= (EditText)findViewById(R.id.pass);
        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(uname.getText().toString().equals("admin")){
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }

    else if (uname.getText().toString().equals("asad")||uname.getText().toString().equals("faruk"))
                {
                    PackageManager pm = getPackageManager();
                    Intent intent = pm.getLaunchIntentForPackage("in.wptrafficanalyzer.locationgeocodingv2");
                    startActivity(intent);

                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        uname.setText(" ");

    }
}
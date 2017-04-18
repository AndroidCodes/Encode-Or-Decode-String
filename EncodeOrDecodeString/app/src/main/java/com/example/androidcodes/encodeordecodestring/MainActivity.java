package com.example.androidcodes.encodeordecodestring;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;

    private EditText et_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;

        et_text = (EditText) findViewById(R.id.et_text);

        findViewById(R.id.btn_decode).setOnClickListener(this);

        findViewById(R.id.btn_encode).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_encode:

                EncodeOrDecode(et_text.getText().toString(), "E");

                break;

            case R.id.btn_decode:

                EncodeOrDecode(et_text.getText().toString(), "D");

                break;

            default:

                break;

        }
    }

    private String EncodeOrDecode(String Password, String EorD) {//For Encode use "E" Or Decode = "D"

        String pass = "";
        String strEncode = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz][?/<~`!@$%^*()+=}|:;,>{";
        String strDecode = ")(*^%$@!";
        String temp = "";
        for (int i = 1; i <= 70; i++) {
            char c = (char) (i + 160);
            temp += c;
        }

        if (EorD.equals("")) {

            strEncode = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz][?/<~#`!@$%^&*()+=}|:;,>{";

            strDecode = ")(*&^%$#@!";

        }

        strDecode += temp;
        int pos = 0;
        for (int j = 0; j < Password.trim().length(); j++) {
            char c = Password.charAt(j);
            if (EorD.equals("E")) {
                pos = strEncode.indexOf(c);
                char tempstr = strDecode.charAt(pos);
                pass += tempstr;
            } else {
                pos = strDecode.indexOf(c);
                char tempstr = strEncode.charAt(pos);
                pass += tempstr;
            }
        }

        et_text.setText(pass);

        Toast.makeText(activity, pass, Toast.LENGTH_SHORT).show();

        return pass;

    }
}

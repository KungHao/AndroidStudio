package com.example.miracle.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText medtSex, medtAge;
private TextView mtxtR;
Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medtSex = (EditText) findViewById(R.id.edtSex);
        medtAge= (EditText) findViewById(R.id.edtage);
        mtxtR= (TextView) findViewById(R.id.txtR);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }
    public View.OnClickListener btnOKOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //按下按鈕後要執行的程式
            String strSex = medtSex.getText().toString();
            int iAge = Integer.parseInt(medtAge.getText().toString());
            String strSug = getString(R.string.suggestion);
            if (strSex.equals(getString(R.string.sex_male)))//男
                if (iAge < 28 )
                    strSug += getString(R.string.sug_not_hurry);
                else if (iAge > 33)
                    strSug += getString(R.string.sug_get_married);
                else
                    strSug += getString(R.string.sug_find_couple);
            else//女
                if (iAge < 25)
                    strSug += getString(R.string.sug_not_hurry);
                else if (iAge > 30)
                    strSug += getString(R.string.sug_get_married);
                else
                    strSug += getString(R.string.sug_find_couple);
            mtxtR.setText(strSug);

        }


    };
}

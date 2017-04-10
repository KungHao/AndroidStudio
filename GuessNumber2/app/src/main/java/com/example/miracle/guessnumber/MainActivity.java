package com.example.miracle.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText medtNum;
    private Button mbtnOK;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "New Game!!!", Toast.LENGTH_SHORT).show();
        medtNum = (EditText) findViewById(R.id.edtNum);
        number = Integer.parseInt(medtNum.getText().toString());
        mbtnOK.setOnClickListener(btnOKOnClick);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        //使RecyclerView保持固定的大小
        mRecyclerView.setHasFixedSize(true);

        //use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new Adapter(number);

    }

    public View.OnClickListener btnOKOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
                if (mAdapter.game(position))
                    Toast.makeText(view.getContext().getApplicationContext(), mAdapter.getanswer(), Toast.LENGTH_LONG).show();
            mRecyclerView.setAdapter(mAdapter);;
        }
    };
}

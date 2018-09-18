package com.example.administrator.bind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.animal.Bind;
import com.example.apilibrary.BufferViewBinder;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BufferViewBinder.bind(this);

        textView.setText("A");

    }
}

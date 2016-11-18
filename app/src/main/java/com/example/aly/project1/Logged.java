package com.example.aly.project1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by aly on 11/18/16.
 */

public class Logged extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.textView4);
        tv.setText(username);

    }

}

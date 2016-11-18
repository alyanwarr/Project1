package com.example.aly.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void onButtonClick (View v)
    {
        if (v.getId() == R.id.button)
        {
            EditText t = (EditText)findViewById(R.id.login_username);
            String str = t.getText().toString();
            EditText tt = (EditText)findViewById(R.id.login_password);
            String pass = tt.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                Intent i = new Intent(this,Logged.class);
                i.putExtra("Username", str);

                startActivity(i);


            }
            else {

                Toast errorlog = Toast.makeText(Login.this,"Username and Password not matching!", Toast.LENGTH_SHORT);
                errorlog.show();

            }




        }
        if(v.getId() == R.id.button2)
        {

            Intent i = new Intent(this,SignUp.class);

            startActivity(i);

        }

    }
}


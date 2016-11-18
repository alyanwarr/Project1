package com.example.aly.project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aly on 11/18/16.
 */
public class SignUp extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
    public void onSignUpClick(View v)

    {

        if(v.getId() == R.id.sbtn);
        {

            EditText eusername = (EditText)findViewById(R.id.user_name);
            EditText epassword = (EditText)findViewById(R.id.pass_word);
            EditText econfirmpassword = (EditText)findViewById(R.id.confirm_password);
            EditText eemail = (EditText)findViewById(R.id.email);

            String username = eusername.getText().toString();
            String password = epassword.getText().toString();
            String confirmpassword = econfirmpassword.getText().toString();
            String email= eemail.getText().toString();

            if(!password.equals(confirmpassword)){

                //popup
                Toast pass = Toast.makeText(SignUp.this,"Passwords not matching!", Toast.LENGTH_SHORT);
                pass.show();

            }
            else
            {
                //insert details in DB
                Users c = new Users();
                c.setUname(username);
                c.setEmail(email);
                c.setPass(password);
                helper.insertUser(c);

            }

        }
    }
}

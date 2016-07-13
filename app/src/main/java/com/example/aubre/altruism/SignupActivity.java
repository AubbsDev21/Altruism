package com.example.aubre.altruism;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    protected EditText mUsername, mEmail, mPassword, mPassword2;
    protected TextView mFacebookintent, mloginintent;
    protected Button mSignupbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
      //implementing widgets
        mUsername = (EditText)findViewById(R.id.Users_name);
        mEmail = (EditText)findViewById(R.id.SUemail);
        mPassword = (EditText)findViewById(R.id.SUPassword);
        mPassword2 = (EditText)findViewById(R.id.SUpassword2);

        mFacebookintent = (TextView)findViewById(R.id.Facebookintent);
        mloginintent = (TextView)findViewById(R.id.Loginintent);

        mSignupbutton = (Button)findViewById(R.id.Signupbutton);


        mSignupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Refreshable*/

                //getting the string value of the edit text
                String Username = mUsername.getText().toString();
                String Email = mEmail.getText().toString();
                String Password = mPassword.getText().toString();
                String Password2 = mPassword2.getText().toString();

                //triming white spaces
                Username = Username.trim();
                Email = Email.trim();
                Password = Password.trim();
                Password2 = Password2.trim();

                if (Username.isEmpty() || Email.isEmpty() || Password.isEmpty() || Password2.isEmpty()){
                    AlertDialog.Builder  builder = new AlertDialog.Builder(SignupActivity.this);
                    builder.setMessage(R.string.Signup_error_message)
                            .setTitle(R.string.Signup_error_title)
                            .setPositiveButton(R.string.ok_label, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else {
                    //signup
                    ParseUser user = new ParseUser();
                    user.setUsername(Username);
                    user.setEmail(Email);
                    user.setPassword(Password);

                    //Phone number
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {

                            if (e == null) {
                                // Hooray! Let them use the app now.
                                Intent intent = new Intent(SignupActivity.this, );
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong
                                //Error message
                                AlertDialog.Builder  builder = new AlertDialog.Builder(Signup_Activity.this);
                                builder.setMessage(R.string.Signup_error_message)
                                        .setTitle(R.string.Signup_error_title)
                                        .setPositiveButton(R.string.ok_label, null);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }

                        }
                    });





                }
            }
        });

    }
}

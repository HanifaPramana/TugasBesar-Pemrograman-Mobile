package com.example.lim.kulinermalang;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_login extends AppCompatActivity {

    //deklarasi EditTexts
    EditText editTextUserName;
    EditText editTextPassword;

    //deklarasi TextInputLayout
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutPassword;

    //deklarasi Button
    Button buttonLogin;

    //deklarasi SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqliteHelper = new SqliteHelper(this);
        initCreateAccountTextView();
        initViews();

        // deklarasi kelas SessionManagement
        final SessionManagement sessionManagement;
        sessionManagement = new SessionManagement(this);

        if(sessionManagement.isLoggedIn()){
            //goToActivity();
        }

        //set click event tombol login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //mengecek input user apakah sudah benar apa belum
                if (validate()) {

                    //mengambil nilai dari field EditText
                    String UserName = editTextUserName.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //autentikasi user
                    User currentUser = sqliteHelper.Authenticate(new User(null, UserName, null, Password));

                    //mengecek autentikasi apakah berhasil atau tidaknya proses login
                    if (currentUser != null) {
                        Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();

                        //user berhasil masuk (dan terlempar ke activity homescreen)

                        EditText editText = (EditText)findViewById(R.id.editTextUserName);
                        sessionManagement.createLoginSession(UserName, Password);
                        goToActivity();
                        finish();

                    } else {

                        //user gagal masuk
                        Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });
    }

    // method untuk intent ke activity lain
    private void goToActivity(){
        Intent intent = new Intent(getApplicationContext(),activity_home.class);
        startActivity(intent);
    }

    //method ini digunakan untuk menghubungkan xml ke objeknya
    private void initViews() {
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

    }

    //method ini digunakan untuk text view create account dan click event
    //untuk texview (unik) belum support di xml jadi kita menyelesaikannya dengan program Html
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#000000'>I don't have account yet. </font><font color='#0c0099'>create one</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                startActivity(intent);
            }
        });
    }

    //method ini digunakan untuk handling fromHtml method
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    //method ini digunakan untuk validasi yang diinputkan oleh user
    public boolean validate() {
        boolean valid = false;

        //mengambil nilai dari field EditText
        String UserName = editTextUserName.getText().toString();
        String Password = editTextPassword.getText().toString();

        //memvalidasi nilai dari field username
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Please enter valid username!");
        }

        //memvalidasi nilai dari field password
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        return valid;
    }
}

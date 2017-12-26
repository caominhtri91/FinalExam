package com.nix.afinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  public static final String MYPREFERENCE = "mypref";
  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";
  EditText edt1, edt2;
  Button button;
  CheckBox checkbox;
  SharedPreferences sharedPreferences;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    edt1 = findViewById(R.id.editText1);
    edt2 = findViewById(R.id.editText2);
    button = findViewById(R.id.button1);
    checkbox = findViewById(R.id.checkBox1);

    sharedPreferences = getSharedPreferences(MYPREFERENCE, Context.MODE_PRIVATE);
    if (sharedPreferences.contains("username")) {
      edt1.setText(sharedPreferences.getString(USERNAME, ""));
    }
    if (sharedPreferences.contains("password")) {
      edt2.setText(sharedPreferences.getString(PASSWORD, ""));
    }

    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        if (checkbox.isChecked()) {
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString(USERNAME, edt1.getText().toString());
          editor.putString(PASSWORD, edt2.getText().toString());
          editor.commit();
        } else {
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString(USERNAME, edt1.getText().toString());
          editor.putString(PASSWORD, "");
          editor.commit();
        }


        if (TextUtils.isEmpty(edt1.getText()) || TextUtils.isEmpty(edt2.getText())) {
          Toast.makeText(MainActivity.this, "Xin hay nhap username && password", Toast.LENGTH_LONG).show();
          return;
        }
        String username = edt1.getText().toString();
        String password = edt2.getText().toString();
        if (username.equals("fpoly") && password.equals("poly123")) {
          Intent i = new Intent(MainActivity.this, Admin.class);
          startActivity(i);
          finish();
        } else {
          Toast.makeText(MainActivity.this, "Sai username hoac password", Toast.LENGTH_LONG).show();
          return;
        }
      }
    });
  }
}

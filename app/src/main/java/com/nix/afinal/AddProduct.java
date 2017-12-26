package com.nix.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class AddProduct extends AppCompatActivity {

  EditText edt1, edt2, edt3, edt4, edt5;
  Button button;
  dbHelper DBHelper;
  ProductDAO productDAO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_product);

    DBHelper = new dbHelper(this);
    productDAO = new ProductDAO(DBHelper);

    edt1 = (EditText) findViewById(R.id.editText1);
    edt2 = (EditText) findViewById(R.id.editText2);
    edt3 = (EditText) findViewById(R.id.editText3);
    edt4 = (EditText) findViewById(R.id.editText4);
    edt5 = (EditText) findViewById(R.id.editText5);
    button = (Button) findViewById(R.id.button1);

    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        if (!TextUtils.isEmpty(edt1.getText().toString()) && !TextUtils.isEmpty(edt2.getText().toString()) && !TextUtils.isEmpty(edt3.getText().toString()) && !TextUtils.isEmpty(edt4.getText().toString()) && !TextUtils.isEmpty(edt5.getText().toString())) {
          try {
            String id = checkID(edt1.getText().toString());
            String name = edt2.getText().toString();
            Float price = checkPrice(Float.valueOf(edt3.getText().toString()));
            String image = edt5.getText().toString();
            Date date = checkDate(new Date(edt4.getText().toString()));
            Product product = new Product(id, name, price, image, date);
            productDAO.insert(product);

            Intent i = new Intent(AddProduct.this, Admin.class);
            startActivity(i);
          } catch(Exception e) {
            Toast.makeText(AddProduct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(AddProduct.this, "Nhap day du please", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  private String checkID(String id) throws Exception{
    if (id.length() != 6 || !id.substring(0, 2).toLowerCase().equals("sp") || !TextUtils.isDigitsOnly(id.substring(3))) {
      throw new Exception("ID sai");
    }
    return id;
  }

  private Float checkPrice(Float price) throws Exception {
    if (price < 200 || price > 800) {
      throw new Exception("Gia sai!");
    }
    return price;
  }

  private Date checkDate(Date date) throws Exception {
    Date today = new Date();
    if (!today.equals(date) && today.before(date)) {
      throw new Exception("Ngay sai");
    }
    return date;
  }
}


package com.nix.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AppCompatActivity {

  Button button;
  ListView lv;
  List<Product> list = new ArrayList<Product>();
  dbHelper DBHelper;
  ProductDAO productDAO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin);

    button = findViewById(R.id.button1);
    lv = findViewById(R.id.listView1);

    DBHelper = new dbHelper(this);
    productDAO = new ProductDAO(DBHelper);
    list = productDAO.getList();
    CustomAdapter customAdapter = new CustomAdapter(this, list);
    lv.setAdapter(customAdapter);

    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Intent i = new Intent(Admin.this, AddProduct.class);
        startActivity(i);
      }
    });
  }
}

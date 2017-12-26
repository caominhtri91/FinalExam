package com.nix.afinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductDAO {
	private dbHelper DBHelper;

	public ProductDAO(dbHelper DBHelper) {
		super();
		this.DBHelper = DBHelper;
	}
	
	public List<Product> getList() {
		SQLiteDatabase db = this.DBHelper.getWritableDatabase();
	    Cursor cursor = db.rawQuery("SELECT * FROM " + dbHelper.PRODUCT_TABLE, null);
	    
	    List<Product> pl = new ArrayList<Product>();
	    Product product = null;
	    
	    if (cursor.getCount() > 0) {
	        while(cursor.moveToNext()) {
	        	String id = cursor.getString(cursor.getColumnIndex(dbHelper.PRODUCT_ID));
	        	String name = cursor.getString(cursor.getColumnIndex(dbHelper.PRODUCT_NAME));
	        	Float price = cursor.getFloat(cursor.getColumnIndex(dbHelper.PRODUCT_PRICE));
	        	String image = cursor.getString(cursor.getColumnIndex(dbHelper.PRODUCT_IMAGE));
	        	Date date = new Date(cursor.getString(cursor.getColumnIndex(dbHelper.PRODUCT_DATE)));
	        	product = new Product(id, name, price, image, date);
	        	pl.add(product);
	        }
	    }
	    
	    cursor.close();
	    
	    return pl;
	}
	
	public void insert(Product product) {
		SQLiteDatabase db = this.DBHelper.getWritableDatabase();

	    ContentValues values = new ContentValues();
	    values.put(dbHelper.PRODUCT_ID, product.getProductID());
	    values.put(dbHelper.PRODUCT_NAME, product.getName());
	    values.put(dbHelper.PRODUCT_PRICE, product.getPrice());
	    values.put(dbHelper.PRODUCT_IMAGE, product.getImage());
	    values.put(dbHelper.PRODUCT_DATE, product.getDate().toString());

	    db.insert(dbHelper.PRODUCT_TABLE, null, values);
	}
	
	public void update(Product product) {
		SQLiteDatabase db = this.DBHelper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(dbHelper.PRODUCT_ID, product.getProductID());
	    values.put(dbHelper.PRODUCT_NAME, product.getName());
	    values.put(dbHelper.PRODUCT_PRICE, product.getPrice());
	    values.put(dbHelper.PRODUCT_IMAGE, product.getImage());
	    values.put(dbHelper.PRODUCT_DATE, product.getDate().toString());
	    
		db.update(dbHelper.PRODUCT_TABLE, values, dbHelper.PRODUCT_ID + "=" + product.getProductID(), null);
	}
	
	public void delete(String id) {
		SQLiteDatabase db = this.DBHelper.getWritableDatabase();
		db.delete(dbHelper.PRODUCT_TABLE, dbHelper.PRODUCT_ID + "=" + id, null);
	}
}

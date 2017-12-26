package com.nix.afinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper{
	
	public static String DATABASE_NAME = "caominhtri_mobileLab_db";
	  public static String PRODUCT_TABLE = "products";
	  public static String PRODUCT_ID = "id";
	  public static String PRODUCT_NAME = "name";
	  public static String PRODUCT_PRICE = "price";
	  public static String PRODUCT_IMAGE = "image";
	  public static String PRODUCT_DATE = "date";

	  public dbHelper(Context context) {
	    super(context, DATABASE_NAME, null, 1);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase sqLiteDatabase) {
	    sqLiteDatabase.execSQL(
	        "CREATE TABLE " + PRODUCT_TABLE + "("
	        + PRODUCT_ID + " text,"
	        + PRODUCT_NAME + " text,"
	        + PRODUCT_PRICE + " number,"
	        + PRODUCT_IMAGE + " text,"
	        + PRODUCT_DATE + " text"
	        + ")"
	    );
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
	    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
	    onCreate(sqLiteDatabase);
	  }

}

package com.nix.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
  private static LayoutInflater inflater = null;
  Context context;
  List<Product> productList;

  public CustomAdapter(Context context, List<Product> productList) {
    // TODO Auto-generated constructor stub
    this.context = context;
    this.productList = productList;
    inflater = (LayoutInflater) context.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    // TODO Auto-generated method stub
    return productList.size();
  }

  @Override
  public Object getItem(int position) {
    // TODO Auto-generated method stub
    return position;
  }

  @Override
  public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    Holder holder = new Holder();
    View rowView;
    rowView = inflater.inflate(R.layout.product_list, null);
    holder.tv = (TextView) rowView.findViewById(R.id.textView1);
    holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
    holder.tv.setText(productList.get(position).getName());
    holder.img.setImageResource(R.drawable.z3);
    rowView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "You Clicked", Toast.LENGTH_LONG).show();
      }
    });
    return rowView;
  }

  public class Holder {
    TextView tv;
    ImageView img;
  }

} 

package com.example.superuser.productlistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mylistview=(ListView)findViewById(R.id.mylistview);
        mylistview.setAdapter(new ProductAdapter(this));

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj = parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private class ProductAdapter extends BaseAdapter {
        private List<Product> productList;
        private LayoutInflater layoutInflater;
        public ProductAdapter(Context context) {
            layoutInflater=LayoutInflater.from(context);
            productList=new ArrayList<>();
            productList.add(new Product(10001,R.drawable.phone2,"Verizpn Phone",10000));
            productList.add(new Product(10002,R.drawable.apple_phone,"Apple Phone",25000));
            productList.add(new Product(10003,R.drawable.windows_phone,"Windows_phone",8000));
            productList.add(new Product(10004,R.drawable.phone2,"Verizpn Phone",10000));
            productList.add(new Product(10005,R.drawable.apple_phone,"Apple Phone",25000));
            productList.add(new Product(10006,R.drawable.windows_phone,"Windows_phone",8000));
            productList.add(new Product(10007,R.drawable.phone2,"Verizpn Phone",10000));
            productList.add(new Product(10008,R.drawable.apple_phone,"Apple Phone",25000));
            productList.add(new Product(10009,R.drawable.windows_phone,"Windows_phone",8000));

        }
        @Override
        public int getCount() {
            return productList.size();
        }

        @Override
        public Object getItem(int position) {
            return productList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return productList.get(position).getProductId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.product_item,parent,false);
            }
            ImageView productIamge=(ImageView) convertView.findViewById(R.id.productIamge);
            productIamge.setImageResource(productList.get(position).getProductImage());

            TextView productName=(TextView)convertView.findViewById(R.id.productName);
            productName.setText(productList.get(position).getProductName());

            TextView productPrice=(TextView)convertView.findViewById(R.id.productPrice);
            productName.setText(String.valueOf(productList.get(position).getProductPrice()));

            return convertView;
        }
    }
}

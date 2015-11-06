package com.example.superuser.recyclerviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclervView);
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter(this));


    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private List<Product> productList;


        public ProductAdapter(Context context) {
            this.context=context;
            layoutInflater=LayoutInflater.from(context);
            //add Product Data
            productList=new ArrayList<>();
            productList.add(new Product(10001,R.drawable.product1,"Code Complete",1750.0));
            productList.add(new Product(10002,R.drawable.product1,"Code Complete",3015.0));
            productList.add(new Product(10003,R.drawable.product2,"Code Complete",1750.0));
            productList.add(new Product(10004,R.drawable.product2,"Code Complete",1750.0));
            productList.add(new Product(10005,R.drawable.product2,"Code Complete",222.0));
            productList.add(new Product(10006,R.drawable.product2,"Code Complete",1750.0));
            productList.add(new Product(10007,R.drawable.product2,"Code Complete",123.0));
            productList.add(new Product(10008,R.drawable.product2,"Code Complete",1750.0));
            productList.add(new Product(10009,R.drawable.product2,"Code Complete",1750.0));

        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView ivImage;
            private TextView tvName,tvPrice;
            private  View itemView;
            public ViewHolder(View itemView) {
                super(itemView);
                this.itemView=itemView;
                ivImage=(ImageView)itemView.findViewById(R.id.imgView);
                tvName=(TextView)itemView.findViewById(R.id.txt_produtName);
                tvPrice=(TextView)itemView.findViewById(R.id.txt_productPrice);

            }

            public ImageView getIvImage(){
                return ivImage;
            }

            public TextView getTvName(){
                return tvName;
            }

            public TextView getTvPrice(){
                return tvPrice;
            }

        }

        @Override
        public int getItemCount() {
            return productList.size();
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView=layoutInflater.inflate(R.layout.product_item,parent,false);
            return new ViewHolder(itemView);//扁平化管理
        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position) {//資料跟View綁定
            final Product product=productList.get(position);
            holder.getIvImage().setImageResource(product.getProductImage());
            holder.getTvName().setText(product.getProductName());
            holder.getTvPrice().setText(String.valueOf(product.getProductPrice()));

            holder.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(product.getProductImage());
                    Toast toast = new Toast(context);
                    toast.setView(imageView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            holder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, product.getProductName(), Toast.LENGTH_SHORT).show();
                }
            });

            holder.tvPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, String.valueOf(product.getProductPrice()), Toast.LENGTH_SHORT).show();
                }
            });




        }


    }
}

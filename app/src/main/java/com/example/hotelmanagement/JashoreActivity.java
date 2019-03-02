package com.example.hotelmanagement;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class JashoreActivity extends AppCompatActivity {

    private RecyclerView mBloglist;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jashore);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("jashore");
        mDatabase.keepSynced(true);

        mBloglist = findViewById(R.id.recyclerviewId);
        mBloglist.setHasFixedSize(true);
        mBloglist.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Blog,BlogViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Blog, BlogViewHolder>
                (Blog.class,R.layout.cardview,BlogViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setName((String) model.getName());
                viewHolder.setLocation((String) model.getLocation());
                viewHolder.setPrice((String) model.getPrice());
                viewHolder.setImage(getApplicationContext(), (String) model.getImage());


            }
        };
        mBloglist.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView = itemView;

        }
        public void setName(String name){
            TextView hotelname = mView.findViewById(R.id.hotelnameId);
            hotelname.setText(name);
        }
        public void setLocation(String location){
            TextView Location = mView.findViewById(R.id.locatitonId);
            Location.setText(location);
        }
        public void setPrice(String price){
            TextView Price = mView.findViewById(R.id.priceId);
            Price.setText(price);
        }
        public void setImage(Context ctx,String image){
            ImageView hotelimage = mView.findViewById(R.id.imageId);
            Picasso.with(ctx).load(image).into(hotelimage);
        }
    }
}

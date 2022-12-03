package com.brewingjava.multithreading.threads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.brewingjava.multithreading.R;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThreadAdapter extends RecyclerView.Adapter<ThreadAdapter.ThreadsViewHolder>  {
    private Context context;
    private ThreadInterface threadInterface;
    private ArrayList<Thread> threads;

    public ThreadAdapter(Context context, ThreadInterface threadInterface, ArrayList<Thread> threads) {
        this.context = context;
        this.threadInterface = threadInterface;
        this.threads = threads;
    }

    @NonNull
    @Override
    public ThreadsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_threads,parent,false);


        ThreadAdapter.ThreadsViewHolder viewHolder = new ThreadAdapter.ThreadsViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threadInterface.onCardClicked(threads.get(viewHolder.getAdapterPosition()));

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThreadsViewHolder holder, int position) {
        Thread thread = threads.get(position);

        String[] mColors = {"#FFF9ED","#EDEDFF","#FFEDED"};

        if(position%3==0){
            holder.constraintLayout.setBackgroundColor(Color.parseColor(mColors[0]));

        }else if(position%3==1){
            holder.constraintLayout.setBackgroundColor(Color.parseColor(mColors[1]));
        }else {
            holder.constraintLayout.setBackgroundColor(Color.parseColor(mColors[2]));
        }

        if(thread!=null){
            new ThreadAdapter.DownloadImageTask((ImageView) holder.image).execute(thread.getImageUrl());
        }


        holder.title.setText(thread.getTitle());
    }

    @Override
    public int getItemCount() {
        return threads.size();
    }

    public class ThreadsViewHolder extends RecyclerView.ViewHolder{

        private TextView title;

        private ImageView image;

        private ConstraintLayout constraintLayout;

        public ThreadsViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            image = itemView.findViewById(R.id.imgImage);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    threadInterface.onCardClicked(threads.get(getAdapterPosition()));
                }
            });

        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage){
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls){
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try{
                InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            }catch (Exception e){
                e.printStackTrace();
            }
            return bmp;
        }

        protected void onPostExecute(Bitmap result){
            bmImage.setImageBitmap(result);
        }
    }
}

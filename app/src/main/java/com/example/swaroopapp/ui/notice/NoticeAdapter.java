package com.example.swaroopapp.ui.notice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.swaroopapp.R;
import com.example.swaroopapp.fullimageview;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {
    private Context context;
    private ArrayList<NoticeData> list;


    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_itemlayout, parent, false);

        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, final int position) {
        final NoticeData currentItem = list.get(position);
        holder.deletenoticetitle.setText(currentItem.getTitle());

        holder.date.setText(currentItem.getDate());

        holder.time.setText(currentItem.getTime());


        try {
            if (currentItem.getImage() != null)
                Glide.with(context).load(currentItem.getImage()).into(holder.deletenoticeimage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.deletenoticeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, fullimageview.class);
                intent.putExtra("image",currentItem.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {


        private TextView deletenoticetitle, date, time;
        private ImageView deletenoticeimage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            deletenoticetitle = itemView.findViewById(R.id.noticenewtitle);
            deletenoticeimage = itemView.findViewById(R.id.deletenoticeimage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);


        }


    }
}

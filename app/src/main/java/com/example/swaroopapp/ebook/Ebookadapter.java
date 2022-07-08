package com.example.swaroopapp.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swaroopapp.R;

import java.util.List;

public class Ebookadapter extends RecyclerView.Adapter<Ebookadapter.ebookviewholder> {
    private Context context;
    private List<Ebookdata>list;

    public Ebookadapter(Context context, List<Ebookdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ebookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.ebookitemlayout,parent,false);
        return new ebookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ebookviewholder holder, final int position) {
        holder.ebookname.setText(list.get(position).getPdftitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(context,pdfvieweractivity.class);
              intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
              context.startActivity(intent);
            }
        });
        holder.ebookdownloadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ebookviewholder extends RecyclerView.ViewHolder {
        private TextView ebookname;
        private ImageView ebookdownloadimg;



        public ebookviewholder(@NonNull View itemView) {
            super(itemView);
            ebookdownloadimg=itemView.findViewById(R.id.ebookimage);
            ebookname=itemView.findViewById(R.id.ebookname);
        }
    }

}

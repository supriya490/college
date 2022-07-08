package com.example.swaroopapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.swaroopapp.R;

import java.util.List;

public class brachadapter extends PagerAdapter {
    private Context context;
    private List<branchmodel>list;

    public brachadapter(Context context, List<branchmodel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.branchitemlayout,container,false);
        ImageView bricon;
        TextView brtitle,brdescription;
        brtitle=view.findViewById(R.id.titlebranch);
        bricon=view.findViewById(R.id.branchicon);
        brdescription=view.findViewById(R.id.branchdescription);
        bricon.setImageResource(list.get(position).getImg());
        brdescription.setText(list.get(position).getDescription());
        brtitle.setText(list.get(position).getTitle());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

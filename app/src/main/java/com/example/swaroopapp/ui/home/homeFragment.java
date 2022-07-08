package com.example.swaroopapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.swaroopapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class homeFragment extends Fragment {

private SliderLayout sliderLayout;
private ImageView map;
private int[] images={
        R.drawable.cllg,
        R.drawable.maam,
        R.drawable.sir,
        R.drawable.hey,
        R.drawable.robot,
                R.drawable.rock,
                R.drawable.srm


};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout=view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3);
        setSliderView();
        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();

            }
        });

        return view;
    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0,0?q=Shri Ramswaroop Memorial College of Engineering and management Tiwariganj Uttarpradesh ");

        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderView() {
        for (int i=0;i<6;i++){
            DefaultSliderView sliderView=new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageDrawable(R.drawable.sir);

                    break;
                    case 1:
                    sliderView.setImageDrawable(R.drawable.hey);

                    break;
                    case 2:
                    sliderView.setImageDrawable(R.drawable.robot);
                    break;
                    case 3:
                    sliderView.setImageDrawable(R.drawable.maam);
                    break;
                    case 4:
                    sliderView.setImageDrawable(R.drawable.cllg);
                    break;
                    case 5:
                    sliderView.setImageDrawable(R.drawable.srm);
                    break;
                    case 6:
                    sliderView.setImageDrawable(R.drawable.rock);
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}
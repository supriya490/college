package com.example.swaroopapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.swaroopapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class galleryFragment extends Fragment {
RecyclerView robotic,gantavya,abhivyakti,fresher;
galleryadapter adapter;
DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        robotic=view.findViewById(R.id.robotic);
        gantavya=view.findViewById(R.id.gantavya);
        abhivyakti=view.findViewById(R.id.abhivyakti);
        fresher=view.findViewById(R.id.fresher);
        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        getrobotsimage();
        getfresherimage();
        return view;
    }

    private void getrobotsimage() {
        reference.child("Robotics Events").addValueEventListener(new ValueEventListener() {
            List<String>imagelist=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String) snapshot.getValue();
                    imagelist.add(data);

                }
                adapter=new galleryadapter(getContext(),imagelist);
                robotic.setLayoutManager(new GridLayoutManager(getContext(),4));
                robotic.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getfresherimage() {
        reference.child("Freshers Party").addValueEventListener(new ValueEventListener() {
            List<String>imagelist=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String) snapshot.getValue();
                    imagelist.add(data);

                }
                adapter=new galleryadapter(getContext(),imagelist);
                fresher.setLayoutManager(new GridLayoutManager(getContext(),4));
                fresher.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    }

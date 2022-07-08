package com.example.swaroopapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.swaroopapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class facultyFragment extends Fragment {
    private RecyclerView CSdepartment,mechanicaldepartment,civildepartment,electricaldepartment,electronicdepartment ,ITdepartment;
    private LinearLayout CSNODATA,mechanicalNODATA,electroniccommunicationNODATA,civilNODATA,electricalNODATA,ITNODATA;
    private List<Teacherdata> list1,list2,list3,list4,list5 ,list6;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbref;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);
        CSNODATA=view.findViewById(R.id.CSNODATA);
        mechanicalNODATA=view.findViewById(R.id.mechanicalNODATA);
        electricalNODATA =view.findViewById(R.id.electricalNODATA);
        electroniccommunicationNODATA=view.findViewById(R.id.electroniccommunicationNODATA);
        civilNODATA=view.findViewById(R.id.civilNODATA);
        ITNODATA=view.findViewById(R.id.ITNODATA);
       ITdepartment =view.findViewById(R.id.ITdepartment);
        CSdepartment=view.findViewById(R.id.CSdepartment);
        mechanicaldepartment=view.findViewById(R.id.mechanicaldepartment);
        civildepartment=view.findViewById(R.id.civildepartment);
        electricaldepartment=view.findViewById(R.id.electricaldepartment);
        electronicdepartment=view.findViewById(R.id.electronicdepartment);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");
        csdepartment();
        mechanicaldepartment();
        electronicdepartment();
        electricaldepartment();
        civildepartment();
        Informationtechnologydepartment();
        return view;
    }

    private void csdepartment() {

        dbref=reference.child("Computer Science Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    CSNODATA.setVisibility(View.VISIBLE);
                    CSdepartment.setVisibility(View.GONE);



                }else{
                    CSNODATA.setVisibility(View.GONE);
                    CSdepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Teacherdata data=snapshot.getValue(Teacherdata.class);
                        list1.add(data);

                    }
                    CSdepartment.setHasFixedSize(true);
                    CSdepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list1,getContext());
                    CSdepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Informationtechnologydepartment() {

        dbref=reference.child("Computer Science Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ITNODATA.setVisibility(View.VISIBLE);
                    ITdepartment.setVisibility(View.GONE);



                }else{
                    ITNODATA.setVisibility(View.GONE);
                    ITdepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Teacherdata data=snapshot.getValue(Teacherdata.class);
                        list6.add(data);

                    }
                    ITdepartment.setHasFixedSize(true);
                    ITdepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list6,getContext());
                    ITdepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void mechanicaldepartment() {

        dbref=reference.child("Mechanical Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mechanicalNODATA.setVisibility(View.VISIBLE);
                    mechanicaldepartment.setVisibility(View.GONE);



                }else{
                    mechanicalNODATA.setVisibility(View.GONE);
                    mechanicaldepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Teacherdata data=snapshot.getValue(Teacherdata.class);
                        list2.add(data);

                    }
                    mechanicaldepartment.setHasFixedSize(true);
                    mechanicaldepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list2, getContext());
                    mechanicaldepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void civildepartment () {

        dbref=reference.child("Civil Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    civilNODATA.setVisibility(View.VISIBLE);
                    civildepartment.setVisibility(View.GONE);



                }else{
                    civilNODATA.setVisibility(View.GONE);
                    civildepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Teacherdata data=snapshot.getValue(Teacherdata.class);
                        list3.add(data);

                    }
                    civildepartment.setHasFixedSize(true);
                    civildepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list3,getContext());
                    civildepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void electricaldepartment() {

        dbref=reference.child("Electrical Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    electricalNODATA.setVisibility(View.VISIBLE);
                    electricaldepartment.setVisibility(View.GONE);



                }else{
                    electricalNODATA.setVisibility(View.GONE);
                    electricaldepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Teacherdata data=snapshot.getValue(Teacherdata.class);
                        list4.add(data);

                    }
                    electricaldepartment.setHasFixedSize(true);
                    electricaldepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list4,getContext());
                    electricaldepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void electronicdepartment() {

        dbref=reference.child("Electronic & Communication Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    electroniccommunicationNODATA.setVisibility(View.VISIBLE);
                    electronicdepartment.setVisibility(View.GONE);



                }else{
                    electroniccommunicationNODATA.setVisibility(View.GONE);
                    electronicdepartment.setVisibility(View.VISIBLE);

                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Teacherdata data=snapshot.getValue(Teacherdata.class);
                        list5.add(data);

                    }
                    electronicdepartment.setHasFixedSize(true);
                    electronicdepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list5,getContext());
                    electronicdepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }























}
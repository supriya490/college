package com.example.swaroopapp.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.swaroopapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ebookactivity extends AppCompatActivity {
    private RecyclerView ebookrecycler;
    private DatabaseReference reference;
    private List <Ebookdata>list;
    private Ebookadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebookactivity);

        ebookrecycler=findViewById(R.id.ebookrecycler);
        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        getData();

    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list =new ArrayList<>();
                for(DataSnapshot snapshot :datasnapshot.getChildren()){
                  Ebookdata data=snapshot.getValue(Ebookdata.class);
                  list.add(data);

                }
                adapter=new Ebookadapter(ebookactivity.this,list);
                ebookrecycler.setLayoutManager(new LinearLayoutManager(ebookactivity.this));
                ebookrecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ebookactivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}

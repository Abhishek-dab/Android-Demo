package com.example.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Calls extends Fragment {
    RecyclerView rv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v3 = inflater.inflate(R.layout.fragment_calls, container, false);
        rv = v3.findViewById(R.id.recycler);

        int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.fidha,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};

        String names[] = {"Android","Bahubali","Chirutha","Dookudu","Eega","Fidha","Gabbar Singh","Happy","I manoharudu", "Jayam"};

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter adapter = new MyAdapter(getActivity(),images,names);
        rv.setAdapter(adapter);



        return v3;
    }
}
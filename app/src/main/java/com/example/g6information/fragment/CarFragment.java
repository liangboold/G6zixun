package com.example.g6information.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g6information.R;
import com.example.g6information.activity.MainActivity;

import com.example.g6information.adarpter.Caradarpter;
import com.example.g6information.entily.Userentily;

import java.util.List;


public class CarFragment extends Fragment {
    private RecyclerView crv;
    Caradarpter caradarpter;

    @Override
    public void onResume() {
        super.onResume();
        List<Userentily> userentilies = MainActivity.daoSession.loadAll(Userentily.class);
        caradarpter = new Caradarpter(userentilies);
        crv.setAdapter(caradarpter);
        crv.setLayoutManager(new LinearLayoutManager(getContext()));
        caradarpter.notifyDataSetChanged();
        caradarpter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_car, container, false);
        crv = (RecyclerView) inflate.findViewById(R.id.crv);
        return inflate;
    }
}
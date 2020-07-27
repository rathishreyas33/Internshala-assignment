package com.shreyasrathi.internshala;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment1 extends Fragment {
    private fragment1.onFragmentBtnSelected listener;

   TextView tvcall,tvmailus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_1,container,false);

        tvcall=view.findViewById(R.id.tvCall);
        tvmailus=view.findViewById(R.id.tvMailUs);

        tvcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedCall();
            }
        });

        tvmailus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonSelectedMail();
            }
        });
        return view;


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragment1.onFragmentBtnSelected) {
            listener = (fragment1.onFragmentBtnSelected) context;
        } else {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }

    public interface onFragmentBtnSelected {
        public void onButtonSelectedCall();
        public void onButtonSelectedMail();
    }
}

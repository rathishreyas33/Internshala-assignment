package com.shreyasrathi.internshala;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment2 extends Fragment {
        private fragment2.onFragmentButtonSelected listener;
    Button btngallery;
    ImageView ImageViewGallery;
    private final int IMG_REQUEST = 1;
    private Bitmap bitmap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2,container,false);

        btngallery=view.findViewById(R.id.btnGallery);
        ImageViewGallery=view.findViewById(R.id.imageViewGallery);

        btngallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
              //  openGallery.setType("image/*");
                //startActivity(openGallery);
                //startActivityForResult(openGallery, IMG_REQUEST);
               // ImageViewGallery.setBackgroundResource();
                //listener.onButtonClickedGallery();
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                try {
                    i.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(i, "Select Picture"), 0);
                }catch (ActivityNotFoundException ex){
                    ex.printStackTrace();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragment2.onFragmentButtonSelected){
            listener=(fragment2.onFragmentButtonSelected) context;
        }else{
            throw new ClassCastException(context.toString()+"must implement Listener");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0 && resultCode == Activity.RESULT_OK){
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), path);
                ImageViewGallery.setImageBitmap(bitmap);
                btngallery.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



    public interface onFragmentButtonSelected {
        public void onButtonClickedGallery();
    }
}

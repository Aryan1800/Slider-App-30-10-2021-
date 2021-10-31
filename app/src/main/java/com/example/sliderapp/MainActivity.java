package com.example.sliderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {



    ViewFlipper flipper;
    CheckBox checkBox;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Objects.requireNonNull(getSupportActionBar()).hide();

        checkBox=findViewById(R.id.check);
        btn = findViewById(R.id.btn);


        checkBox.setOnCheckedChangeListener((compoundButton, b) -> {

            if (b){
                btn.setVisibility(View.VISIBLE);
            }else {
                btn.setVisibility(View.INVISIBLE);
            }
        });











        int[] imagearray ={R.drawable.imageone,R.drawable.imagetwo,R.drawable.imagethree};

        flipper =findViewById(R.id.flipper);

        for (int j : imagearray) showimage(j);




    }
    public void showimage(int img){
        ImageView imageview=new ImageView(this);
        imageview.setBackgroundResource(img);

        imageview.setOnClickListener(view -> {
          if(img==R.drawable.imageone)
              startActivity(new Intent(getApplicationContext(),SlideOne.class));

            if(img==R.drawable.imagetwo)
                startActivity(new Intent(getApplicationContext(),SlideTwo.class));

            if(img==R.drawable.imagethree)
                startActivity(new Intent(getApplicationContext(),SlideThree.class));

        });


        flipper.addView(imageview);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);




    }

}
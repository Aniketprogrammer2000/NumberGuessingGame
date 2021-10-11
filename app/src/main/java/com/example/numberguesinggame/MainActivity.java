package com.example.numberguesinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView show;
private EditText put;
private Button submit;
private int limit=5;
private boolean t=true;
 MediaPlayer player,player1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=findViewById(R.id.textView);
       // sh=findViewById(R.id.textView3);
        put=findViewById(R.id.editTextTextPersonName);
        submit=findViewById(R.id.button);
        player= MediaPlayer.create(MainActivity.this,R.raw.hurray);
        player1=MediaPlayer.create(MainActivity.this,R.raw.loser);
        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(t){

                 String number = put.getText().toString();
                 if(!number.isEmpty()){
                int num = Integer.parseInt(number);
                put.getText().clear();
                Random random = new Random();
                int nu = random.nextInt(100);

                if(limit!=0){
                if (num <100) {
                    if (num == nu) {
                        show.setText(nu + ":correct guessing number");
t=false;
                        limit=0;
player.start();


                    } else {
                        show.setText(nu + ":wrong guessing number try again");
                        //limit--;



                    }
                } else show.setText(num+" number above of 99 try again");}
                else{
                    Toast.makeText(MainActivity.this, "please restart your game for play again:", Toast.LENGTH_SHORT).show();

                }}
                else
                     Toast.makeText(MainActivity.this, "please enter the number:^^", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(MainActivity.this, "please restart your game for play again:", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        player.release();

    }
}
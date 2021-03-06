package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.Question;

public class QuizQuestion extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1_question,timerTxt;
    int total =1;
    int correct =0;
    int wrong =0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

        t1_question = findViewById(R.id.questionTxt);
        timerTxt = findViewById(R.id.timerTxt);

        updateQuestion();
        reverseTimer(30,timerTxt);
    }

    private void updateQuestion() {
        if(total>4){

        }
        else{
            reference= FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question =dataSnapshot.getValue(Question.class);

                    t1_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b1.getText().toString().equals(question.getAnswer())){
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b1.setBackgroundColor(Color.RED);

                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        updateQuestion();
                                    }
                                },1500);

                            }
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b2.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        updateQuestion();
                                    }
                                },1500);

                            }
                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b3.getText().toString().equals(question.getAnswer())){
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b3.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        updateQuestion();
                                    }
                                },1500);

                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b4.getText().toString().equals(question.getAnswer())){
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                            else{
                                wrong++;
                                b4.setBackgroundColor(Color.RED);

                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9FA"));
                                        updateQuestion();
                                    }
                                },1500);

                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    public void reverseTimer(int seconds,final TextView tv){
        new CountDownTimer(seconds* 1000+1000, 1000){
            public void onTick(long millisUntilFinished){
                int seconds = (int)(millisUntilFinished / 1000);
                int minutes = seconds/60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d",minutes)
                        + ":" + String.format("%02d",seconds));
            }

            public void onFinish(){
                tv.setText("Completed");
                Intent myIntent = new Intent(QuizQuestion.this,ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);
            }
        }.start();
    }
}


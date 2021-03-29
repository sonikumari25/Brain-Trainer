package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    int track=31;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    int locationOfCorrectAnswer;
    int add;
    int score=0;
    int total=0;
    public void onClick(View view) {
        button6 = (Button) findViewById(R.id.button6);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        button6.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        game();
    }
        public void game() {
            CountDownTimer count = new CountDownTimer(31000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    track--;
                    textView.setText(Integer.toString(track) + "s");

                }

                @Override
                public void onFinish() {
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                    button4.setEnabled(false);
                    button5.setVisibility(View.VISIBLE);
                    textView4.setText("Your Score Is" + Integer.toString(score) + "/" + Integer.toString(total));
                }
            }.start();

            displayQuestion();

        }
    public void displayQuestion(){
        int random = rand.nextInt(30) + 1;
        int random1 = rand.nextInt(30) + 1;
        add=random+random1;
        textView3.setText(Integer.toString(random)+"+"+Integer.toString(random1));
        locationOfCorrectAnswer=rand.nextInt(5)+1;
        button1.setText(Integer.toString(rand.nextInt(59)+2));
        button2.setText(Integer.toString(rand.nextInt(59)+2));
        button3.setText(Integer.toString(rand.nextInt(59)+2));
        button4.setText(Integer.toString(rand.nextInt(59)+2));
        if(locationOfCorrectAnswer==1){
            button1.setText(Integer.toString(add));
        }
        else if(locationOfCorrectAnswer==2){
            button2.setText(Integer.toString(add));
        }
        else if(locationOfCorrectAnswer==3){
            button3.setText(Integer.toString(add));
        }
        else{
            button4.setText(Integer.toString(add));
        }


    }
    public void answer(View view){
        if(view.getId()==R.id.button1 && locationOfCorrectAnswer==1 ){
            score++;
            total++;
            textView2.setText(Integer.toString(score)+"/"+Integer.toString(total));
            textView4.setText("Correct!");
            textView4.setVisibility(View.VISIBLE);

        }
       else if(view.getId()==R.id.button2 && locationOfCorrectAnswer==2 ){
            score++;
            total++;
            textView2.setText(Integer.toString(score)+"/"+Integer.toString(total));
            textView4.setText("Correct!");
            textView4.setVisibility(View.VISIBLE);

        }
       else if(view.getId()==R.id.button3 && locationOfCorrectAnswer==3 ){
            score++;
            total++;
            textView2.setText(Integer.toString(score)+"/"+Integer.toString(total));
            textView4.setText("Correct!");
            textView4.setVisibility(View.VISIBLE);

        }
       else if(view.getId()==R.id.button4 && locationOfCorrectAnswer==4 ){
            score++;
            total++;
            textView2.setText(Integer.toString(score)+"/"+Integer.toString(total));
            textView4.setText("Correct!");
            textView4.setVisibility(View.VISIBLE);

        }
       else{
           total++;
            textView2.setText(Integer.toString(score)+"/"+Integer.toString(total));
           textView4.setText("Wrong!");
           textView4.setVisibility(View.VISIBLE);
        }
       displayQuestion();

    }
    public void playAgain(View view){
        track=31;
        score=0;
        total=0;
        textView2.setText(Integer.toString(score)+"/"+Integer.toString(total));
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        textView4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        game();
        displayQuestion();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand=new Random();
    }
}
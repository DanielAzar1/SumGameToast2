package com.example.sumgametoast2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Random rnd = new Random();
    TextView num1q1,num2q1,num1q2,num2q2,num1q3,num2q3;
    EditText answerq1,answerq2,answerq3;
    Button enter1;
    Button enter2;
    Button enter3;
    Button nextbutton;
    ImageView checkbox1,checkbox2,checkbox3;
    int rndNum = (rnd.nextInt(89) + 10);
    int rndNum2 = (rnd.nextInt(89) + 10);
    int answer;
    int sum;
    int correct = 0;
    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1q1 = findViewById(R.id.num1q1);
        num2q1 = findViewById(R.id.num2q1);

        num1q2 = findViewById(R.id.num1q2);
        num2q2 = findViewById(R.id.num2q2);

        num1q3 = findViewById(R.id.num1q3);
        num2q3 = findViewById(R.id.num2q3);

        answerq1 = findViewById(R.id.answerq1);
        answerq2 = findViewById(R.id.answerq2);
        answerq3 = findViewById(R.id.answerq3);

        enter1 = findViewById(R.id.enter1);
        enter2 = findViewById(R.id.enter2);
        enter3 = findViewById(R.id.enter3);

        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);

        nextbutton = findViewById(R.id.nextbutton);
        num1q1.setText(""+rndNum);
        num2q1.setText(""+rndNum2);
    }

    public void click1(View view) {
        ans = answerq1.getText().toString();
        if(!ans.isEmpty())
        {
            answer = Integer.parseInt(ans);
            if (answer == rndNum + rndNum2)
            {
                correct++;
                checkbox1.setVisibility(View.VISIBLE);
                checkbox1.setImageResource(R.drawable.vvv);
                num1q2.setVisibility(View.VISIBLE);
                num2q2.setVisibility(View.VISIBLE);
                enter2.setVisibility(View.VISIBLE);
                answerq2.setVisibility(View.VISIBLE);
            }
            else
            {
                checkbox1.setVisibility(View.VISIBLE);
                checkbox1.setImageResource(R.drawable.xxx);
                num1q2.setVisibility(View.VISIBLE);
                num2q2.setVisibility(View.VISIBLE);
                enter2.setVisibility(View.VISIBLE);
                answerq2.setVisibility(View.VISIBLE);
            }
        }
        else Toast.makeText(this, "Enter a number!.", Toast.LENGTH_SHORT).show();
        sum = rndNum + rndNum2;
        rndNum = (rnd.nextInt(89) + 10);
        num1q2.setText(""+sum);
        num2q2.setText(""+rndNum);


    }


    public void click2(View view) {
        ans = answerq2.getText().toString();
        if (!ans.isEmpty()) {
            answer = Integer.parseInt(ans);
            if (answer == sum + rndNum) {
                correct++;
                checkbox2.setVisibility(View.VISIBLE);
                checkbox2.setImageResource(R.drawable.vvv);
                num1q3.setVisibility(View.VISIBLE);
                num2q3.setVisibility(View.VISIBLE);
                enter3.setVisibility(View.VISIBLE);
                answerq3.setVisibility(View.VISIBLE);
            } else {
                checkbox2.setVisibility(View.VISIBLE);
                checkbox2.setImageResource(R.drawable.xxx);
                num1q3.setVisibility(View.VISIBLE);
                num2q3.setVisibility(View.VISIBLE);
                enter3.setVisibility(View.VISIBLE);
                answerq3.setVisibility(View.VISIBLE);
            }
        }
        else Toast.makeText(this, "Enter a number!.", Toast.LENGTH_SHORT).show();
        sum = rndNum + sum;
        rndNum = (rnd.nextInt(89) + 10);
        num1q3.setText(""+sum);
        num2q3.setText(""+rndNum);
    }

    public void click3(View view) {
        ans = answerq3.getText().toString();
        if (!ans.isEmpty()) {
            answer = Integer.parseInt(ans);
            if (answer == sum + rndNum) {
                checkbox3.setVisibility(View.VISIBLE);
                correct++;
                checkbox3.setImageResource(R.drawable.vvv);
                nextbutton.setVisibility(View.VISIBLE);

            } else {
                checkbox3.setVisibility(View.VISIBLE);
                checkbox3.setImageResource(R.drawable.xxx);
                nextbutton.setVisibility(View.VISIBLE);
            }
        }
        else Toast.makeText(this, "Enter a number!.", Toast.LENGTH_SHORT).show();
        switch (correct)
        {
            case 0:
                nextbutton.setText("0/3  0%");
            case 1:
                nextbutton.setText("1/3  33%");
                break;
            case 2:
                nextbutton.setText("2/3  67%");
                break;
            case 3:
                nextbutton.setText("3/3  100%");
                break;
        }
    }

    public void newGame(View view) {
        correct = 0;
        rndNum = (rnd.nextInt(89) + 10);
        rndNum2 = (rnd.nextInt(89) + 10);
        num1q1.setText(""+rndNum);
        num2q1.setText(""+rndNum2);

        answerq1.setText("");
        answerq2.setText("");
        answerq3.setText("");


        num1q2.setVisibility(View.INVISIBLE);
        num2q2.setVisibility(View.INVISIBLE);
        num1q3.setVisibility(View.INVISIBLE);
        num2q3.setVisibility(View.INVISIBLE);

        answerq2.setVisibility(View.INVISIBLE);
        answerq3.setVisibility(View.INVISIBLE);

        enter2.setVisibility(View.INVISIBLE);
        enter3.setVisibility(View.INVISIBLE);

        checkbox1.setVisibility(View.INVISIBLE);
        checkbox2.setVisibility(View.INVISIBLE);
        checkbox3.setVisibility(View.INVISIBLE);

        nextbutton.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "New game created.", Toast.LENGTH_SHORT).show();

    }
}
package com.teresa.hausuebung12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.teresa.hausuebung12.InfixToPostFix.infixToPostFix;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, multiply, div, ac, cOpen, cClose, dot, equals;
    private String input, answer;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.screen);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multiply = findViewById(R.id.multiply);
        div = findViewById(R.id.div);
        ac = findViewById(R.id.ac);
        cOpen = findViewById(R.id.open);
        cClose = findViewById(R.id.close);
        dot = findViewById(R.id.dot);
        equals = findViewById(R.id.equals);
    }
    
    public void buttonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        
        switch (data) {
            case "AC":
                input = "";
                break;
            case "=":
                solve(input);
                screen.setText(answer);
                break;
            default:
                if (input == null) {
                    input = "";
                } else {
                    input += data;
                }
            
        }
        screen.setText(input);
    }
    
    double res = 0;
    
    private void solve(String numbers) {
        String s = infixToPostFix(numbers);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            list.add(String.valueOf(s.charAt(i)));
        }
        PostFixCalculator pfc = new PostFixCalculator(list);
    }
}
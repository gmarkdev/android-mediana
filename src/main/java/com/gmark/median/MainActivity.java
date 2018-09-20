package com.gmark.median;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Double> numbers = new ArrayList<>();
    EditText numbersEditText;
    Button countBtn;
    TextView resultTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersEditText = (EditText) findViewById(R.id.numbersEditText);
        countBtn = (Button) findViewById(R.id.countBtn);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        countBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(numbersEditText.getText().toString().trim().length() > 0) {
                    String[] numbersStr = numbersEditText.getText().toString().split(",");

                    for(int i = 0; i < numbersStr.length; i++) {
                        try {
                            if(numbersStr.length > 0) {
                                numbers.add(Double.valueOf(numbersStr[i]));
                            }
                        }
                        catch(Exception e) {}
                    }

                    numbersEditText.setText("");
                    resultTextView.setText(String.valueOf(median()));
                    numbers.clear();

                }
                else {
                    Toast.makeText(MainActivity.this, getString(R.string.typeNumbers), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public double median() {
        Collections.sort(numbers);
        double median;

        int middle = ((numbers.size()) / 2);
        if(numbers.size() % 2 == 0){
            double medianA = numbers.get(middle);
            double medianB = numbers.get(middle - 1);
            median = (medianA + medianB) / 2;
        } else{
            median = numbers.get(middle);
        }
        return median;
    }
}

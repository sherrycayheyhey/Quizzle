package com.chromsicle.quizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//this "implements" showed up because I chose to "Make 'MainActivity' implement 'android.view.View.OnClickListener' to use the true/false buttons
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //create variable for the UI widgets
    private Button falseButton;
    private Button trueButton;
    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the UI widgets and set them to variables, instantiate them
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTextView = findViewById(R.id.answer_text_view);

        //set the onClick action of the button, used "this" then added the "implements" above and the onClick override showed up too
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();

            case R.id.true_button:
                Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
        }

    }
}
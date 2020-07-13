package com.chromsicle.quizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//this "implements" showed up because I chose to "Make 'MainActivity' implement 'android.view.View.OnClickListener' to use the true/false buttons
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //create variable for the UI widgets
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton backButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;

    //array to hold all the questions
    private Question[] questions = new Question[] {
            new Question(R.string.test_question_1, true),
            new Question(R.string.test_question_2, false),
            new Question(R.string.test_question_3, true),
            new Question(R.string.test_question_4, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the UI widgets and set them to variables, instantiate them
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        backButton = findViewById(R.id.back_button);
        questionTextView = findViewById(R.id.answer_text_view);

        //set the onClick action of the button, used "this" then added the "implements" above and the onClick override showed up too
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                //go to the next question
                //this code makes it so the group of questions will wrap around and never be out of bounds, so cool!
                currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
                updateQuestion();
                break;

            case R.id.back_button:
                //go to the previous question
                // goes back a single question at a time, stops going back if at the 0th question
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questions.length;
                    updateQuestion();
                }

                break;
        }
    }

    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionTextView.setText(questions[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = questions[currentQuestionIndex].isTrue();
        int toastMessageId;

        if(userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.incorrect_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}
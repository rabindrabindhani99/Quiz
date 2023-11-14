package com.grabs4buisness.quiz;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTV, question,scoreTv;
    AppCompatButton choice1, choice2, choice3, choice4, submitBtn;

    int score = 0;
    int currentQuestionIndex = 0;
    int totalQue=20;
    String selectedAnswer = "";

    String termPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        totalQuestionsTV = findViewById(R.id.totalQue_tv);
        scoreTv=findViewById(R.id.score_tv);
        question = findViewById(R.id.questionTv);
        choice1 = findViewById(R.id.choice_1);
        choice2 = findViewById(R.id.choice_2);
        choice3 = findViewById(R.id.choice_3);
        choice4 = findViewById(R.id.choice_4);
        submitBtn = findViewById(R.id.submit_btn);

        Intent intent = getIntent();
        termPass = intent.getStringExtra("term_pass");

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        loadNewQuestion();

    }
    @Override
    public void onClick(View view) {
        choice1.setBackgroundColor(Color.GRAY);
        choice2.setBackgroundColor(Color.GRAY);
        choice3.setBackgroundColor(Color.GRAY);
        choice4.setBackgroundColor(Color.GRAY);

        AppCompatButton clickedButton = (AppCompatButton) view;
        if (clickedButton.getId() == R.id.submit_btn) {

            switch (termPass) {
                case "general knowledge":
                    if (selectedAnswer.equals(QuestionAnswer.gkAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                case "history":
                    if (selectedAnswer.equals(QuestionAnswer.historyAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                case "geography":
                    if (selectedAnswer.equals(QuestionAnswer.geographyAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                case "mathematics":
                    if (selectedAnswer.equals(QuestionAnswer.mathAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                case "politics":
                    if (selectedAnswer.equals(QuestionAnswer.politicsAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                case "music":
                    if (selectedAnswer.equals(QuestionAnswer.musicAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                case "computer science":
                    if (selectedAnswer.equals(QuestionAnswer.csAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
                    //Sports
                default:
                    if (selectedAnswer.equals(QuestionAnswer.sportsAnswers[currentQuestionIndex])) {
                        score++;
                    }
                    break;
            }

            currentQuestionIndex++;
            loadNewQuestion();
        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
                builder.setTitle("Quiz");
                builder.setMessage("Do you want to leave the Quiz?");
                builder.setPositiveButton("Leave", (dialog, which) -> openComprehension());
                builder.setNegativeButton("Stay", (dialog, which) -> dialog.dismiss());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @SuppressLint("SetTextI18n")
    void loadNewQuestion() {

        scoreTv.setText("Score:"+score);

        if(currentQuestionIndex<totalQue) {
            //Setting the total no of question value to the text view
            totalQuestionsTV.setText("No of questions: " + (currentQuestionIndex + 1) + "/" + totalQue);
        }
        else if (currentQuestionIndex == totalQue) {
            finishQuiz();
            return;
        }

        switch (termPass) {
            case "general knowledge":
                question.setText(QuestionAnswer.gkQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.gkChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.gkChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.gkChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.gkChoices[currentQuestionIndex][3]);
                break;
            case "history":
                question.setText(QuestionAnswer.historyQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.historyChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.historyChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.historyChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.historyChoices[currentQuestionIndex][3]);
                break;
            case "geography":
                question.setText(QuestionAnswer.geographyQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.geographyChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.geographyChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.geographyChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.geographyChoices[currentQuestionIndex][3]);
                break;
            case "mathematics":
                question.setText(QuestionAnswer.mathQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.mathChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.mathChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.mathChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.mathChoices[currentQuestionIndex][3]);
                break;
            case "politics":
                question.setText(QuestionAnswer.politicsQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.politicsChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.politicsChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.politicsChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.politicsChoices[currentQuestionIndex][3]);
                break;
            case "music":
                question.setText(QuestionAnswer.musicQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.musicChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.musicChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.musicChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.musicChoices[currentQuestionIndex][3]);
                break;
            case "computer science":
                question.setText(QuestionAnswer.csQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.csChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.csChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.csChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.csChoices[currentQuestionIndex][3]);
                break;
            default:
//Sports

                question.setText(QuestionAnswer.sportsQuestions[currentQuestionIndex]);
                choice1.setText(QuestionAnswer.sportsChoices[currentQuestionIndex][0]);
                choice2.setText(QuestionAnswer.sportsChoices[currentQuestionIndex][1]);
                choice3.setText(QuestionAnswer.sportsChoices[currentQuestionIndex][2]);
                choice4.setText(QuestionAnswer.sportsChoices[currentQuestionIndex][3]);
                break;
        }

    }

    private void finishQuiz(){
        String passStatus;
        if(score > totalQue*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQue)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setNegativeButton("Home",((dialog, which) -> openComprehension()))
                .setCancelable(false)
                .show();

    }
    private void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
    private void openComprehension()
    {
        score=0;
        currentQuestionIndex=0;
        Intent intent=new Intent(QuizActivity.this,ComprehensionActivity.class);
        startActivity(intent);
    }

}

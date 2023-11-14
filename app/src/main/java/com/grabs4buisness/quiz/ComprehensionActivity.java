package com.grabs4buisness.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ComprehensionActivity extends AppCompatActivity {
    Button generalKnowledgeBtn, historyBtn, geographyBtn, mathematicsBtn, politicsBtn,
            musicBtn, computerScienceBtn, sportsBtn;
    String termPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehension);

        generalKnowledgeBtn = findViewById(R.id.general_knowledge);
        historyBtn = findViewById(R.id.history);
        geographyBtn = findViewById(R.id.geography);
        mathematicsBtn = findViewById(R.id.mathematics);
        politicsBtn = findViewById(R.id.politics);
        musicBtn = findViewById(R.id.music);
        computerScienceBtn = findViewById(R.id.computer_science);
        sportsBtn = findViewById(R.id.sports);

        generalKnowledgeBtn.setOnClickListener(v -> {
            termPass = "general knowledge";
            OpenQuizActivity();
        });

        historyBtn.setOnClickListener(v -> {
            termPass = "history";
            OpenQuizActivity();
        });

        geographyBtn.setOnClickListener(v -> {
            termPass = "geography";
            OpenQuizActivity();
        });

        mathematicsBtn.setOnClickListener(v -> {
            termPass = "mathematics";
            OpenQuizActivity();
        });

        politicsBtn.setOnClickListener(v -> {
            termPass = "politics";
            OpenQuizActivity();
        });

        musicBtn.setOnClickListener(v -> {
            termPass = "music";
            OpenQuizActivity();
        });

        computerScienceBtn.setOnClickListener(v -> {
            termPass = "computer science";
            OpenQuizActivity();
        });

        sportsBtn.setOnClickListener(v -> {
            termPass = "sports";
            OpenQuizActivity();
        });

    }

    private void OpenQuizActivity() {
        Intent intent = new Intent(ComprehensionActivity.this, QuizActivity.class);
        intent.putExtra("term_pass", termPass);
        startActivity(intent);
    }
}
package com.grabs4buisness.quiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button enterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterBtn = findViewById(R.id.enter_into_app_btn);

        // Create an instance of the callback to ask for quiting the app
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Quiz");
                builder.setMessage("Do you want to exit?");
                builder.setPositiveButton("Yes", (dialog, which) -> finish());
                builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
        //When enter button get clicked
        enterBtn.setOnClickListener(v -> openComprehensionsScreen());
    }

    private void openComprehensionsScreen() {
        Intent intent = new Intent(MainActivity.this, ComprehensionActivity.class);
        startActivity(intent);
    }
}

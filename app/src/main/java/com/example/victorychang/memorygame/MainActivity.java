package com.example.victorychang.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * The action to take when the PLAY button is clicked.
     * Post Condition: Move to the physical game activity
     */
    public void playButtonClicked(View view) {
        Toast.makeText(this, "You clicked the play button, moving to GameActivity!", Toast.LENGTH_SHORT).show();
        Intent moveToGameActivity = new Intent(this, GameActivity.class);
        startActivity(moveToGameActivity);
    }


    /**
     * The action to take when the RULES button is clicked.
     * Post Condition: Move to the physical RULES activity
     */
    public void rulesButtonClicked(View view) {
        Toast.makeText(this, "You clicked the rules button!", Toast.LENGTH_SHORT).show();
        Intent moveToRulesActivity = new Intent(this, RulesActivity.class);
        startActivity(moveToRulesActivity);
    }
}

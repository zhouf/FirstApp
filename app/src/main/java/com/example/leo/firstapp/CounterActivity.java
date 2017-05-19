package com.example.leo.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        //displayForTeamA(scoreTeamA);
    }

    private void displayForTeamA(int score){
        TextView scoreView = (TextView)findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForTeamB(int score){
        TextView scoreView = (TextView)findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeA(View btn){
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoA(View btn){
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneA(View btn){
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeB(View btn){
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }
    public void addTwoB(View btn){
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }
    public void addOneB(View btn){
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void reset(View btn){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}

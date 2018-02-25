package com.anonymous.scarnedice.scarnesdice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class User extends AppCompatActivity {

    private boolean isplayerTurn = true;

    private long player1Score = 0, player2Score = 0, turnScore = 0;
    private Button roll, hold, reset;
    private ImageView diceImage;
    private TextView scoreText;
    private int currentDiceValue = 1;
    private String SCOREPLAYER1 = "Player One Score : ";
    private String SCOREPLAYER2 = "Player Two Score : ";
    private String SCORETURN = "Turn Score : ";
    int images[] = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        scoreText = (TextView) findViewById(R.id.textView6);
        diceImage = (ImageView) findViewById(R.id.imageView3);
        roll = (Button) findViewById(R.id.roll);
        hold = (Button) findViewById(R.id.hold);
        reset = (Button) findViewById(R.id.reset);
        updateUi();

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isplayerTurn)
                    roll();
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isplayerTurn)
                    hold();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });


    }

    private void roll() {
        currentDiceValue = new Random().nextInt(6) + 1;
        if (currentDiceValue == 1) {
            turnScore = 0;
            hold();
        } else {
            turnScore += currentDiceValue;
        }
        updateUi();
    }

    private void hold() {
        if (isplayerTurn==true) {

            player1Score += turnScore;
            isplayerTurn=false;
        }
        else {
            player2Score += turnScore;
            isplayerTurn=true;
        }
        turnScore = 0;
        currentDiceValue = 1;
        updateUi();
        if(player2Score>100|| player1Score>100)
        {
            Toast.makeText(this,(player2Score>100?"Player2":"Player")+" won",Toast.LENGTH_SHORT).show();
            reset();
        }
        if (isplayerTurn==false) {
                    player2Turn();
                }
       }



    private void reset() {
        player1Score = turnScore = player2Score = 0;
        isplayerTurn = true;
        updateUi();
    }

    private void updateUi() {
        scoreText.setText(SCOREPLAYER1 + player1Score + "\n" + SCOREPLAYER2 + player2Score + "\n" + SCORETURN + turnScore);
        diceImage.setImageResource(images[(int) currentDiceValue - 1]);

    }

    private void player2Turn() {
        isplayerTurn=false;
        if (isplayerTurn==false) {
            roll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isplayerTurn==false)
                        roll();
                }
            });

            hold.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isplayerTurn==false)
                        hold();
                }
            });

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reset();
                }
            });


        }
        }

    }

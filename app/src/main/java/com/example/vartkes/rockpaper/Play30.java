package com.example.vartkes.rockpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Play30 extends AppCompatActivity {

    Button b_rock, b_paper, b_scissors, b_you, b_comp, b_score,b_comment;
    ImageView iv_YourChoice, iv_ComputerChoice;
    TextView tv_declare;

    int YourScore, ComputerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play30);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissors = (Button) findViewById(R.id.b_scissors);
        b_score = (Button) findViewById(R.id.b_score);
        b_you = (Button) findViewById(R.id.b_you);
        b_comp = (Button) findViewById(R.id.b_comp);
        b_comment = (Button) findViewById(R.id.b_comment);

        iv_YourChoice = (ImageView) findViewById(R.id.iv_YourChoice);
        iv_ComputerChoice = (ImageView) findViewById(R.id.iv_ComputerChoice);

        tv_declare = (TextView) findViewById(R.id.tv_declare);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (YourScore < 30 && ComputerScore < 30)
                    iv_YourChoice.setImageResource(R.drawable.you_rock);

                if (YourScore < 30 && ComputerScore < 30) {
                    String message = play_turn("rock");
                    tv_declare.setText(message);
                    if (YourScore == 30)
                        tv_declare.setText("Congratulations!!! You won the game.");
                    if (ComputerScore == 30)
                        tv_declare.setText("Don't be sad. Click PLAY AGAIN to start over.");
                }

                if (YourScore <= 30 && ComputerScore <= 30) {
                    b_score.setText("Your Score: " + Integer.toString(YourScore) + "   \t" + "Computer Score: " + Integer.toString(ComputerScore));

                }

                if (YourScore > 30 || ComputerScore > 30)
                    b_score.setText("Your Score: "+Integer.toString(0) + "   \t" + "Computer Score: " +Integer.toString(0));

                if (YourScore == 30 || ComputerScore == 30)
                    b_comment.setText("PLAY AGAIN!");


            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (YourScore < 30 && ComputerScore < 30)
                    iv_YourChoice.setImageResource(R.drawable.you_paper);

                if (YourScore < 30 && ComputerScore < 30) {
                    String message = play_turn("paper");
                    tv_declare.setText(message);

                    if (YourScore == 30)
                        tv_declare.setText("Congratulations!!! You won the game.");
                    if (ComputerScore == 30)
                        tv_declare.setText("Don't be sad. Click PLAY AGAIN to start over.");
                }

                if (YourScore <= 30 && ComputerScore <= 30) {
                    b_score.setText("Your Score: " + Integer.toString(YourScore) + "   \t" + "Computer Score: " + Integer.toString(ComputerScore));

                }

                if (YourScore > 30 || ComputerScore > 30)
                    b_score.setText("Your Score: "+Integer.toString(0) + "   \t" + "Computer Score: " +Integer.toString(0));

                if (YourScore == 30 || ComputerScore == 30)
                    b_comment.setText("PLAY AGAIN!");

            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (YourScore < 30 && ComputerScore < 30)
                    iv_YourChoice.setImageResource(R.drawable.you_scis);

                if (YourScore < 30 && ComputerScore < 30) {
                    String message = play_turn("scissors");
                    tv_declare.setText(message);

                    if (YourScore == 30)
                        tv_declare.setText("Congratulations!!! You won the game.");
                    if (ComputerScore == 30)
                        tv_declare.setText("Don't be sad. Click PLAY AGAIN to start over.");
                }

                if (YourScore <= 30 && ComputerScore <= 30) {
                    b_score.setText("Your Score: " + Integer.toString(YourScore) + "   \t" + "Computer Score: " + Integer.toString(ComputerScore));

                }

                if (YourScore > 30 || ComputerScore > 30)
                    b_score.setText("Your Score: "+Integer.toString(0) + "   \t" + "Computer Score: " +Integer.toString(0));

                if (YourScore == 30 || ComputerScore == 30)
                    b_comment.setText("PLAY AGAIN!");

            }
        });

        b_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (YourScore == 30 || ComputerScore == 30) {
                    Intent Level30 = new Intent(Play30.this, Play30.class);
                    startActivity(Level30);
                }
            }

        });

    }

    public String play_turn (String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        //choose for computer 1,2 or 3
        int computer_choice_number = r.nextInt(3)+1;

        if (computer_choice_number == 1) {
            computer_choice = "rock";
        } else if (computer_choice_number == 2) {
            computer_choice = "paper";
        } else if (computer_choice_number == 3) {
            computer_choice = "scissors";
        }

        //set the computer image based on his choice
        if (computer_choice == "rock") {
            iv_ComputerChoice.setImageResource(R.drawable.comp_rock);
        } else if (computer_choice == "paper") {
            iv_ComputerChoice.setImageResource(R.drawable.comp_paper);
        } else if (computer_choice == "scissors") {
            iv_ComputerChoice.setImageResource(R.drawable.comp_scis);
        }

        //compare human and computer to determine who wins
        if (computer_choice == player_choice) {
            return "TIE. Nobody win.";
        }
        else if (player_choice == "rock" && computer_choice == "scissors") {
            YourScore++;
            return "Rock crushes Scissors. YOU WIN!";
        }
        else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Paper covers Rock. COMPUTER WINS!";
        }
        else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Scissors cuts Paper. COMPUTER WINS!";
        }
        else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Rock crushes Scissors. COMPUTER WINS!";
        }
        else if (player_choice == "scissors" && computer_choice == "paper") {
            YourScore++;
            return "Scissors cuts Paper. YOU WIN!";
        }
        else if (player_choice == "paper" && computer_choice == "rock") {
            YourScore++;
            return "Paper covers Rock. YOU WIN!";
        } else return "Not Sure";

    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
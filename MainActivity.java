package com.example.memorygame;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 60000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    final int MAX_FLIPPED = 2;
    int countFlipped = 0;
    int[] unmatchedButtons = new int [2];
    int[] unmatchedImages = new int [2];
    List<Integer> randomImages = new ArrayList<>();
    List<Integer> randomizedImages = new ArrayList<>();
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    ImageButton one;
    ImageButton two;
    ImageButton three;
    ImageButton four;
    ImageButton five;
    ImageButton six;
    ImageButton seven;
    ImageButton eight;
    ImageButton nine;
    ImageButton ten;
    ImageButton eleven;
    ImageButton twelve;
    ImageButton thirteen;
    ImageButton fourteen;
    ImageButton fifteen;
    ImageButton sixteen;
    TextView outText;
    int scorecounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (ImageButton) findViewById(R.id.one);
        two = (ImageButton) findViewById(R.id.two);
        three = (ImageButton) findViewById(R.id.three);
        four = (ImageButton) findViewById(R.id.four);
        five = (ImageButton) findViewById(R.id.five);
        six = (ImageButton) findViewById(R.id.six);
        seven = (ImageButton) findViewById(R.id.seven);
        eight = (ImageButton) findViewById(R.id.eight);
        nine = (ImageButton) findViewById(R.id.nine);
        ten = (ImageButton) findViewById(R.id.ten);
        eleven = (ImageButton) findViewById(R.id.eleven);
        twelve= (ImageButton) findViewById(R.id.twelve);
        thirteen = (ImageButton) findViewById(R.id.thirteen);
        fourteen = (ImageButton) findViewById(R.id.fourteen);
        fifteen = (ImageButton) findViewById(R.id.fifteen);
        sixteen = (ImageButton) findViewById(R.id.sixteen);
        outText = (TextView) findViewById(R.id.outText);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        one.setImageResource(R.mipmap.blank);
        two.setImageResource(R.mipmap.blank);
        three.setImageResource(R.mipmap.blank);
        four.setImageResource(R.mipmap.blank);
        five.setImageResource(R.mipmap.blank);
        six.setImageResource(R.mipmap.blank);
        seven.setImageResource(R.mipmap.blank);
        eight.setImageResource(R.mipmap.blank);
        nine.setImageResource(R.mipmap.blank);
        ten.setImageResource(R.mipmap.blank);
        eleven.setImageResource(R.mipmap.blank);
        twelve.setImageResource(R.mipmap.blank);
        thirteen.setImageResource(R.mipmap.blank);
        fourteen.setImageResource(R.mipmap.blank);
        fifteen.setImageResource(R.mipmap.blank);
        sixteen.setImageResource(R.mipmap.blank);
        setImages();
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();

}

    public void setImages() {
        randomizedImages.clear();
        randomImages = new ArrayList<>( Arrays.asList(R.mipmap.sheep, R.mipmap.tiger, R.mipmap.panda, R.mipmap.fox, R.mipmap.owl, R.mipmap.giraffe, R.mipmap.chick, R.mipmap.cheetah,
                R.mipmap.sheep, R.mipmap.tiger, R.mipmap.panda, R.mipmap.fox, R.mipmap.owl, R.mipmap.giraffe, R.mipmap.chick, R.mipmap.cheetah));
        int randomNum = (int) (Math.random() * 16);
        int randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 15);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 14);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 13);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 12);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 11);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 10);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 9);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 8);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 7);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 6);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 5);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 4);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 3);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomNum = (int) (Math.random() * 2);
        randomImage = randomImages.get(randomNum);
        randomizedImages.add(randomImage);

        randomImages.remove(randomNum);
        randomImage = randomImages.get(0);
        randomizedImages.add(randomImage);

    }

    public void onClicked(View v) {
        if(mTimerRunning == false)
            return;

        if(countFlipped == MAX_FLIPPED) {
            for(int index = 0; index < MAX_FLIPPED; index++) {
                int id = unmatchedButtons[index];
                switch (id) {
                    case R.id.one:
                        one.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.two:
                        two.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.three:
                        three.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.four:
                        four.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.five:
                        five.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.six:
                        six.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.seven:
                        seven.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.eight:
                        eight.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.nine:
                        nine.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.ten:
                        ten.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.eleven:
                        eleven.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.twelve:
                        twelve.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.thirteen:
                        thirteen.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.fourteen:
                        fourteen.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.fifteen:
                        fifteen.setImageResource(R.mipmap.blank);
                        break;
                    case R.id.sixteen:
                        sixteen.setImageResource(R.mipmap.blank);
                        break;
                }
            }
            countFlipped = 0;
            unmatchedButtons[0] = 0;
            unmatchedButtons[1] = 0;
            unmatchedImages[0] = 0;
            unmatchedImages[1] = 0;
        }
        else {
            final int id = v.getId();
            switch (id) {
                case R.id.one:
                    one.setImageResource(randomizedImages.get(0));
                    unmatchedButtons[countFlipped] = R.id.one;
                    unmatchedImages[countFlipped++] = randomizedImages.get(0);
                    break;
                case R.id.two:
                    two.setImageResource(randomizedImages.get(1));
                    unmatchedButtons[countFlipped] = R.id.two;
                    unmatchedImages[countFlipped++] = randomizedImages.get(1);
                    break;
                case R.id.three:
                    three.setImageResource(randomizedImages.get(2));
                    unmatchedButtons[countFlipped] = R.id.three;
                    unmatchedImages[countFlipped++] = randomizedImages.get(2);
                    break;
                case R.id.four:
                    four.setImageResource(randomizedImages.get(3));
                    unmatchedButtons[countFlipped] = R.id.four;
                    unmatchedImages[countFlipped++] = randomizedImages.get(3);
                    break;
                case R.id.five:
                    five.setImageResource(randomizedImages.get(4));
                    unmatchedButtons[countFlipped] = R.id.five;
                    unmatchedImages[countFlipped++] = randomizedImages.get(4);
                    break;
                case R.id.six:
                    six.setImageResource(randomizedImages.get(5));
                    unmatchedButtons[countFlipped] = R.id.six;
                    unmatchedImages[countFlipped++] = randomizedImages.get(5);
                    break;
                case R.id.seven:
                    seven.setImageResource(randomizedImages.get(6));
                    unmatchedButtons[countFlipped] = R.id.seven;
                    unmatchedImages[countFlipped++] = randomizedImages.get(6);
                    break;
                case R.id.eight:
                    eight.setImageResource(randomizedImages.get(7));
                    unmatchedButtons[countFlipped] = R.id.eight;
                    unmatchedImages[countFlipped++] = randomizedImages.get(7);
                    break;
                case R.id.nine:
                    nine.setImageResource(randomizedImages.get(8));
                    unmatchedButtons[countFlipped] = R.id.nine;
                    unmatchedImages[countFlipped++] = randomizedImages.get(8);
                    break;
                case R.id.ten:
                    ten.setImageResource(randomizedImages.get(9));
                    unmatchedButtons[countFlipped] = R.id.ten;
                    unmatchedImages[countFlipped++] = randomizedImages.get(9);
                    break;
                case R.id.eleven:
                    eleven.setImageResource(randomizedImages.get(10));
                    unmatchedButtons[countFlipped] = R.id.eleven;
                    unmatchedImages[countFlipped++] = randomizedImages.get(10);
                    break;
                case R.id.twelve:
                    twelve.setImageResource(randomizedImages.get(11));
                    unmatchedButtons[countFlipped] = R.id.twelve;
                    unmatchedImages[countFlipped++] = randomizedImages.get(11);
                    break;
                case R.id.thirteen:
                    thirteen.setImageResource(randomizedImages.get(12));
                    unmatchedButtons[countFlipped] = R.id.thirteen;
                    unmatchedImages[countFlipped++] = randomizedImages.get(12);
                    break;
                case R.id.fourteen:
                    fourteen.setImageResource(randomizedImages.get(13));
                    unmatchedButtons[countFlipped] = R.id.fourteen;
                    unmatchedImages[countFlipped++] = randomizedImages.get(13);
                    break;
                case R.id.fifteen:
                    fifteen.setImageResource(randomizedImages.get(14));
                    unmatchedButtons[countFlipped] = R.id.fifteen;
                    unmatchedImages[countFlipped++] = randomizedImages.get(14);
                    break;
                case R.id.sixteen:
                    sixteen.setImageResource(randomizedImages.get(15));
                    unmatchedButtons[countFlipped] = R.id.sixteen;
                    unmatchedImages[countFlipped++] = randomizedImages.get(15);
                    break;
            }

            if(countFlipped == MAX_FLIPPED) {
                if(unmatchedImages[0] == unmatchedImages[1]) {
                    incrementAndSetOutText();
                    countFlipped = 0;
                    unmatchedButtons[0] = 0;
                    unmatchedButtons[1] = 0;
                    unmatchedImages[0] = 0;
                    unmatchedImages[1] = 0;
                }
            }
        }
    }

    private void incrementAndSetOutText() {
        if(scorecounter > 8) {
            scorecounter--;
        }
        scorecounter++;
        outText.setText(scorecounter + "/8");
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("START");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("PAUSE");
        mButtonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("START");
        mButtonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
        scorecounter = 0;
        outText.setText(scorecounter + "/8");
        one.setImageResource(R.mipmap.blank);
        two.setImageResource(R.mipmap.blank);
        three.setImageResource(R.mipmap.blank);
        four.setImageResource(R.mipmap.blank);
        five.setImageResource(R.mipmap.blank);
        six.setImageResource(R.mipmap.blank);
        seven.setImageResource(R.mipmap.blank);
        eight.setImageResource(R.mipmap.blank);
        nine.setImageResource(R.mipmap.blank);
        ten.setImageResource(R.mipmap.blank);
        eleven.setImageResource(R.mipmap.blank);
        twelve.setImageResource(R.mipmap.blank);
        thirteen.setImageResource(R.mipmap.blank);
        fourteen.setImageResource(R.mipmap.blank);
        fifteen.setImageResource(R.mipmap.blank);
        sixteen.setImageResource(R.mipmap.blank);
        setImages();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }

}




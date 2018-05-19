package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String JOKE_BUTTON_TEXT_TAG = "joke_btn_text";

    private Button mJokeButton;
    private FrameLayout mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJokeButton = (Button) findViewById(R.id.joke_button);
        mProgressBar = (FrameLayout) findViewById(R.id.progress_bar_frame);
        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

        if (savedInstanceState != null) {
            mJokeButton.setText(savedInstanceState.getString(JOKE_BUTTON_TEXT_TAG));
        } else {
            setJokeButtonText();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setJokeButtonText();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(JOKE_BUTTON_TEXT_TAG ,mJokeButton.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke() {
        new EndpointsAsyncTask().execute(this);
        mJokeButton.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);

    }

    private void setJokeButtonText() {
        String[] texts = {
                "Hit me hard!",
                "Tell me!",
                "Tell me already!",
                "I am all ears",
                "What are we waiting for?"
        };
        Random r = new Random();
        String text = texts[r.nextInt(texts.length)];
        mJokeButton.setText(text);
        mJokeButton.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}

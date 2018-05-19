package com.example.android.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private final String JOKE_BODY_TAG = "joke_body";
    public  static final String JOKE_INTENT_TAG = "joke_intent";

    private TextView mJokeBody;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        mJokeBody = (TextView) findViewById(R.id.joke_body);
        mBackButton = (Button) findViewById(R.id.back_button);

        if (savedInstanceState != null) {
            mJokeBody.setText(savedInstanceState.getString(JOKE_BODY_TAG));
        } else {
            mJokeBody.setText(getIntent().getStringExtra(JOKE_INTENT_TAG));
        }

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(JOKE_BODY_TAG, mJokeBody.getText().toString());
        super.onSaveInstanceState(outState);
    }
}

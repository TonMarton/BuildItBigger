package com.example.android.jokeactivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/** This is a test to check the workings of the JokeActivity, with a fabricated intent to start with. */

@RunWith(AndroidJUnit4.class)

public class JokeActivityTest {

    private final String mJoke = "This is a joke...";

    @Rule
    public ActivityTestRule<JokeActivity> activityTestRule =
            new ActivityTestRule<JokeActivity>(JokeActivity.class) {
                @Override
                protected Intent getActivityIntent() {
                    Intent resultData = new Intent();
                    resultData.putExtra("joke_intent", mJoke);
                    return resultData;
                }
            };

    @Test
    public void JokeActivityTest() {
        onView(withId(R.id.joke_body)).check(matches(withText(mJoke)));
        onView(withId(R.id.back_button)).perform(click());
    }
}
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.jokeactivity.JokeActivity;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;

/** Since I know that the AsyncTask starts an activity from an intent in postExecute,
 * I intercept the intent and read out the correct extra, to check, if the async task was
 * executed well, or not. */

@RunWith(AndroidJUnit4.class)

public class AsyncTaskTest {

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class);

    @Test
    public void endpointsAsyncTaskTest() {

        onView(withId(R.id.joke_button)).perform(click());

        String joke = "Why did the chicken cross the road? To avoid hearing this jokes for the millionth time...";
        intended(allOf(hasExtras(allOf(hasEntry(equalTo(JokeActivity.JOKE_INTENT_TAG),equalTo(joke))))));

    }
}
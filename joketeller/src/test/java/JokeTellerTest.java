import com.example.android.joketeller.JokeTeller;

import org.junit.Test;

public class JokeTellerTest {

    /** Since the focus of the project was rather on wiring up the modules,
     *  this test is very small as well. */

    @Test
    public void jokeGot() {
        assert !JokeTeller.getJoke().getBody().isEmpty();
    }
}

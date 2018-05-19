package com.example.android.joketeller;

public class JokeTeller {

    private static Joke mDummyJoke = new Joke("The chicken at the road...", "Why did the chicken cross the road? To avoid hearing this jokes for the millionth time...");

    public static final String JOKE_INTENT_TAG = "joke";

    public static Joke getJoke(){
        return mDummyJoke;
    }
}

package com.example.android.joketeller;

/**Simple joke object*/

public class Joke {

    private String mName;
    private String mBody;

    public Joke(String name, String body) {

        mName = name;
        mBody = body;
    }

    public String getName() {
        return mName;
    }

    public String getBody() {
        return mBody;
    }
}

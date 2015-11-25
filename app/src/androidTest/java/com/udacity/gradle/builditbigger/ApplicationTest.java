package com.udacity.gradle.builditbigger;


import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.widget.Button;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
*/
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private static final String LOG_TAG = ApplicationTest.class.getSimpleName();
    JokeEndpointsAsyncTask asyncTask;
    public ApplicationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        asyncTask = new JokeEndpointsAsyncTask();

    }
    @MediumTest
    public void testAsync() {
        String joke = null;
        Button testTellJoke;

        try {
            //MockContext mockContext = new MockContext();
            MainActivity mainActivity = getActivity();
           // Context context = getInstrumentation().getTargetContext().getApplicationContext();
            //testTellJoke = (Button) mainActivity.findViewById(R.id.freeTellJokeButtonId);
            asyncTask.execute(mainActivity);
            joke =  asyncTask.get(35, TimeUnit.SECONDS);
            Log.d(LOG_TAG, joke);
            assertNotNull("Joke String was returned as null", joke);
            Log.d(LOG_TAG, joke);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            fail("Timeout");
        }
    }
}
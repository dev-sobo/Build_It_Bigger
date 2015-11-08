package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    //JokeEndpointsAsyncTask asyncTask;
    public ApplicationTest() {
        super(MainActivity.class);
    }

/*    @Override
    protected void setUp() throws Exception {
        super.setUp();
        asyncTask = new JokeEndpointsAsyncTask();

    }*/
    @MediumTest
    public void testAsync() {
        String joke = null;
        JokeEndpointsAsyncTask asyncTask = new JokeEndpointsAsyncTask();
        try {
            //MockContext mockContext = new MockContext();
           // Context context = getInstrumentation().getTargetContext().getApplicationContext();
            MainActivity mainActivity = getActivity();
            asyncTask.execute(mainActivity);
            joke =  asyncTask.get(35, TimeUnit.SECONDS);
            assertNotNull("Joke String was returned as null", joke);
            Log.d("ACTIVITY TEST", joke);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            fail("Timeout");
        }
    }
}
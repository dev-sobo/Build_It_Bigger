package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {
    JokeEndpointsAsyncTask asyncTask;
    public ApplicationTest() {
        super();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        asyncTask = new JokeEndpointsAsyncTask();

    }
    @MediumTest
    public void testAsync() {
        String joke = null;
        try {
            asyncTask.execute();
            joke =  asyncTask.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            fail("Timeout");
        }
        assertNotNull("Joke String was returned as null", joke);
    }
}
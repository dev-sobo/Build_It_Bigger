package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ian.androidjokelibrary.JokeActivity;
import com.example.ian.myapplication.backend.jokeBeanApi.JokeBeanApi;
import com.example.ian.myapplication.backend.jokeBeanApi.model.JokeBean;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    InterstitialAd mInterstitialAd;
    Button mTellJokeButton;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

       // new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        mTellJokeButton = (Button) findViewById(R.id.freeTellJokeButtonId);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        requestNewInterstitial();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                JokeEndpointsAsyncTask asyncTask = new JokeEndpointsAsyncTask();
                asyncTask.execute(MainActivity.this);
                // requestNewInterstitial();

            }
        });

        //mTellJokeButton.setEnabled(true);


        /*mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                new JokeEndpointsAsyncTask().execute(MainActivity.this);
            }
        });*/


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

    public void tellJoke(View view){
        // TODO: Have this kick off an AsyncTask that
       /* JokesContainer jokesContainer = new JokesContainer();
        String joke = jokesContainer.getJoke();
        Toast.makeText(this,joke , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, joke);
        startActivity(intent);*/
        mTellJokeButton.setEnabled(false);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            new JokeEndpointsAsyncTask().execute(this);
            //mTellJokeButton.setEnabled(false);
        }
        requestNewInterstitial();
        //new JokeEndpointsAsyncTask().execute(this);
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
       // mTellJokeButton.setEnabled(true);
    }
}

 /*
class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1104.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.i("MAINACTIVITY ASYNCTASK", result);
    }
}*/
/*MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.56.1:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/

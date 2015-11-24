package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ian.androidjokelibrary.JokeActivity;
import com.example.ian.myapplication.backend.jokeBeanApi.JokeBeanApi;
import com.example.ian.myapplication.backend.jokeBeanApi.model.JokeBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class JokeEndpointsAsyncTask extends AsyncTask<Context, Void, String> {
   private static JokeBeanApi jokeApiService = null;
   private Context context;

   @Override
   protected String doInBackground(Context... params) {
       if(jokeApiService == null) {
           JokeBeanApi.Builder builder = new JokeBeanApi.Builder(AndroidHttp.newCompatibleTransport(),
                   new AndroidJsonFactory(), null)
                   .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                   .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                       @Override
                       public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                           abstractGoogleClientRequest.setDisableGZipContent(true);
                       }
                   });
           jokeApiService = builder.build();
       }
       context = params[0];


      /* Runnable runnable = new Runnable() {
           @Override
           public void run() {
               button.setEnabled(true);
           }
       };
       runnable.run();*/
       //Looper looper = Looper.getMainLooper();
       //looper.getThread().run();
       /*new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
           @Override
           public void run() {
               button.setEnabled(true);
           }
       }, 1000);*/


       try {
           JokeBean jokeBean = jokeApiService.getJoke(0).execute();
           //return jokeApiService.getJoke(1).execute().getJoke();
           return jokeBean.getJoke();
       } catch (IOException error) {
           return null;
       }

       //return null;
   }

   @Override
   protected void onProgressUpdate(Void... values) {
       //super.onProgressUpdate(values);

   }

   @Override
   protected void onPostExecute(String joke) {
        MainActivity postActivity = (MainActivity) context;
        Button button = (Button) postActivity.findViewById(R.id.freeTellJokeButtonId);
       ProgressBar progressBar = (ProgressBar) postActivity.findViewById(R.id.progressBar);

      // super.onPostExecute(joke);
       if (joke != null && joke != "") {
           Log.d("ON POST EXECUTE", joke);
           Intent intent = new Intent(context, JokeActivity.class);
           intent.putExtra(Intent.EXTRA_TEXT, joke);
           button.setEnabled(true);
           progressBar.setVisibility(View.INVISIBLE);
           context.startActivity(intent);
       }
       else {
           button.setEnabled(true);
           Toast.makeText(context, "Network Error. Check your connection.", Toast.LENGTH_SHORT).show();
       }

   }
}

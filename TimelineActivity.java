package com.codepath.apps.mysimpletweets;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.codepath.apps.mysimpletweets.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends ActionBarActivity {
  private TwitterClient client;
  private ArrayList<Tweet>tweets;
  private TweetsArrayAdapter aTweets;
  private ListView lvTweets;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timeline);
    lvTweets = (ListView) findViewById(R.id.lvTweets);
    lvTweets.setAdapter(aTweets);
    tweets= new ArrayList<>();
    aTweets = new TweetsArrayAdapter(this,tweets);
    client = TwitterApplication.getRestClient(); // Singleton client
    populateTimeline();
  }

  private void populateTimeline() {
    client.getHomeTimeline(new JsonHttpResponseHandler(){

      //succes
      @Override
      public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
        Log.d("DEBUG",json.toString());
        aTweets.addAll(Tweet.fromJSONArray(json));
      }

      //failure
      @Override
      public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        Log.d("DEBUG",errorResponse.toString());
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu (Menu menu){
    getMenuInflater().inflate(R.menu.menu_timeline,menu);
  return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
    int id = item.getItemId();

    if (id == R.id.action_settings){
      return  true;
    }

    return super.onOptionsItemSelected(item);
  }

}

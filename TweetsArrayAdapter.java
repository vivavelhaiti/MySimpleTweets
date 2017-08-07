package com.codepath.apps.mysimpletweets;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.codepath.apps.mysimpletweets.models.Tweet;

import java.util.List;

/**
 * Created by shedeline on 8/6/2017.
 */

public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {
  public TweetsArrayAdapter(@NonNull Context context, List<Tweet> tweets) {
    super(context,android.R.layout.simple_list_item_1, tweets);
  }

  //override nd setup custom template

}

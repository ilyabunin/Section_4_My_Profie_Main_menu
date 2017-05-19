package com.example.ilyab.section_4_my_profie_main_menu.motiv_gym_feed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ilyab.section_4_my_profie_main_menu.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilyab on 05.05.2017.
 */

public class MotivationGymFeed extends Activity {
    private static final String TAG = MotivationGymFeed.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feednews;
    private String URL_FEED = "http://devandcraft.com/test.json";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_feed_gym_news);

        listView = (ListView) findViewById(R.id.list_news_fb_gym);

        feednews = new ArrayList<FeedItem>();

        listAdapter = new FeedListAdapter(this, feednews);
        listView.setAdapter(listAdapter);

        // These two lines not needed,
        // just to get the look of facebook (changing background color & hiding the icon)
//        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3b5998")));
//        getActionBar().setIcon(
//                new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading news from gym...");
        pDialog.show();
        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_FEED);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // making fresh volley request and getting json
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                    URL_FEED, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());

                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {

                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    hidePDialog();
                    ToastError();
                    VolleyLog.d(TAG, "Error: " + error.getMessage());

                }
            });

            // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(jsonReq);
        }

    }

    /**
     * Parsing json reponse and passing the data to feed view list adapter
     * */
    private void parseJsonFeed(JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("feed");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                FeedItem item = new FeedItem();
                item.setId(feedObj.getInt("id"));
                item.setName(feedObj.getString("name"));

                // Image might be null sometimes
                String image = feedObj.isNull("image") ? null : feedObj
                        .getString("image");
                item.setImge(image);
                item.setStatus(feedObj.getString("status"));
                item.setProfilePic(feedObj.getString("profilePic"));
                item.setTimeStamp(feedObj.getString("timeStamp"));

                // url might be null sometimes
                String feedUrl = feedObj.isNull("url") ? null : feedObj
                        .getString("url");
                item.setUrl(feedUrl);

                feednews.add(item);
                hidePDialog();
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    private void ToastError(){
        Toast toast = Toast.makeText(this,"Something wrong. Try to refresh your internet connection",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0,160);
        toast.show();
    }


}
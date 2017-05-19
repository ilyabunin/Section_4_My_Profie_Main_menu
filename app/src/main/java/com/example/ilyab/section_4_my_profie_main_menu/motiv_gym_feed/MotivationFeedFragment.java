package com.example.ilyab.section_4_my_profie_main_menu.motiv_gym_feed;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import static com.example.ilyab.section_4_my_profie_main_menu.R.id.swipe_refresh_layout;

/**
 * Created by ilyab on 05.05.2017.
 */

public class MotivationFeedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = MotivationFeedFragment.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feednews;
    private String URL_FEED = "http://devandcraft.com/test7.json";
    SwipeRefreshLayout swipeLayout;
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.activity_motivation_feed_gym_news, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        swipeLayout = (SwipeRefreshLayout) getView().findViewById(swipe_refresh_layout);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(true);

                initControls();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        initControls();
        super.onResume();
    }

    @Override
    public void onStart() {

            listView = (ListView) getActivity().findViewById(R.id.list_news_fb_gym);

            feednews = new ArrayList<FeedItem>();

            listAdapter = new FeedListAdapter(getActivity(), feednews);
            listView.setAdapter(listAdapter);


        super.onStart();


    }

    @SuppressLint("NewApi")
    public void initControls() {




//        // These two lines not needed,
//        // just to get the look of facebook (changing background color & hiding the icon)
//        getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3b5998")));
//        getActivity().getActionBar().setIcon(
//                new ColorDrawable(getResources().getColor(android.R.color.transparent)));

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
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

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
     */
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

            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        swipeLayout.setRefreshing(false);
    }



    private void ToastError() {
        Toast toast = Toast.makeText(getActivity(), "Something wrong. Try to refresh your internet connection", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();

    }

    @Override
    public void onRefresh() {
        initControls();
    }

    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }
}


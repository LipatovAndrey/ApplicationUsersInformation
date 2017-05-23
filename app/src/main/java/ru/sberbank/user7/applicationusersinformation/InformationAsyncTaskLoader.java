package ru.sberbank.user7.applicationusersinformation;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user7 on 23.05.2017.
 */

public class InformationAsyncTaskLoader extends AsyncTaskLoader<String> {

    public InformationAsyncTaskLoader(Context context) {
                super(context);
        Log.e( "ConstructorLoader", "1" );
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        String line=null;
        HttpURLConnection connection = null;
        JSONArray arrayJSON;
        Log.e( "LoadInBackground", "1" );
            URL myURL = null;
          try {
                myURL = new URL("https://api.github.com/users?");
                connection = (HttpURLConnection) myURL.openConnection();
                connection.setRequestMethod("GET");
                InputStreamReader br = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(br);
                line = bufferedReader.readLine();
                Log.e( "LoaderDeliver result", line);
                arrayJSON = new JSONArray(line);

                Log.e( "LoaderDeliver result", String.valueOf(arrayJSON.length()));
                connection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
              e.printStackTrace();
          }
        return "finish";
    }

    @Override
    public void deliverResult(String data) {
        super.deliverResult(data);
        Log.e( "LoaderDeliver result", data);
    }
}

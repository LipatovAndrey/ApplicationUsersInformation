package ru.sberbank.user7.applicationusersinformation;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportLoaderManager().initLoader(1, null, new InformationAcyncTaskLoader());
        listView = (ListView) findViewById(R.id.listView);


    }

        class InformationAcyncTaskLoader implements LoaderManager.LoaderCallbacks<String>{
            @Override
            public Loader onCreateLoader(int id, Bundle args) {
                return new InformationAsyncTaskLoader(MainActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<String> loader, String data) {
                listView.setAdapter(new MyLoginsAdapter());
            }


            @Override
            public void onLoaderReset(Loader loader) {

            }
        }
}

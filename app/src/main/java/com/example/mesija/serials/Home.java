package com.example.mesija.serials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getIndexMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public boolean getIndexMenu() {
        String matchtemper = "";
        try
        {
            URL url = new URL("http://c.mesija.net/catwoman/");
            URLConnection conn = url.openConnection();
            InputStreamReader rd = new InputStreamReader(conn.getInputStream());
            StringBuilder allPage = new StringBuilder();
            int n = 0;
            char[] buffer = new char[40000];
            while (n >= 0)
            {
                n = rd.read(buffer, 0, buffer.length);
                if (n > 0)
                {
                    allPage.append(buffer, 0, n);
                }
            }

            setContentView(R.layout.activity_home);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(allPage.toString());
            return true;
        }
        catch (Exception e)
        {
            String matchtemper2 = e.getMessage();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_settings:
                setContentView(R.layout.activity_settings);
                Toolbar toolbarSettings = (Toolbar) findViewById(R.id.toolbarSettings);
                setSupportActionBar(toolbarSettings);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setTitle("Settings");
                return true;
            case android.R.id.home:
                setContentView(R.layout.activity_home);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

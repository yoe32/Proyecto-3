package com.dev.p3.bus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {

    private ListView mDrawerList;
    // nav drawer title
    // used to store app title
    private CharSequence mTitle;
    // slide menu items
    private String[] navMenuTitles;
    private NavDrawerItem[] navDrawerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        // adding nav drawer items to array

        navDrawerItems = new NavDrawerItem[]
                {
                        new NavDrawerItem("Geannie Sharel"),
                        new NavDrawerItem("Juan Perez"),
                        new NavDrawerItem("Yohel Solis"),
                        new NavDrawerItem("Flury Heart"),
                        new NavDrawerItem("Pooopa")
                };
        NavDrawerListAdapter  navDrawerListAdapter= new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);

        mDrawerList.setAdapter(navDrawerListAdapter);

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    /**
     * Slide menu item click listener
     */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            Intent intent = new Intent(RouteActivity.this,BusActivity.class);
            startActivity(intent);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title

        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items

        return super.onPrepareOptionsMenu(menu);
    }
    /**
     * Diplaying fragment view for selected nav drawer list item
     */
    private void displayView(int position) {

        // update the main content by replacing fragments
        Fragment fragment = null;

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);

        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
     class NavDrawerListAdapter extends ArrayAdapter
    {
        public NavDrawerListAdapter(Context context, NavDrawerItem[] navDrawerItems){
            super(context,R.layout.drawer_list_item, navDrawerItems);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
               convertView= inflater.inflate(R.layout.drawer_list_item, null);
            }
            TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
            txtTitle.setText(navDrawerItems[position].getTitle());
            // displaying count
            // check whether it set visible or not
            return convertView;
        }
    }
}
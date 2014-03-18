package com.gmail.sihuih.ECSEventsFeed.pictureClasses;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gmail.sihuih.ECSEventsFeed.R;

public class acmcoding extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acmcoding);
		 //action bar and up button
        ActionBar actionBar = getActionBar(); 
        actionBar.setTitle("ECS Events Feed"); 
        actionBar.setDisplayHomeAsUpEnabled(true); 
        actionBar.setIcon(R.drawable.ic_launcher); 
    }
	//action bar and up button
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case android.R.id.home:
	        finish();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
}

package com.gmail.sihuih.ECSEventsFeed.pictureClasses;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.gmail.sihuih.ECSEventsFeed.R;
import com.loopj.android.image.SmartImageView;

public class displayPic  extends Activity {
	
	// JSON node keys
	private static final String TAG_PICTURE = "picture";

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_pic);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String pictureURL = in.getStringExtra(TAG_PICTURE);
        SmartImageView eventPicture = (SmartImageView) findViewById(R.id.eventpic); 
        eventPicture.setImageUrl(pictureURL);
        
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


package com.gmail.sihuih.ECSEventsFeed.fragments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.gmail.sihuih.ECSEventsFeed.R;
import com.gmail.sihuih.ECSEventsFeed.JSON.ServiceHandler;
import com.gmail.sihuih.ECSEventsFeed.indexableListView.ContentAdapter_Feb;
import com.gmail.sihuih.ECSEventsFeed.indexableListView.IndexableListView;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.displayPic;

/**
 * 
 * @author sihui
 * For Oct_2013 Nov_2013 Dec_2013: 
 * The titles of events and pictures of events are hard-coded into the app.
 * 
 * For Jan_2014 Feb_2014 Mar_2014 Apr_2014 May_2014: 
 * Informations of the events will be pulled from database through network connections, using JSON  
 *
 * 
 */

public class Feb_2014_Event_Fragment extends Fragment
{
 	
	private ProgressDialog pDialog;
  		 
	private IndexableListView   _list;

	private ContentAdapter_Feb _adapter;

	Context                 _context;

	private ViewGroup       _root;

	private ArrayList<String> mItems;
  
  	//events JSONArray
	JSONArray events = null;
  	
  	//Hashmap for ListView
  	ArrayList<HashMap<String, String>> eventsList;
  	
  	//JSON Node names
  	private static final String TAG_Events = "events";
	private static final String TAG_TITLE = "title";
	private static final String TAG_PICTURE = "picture";
		
	// URL to get events JSON
	private static String url = "http://ecseventsfeed.x10.mx/AndroidApp_ecs_events_feed/ecs_eventslist_feb2014";
	
  
  public Feb_2014_Event_Fragment()
  {

  }

  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
	  _context = getActivity().getApplication().getApplicationContext();
	  eventsList = new ArrayList<HashMap<String, String>>();
	  mItems = new ArrayList<String>();
	  _root = (ViewGroup) inflater.inflate(R.layout.test_layout, null);
      _list = (IndexableListView) _root.findViewById(R.id.listview);
      _list.setFastScrollEnabled(true);
      
      /**get data**/
      new RetreiveDataTask().execute();   
      /**End Get Data**/ 	
	  
      _list.setOnItemClickListener(new OnItemClickListener() {

	    		@Override
	    		public void onItemClick(AdapterView<?> parent, View view,
	    				int position, long id) {
	    			// getting values from selected ListItem	    			
	    			String picture = eventsList.get(position).get(TAG_PICTURE);
	    			
	    			// Starting new intent
	    			Intent in = new Intent(_context, displayPic.class);
	    			in.putExtra(TAG_PICTURE, picture);
	    			startActivity(in);

	    		}
	    	});
     
    return _root;
  }
class RetreiveDataTask extends AsyncTask<Void, Void, Void> {
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// Showing progress dialog
		//pDialog = new ProgressDialog(getActivity());
		//pDialog.setMessage("Please wait...");
		//pDialog.setCancelable(false);
		//pDialog.show();

	}
		
	@Override
	protected Void doInBackground(Void... arg0) {
		// Creating service handler class instance
		ServiceHandler sh = new ServiceHandler();

		// Making a request to url and getting response
		String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

		Log.d("Response: ", "> " + jsonStr);

		if (jsonStr != null) {
			try {
				JSONObject jsonObj = new JSONObject(jsonStr);
				
				// Getting JSON Array node
				events = jsonObj.getJSONArray(TAG_Events);
			      
			    		for(int i = 0; i < events.length(); i++){
			    			
			    			JSONObject c = events.getJSONObject(i);
			    					
			    			// Storing each json item in variable
			    			String title = c.getString(TAG_TITLE);
			    			String picture = c.getString(TAG_PICTURE);
			    					
			    			// creating new HashMap
			    			HashMap<String, String> map = new HashMap<String, String>();
			    					
			    			// adding each child node to HashMap key => value
			    			map.put(TAG_TITLE, title);
			    			map.put(TAG_PICTURE, picture);

			    			// adding HashList to ArrayList
			    			eventsList.add(map);
			    				}
			    			} catch (JSONException e) {
			    				e.printStackTrace();
			    			}
			            
			        } 
		return null;
	      }

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		// Dismiss the progress dialog
		//if (pDialog.isShowing())
		//	pDialog.dismiss();
		
		/**Add event titles to the list**/
		 for(int i =0;i<eventsList.size();i++){
		    	mItems.add(eventsList.get(i).get(TAG_TITLE));
		    }
		/**End adding event titles**/
		Collections.sort(mItems);
		_adapter = new ContentAdapter_Feb(_context,android.R.layout.simple_list_item_1, mItems);  		     	     		 
		_list.setAdapter(_adapter);
	}
}
}


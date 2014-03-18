package com.gmail.sihuih.ECSEventsFeed.fragments;
import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.gmail.sihuih.ECSEventsFeed.R;
import com.gmail.sihuih.ECSEventsFeed.indexableListView.ContentAdapter_Dec;
import com.gmail.sihuih.ECSEventsFeed.indexableListView.IndexableListView;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ECS_Winter_Workshop_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ireland_internship_program_Pic;

/**
 * 
 * @author sihui
 * For Oct_2013 Nov_2013 Dec_2013: 
 * The titles of events and pictures of events are hard-coded into the app.
 * 
 * For Jan_2014 Feb_2014 Mar_2014 Apr_2014 May_2014: 
 * Informations of the events will be pulled from database through network connections  
 *
 */

public class Dec_2013_Event_Fragment extends Fragment
{

  
  private IndexableListView        _list;

  private ContentAdapter_Dec _adapter;

  Context                 _context;

  private ViewGroup       _root;

  private ArrayList<String> mItems;
  
  public Dec_2013_Event_Fragment()
  {

  }

  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
	  _context = getActivity().getApplication().getApplicationContext();


      mItems = new ArrayList<String>();
      mItems.add("12/05 Ireland Internship Program Info Session");
      mItems.add("12/27 ECS Advanced Java (prep for Android app development) Register@bit.ly/utdwcamp");         
      mItems.add("12/27 ECS Advanced Java (prep for Android app development) Register@bit.ly/utdwcamp"); 
      mItems.add("12/23 ECS Intro to Programming Competitions Register@bit.ly/utdwcamp"); 
      mItems.add("12/23 ECS Objective C (prep for iOS app development) Register@bit.ly/utdwcamp"); 
      mItems.add("12/24 ECS Intro to Progamming Competitions Register@bit.ly/utdwcamp"); 
      mItems.add("12/27 ECS OOP in Java using Robots Register@bit.ly/utdwcamp"); 
      mItems.add("12/30 ECS Android app development Register@bit.ly/utdwcamp"); 
      mItems.add("12/30 ECS Build web-site with database back-end Register@bit.ly/utdwcamp"); 
      mItems.add("12/31 ECS Android app development Register@bit.ly/utdwcamp"); 
      mItems.add("12/31 ECS OOP in C++ using Robots Register@bit.ly/utdwcamp"); 
      Collections.sort(mItems);
	_adapter = new ContentAdapter_Dec(_context,android.R.layout.simple_list_item_1, mItems);	
	_root = (ViewGroup) inflater.inflate(R.layout.test_layout, null);
	_list = (IndexableListView) _root.findViewById(R.id.listview);	     		 
	_list.setAdapter(_adapter);
	_list.setFastScrollEnabled(true); 
	_list.setOnItemClickListener(new OnItemClickListener() {
	
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		switch (position) {
			case 0:
			startActivity(new Intent(_context, ireland_internship_program_Pic.class));
			break;
			case 1:
			startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
			break;
			case 2:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 3:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 4:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 5:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 6:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 7:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 8:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 9:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
			case 10:
				startActivity(new Intent(_context, ECS_Winter_Workshop_Pic.class));
				break;
		}
	}
	});

    return _root;
  }
  
}

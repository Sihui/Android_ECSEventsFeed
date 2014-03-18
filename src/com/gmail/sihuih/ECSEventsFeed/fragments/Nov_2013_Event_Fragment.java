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
import com.gmail.sihuih.ECSEventsFeed.indexableListView.ContentAdapter_Nov;
import com.gmail.sihuih.ECSEventsFeed.indexableListView.IndexableListView;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.acmparson;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.att_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.careerdev_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.cloudcomputing;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ecsdean_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ireland_internship_program_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.lanparty_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.linuxamazon;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.luckwarm_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.same_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.shegeneralmeeting;

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

public class Nov_2013_Event_Fragment extends Fragment
{

	  
	  private IndexableListView        _list;

	  private ContentAdapter_Nov _adapter;

	  Context                 _context;

	  private ViewGroup       _root;

	  private ArrayList<String> mItems;
	  
	  public Nov_2013_Event_Fragment()
	  {

	  }

	  
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	  {
		  _context = getActivity().getApplication().getApplicationContext();


	      mItems = new ArrayList<String>();
	      mItems.add("11/04 IEEE AT&T - Antenna Solutions Group");
	      mItems.add("11/06 SAME Networking & Information Session");         
	      mItems.add("11/06 Ireland-internship-program-Information Sessions"); 
	      mItems.add("11/07 ACM Luckwarm Media Game Development Talk and Q&A Session"); 
	      mItems.add("11/09 Career Development Forum"); 
	      mItems.add("11/13 ECS Hear and Be Heard Jonsson School-Meet the Dean Event"); 
	      mItems.add("11/15 ACM & IEEE Lan Party"); 
	      mItems.add("11/16  Cloud Computing Techs"); 
	      mItems.add("11/18 Ireland-internship-program-Information Sessions"); 
	      mItems.add("11/19 The Linux Users Group-Amazon Web Services"); 
	      mItems.add("11/20 SHPE General Meeting"); 
	      mItems.add("11/21 ACM Parsons The Past & Future of Information Tech-An Industry Perspective"); 	      
	      Collections.sort(mItems);
	      
		_adapter = new ContentAdapter_Nov(_context,android.R.layout.simple_list_item_1, mItems);
		_root = (ViewGroup) inflater.inflate(R.layout.test_layout, null);
		_list = (IndexableListView) _root.findViewById(R.id.listview);	     		 
		_list.setAdapter(_adapter);
		_list.setFastScrollEnabled(true); 
		_list.setOnItemClickListener(new OnItemClickListener() {
		
		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
			switch (position) {
				case 0:
				startActivity(new Intent(_context, att_Pic.class));
				break;
				case 1:
				startActivity(new Intent(_context, ireland_internship_program_Pic.class));
				break;
				case 2:
					startActivity(new Intent(_context, same_Pic.class));
					break;
				case 3:
					startActivity(new Intent(_context, luckwarm_Pic.class));
					break;
				case 4:
					startActivity(new Intent(_context, careerdev_Pic.class));
					break;
				case 5:
					startActivity(new Intent(_context, ecsdean_Pic.class));
					break;
				case 6:
					startActivity(new Intent(_context, lanparty_Pic.class));
					break;
				case 7:
					startActivity(new Intent(_context, cloudcomputing.class));
					break;
				case 8:
					startActivity(new Intent(_context, ireland_internship_program_Pic.class));
					break;
				case 9:
					startActivity(new Intent(_context, linuxamazon.class));
					break;
				case 10:
					startActivity(new Intent(_context, shegeneralmeeting.class));
					break;
				case 11:
					startActivity(new Intent(_context, acmparson.class));
					break;
			}
		}
		});

	    return _root;
	  }
	  
	}


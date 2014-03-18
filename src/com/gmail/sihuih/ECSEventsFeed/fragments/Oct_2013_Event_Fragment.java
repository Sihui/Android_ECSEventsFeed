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
import com.gmail.sihuih.ECSEventsFeed.indexableListView.ContentAdapter_Oct;
import com.gmail.sihuih.ECSEventsFeed.indexableListView.IndexableListView;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.acmcoding;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ccadvice;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.dance;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.dia;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.grad;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ieeeit;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ieeetech;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.ireland_internship_program_Pic;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.par;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.shefourth;
import com.gmail.sihuih.ECSEventsFeed.pictureClasses.team;

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

public class Oct_2013_Event_Fragment extends Fragment
{

  
  private IndexableListView        _list;

  private ContentAdapter_Oct _adapter;

  Context                 _context;

  private ViewGroup       _root;

  private ArrayList<String> mItems;
  
  public Oct_2013_Event_Fragment()
  {

  }

  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
	  _context = getActivity().getApplication().getApplicationContext();


      mItems = new ArrayList<String>();
      mItems.add("10/03 ACM Coding Competition");
      mItems.add("10/07 IEEE TI Guest Speach Change the World Love Your Job");         
      mItems.add("10/08 Ireland Internship Program Information Sessions"); 
      mItems.add("10/11 Career Center-Career Advice & A slice"); 
      mItems.add("10/11 SHPE Salsa Dancing"); 
      mItems.add("10/14 IEEE Tech Talk featuring Intel Drive to Exascale Analytics"); 
      mItems.add("10/14 Ireland Internship Program Information Sessions"); 
      mItems.add("10/16 SHPE 4th General Meeting"); 
      mItems.add("10/17 Grad School Expo Day"); 
      mItems.add("10/22 The Parallels Between Job Seeking and Dating"); 
      mItems.add("10/25 ACM Team Fortress 2 Lan Party");
      mItems.add("10/25 Ireland Internship Program Information Sessions"); 
      mItems.add("10/29 Ireland Internship Program Information Sessions"); 
      mItems.add("10/31 SHE DIA DE LOS MUERTOS"); 
      Collections.sort(mItems);
      
	_adapter = new ContentAdapter_Oct(_context,android.R.layout.simple_list_item_1, mItems);
	_root = (ViewGroup) inflater.inflate(R.layout.test_layout, null);
	_list = (IndexableListView) _root.findViewById(R.id.listview);	     		 
	_list.setAdapter(_adapter);
	_list.setFastScrollEnabled(true); 
	_list.setOnItemClickListener(new OnItemClickListener() {
	
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		switch (position) {
			case 0:
			startActivity(new Intent(_context, acmcoding.class));
			break;
			case 1:
			startActivity(new Intent(_context, ieeeit.class));
			break;
			case 2:
				startActivity(new Intent(_context, ireland_internship_program_Pic.class));
				break;
			case 3:
				startActivity(new Intent(_context, ccadvice.class));
				break;
			case 4:
				startActivity(new Intent(_context, dance.class));
				break;
			case 5:
				startActivity(new Intent(_context, ieeetech.class));
				break;
			case 6:
				startActivity(new Intent(_context, ireland_internship_program_Pic.class));
				break;
			case 7:
				startActivity(new Intent(_context, shefourth.class));
				break;
			case 8:
				startActivity(new Intent(_context, grad.class));
				break;
			case 9:
				startActivity(new Intent(_context, par.class));
				break;
			case 10:
				startActivity(new Intent(_context, team.class));
				break;
			case 11:
				startActivity(new Intent(_context, ireland_internship_program_Pic.class));
				break;	
			case 12:
				startActivity(new Intent(_context, ireland_internship_program_Pic.class));
				break;	
			case 13:
				startActivity(new Intent(_context, dia.class));
				break;
		}
	}
	});

    return _root;
  }
  
}

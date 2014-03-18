package com.gmail.sihuih.ECSEventsFeed.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.sihuih.ECSEventsFeed.R;

public class about_Fragment extends Fragment{
private View root;
	public about_Fragment(){}
	
	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	  {
		root=(View) inflater.inflate(R.layout.about_page, null);
		return root;
	}
}

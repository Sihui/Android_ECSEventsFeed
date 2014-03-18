package com.gmail.sihuih.ECSEventsFeed;

import com.gmail.sihuih.ECSEventsFeed.fragments.*;
import com.gmail.sihuih.ECSEventsFeed.fragments.about_Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;




public class MyFragmentPagerAdapter extends FragmentPagerAdapter
{

  
  private static final String[] CONTENT = new String[] { "About", "2013 Oct.","2013 Nov.", "2013 Dec.","2014 Jan.","2014 Feb.","2014 Mar.","2014 Apr.","2014 May."};
  
  public MyFragmentPagerAdapter(FragmentManager fm)
  {

    super(fm);
  }

  @Override
  public Fragment getItem(int position)
  {

    Fragment f = new Fragment();
    switch (position)
    {
      case 0:
        f = new about_Fragment();
        break;
     case 1:
        f = new Oct_2013_Event_Fragment();
        break;
     case 2:
       f = new Nov_2013_Event_Fragment();
       break;
    case 3:
       f = new Dec_2013_Event_Fragment();
       break;
    case 4:
      f = new Jan_2014_Event_Fragment();
      break;
    case 5:
        f = new Feb_2014_Event_Fragment();
        break;
    case 6:
        f = new Mar_2014_Event_Fragment();
        break;
    case 7:
        f = new Apr_2014_Event_Fragment();
        break;
    case 8:
        f = new May_2014_Event_Fragment();
        break;
    }
    return f;
  }

  @Override
  public int getCount()
  {
    return 9;
  }

  
  
  @Override
  public CharSequence getPageTitle(int position)
  {

    return CONTENT[position % CONTENT.length].toUpperCase();
  }
}

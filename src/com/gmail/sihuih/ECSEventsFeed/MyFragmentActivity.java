
package com.gmail.sihuih.ECSEventsFeed;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;

public class MyFragmentActivity extends FragmentActivity
{

  MyFragmentPagerAdapter _adapter;

  private ViewPager        _mViewPager;

  public MyFragmentActivity()
  {

  }

  @Override
  protected void onCreate(Bundle arg0)
  {requestWindowFeature(Window.FEATURE_NO_TITLE);  
 
    super.onCreate(arg0);
    setContentView(R.layout.simple_tabs);
    _mViewPager = (ViewPager) findViewById(R.id.pager);

    _adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
    _mViewPager.setAdapter(_adapter);
    _mViewPager.setCurrentItem(0);

    TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
    indicator.setViewPager(_mViewPager);

  }

}

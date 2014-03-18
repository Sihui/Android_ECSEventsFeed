package com.gmail.sihuih.ECSEventsFeed.indexableListView;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.gmail.sihuih.ECSEventsFeed.indexableListView.StringMatcher;

public class ContentAdapter_Feb extends ArrayAdapter<String> implements SectionIndexer {
	
	private String mSections ="02/0102/0202/0302/0402/0502/0602/0702/0802/0902/10"
								+"02/1102/1202/1302/1402/1502/1602/1702/1802/1902/20"
								+"02/2102/2202/2302/2402/2502/2602/2702/2802/29";
	
	
	public ContentAdapter_Feb(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		
	}

	@Override
	public int getPositionForSection(int section) {		
		// If there is no item for current section, previous section will be selected
		for (int i = section; i >= 0; i--) {
			for (int j = 0; j < getCount(); j++) {
				{
					if (StringMatcher.match(String.valueOf(getItem(j).charAt(3)),
							String.valueOf(getItem(j).charAt(4)), String.valueOf((mSections.toString()).charAt(i*5+3)),
							String.valueOf((mSections.toString()).charAt(i*5+4))))
						return j;
				}
			}
		}
		return 0;
	}

	@Override
	public int getSectionForPosition(int position) {
		return 0;
	}

	@Override
	public Object[] getSections() {
		String[] sections = new String[(mSections.toString()).length()];
		for (int i = 0; i < (mSections.toString()).length(); i++){
			sections[i] = String.valueOf((mSections.toString()).charAt(i));
			}
		return sections;
	}

	/**customize text view**/
	@Override
	 public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setPadding(30, 15, 20,15);
        textView.setTextSize(20);
        return textView;
    }	
	
}

package com.gmail.sihuih.ECSEventsFeed.indexableListView;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.gmail.sihuih.ECSEventsFeed.indexableListView.StringMatcher;

public class ContentAdapter_Apr extends ArrayAdapter<String> implements SectionIndexer {
	
	private String mSections ="04/0104/0204/0304/0404/0504/0604/0704/0804/0904/10"
								+"04/1104/1204/1304/1404/1504/1604/1704/1804/1904/20"
								+"04/2104/2204/2304/2404/2504/2604/2704/2804/2904/30";
	
	
	public ContentAdapter_Apr(Context context, int textViewResourceId,
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

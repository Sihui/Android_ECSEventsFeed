package com.gmail.sihuih.ECSEventsFeed.indexableListView;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.gmail.sihuih.ECSEventsFeed.indexableListView.StringMatcher;

public class ContentAdapter_May extends ArrayAdapter<String> implements SectionIndexer {
	
	private String mSections ="05/0105/0205/0305/0405/0505/0605/0705/0805/0905/10"
								+"05/1105/1205/1305/1405/1505/1605/1705/1805/1905/20"
								+"05/2105/2205/2305/2405/2505/2605/2705/2805/2905/3005/31";
	
	
	public ContentAdapter_May(Context context, int textViewResourceId,
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

package com.gmail.sihuih.ECSEventsFeed.indexableListView;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.gmail.sihuih.ECSEventsFeed.indexableListView.StringMatcher;

public class ContentAdapter_Nov extends ArrayAdapter<String> implements SectionIndexer {
	
	private String mSections ="11/0111/0211/0311/0411/0511/0611/0711/0811/0911/10"
								+"11/1111/1211/1311/1411/1511/1611/1711/1811/1911/20"
								+"11/2111/2211/2311/2411/2511/2611/2711/2811/2911/30";
	
	public ContentAdapter_Nov(Context context, int textViewResourceId,
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

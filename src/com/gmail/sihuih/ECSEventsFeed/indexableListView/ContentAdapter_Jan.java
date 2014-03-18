package com.gmail.sihuih.ECSEventsFeed.indexableListView;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.gmail.sihuih.ECSEventsFeed.indexableListView.StringMatcher;

public class ContentAdapter_Jan extends ArrayAdapter<String> implements SectionIndexer {
	
	private String mSections ="01/0101/0201/0301/0401/0501/0601/0701/0801/0901/10"
								+"01/1101/1201/1301/1401/1501/1601/1701/1801/1901/20"
								+"01/2101/2201/2301/2401/2501/2601/2701/2801/2901/3001/31";
	
	
	public ContentAdapter_Jan(Context context, int textViewResourceId,
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

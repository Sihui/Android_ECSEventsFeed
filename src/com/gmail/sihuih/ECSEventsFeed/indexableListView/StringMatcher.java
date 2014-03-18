package com.gmail.sihuih.ECSEventsFeed.indexableListView;


public class StringMatcher {
	public static boolean match(String value1,String value2, String keyword1,String keyword2){
		if (value1 == null || keyword1 == null) 
			return false;
		if (keyword1.length() > value1.length())
			return false; 
		int i = 0, j = 0;
		do {
			if (keyword1.charAt(j) == value1.charAt(i)) {
				i++;
				j++;
			} else if (j > 0)
				break;
			else
				i++;
		} while (i < value1.length() && j < keyword1.length()); 
		if(j == keyword1.length()){
			if (value2 == null || keyword2 == null) 
				return false;
			if (keyword2.length() > value2.length())
				return false; 
			int x = 0, y = 0;
			do {
				if (keyword2.charAt(y) == value2.charAt(x)) {
					x++;
					y++;
				} else if (y > 0)
					break;
				else
					x++;
			} while (x < value2.length() && y < keyword2.length()); 
			return (y == keyword2.length()) ? true : false;
		} 
		else{return false;}
		
	} 
}

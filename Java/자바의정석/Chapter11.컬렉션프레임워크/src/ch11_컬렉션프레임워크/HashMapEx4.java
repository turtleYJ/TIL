package ch11_컬렉션프레임워크;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		
		HashMap map = new HashMap();
		
		for (String s : data) {
			if (map.containsKey(s)) {
				Integer value = (Integer)map.get(s);
				map.put(s, Integer.valueOf(value + 1));
			} else {
				map.put(s, Integer.valueOf(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		
		return new String(bar);
	}
}

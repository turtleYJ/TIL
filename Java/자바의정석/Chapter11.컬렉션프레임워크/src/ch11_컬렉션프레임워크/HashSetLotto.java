package ch11_컬렉션프레임워크;

import java.util.*;

public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		for (int i = 0; 6 > set.size(); i++) {
			set.add((int)(Math.random()*45) + 1);
		}
		
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
	}
}

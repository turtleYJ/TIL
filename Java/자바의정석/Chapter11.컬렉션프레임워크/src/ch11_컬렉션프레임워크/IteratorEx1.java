package ch11_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) System.out.println(it.next());
	}
}

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
		
		while (it.hasNext()) {
			System.out.println(it.next());
			// 넥스트 이후에 리무브를 하면 해당 값이 삭제된다.(추출 후 삭제)
//			it.remove();
		}
		
		System.out.println(list);
	}
}

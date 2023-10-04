package ch11_컬렉션프레임워크;

import java.util.*;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-1111");
		addPhoneNo("친구", "김자바", "010-333-1111");
		addPhoneNo("회사", "김대리", "010-444-1111");
		addPhoneNo("회사", "김대리", "010-555-1111");
		addPhoneNo("회사", "박대리", "010-666-1111");
		addPhoneNo("회사", "이과장", "010-777-1111");
		addPhoneNo("세탁", "010-888-1111");
		
		printList();
	}
	
	// 전화번호를 추가하는 메서드
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel, name);
	}
	
	// 기타 그
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap());
		}
	}
	
	// 전화번호부 전체를 출력하는 메서드
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			
			String groupName = (String)e.getKey();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(" * " + groupName + "[" + subSet.size() + "]");
			
			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				System.out.println(subE.getValue() + " " + subE.getKey());
			}
			
			System.out.println();
		}
	}
}

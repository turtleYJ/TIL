package ch11_컬렉션프레임워크;

import java.util.*;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", Integer.valueOf(100));
		map.put("이자바", Integer.valueOf(100));
		map.put("강자바", Integer.valueOf(80));
		map.put("안자바", Integer.valueOf(90));
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
		Set keySet = map.keySet();
		System.out.println("참가자 명단 : " + keySet);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total += i;
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}

package ch11_컬렉션프레임워크;
import java.util.*;
import static java.util.Collections.*;

public class CollectionsEx {
	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list);
		
		addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		rotate(list, 2); // 오른쪽으로 두 칸씩 이동
		System.out.println(list);
		
		swap(list, 0, 2); // 첫 번째와 세 번째를 교환
		System.out.println(list);
		
		shuffle(list);
		System.out.println(list); // 저장된 요소의 위치를 임의로 변경
		
		sort(list, reverseOrder()); // 역순으로 정렬함
		System.out.println(list);
		
		sort(list);
		System.out.println(list);
		
		int idx = binarySearch(list, 3);
		System.out.println("index of 3 = " + idx);
		
		System.out.println("max=" + max(list));
		System.out.println("min=" + min(list));
		System.out.println("min=" + max(list, reverseOrder()));
		
		fill(list, 9);
		System.out.println(list); // list를 9로 채운다.
		
		// list와 같은 크기의 새로운 list를 생성하고 2로 채운다.
		List newList = nCopies(list.size(), 2);
		System.out.println("newList=" + newList);
		
		System.out.println(disjoint(list, newList)); // 공통요소가 없으면 true
		
		copy(list, newList); // newList를 카피해서 list를 만들어준다.
		System.out.println("newList=" + newList);
		System.out.println("List=" + list);
		
		replaceAll(list, 2, 1); // list의 모든 2를 1로 변경한다.
		System.out.println("List=" + list);
		
		Enumeration e = enumeration(list);
		ArrayList list2 = list(e); // Collections클래스의 list메서드가 열거형 객체인 Enumeration을 ArrayList로 변환
		
		System.out.println("List2=" + list2);
		
	}
}

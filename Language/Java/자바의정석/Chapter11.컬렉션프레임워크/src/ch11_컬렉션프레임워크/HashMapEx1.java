package ch11_컬렉션프레임워크;

import java.util.*;

// 해시맵을 통해서 비밀번호 인증 시스템을 만든다.
public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
//		System.out.println(map);
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("id와 passwd를 입력해 주세요.");
			System.out.print("id : ");
			String id = sc.nextLine().trim();
			
			System.out.print("passwd : ");
			String pw = sc.nextLine().trim();
			System.out.println();
			
			if (!map.containsKey(id)) {
				System.out.println("아이디가 존재하지 않습니다.");
				
				continue;
			}
			
			if (map.get(id).equals(pw)) {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			} else {
				System.out.println("id와 비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
			}
			
		}
		
	}

}

package ch11_컬렉션프레임워크;

import java.util.*;

// 클래스의 인스턴스를 Set에서 중복 피하도록 구현
// set이 비교할 때 hashCode()와 equals()를 통해 비교하기 때문에 오버라이딩 해준다.
public class HashSetEx2 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(new String("ABC"));
		set.add(new String("ABC"));
		set.add(new Person("yooil", 32));
		set.add(new Person("yooil", 32));
		
		System.out.println(set);
	}
}

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person tmp = (Person) obj;
			return this.name == tmp.name && this.age == tmp.age;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

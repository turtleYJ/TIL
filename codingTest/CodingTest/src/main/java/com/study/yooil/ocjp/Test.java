package com.study.yooil.ocjp;

public class Test {
//	class Employee {
//		private String name;
//		private int age;
//		private int salary;
//		
//		private Employee(String name, int age) {
//			setName(name);
//			setAge(age);
//			setSalary(2000);
//		}
//		
//		public Employee(String name, int age, int salary) {
//			this(name, age);
//			setSalary(salary);
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public int getAge() {
//			return age;
//		}
//
//		public void setAge(int age) {
//			this.age = age;
//		}
//
//		public int getSalary() {
//			return salary;
//		}
//
//		public void setSalary(int salary) {
//			this.salary = salary;
//		}
//		
//		public void printDetails() {
//			System.out.println(name + " : " + age + " : " + salary);
//		}
//		
//		
//	}
	
//	public static void main(String[] args) {
//		Employee e1 = new Employee();
//		Employee e2 = new Employee("Jack", 50);
//		
//		e2.age = 3;
//		
//	}
	
	public static void main(String[] args) {
		Test ex = new Test();
		int cardNo = 12344;
//		ex.readCard(cardNo);
		ex.checkCard(cardNo);
	}

	private void checkCard(int cardNo) throws RuntimeException{
		System.out.println("Checking Card");
	}

	void readCard(int cardNo) throws Exception {
		System.out.println("Reading Card");
	}
}
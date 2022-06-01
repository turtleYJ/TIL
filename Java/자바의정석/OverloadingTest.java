import java.util.Arrays;

public class OverloadingTest {

	public static void main(String[] args) {
        // 가변인자
//		method7("정유일", 1, 2, 3, 4, 5);
		
		int[] nums = {1, 2, 3, 4, 5};
		
		method7("정유일", nums);
		
    }
	
	static public void method7(String name, int ... numbers) {
		System.out.println(name);
		System.out.println(numbers.length);
		System.out.println(Arrays.toString(numbers));
	}
}
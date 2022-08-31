import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int systemA = Integer.parseInt(st.nextToken());
        int systemB = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int decimal = 0;
        for (int i = 0; i < m; i++) {
            decimal += Math.pow(systemA, m - 1 - i) * Integer.parseInt(st.nextToken());
        }

//        decimalToSystemB(decimal, systemB);
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            int num = decimal % systemB;
            stack.add(num);
            decimal /= systemB;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

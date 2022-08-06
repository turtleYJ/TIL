import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n1 = new BigInteger(br.readLine());
        char op = br.readLine().charAt(0);
        BigInteger n2 = new BigInteger(br.readLine());

        if (op == '+') {
            System.out.println(n1.add(n2));
        } else {
            System.out.println(n1.multiply(n2));
        }
    }
}
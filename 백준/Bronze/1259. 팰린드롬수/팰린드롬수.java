import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) break;

            if (isPalindrome(num)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    private static boolean isPalindrome(int value) {
        String S = Integer.toString(value);

        for (int j = 0; j < S.length() / 2; j++) {
            if(S.charAt(j) != S.charAt(S.length() - 1 - j)) {
                return false;
            }
        }
        return true;
    }
}
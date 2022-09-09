import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if (isPalindrome(str)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean isPalindrome(String S) {
        for (int j = 0; j < S.length() / 2; j++) {
            if(S.charAt(j) != S.charAt(S.length() - 1 - j)) {
                return false;
            }
        }
        return true;
    }
}

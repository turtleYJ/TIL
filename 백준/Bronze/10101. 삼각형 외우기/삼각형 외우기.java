import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int agl1 = Integer.parseInt(br.readLine());
        int agl2 = Integer.parseInt(br.readLine());
        int agl3 = Integer.parseInt(br.readLine());

        if (agl1 + agl2 + agl3 != 180) {
            System.out.println("Error");

            return;
        }

        String res = "";
        if (agl1 == agl2 && agl2 == agl3) res = "Equilateral";
        else if (agl1 == agl2 || agl2 == agl3 || agl3 == agl1) res = "Isosceles";
        else res = "Scalene";

        System.out.println(res);
    }
}
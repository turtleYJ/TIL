import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        int len = order.length();
        int[] position = new int[3];
        position[0] = 1;

        for (int i = 0; i < len; i++) {
            char cur = order.charAt(i);

            change(cur, position);
        }

        int res = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] == 1) {
                res = i + 1;

                break;
            }
        }

        System.out.println(res);
    }

    private static void change(char cur, int[] position) {

        switch (cur) {
            case 'A':
                int temp = position[0];
                position[0] = position[1];
                position[1] = temp;

                break;
            case 'B':
                temp = position[1];
                position[1] = position[2];
                position[2] = temp;

                break;
            case 'C':
                temp = position[0];
                position[0] = position[2];
                position[2] = temp;

                break;
        }
    }
}

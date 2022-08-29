import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] DNAs = new String[N];
        int[] disSum = new int[N];

        for (int i = 0; i < N; i++) {
            DNAs[i] = br.readLine();
        }

        String resStr = "";
        for (int i = 0; i < M; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                char c = DNAs[j].charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int max = 0;
            char temp = '\u0000';
            for (Character c : map.keySet()) {
                Integer cnt = map.get(c);

                if (cnt > max) {
                    temp = c;
                    max = cnt;
                } else if (cnt == max) {
                    if (c.compareTo(temp) < 0) {
                        temp = c;
                    }
                }
            }

            resStr += temp;
        }

        int resInt = 0;
        for (int i = 0; i < N; i++) {
            String dna = DNAs[i];

            for (int j = 0; j < M; j++) {
                if (dna.charAt(j) != resStr.charAt(j)) resInt++;
            }
        }

        System.out.println(resStr);
        System.out.println(resInt);
    }
}

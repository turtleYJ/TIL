import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int diagonal = Integer.parseInt(st.nextToken());
        int heightR = Integer.parseInt(st.nextToken());
        int widthR = Integer.parseInt(st.nextToken());

        double x = Math.sqrt(Math.pow(diagonal, 2) / (Math.pow(heightR, 2) + Math.pow(widthR, 2)));

        int H = (int)(heightR * x);
        int W = (int)(widthR * x);

        System.out.println(H + " " + W);
    }
}
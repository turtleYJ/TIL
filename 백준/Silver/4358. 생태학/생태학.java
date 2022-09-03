import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeMap = new HashMap<>();

        double total = 0;
        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.length() == 0) break;

            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
            total++;
        }

        List<Map.Entry<String, Integer>> treeList = new ArrayList<>(treeMap.entrySet());

        Collections.sort(treeList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, Integer> stringIntegerEntry : treeList) {
            System.out.printf("%s %.4f\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue() / total * 100);
        }
    }
}

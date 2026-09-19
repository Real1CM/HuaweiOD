import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> edges = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextInt() + "," + sc.nextInt();

            edges.add(str);
        }

        for (String edge : edges) {
            String[] str = edge.split(",");
            String a = str[1] + "," + str[0];
            if (!edges.contains(a)) {
                System.out.println("False");
                return;
            }
        }

        System.out.println("True");
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String originalText = sc.nextLine();
        StringBuilder sb = new StringBuilder(originalText);

        int ptr = 0;
        while (n-- > 0) {
            String line = sc.nextLine();

            int first = line.indexOf(' ');
            String cmd = (first == -1) ? line : line.substring(0, first);
            String param = (first == -1) ? "" : line.substring(first + 1);

            switch (cmd) {
                case "FORWARD": {
                    int x = Integer.parseInt(param);
                    ptr = Math.min(ptr + x, sb.length());
                    break;
                }
                case "BACKWARD": {
                    int x = Integer.parseInt(param);
                    ptr = Math.max(ptr + x, 0);
                    break;
                }
                case "SEARCH-FORWARD": {
                    int idx = sb.indexOf(param, ptr);
                    if (idx != -1) ptr = idx;
                    break;
                }
                case "SEARCH-BACKWARD": {
                    int idx = sb.lastIndexOf(param, ptr);
                    if (idx != -1) ptr = idx;
                    break;
                }
                case "INSERT": {
                    sb.insert(ptr, param);
                    ptr += param.length();
                    break;
                }
                case "REPLACE": {
                    int len = param.length();
                    int end = Math.min(ptr + len, sb.length());
                    sb.replace(ptr, end, param);
                    ptr += len;
                    break;
                }
                case "DELETE": {
                    int x = Integer.parseInt(param);
                    int end = Math.min(ptr + x, sb.length());
                    sb.delete(ptr, end);
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}

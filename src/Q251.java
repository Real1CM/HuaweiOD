import java.io.*;
import java.util.*;

public class Q251 {
    static class UnionFind {
        int[] arr = new int[128];

        public UnionFind() {
            for (int i = 0; i < 128; i++) arr[i] = i;
        }

        public int find(int i) {
            if (arr[i] != i) arr[i] = find(arr[i]);
            return arr[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX < rootY) arr[rootY] = rootX;
            else if (rootX > rootY) arr[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        UnionFind uf = new UnionFind();
        StringBuilder upperlower = new StringBuilder();
        boolean inBracket = false;
        char last = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                inBracket = true;
                last = ' ';
            } else if (c == ')') inBracket = false;

            if (inBracket && c != '(') {
                if (last == ' ') last = c;
                else uf.union(last, c);

                char upper = Character.toUpperCase(c);
                char lower = Character.toLowerCase(c);
                int findUpper = upperlower.indexOf(upper + "");
                int findLower = upperlower.indexOf(lower + "");
                if (findUpper != -1 || findLower != -1) {
                    if(findLower != -1) {
                        char one = upperlower.charAt(findLower);
                        uf.union(c, one);
                    }
                    if(findUpper != -1) {
                        char two = upperlower.charAt(findUpper);
                        uf.union(c, two);
                    }
                } else upperlower.append(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        inBracket = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                inBracket = true;
            } else if (c == ')') inBracket = false;
            else if (!inBracket) {
                c = (char) uf.find(c);
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
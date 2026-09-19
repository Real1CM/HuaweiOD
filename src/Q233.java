import java.util.Scanner;

public class Q233 {
    static class UnionSet {
        int n;
        int[] a;

        public UnionSet(int n) {
            this.n = n;
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = i;
        }

        public int find(int i) {
            if (a[i] != i) a[i] = find(a[i]);
            return a[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ)
                a[rootI] = rootJ;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n < 1 || n >= 100000 || m < 1 || m >= 100000) {
            System.out.println("Null");
            return;
        }

        UnionSet set = new UnionSet(n);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (c == 0) {
                set.union(a, b);
            } else if (c == 1) {
                if (set.connected(a, b)) {
                    System.out.println("We are a team");
                } else System.out.println("We are not a team");
            } else {
                System.out.println("da pian zi");
            }
        }
    }
}
import java.util.*;

public class Q505 {
    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int p) {
            if (p == parent[p]) return p;
            return parent[p] = find(parent[p]);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else {
                    parent[rootP] = rootQ;
                    rank[rootQ]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        List<int[]> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;

            String[] s =  line.split(",");
            list.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }

        int[] res = solve(m,n,list);
        System.out.println(Arrays.toString(res).replace(" ", ""));
    }

    private static int[] solve(int m, int n, List<int[]> list) {
        int k = list.size();
        int[] res = new int[k];
        int[][] map = new int[m][n];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        UnionFind uf = new UnionFind(m * n);
        int curBlock = 0;

        for (int i = 0; i < k; i++) {
            int curX = list.get(i)[0];
            int curY = list.get(i)[1];

            if (map[curX][curY] == 1) {
                res[i] = curBlock;
                continue;
            }

            map[curX][curY] = 1;
            int curIndex = curX * n + curY;
            curBlock++;

            for (int[] dir : dirs) {
                int newX = list.get(i)[0] + dir[0];
                int newY = list.get(i)[1] + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && map[newX][newY] == 1) {
                    int neighborIndex = newX * n + newY;
                    if (uf.find(curIndex) != uf.find(neighborIndex)) {
                        uf.union(curIndex, neighborIndex);
                        curBlock--;
                    }
                }
            }
            res[i] = curBlock;
        }
        return res;
    }
}
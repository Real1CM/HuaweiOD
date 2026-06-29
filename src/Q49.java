import java.util.*;

public class Q49 {
    static class Citizen {
        int shop;
        long cost;

        Citizen(int shop, long cost) {
            this.shop = shop;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String[] firstLine = sc.nextLine().split(",");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<Citizen>[] shops = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++) shops[i] = new ArrayList<>();

        int initialVotes = 0;
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(",");
            int p = Integer.parseInt(line[0]);
            long q = Long.parseLong(line[1]);
            if (p == 1) {
                initialVotes++;
            } else {
                shops[p].add(new Citizen(p, q));
            }
        }

        // 对每个店铺内的市民按补贴金额升序排序
        for (int i = 2; i <= m; i++) {
            Collections.sort(shops[i], (a, b) -> Long.compare(a.cost, b.cost));
        }

        long minTotalCost = Long.MAX_VALUE;

        // 穷举1号店最终可能的票数 k
        for (int k = 1; k <= n; k++) {
            long currentCost = 0;
            int currentVotes = initialVotes;
            List<Long> remainingCosts = new ArrayList<>();

            // 步骤1: 处理所有票数 >= k 的店铺
            for (int i = 2; i <= m; i++) {
                int size = shops[i].size();
                for (int j = 0; j < size; j++) {
                    if (size - j >= k) { // 该店票数必须减到 k-1 以下
                        currentCost += shops[i].get(j).cost;
                        currentVotes++;
                    } else {
                        // 暂时不需要买的，放入候选池
                        remainingCosts.add(shops[i].get(j).cost);
                    }
                }
            }

            // 步骤2: 如果票数还不够 k，从候选池里挑最便宜的买
            if (currentVotes < k) {
                Collections.sort(remainingCosts);
                int needed = k - currentVotes;
                if (needed <= remainingCosts.size()) {
                    for (int i = 0; i < needed; i++) {
                        currentCost += remainingCosts.get(i);
                    }
                    currentVotes += needed;
                } else {
                    // 无法达到 k 票，跳过此情况
                    continue;
                }
            }

            // 更新全局最小花费
            if (currentVotes >= k) {
                minTotalCost = Math.min(minTotalCost, currentCost);
            }
        }

        System.out.println(minTotalCost == Long.MAX_VALUE ? 0 : minTotalCost);
    }
}
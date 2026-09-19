import java.util.*;

public class Q153 {
    static class Player {
        int id;
        long weight; // 实力值可能较大，用 long

        Player(int id, long weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] inputs = sc.nextLine().split(" ");
        int n = inputs.length;

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(i, Long.parseLong(inputs[i])));
        }

        Map<Integer, List<Player>> defeatMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            defeatMap.put(i, new ArrayList<>());
        }

        List<Player> currentRound = new ArrayList<>(players);
        while (currentRound.size() > 1) {
            List<Player> nextRound = new ArrayList<>();
            for (int i = 0; i < currentRound.size(); i += 2) {
                if (i + 1 < currentRound.size()) {
                    Player p1 = currentRound.get(i);
                    Player p2 = currentRound.get(i + 1);

                    Player winner, loser;
                    if (p1.weight > p2.weight) {
                        winner = p1;
                        loser = p2;
                    } else if (p1.weight < p2.weight) {
                        winner = p2;
                        loser = p1;
                    } else {
                        if (p1.id < p2.id) {
                            winner = p1;
                            loser = p2;
                        } else {
                            winner = p2;
                            loser = p1;
                        }
                    }
                    nextRound.add(winner);
                    defeatMap.get(winner.id).add(loser);
                } else {
                    nextRound.add(currentRound.get(i));
                }
            }
            currentRound = nextRound;
        }

        Player champion = currentRound.get(0);

        // 冠军淘汰的列表
        List<Player> champDefeated = defeatMap.get(champion.id);
        // 亚军是最后一个被冠军淘汰的人
        Player runnerUp = champDefeated.get(champDefeated.size() - 1);

        // 亚军淘汰的列表
        List<Player> runnerUpDefeated = defeatMap.get(runnerUp.id);

        // 争夺季军的两个人：在半决赛被冠军和亚军淘汰的人
        // 即 champDefeated 的倒数第二个人，和 runnerUpDefeated 的最后一个个人
        // 注意：需要判断是否存在（比如N=3的时候，亚军可能没有淘汰过人，或者冠军没有倒数第二个人）
        Player candidate1 = champDefeated.size() >= 2 ? champDefeated.get(champDefeated.size() - 2) : null;
        Player candidate2 = !runnerUpDefeated.isEmpty() ? runnerUpDefeated.get(runnerUpDefeated.size() - 1) : null;

        Player thirdPlace = null;
        if (candidate1 != null && candidate2 != null) {
            // 两人PK决出季军
            if (candidate1.weight > candidate2.weight) {
                thirdPlace = candidate1;
            } else if (candidate1.weight < candidate2.weight) {
                thirdPlace = candidate2;
            } else {
                thirdPlace = candidate1.id < candidate2.id ? candidate1 : candidate2;
            }
        } else if (candidate1 != null) {
            thirdPlace = candidate1;
        } else if (candidate2 != null) {
            thirdPlace = candidate2;
        }

        // 输出结果
        System.out.println(champion.id + " " + runnerUp.id + " " + (thirdPlace != null ? thirdPlace.id : ""));
    }
}
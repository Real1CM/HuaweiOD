import java.util.*;

public class Q272 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String a = sc.nextLine();
        if (!sc.hasNextLine()) return;
        String b = sc.nextLine();

        // 1. 记录 A 中每个字符出现的所有位置索引
        List<Integer>[] charPositions = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            charPositions[i] = new ArrayList<>();
        }
        for (int i = 0; i < a.length(); i++) {
            charPositions[a.charAt(i) - 'a'].add(i);
        }

        // 2. 记录每个字符在 charPositions 中当前可用的索引下标
        int[] ptr = new int[26];
        int count = 0;

        while (true) {
            int lastIndex = -1; // 记录上一个挑选字符在 A 中的位置
            boolean canFormB = true;

            for (int i = 0; i < b.length(); i++) {
                int charIdx = b.charAt(i) - 'a';
                List<Integer> positions = charPositions[charIdx];

                // 在该字符的所有位置中，寻找第一个大于 lastIndex 的位置
                boolean found = false;
                while (ptr[charIdx] < positions.size()) {
                    int pos = positions.get(ptr[charIdx]);
                    ptr[charIdx]++; // 无论是否符合，该位置在这一组或之前的尝试中都已被考虑/消耗
                    if (pos > lastIndex) {
                        lastIndex = pos;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    canFormB = false;
                    break;
                }
            }

            if (canFormB) {
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
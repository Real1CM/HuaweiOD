import java.util.Scanner;

public class Q151 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int y = sc.nextInt();

        long total = 1;
        for (int i = 0; i < y; i++) {
            total *= 26;
        }

        int z = 1;
        total *= 10;
        while (total < x) {
            total *= 10;
            z++;
        }
        System.out.println(z);
    }
}

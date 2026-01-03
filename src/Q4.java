import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long min = Long.MAX_VALUE;
        while (n-- > 0) {
            int T = sc.nextInt();
            int MaxRespCode = sc.nextInt();
            long time = ok(T, MaxRespCode);
            min = Math.min(min, time);
        }

        System.out.println(min);
    }

    private static long ok(int T, int MaxRespCode) {
        long earliestRespTime = 0; //可能会溢出的情况使用long
        if(MaxRespCode < 128)
            earliestRespTime = T + MaxRespCode;
        else {
            int mant = MaxRespCode & 0x0F; //0x是16进制开头
            int exp = MaxRespCode >> 4 & 0x07;
            earliestRespTime = (long)((mant | 0x10) << (exp + 3)) + T;
        }
        return earliestRespTime;
    }
}

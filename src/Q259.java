import java.util.Scanner;

public class Q259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double distA = sc.nextDouble() * 1000;
        double distB = sc.nextDouble() * 1000;
        double taxiSpeed = sc.nextDouble();
        double wait = sc.nextDouble();
        double walkingSpeed = sc.nextDouble();

        double taxiTime = wait + (distA / taxiSpeed);
        double walkingTime = distB / walkingSpeed;

        if (taxiTime > walkingTime) {
            System.out.println("walk");
        } else if (taxiTime < walkingTime) {
            System.out.println("taxi");
        } else {
            System.out.println("same");
        }
    }
}

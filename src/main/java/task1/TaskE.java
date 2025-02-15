package task1;

import java.util.Scanner;

public class TaskE {
    private static Scanner sc;
    private static int a, b, c, d;
    private static double low = -2000.0, high = 2000.0;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        while (high - low > 1e-5) {
            double mid = (low + high) / 2.0;
            double result_low = a * low * low * low + b * low * low + c * low + d;
            double result_mid = a * mid * mid * mid + b * mid * mid + c * mid + d;

            if (result_mid * result_low > 0)
                low = mid;
            else
                high = mid;
        }
        System.out.println((low + high) / 2.0);
    }
}
package task1;

import java.util.Locale;
import java.util.Scanner;

public class TaskD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double c = scanner.nextDouble();
        scanner.close();

        double low = 0.0;
        double high = Math.sqrt(c);

        double epsilon = 1e-7;

        while (high - low > epsilon) {
            double mid = (low + high) / 2.0;
            double result = mid * mid + Math.sqrt(mid + 1.0);

            if (result > c) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(low);
    }
}
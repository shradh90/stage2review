import java.util.Scanner;

public class wind {
        public static void main(String[] args) {
                System.out.println("enter point  a");
		Scanner sc = new Scanner(System.in);
		double t = sc.nextInt();
		System.out.println("enter a point b");
		Scanner sc1 = new Scanner(System.in);
		double v = sc1.nextInt();
		double w = 35.74 + 0.6215 * t + (o.4275 * t - 35.75) * Math.pow(v , 0.16);
		System.out.println("calculated : " + w);
	}
}

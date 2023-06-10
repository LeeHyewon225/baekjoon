import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int a = 100 - x;
		int b = 100 - y;
		int c = 100 - a - b;
		int d = a * b;
		int q = d / 100;
		int r = d % 100;
		System.out.println(a + " " + b + " " + c + " " + d + " " + q + " " + r);
		System.out.println((c+q) + " " + r);
	}

}
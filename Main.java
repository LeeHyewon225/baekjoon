import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String s = scanner.next();
		char[] c = s.toCharArray();
		
		int sum = 0;
		for(int i=0;i<n;i++)
			sum += c[i] - '0';
		System.out.println(sum);
		scanner.close();
	}

}

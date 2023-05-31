import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int sum = 0;
		int max = 0;
		for(int i=0;i<N;i++) {
			int a = scanner.nextInt();
			sum += a;
			if(max<a) 
				max = a;
		}
		System.out.println(sum*100.0/N/max);
		scanner.close();
	}
 
}

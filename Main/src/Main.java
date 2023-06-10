import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int i = 1;
		int sum = 0;
		int answer;
		boolean winner = false;
		while(true) {
			sum += i;
			i++;
			if(sum > N) {
				answer = (winner) ? 0 : sum - N;
				break;
			}
			else if(sum == N) {
				answer = (winner) ? sum + i  - N: 0;
				break;
			}
			winner = !winner;
		}
		System.out.print(answer);
	}
}
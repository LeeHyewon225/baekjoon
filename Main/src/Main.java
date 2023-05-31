import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		long S[] = new long[N + 1];
		long C[] = new long[M];
		long result = 0;
		for (int i = 1; i < N + 1; i++) {
			int a = s.nextInt();
			S[i] += S[i - 1] + a;
			S[i] %= M;
			if (S[i] == 0)
				result++;
			C[(int) S[i]]++;
		}
		for (int i = 0; i < M; i++) {
			result += C[i] * (C[i] - 1) / 2;
		}
		System.out.println(result);
	}
}

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();
		for (int i = 1; i < N; i++)
			for (int j = 0; j < i; j++)
				if (A[i] < A[j]) {
					int temp = A[i];
					int now = i;
					while (j < now) {
						A[now] = A[now - 1];
						now--;
					}
					A[j] = temp;
				}
		int sum = 0;
		int S[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			S[i] += S[i - 1] + A[i - 1];
		}
		for (int i = 1; i <= N; i++)
			sum += S[i];
		System.out.print(sum);
	}
}

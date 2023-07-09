import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int B[];
	static int max_index = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S[] = new int[N + 1];
		int D[] = new int[N + 1];
		B = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			S[i] = Integer.parseInt(st.nextToken());
		D[1] = 1;
		B[1] = S[1];
		for (int i = 2; i <= N; i++)
			D[i] = search(1, max_index, S[i]);
		int A[] = new int[max_index + 1];
		System.out.println(max_index);
		for (int i = N; i > 0; i--) {
			if (D[i] == max_index)
				A[max_index--] = S[i];
			if (max_index == 0)
				break;
		}
		for (int i = 1; i < A.length; i++)
			System.out.print(A[i] + " ");
	}

	static int search(int start, int end, int n) {
		while (start <= end) {
			int m = (start + end) / 2;
			if (B[m] == n)
				return m;
			else if (B[m] < n)
				start = m + 1;
			else
				end = m - 1;
		}
		max_index = Math.max(max_index, start);
		B[start] = n;
		return start;
	}
}

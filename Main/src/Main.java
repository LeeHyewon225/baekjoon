import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		pivot(A, 0, N - 1, K);
		System.out.println(A[K - 1]);
	}

	static void pivot(int A[], int s, int e, int K) {
		if (s >= e)
			return;
		int start = s;
		int end = e;
		int p;
		if (s + 1 == e) {
			if (A[s] > A[e]) {
				int temp = A[s];
				A[s] = A[e];
				A[e] = temp;
			}
			p = e;
		} else {
			int m = (s + e) / 2;
			int temp = A[s];
			A[s] = A[m];
			A[m] = temp;
			s++;
			while (s <= e) {
				while (A[e] > A[start] && e > 0)
					e--;
				while (A[s] < A[start] && s < A.length - 1)
					s++; 
				if (s <= e) {
					temp = A[s];
					A[s] = A[e];
					A[e] = temp;
					s++;
					e--;
				}
			}
			temp = A[start];
			A[start] = A[e];
			A[e] = temp;
			p = e;
		}
		if (K - 1 < p)
			pivot(A, start, p - 1, K);
		else if (p < K - 1)
			pivot(A, p + 1, end, K);

	}
}

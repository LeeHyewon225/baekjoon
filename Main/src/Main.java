import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(bf.readLine());
		}
		pivot(A, 0, N - 1);
		for (int i = 0; i < N; i++)
			System.out.println(A[i] + " ");
	}

	static void pivot(int A[], int s, int e) {
		int start = s;
		int end = e;
		int p = e;
		if (s > e)
			return;
		while (s != e) {
			if (A[s] < A[p])
				s++;
			else if (A[e] >= A[p])
				e--;
			else if (A[s] > A[p] && A[e] < A[p]) {
				int temp = A[s];
				A[s] = A[e];
				A[e] = temp;
				s++;
			}
		}
		
		int temp = A[s];
		A[s] = A[p];
		A[p] = temp;
		
		pivot(A, start, s - 1);
		pivot(A, s + 1, end);
	}
}

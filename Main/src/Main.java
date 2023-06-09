import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		int s = 0;
		int e = 0;
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (s < A[i])
				s = A[i];
			e += A[i];
		}
		int m = 0;
		while (s <= e) {
			int sum = 0;
			int count = 0;
			m = (s + e) / 2;
			for (int i = 0; i < N; i++) {
				sum += A[i];
				if (sum > m) {
					sum = A[i];
					count++;
				}
				if (count > M)
					break;
			}
			if (count >= M) {
				s = m + 1;
			}
			else if(count < M) {
				e = m-1;
			}
		}
		System.out.println(s);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A[] = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(bf.readLine());
		Arrays.sort(A);
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int s = 0;
			int e = N - 1;
			boolean result = false;
			while (s <= e) {
				int index = (s + e) / 2;
				if (A[index] == num) {
					result = true;
					break;
				} else if (A[index] < num) {
					s = index + 1;
				} else {
					e = index - 1;
				}
			}
			System.out.println(result ? 1 : 0);
		}
	}
}

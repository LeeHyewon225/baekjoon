import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long segment_tree[];
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		n = 2;
		while (n < N)
			n *= 2;
		n *= 2;
		segment_tree = new long[n];
		int index = n / 2;
		for (int i = 0; i < N; i++)
			segment_tree[index++] = Long.parseLong(br.readLine());
		for (int i = n / 2 - 1; i > 0; i--)
			segment_tree[i] = (segment_tree[i * 2] * segment_tree[i * 2 + 1]) % 1000000007;
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (t == 1)
				Change(a, b);
			else
				System.out.println(Prefix_Sum(a, b));
		}
	}

	static void Change(int a, int b) {
		a += n / 2 - 1;
		segment_tree[a] = b;
		a /= 2;
		while (a >= 1) {
			segment_tree[a] = ((segment_tree[a * 2] % 1000000007) * (segment_tree[a * 2 + 1] % 1000000007))
					% 1000000007;
			a /= 2;
		}
	}

	static long Prefix_Sum(int a, int b) {
		int start = a + n / 2 - 1;
		int end = b + n / 2 - 1;
		long value = 1;
		while (start < end) {
			if (start % 2 == 1)
				value = value * segment_tree[start] % 1000000007;
			if (end % 2 == 0)
				value = value * segment_tree[end] % 1000000007;
			start = (start + 1) / 2;
			end = (end - 1) / 2;
		}
		if (start == end)
			value = value * segment_tree[start] % 1000000007;
		return value;
	}
}

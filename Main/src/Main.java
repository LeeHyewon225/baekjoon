import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int segment_tree[];
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		n = 2;
		while (n < N)
			n *= 2;
		n *= 2;
		segment_tree = new int[n];
		int index = n / 2;
		for (int i = 0; i < N; i++)
			segment_tree[index++] = Integer.parseInt(br.readLine());
		for (int i = n / 2 - 1; i > 0; i--)
			segment_tree[i] = Math.min(segment_tree[i * 2], segment_tree[i * 2 + 1]);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(Prefix_Sum(a, b));
		}
	}

	static long Prefix_Sum(int a, int b) {
		int start = a + n / 2 - 1;
		int end = b + n / 2 - 1;
		int min = Integer.MAX_VALUE;
		while (start < end) {
			if (start % 2 == 1)
				min = Math.min(min, segment_tree[start]);
			if (end % 2 == 0)
				min = Math.min(min, segment_tree[end]);
			start = (start + 1) / 2;
			end = (end - 1) / 2;
		}
		if (start == end)
			min = Math.min(min, segment_tree[start]);
		return min;
	}
}

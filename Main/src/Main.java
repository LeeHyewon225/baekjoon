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
		for (int i = 0; i < N; i++) {
			long a = Long.parseLong(br.readLine());
			segment_tree[2] = a;
			segment_tree[index++] = a;
		}
		for (int i = n / 2 - 1; i > 0; i--) 
			segment_tree[i] = segment_tree[i * 2] + segment_tree[i * 2 + 1];
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1)
				Change(b, c);
			else if (a == 2)
				System.out.println(Prefix_Sum(b, c));
		}
	}

	static void Change(int b, long c) {
		b += n / 2 - 1;
		long sum = c - segment_tree[b];
		segment_tree[b] = c;
		b /= 2;
		while (b >= 1) {
			segment_tree[b] += sum;
			b /= 2;
		}
	}

	static long Prefix_Sum(int b, long c) {
		int start = b + n / 2 - 1;
		long end = c + n / 2 - 1;
		long sum = 0;
		while (start < end) {
			if (start % 2 == 1)
				sum += segment_tree[start];
			if (end % 2 == 0)
				sum += segment_tree[(int) end];
			start = (start + 1) / 2;
			end = (end - 1) / 2;
		}
		if (start == end)
			sum += segment_tree[start];
		return sum;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int left[] = new int[N + 2];
		int right[] = new int[N + 2];
		int list[] = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			list[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < left.length; i++) {
			left[i] = -1001;
			right[i] = -1001;
		}
		for (int i = 1; i < N + 1; i++) {
			left[i] = Math.max(list[i], left[i - 1] + list[i]);
			right[N + 1 - i] = Math.max(list[N + 1 - i], right[N + 2 - i] + list[N + 1 - i]);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(left[i], max);
			max = Math.max(max, left[i - 1] + right[i + 1]);
		}
		System.out.println(max);
	}
}

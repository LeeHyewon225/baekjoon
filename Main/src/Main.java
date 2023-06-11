import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a[][] = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		int count = 1;
		int time = a[0][1];
		for (int i = 1; i < N; i++) {
			if (a[i][0] >= time) {
				time = a[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
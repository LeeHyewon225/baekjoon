import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int D[][] = new int[n + 1][m + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				char c = str.charAt(j - 1);
				if (c == '1') {
					D[i][j] = Math.min(Math.min(D[i - 1][j], D[i][j - 1]), D[i - 1][j - 1]) + 1;
					max = Math.max(max, D[i][j]);
				} else
					D[i][j] = 0;
			}
		}
		System.out.println(max * max);
	}
}

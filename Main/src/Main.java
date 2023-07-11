import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int D[][] = new int[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 30; i++)
			for (int j = 1; j <= 30; j++)
				D[i][j] = j == 1 ? i : (D[i - 1][j] + D[i - 1][j - 1]);
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if (N < K) {
				int temp = N;
				N = K;
				K = temp;
			}
			System.out.println(D[N][K]);
		}
	}
}

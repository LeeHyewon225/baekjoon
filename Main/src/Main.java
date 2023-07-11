import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (K == 0) {
			System.out.println(1);
			return;
		}
		int D[][] = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= K; j++)
				D[i][j] = j == 1 ? i : (D[i - 1][j] + D[i - 1][j - 1]);
		System.out.println(D[N][K]);
	}
}

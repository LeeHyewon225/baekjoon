import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		int D[][] = new int[N + M + 1][M + 1];
		D[0][0] = 1;
		for (int i = 1; i <= N + M; i++) {
			D[i][0] = 1;
			for (int j = 1; j <= M; j++) {
				D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
				if (D[i][j] > 1000000000)
					D[i][j] = 1000000001;
			}
		}
		if (D[N + M][M] < K) {
			System.out.println(-1);
			return;
		}
		int x = N + M - 1;
		int z = M;
		for (int i = 0; i < N + M; i++) {
			if (D[x][z] >= K)
				sb.append('a');
			else {
				sb.append('z');
				K = K - D[x][z];
				z--;
			}
			x--;
		}
		System.out.println(sb);
	}
}

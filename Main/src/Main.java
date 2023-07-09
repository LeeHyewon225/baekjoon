import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int D[][];
	static int distance[][];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		distance = new int[N][N];
		D = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				distance[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dp(0, 1));
	}

	static int dp(int now, int v) {
		if (v == (1 << N) - 1)
			return distance[now][0] == 0 ? 100000000 : distance[now][0];
		if (D[now][v] != 0)
			return D[now][v];
		int min = 100000000;
		for (int i = 0; i < N; i++)
			if ((v & (1 << i)) == 0 && distance[now][i] != 0)
				min = Math.min(min, dp(i, (v | (1 << i))) + distance[now][i]);
		return D[now][v] = min;
	}
}

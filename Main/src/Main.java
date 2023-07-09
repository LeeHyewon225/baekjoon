import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int D[][];
	static int matrix[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][2];
		D = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				D[i][j] = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dp(0, N - 1));
	}

	static int dp(int start, int end) {
		if (D[start][end] != -1)
			return D[start][end];
		if (start == end)
			return D[start][end] = 0;
		if (start + 1 == end)
			return D[start][end] = matrix[start][0] * matrix[end][0] * matrix[end][1];
		int result = Integer.MAX_VALUE;
		for (int i = start; i < end; i++)
			result = Math.min(result, dp(start, i) + dp(i + 1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1]);
		return D[start][end] = result;

	}
}

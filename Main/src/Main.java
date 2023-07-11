import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int D[][] = new int[15][15];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 14; i++)
			D[0][i] = i;
		for (int i = 1; i <= 14; i++)
			for (int j = 1; j <= 14; j++)
				D[i][j] = D[i][j - 1] + D[i - 1][j];
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int K = Integer.parseInt(br.readLine());
			System.out.println(D[N][K]);
		}
	}
}

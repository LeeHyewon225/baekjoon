import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D[][][] = new int[100001][5][5];
		for (int i = 0; i < 100001; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < 5; k++)
					D[i][j][k] = 10000000;
		D[0][0][0] = 0;
		int count = 1;
		int mp[][] = { { 1, 2, 2, 2, 2 }, { -1, 1, 3, 4, 3 }, { -1, 3, 1, 3, 4 }, { -1, 4, 3, 1, 3 }, { -1, 3, 4, 3, 1 } };
		while (true) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 5; j++)
					D[count][i][n] = Math.min(D[count][i][n], D[count - 1][i][j] + mp[j][n]);
			for (int i = 0; i < 5; i++)
				for (int j = 0; j < 5; j++)
					D[count][n][i] = Math.min(D[count][n][i], D[count - 1][j][i] + mp[j][n]);
			count++;
		}
		count--;
		int answer = 10000000;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				answer = Math.min(answer, D[count][i][j]);
		System.out.println(answer);
	}
}

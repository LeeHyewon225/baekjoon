import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int distance[][] = new int[n][n];
		for (int i = 0; i < distance.length; i++)
			for (int j = 0; j < distance.length; j++)
				distance[i][j] = i == j ? 0 : 100000000;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			if (distance[s][e] > v)
				distance[s][e] = v;
		}
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance.length; j++)
				System.out.print(distance[i][j] == 100000000 ? 0 + " " : distance[i][j] + " ");
			System.out.println();
		}
	}
}
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
		int distance[][] = new int[n][n];
		for (int i = 0; i < distance.length; i++) 
			for (int j = 0; j < distance.length; j++) 
				distance[i][j] = i == j ? 0 : 1000000;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
		int min = 100000;
		int min_index = -1;
		for (int i = 0; i < distance.length; i++) {
			int sum = 0;
			for (int j = 0; j < distance.length; j++)
				sum += distance[i][j];
			if (sum < min) {
				min = sum;
				min_index = i;
			}
		}
		System.out.println(min_index + 1);
	}
}
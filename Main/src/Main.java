import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		double D[] = new double[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0;
		for (int i = 0; i < M; i++) {
			D[i] = Double.parseDouble(st.nextToken());
			sum += D[i];
		}
		int K = Integer.parseInt(br.readLine());
		double denominator = 0;
		double numerator = 1;
		for (int i = 0; i < M; i++)
			if (D[i] >= K) {
				double mul = 1;
				for (int j = 0; j < K; j++)
					mul *= (D[i] - j);
				denominator += mul;
			}
		for (int i = 0; i < K; i++)
			numerator *= (sum - i);
		System.out.println(denominator / numerator);
	}
}

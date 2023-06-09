import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		int s = 1;
		int e = k;
		int answer = 0;
		while (s <= e) {
			int m = (s + e) / 2;
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i > m)
					break;
				sum = sum + (m / i > N ? N : m / i);
			}
			if (sum < k) 
				s = m + 1;
			else if (sum >= k) {
				e = m - 1;
				answer = m;
			}
		}
		System.out.println(answer);
	}
}

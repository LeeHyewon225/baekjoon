import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long result = n;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				result -= result / i;
				while (n % i == 0)
					n /= i;
			}
		}
		System.out.println(n > 1 ? result - result / n : result);
	}
}
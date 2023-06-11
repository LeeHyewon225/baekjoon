import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
		boolean first = true;
		int result = 0;
		while (st1.countTokens() > 0) {
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
			int sum = 0;
			while (st2.countTokens() > 0) {
				int num = Integer.parseInt(st2.nextToken());
				sum += num;
			}
			result += first ? sum : -sum;
			first = false;
		}
		System.out.println(result);
	}
}
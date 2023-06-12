import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		boolean prime[] = new boolean[10000001];
		prime[1] = true;
		for (int i = 2; i <= Math.sqrt(10000000); i++) {
			if (!prime[i])
				for (int j = 2; j * i <= 10000000; j++) {
					prime[i * j] = true;
				}
		}
		int count=0;
		for (int i = 2; i <= 10000000; i++)
			if (!prime[i]) {
				double k = i;
				double a = A / k;
				double b = B / k;
				while(true) {
					if(k > b)
						break;
					if(k >= a)
						count++;
					a /= k;
					b /= k;
				}
			}
		System.out.println(count);
	}
}
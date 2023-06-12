import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean prime[] = new boolean[10000001];
		prime[1] = true;
		for (int i = 2; i <= Math.sqrt(10000000); i++) {
			if (!prime[i])
				for (int j = 2; j * i <= 10000000; j++) {
					prime[i * j] = true;
				}
		}
		for (int i = N; i <= 10000000; i++)
			if (!prime[i]) {
				if(i==Integer.parseInt(new StringBuffer(String.valueOf(i)).reverse().toString())) {
					System.out.println(i);
					break;
				}
			}
	}
}
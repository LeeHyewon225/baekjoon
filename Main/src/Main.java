import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println(0);
			return;
		}
		long D[] = new long[N + 1];
		D[1] = 0;
		D[2] = 1;
		for (int i = 3; i < D.length; i++) 
			D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % 1000000000;
		System.out.println(D[N]);
	}
}

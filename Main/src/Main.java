import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		if(N==1) {
			System.out.println(2+"\n" + 3+"\n" +5+"\n" +7+"\n");
			return;
		}
		DFS(2, 1, N);
		DFS(3, 1, N);
		DFS(5, 1, N);
		DFS(7, 1, N);
	}

	static void DFS(int num, int digit, int N) {
		if (digit == N) {
			System.out.println(num);
			return;
		}
		for (int j = 0; j < 5; j++) {
			int k = num * 10 + j * 2 + 1;
			if (isPrime(k))
				DFS(k, digit + 1, N);
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}

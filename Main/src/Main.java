import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int money[] = new int[N];
		int j = 0;
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			if (money[i] <= K)
				j = i;
		}
		int now = 0;
		int count = 0;
		while (K > 0) {
			int c = K / money[j];
			now += c * money[j];
			K -= c * money[j];
			j--;
			count += c;
		}
		System.out.println(count);
	}
}
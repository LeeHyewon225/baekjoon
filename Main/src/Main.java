import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean a[] = new boolean[N + 1];
		a[1] = true;
		for (int i = 2; i <= N; i++) {
			if (!a[i])
				for (int j = 2; j * i <= N; j++) {
					a[i * j] = true;
				}
		}
		for (int i = M; i <= N; i++)
			if (!a[i])
				System.out.println(i);
	}
}
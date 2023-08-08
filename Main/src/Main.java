import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N + 1];
		a[1] = 1;
		for (int i = 2; i <= N; i++) 
			if (a[i] == 0) 
				for (int j = 2; i * j <= N; j++)
					a[j * i] = 1;
		int start = 2;
		int end = 2;
		int sum = 2;
		int answer = 0;
		while (start <= N && end <= N) 
			if (sum == N) {
				answer++;
				
				end++;
				while (end <= N && a[end] == 1)
					end++;
				sum += end;
				
				sum -= start;
				start++;
				while (start <= N && a[start] == 1)
					start++;
			} else if (sum < N) {
				end++;
				while (end <= N && a[end] == 1)
					end++;
				sum += end;
			} else {
				sum -= start;
				start++;
				while (start <= N && a[start] == 1)
					start++;
			}
		System.out.println(answer);
	}
}

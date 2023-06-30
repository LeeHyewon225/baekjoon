import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int a[] = new int[n];
		st = new StringTokenizer(br.readLine());
		int zero = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			zero += a[i];
		}
		if (zero < s) {
			System.out.println(0);
			return;
		}
		int min = n;
		int count = 1;
		int start = 0;
		int end = 0;
		int sum = a[0];
		while (start <= end) {
			if (sum < s) {
				if (end == n - 1)
					break;
				sum += a[++end];
				count++;
			} else if (sum >= s) {
				if (min > count)
					min = count;
				sum -= a[start++];
				count--;
			}
		}
		System.out.println(min);
	}
}
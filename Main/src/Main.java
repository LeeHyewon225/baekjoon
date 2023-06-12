import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean a[] = new boolean[1000001];
		for (long i = 2; i <= Math.sqrt(max); i++) {
			long n = i * i;
			long start =  ((min + n - 1) / n);
			for (long j = start; j * n <= max; j++) {
				a[(int) (j * n - min)] = true;  
			}
		}
		int count = 0;
		for (int i = 0; i <= max - min; i++)
			if (!a[i]) 
				count++;
		System.out.println(count);
	}
}
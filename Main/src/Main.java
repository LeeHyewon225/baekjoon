import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Long.parseLong(st.nextToken());
		Arrays.sort(A);
		int count = 0;
		for (int k = 0; k < N; k++) {
			int i = 0;
			int j = N - 1;
			while (i < j) {
				if (A[i] + A[j] < A[k])
					i++;
				else if (A[i] + A[j] > A[k])
					j--;
				else {
					if (i != k && j != k) {
						count++;
						break;
					}
					else if(i==k)
						i++;
					else
						j--;
				}
			}
		}
		System.out.println(count);
		bf.close();
	}
}

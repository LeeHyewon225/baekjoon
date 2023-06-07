import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int A[];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(bf.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(bf.readLine());
		Radix_Sort(5);
		for (int i = 0; i < N; i++)
			bw.write(A[i] + "\n");
		bw.flush();
		bw.close();

	}

	static void Radix_Sort(int max_size) {
		int count = 0;
		int jarisu = 1;
		int output[] = new int[N];
		while (count < max_size) {
			int bucket[] = new int[10];
			for (int i = 0; i < N; i++)
				bucket[A[i] / jarisu % 10]++;
			for (int i = 1; i < 10; i++)
				bucket[i] += bucket[i - 1];
			for (int i = N - 1; i >= 0; i--) {
				output[--bucket[A[i] / jarisu % 10]] = A[i];
			}
			for (int i = 0; i < N; i++)
				A[i] = output[i];
			count++;
			jarisu *= 10;
		}
	}
}

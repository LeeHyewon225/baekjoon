import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static int[] A, tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		A = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(bf.readLine());
		mergeSort(0, N - 1);
		for (int i = 0; i < N; i++)
			bw.write(A[i] + "\n");
		bw.flush();
		bw.close();

	}

	static void mergeSort(int s, int e) {
		if (s >= e)
			return;
		int m = s + (e - s) / 2;
		mergeSort(s, m);
		mergeSort(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while (index1 <= m && index2 <= e) {
			if (tmp[index1] > tmp[index2])
				A[k++] = tmp[index2++];
			else
				A[k++] = tmp[index1++];
		}
		while (index1 <= m)
			A[k++] = tmp[index1++];
		while (index2 <= e)
			A[k++] = tmp[index2++];
	}

}

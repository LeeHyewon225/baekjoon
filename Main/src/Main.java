import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] A, tmp;
	public static long result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		A = new int[N];
		tmp = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		mergeSort(0, N - 1);
		System.out.println(result);
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
			if (tmp[index1] > tmp[index2]) {
				result += index2 - k;
				A[k++] = tmp[index2++];
			} else
				A[k++] = tmp[index1++];
		}
		while (index1 <= m)
			A[k++] = tmp[index1++];
		while (index2 <= e)
			A[k++] = tmp[index2++];
	}

}

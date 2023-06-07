import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N - 1, K - 1);
		System.out.println(A[K - 1]);
	}

	static void quickSort(int A[], int start, int end, int K) {
		if (start >= end)
			return;
		int pivot = pivot(A, start, end);
		if (K < pivot)
			quickSort(A, start, pivot - 1, K);
		else if (pivot < K)
			quickSort(A, pivot + 1, end, K);
	}

	static int pivot(int A[], int start, int end) {
		if (start + 1 == end) {
			if (A[start] > A[end])
				swap(A, start, end);
			return end;
		}
		int Middle = (start + end) / 2;
		swap(A, Middle, start);
		int i = start + 1;
		int j = end;
		while (i <= j) {
			if (A[start] < A[j])
				j--;
			else if (A[start] > A[i])
				i++;
			else if (i <= j) {
				swap(A, i++, j--);
			}
		}
		swap(A, start, j);
		return j;
	}

	static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}

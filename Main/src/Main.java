import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		public int index;
		public long value;

		public Node(int a, long b) {
			index = a;
			value = b;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(A[i]);
		}
	}
}

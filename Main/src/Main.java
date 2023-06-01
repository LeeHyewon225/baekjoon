import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		public int value;
		public int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int A[] = new int[N];
		Deque<Node> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.getLast().value > now)
				deque.removeLast();
			deque.addLast(new Node(now, i));
			if (deque.getFirst().index < i - L + 1)
				deque.removeFirst();
			bw.write(deque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
}

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
	static class Node implements Comparable<Node>{
		public int index;
		public int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Node A[] = new Node[N];
		for (int i = 0; i < N; i++) 
			A[i] = new Node(i, Integer.parseInt(bf.readLine()));
		Arrays.sort(A);
		int answer = 0;
		for(int i=0;i<N;i++) 
			if(answer <A[i].index - i)
				answer = A[i].index - i;
		System.out.print(answer + 1);
		
	}
}

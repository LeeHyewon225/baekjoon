import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long lcm = 1;
		ArrayList<Node> A[] = new ArrayList[N];
		int visit[] = new int[N];
		long result[] = new long[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Node>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			lcm *= p * q / gcd(p, q);
			A[a].add(new Node(b, p, q));
			A[b].add(new Node(a, q, p));
		}
		result[0] = lcm;
		visit[0] = 1;
		DFS(0, A, visit, result);
		long gcd = result[0];
		for (int i = 1; i < N; i++) {
			gcd = gcd(gcd, result[i]);
		}
		for (int i = 0; i < N; i++)
			System.out.print(result[i] / gcd + " ");
	}

	static void DFS(int n, ArrayList<Node> A[], int visit[], long result[]) {
		for (int i = 0; i < A[n].size(); i++) {
			Node node = A[n].get(i);
			if (visit[node.b] == 0) {
				visit[node.b] = 1;
				result[node.b] = result[n] * node.q / node.p;
				DFS(node.b, A, visit, result);
			}
		}
	}

	static long gcd(long a, long b) {
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}

	static class Node {
		public int b;
		public int p;
		public int q;

		public Node(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}
	}
}

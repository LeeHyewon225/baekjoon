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
		ArrayList<Node> a[] = new ArrayList[N];
		int visit[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = new ArrayList<Node>();
			visit[i] = -1;
		}
		for (int j = 0; j < N - 1; j++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			a[n1].add(new Node(n2, v));
			a[n2].add(new Node(n1, v));
		}
		visit[0] = 0;
		DFS(0, a, visit);
		int max = 0;
		int max_index = 0;
		for (int i = 0; i < N; i++)
			if (max < visit[i]) {
				max = visit[i];
				max_index = i;
			}
		visit = new int[N];
		for (int i = 0; i < N; i++)
			visit[i] = -1;
		visit[max_index] = 0;
		max = 0;
		DFS(max_index, a, visit);
		for (int i = 0; i < N; i++)
			if (max < visit[i])
				max = visit[i];
		System.out.println(max);
	}

	static void DFS(int n, ArrayList<Node> a[], int visit[]) {
		for (int i = 0; i < a[n].size(); i++) {
			Node n2 = a[n].get(i);
			if (visit[n2.node] == -1) {
				visit[n2.node] = n2.value + visit[n];
				DFS((int) n2.node, a, visit);
			}
		}
	}

	static class Node {
		int node;
		int value;

		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}
}

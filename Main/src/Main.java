import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge edge[] = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int V = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(A, B, V);
		}
		long distance[] = new long[N];
		for (int i = 0; i < distance.length; i++)
			distance[i] = Long.MAX_VALUE;
		distance[0] = 0;
		for (int i = 0; i < N - 1; i++)
			for (int j = 0; j < M; j++)
				if (distance[edge[j].start_node] != Long.MAX_VALUE
						&& distance[edge[j].end_node] > distance[edge[j].start_node] + edge[j].value)
					distance[edge[j].end_node] = distance[edge[j].start_node] + edge[j].value;
		for (int j = 0; j < M; j++)
			if (distance[edge[j].start_node] != Long.MAX_VALUE
					&& distance[edge[j].end_node] > distance[edge[j].start_node] + edge[j].value) {
				System.out.println(-1);
				return;
			}
		for (int i = 1; i < distance.length; i++)
			System.out.println(distance[i] == Long.MAX_VALUE ? -1 : distance[i]);
	}

	static class Edge {
		public int start_node;
		public int end_node;
		public int value;

		public Edge(int start_node, int end_node, int value) {
			this.start_node = start_node;
			this.end_node = end_node;
			this.value = value;
		}
	}
}

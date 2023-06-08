import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> A[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			A[u].add(v);
			A[v].add(u);
		}
		int visit[] = new int[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (visit[i] == 0) {
				DFS(i, A, visit);
				count++;
			}
		}
		System.out.println(count);
	}

	static void DFS(int i, ArrayList A[], int visit[]) {
		visit[i] = 1;
		for (int j = 0; j < A[i].size(); j++) {
			if (visit[(int) A[i].get(j)] == 0)
				DFS((int) A[i].get(j), A, visit);
		}
	}

}

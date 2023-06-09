import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		ArrayList<Integer> A[] = new ArrayList[N];
		int visit[];
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1)
					A[i].add(j);
			}
		}
		for (int i = 0; i < N; i++) {
			visit = new int[N];
			DFS(i, A, visit);
			for (int j = 0; j < N; j++)
				System.out.print(visit[j] + " ");
			System.out.println();
		}
	}

	static void DFS(int num, ArrayList<Integer> A[], int visit[]) {
		for (int i = 0; i < A[num].size(); i++) {
			if (visit[A[num].get(i)] == 0) {
				visit[A[num].get(i)] = 1;
				DFS(A[num].get(i), A, visit);
			}
		}
	}
}

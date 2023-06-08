import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean ABCDE = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] A = new ArrayList[N];
		int visit[] = new int[N];
		for(int i=0;i<N;i++) 
			A[i] = new ArrayList<Integer>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		for(int i=0;i<N;i++) 
			DFS(i, A, visit, 1);
		System.out.println(ABCDE ? 1 : 0);
	}

	static void DFS(int i, ArrayList<Integer>[] A, int visit[], int depth) {
		if(ABCDE)
			return;
		if(depth == 5) {
			ABCDE = true;
			return;
		}
		visit[i] = 1;
		for(int j=0;j<A[i].size();j++) {
			if(visit[(int) A[i].get(j)] == 0)
				DFS((int) A[i].get(j), A, visit, depth+1);
		}
		visit[i] = 0;
	}
}

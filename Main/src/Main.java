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
		ArrayList<Integer> a[] = new ArrayList[N];
		int count =0;
		for(int i=0;i<N;i++) {		
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++) {		
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) - 1;
			int n2 = Integer.parseInt(st.nextToken()) - 1;
			a[n1].add(n2);
			a[n2].add(n1);
		}
		int parent[] = new int[N];
		int visit[] = new int[N];
		visit[0] = 1;
		DFS(0, a, parent, visit);
		for(int i=1;i<N;i++) 
			System.out.println(parent[i] + 1);
		
	}
	static void DFS(int n, ArrayList a[], int parent[], int visit[]) {
		for(int i=0;i<a[n].size();i++) {
			int temp = (int) a[n].get(i);
			if(visit[temp]==0) {
				visit[temp]=1;
				parent[temp] = n;
				DFS(temp, a, parent, visit);
			}
		}
	}
}
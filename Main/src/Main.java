import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int visit[] = new int[N];
		st = new StringTokenizer(br.readLine());
		int truth_count = Integer.parseInt(st.nextToken());
		int truth[] = new int[N];
		for (int i = 0; i < truth_count; i++)
			truth[Integer.parseInt(st.nextToken()) - 1]++;
		ArrayList<Integer> a[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			a[i] = new ArrayList<Integer>();
		ArrayList<Integer> party[] = new ArrayList[M];
		for (int i = 0; i < M; i++)
			party[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int party_count = Integer.parseInt(st.nextToken());
			int person1 = Integer.parseInt(st.nextToken()) - 1;
			party[i].add(person1);
			for (int j = 1; j < party_count; j++) {
				int person2 = Integer.parseInt(st.nextToken()) - 1;
				party[i].add(person2);
				a[person1].add(person2);
				a[person2].add(person1);
				person1 = person2;
			}
		}
		for (int i = 0; i < N; i++) {
			if (truth[i] == 1 && visit[i] == 0) {
				visit[i] = 1;
				BFS(i, a, visit);
			}
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			int lie = 1;
			for (int j = 0; j < party[i].size(); j++) {
				if (visit[party[i].get(j)] == 1) {
					lie = 0;
					break;
				}
			}
			count += lie;
		}
		System.out.println(count);
	}

	static void BFS(int n, ArrayList<Integer> a[], int visit[]) {
		for (int i = 0; i < a[n].size(); i++) {
			int now = (int) a[n].get(i);
			if (visit[now] == 0) {
				visit[now] = 1;
				BFS(now, a, visit);
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int Node[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node = new int[n + 1];
		for (int i = 1; i <= n; i++)
			Node[i] = i;
		st = new StringTokenizer(br.readLine());
		int true_people_count = Integer.parseInt(st.nextToken());
		int true_people[] = new int[true_people_count];
		for (int i = 0; i < true_people_count; i++)
			true_people[i] = Integer.parseInt(st.nextToken());
		ArrayList<Integer> party[] = new ArrayList[m + 1];
		for (int i = 1; i <= m; i++) {
			party[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= t; j++)
				party[i].add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= m; i++) {
			int first = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++)
				union(first, party[i].get(j));
		}
		int result = 0;
		for (int i = 1; i <= m; i++) {
			boolean possible = true;
			for (int j = 0; j < true_people_count; j++)
				if (find(party[i].get(0)) == find(true_people[j])) {
					possible = false;
					break;
				}
			if (possible)
				result++;
		}
		System.out.println(result);
	}

	static void union(int a, int b) {
		Node[find(b)] = find(a);
	}

	static int find(int a) {
		if (a == Node[a])
			return a;
		else
			return Node[a] = find(Node[a]);
	}
}

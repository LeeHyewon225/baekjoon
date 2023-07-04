import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int visit[];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		tNode root = new tNode();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			tNode now = root;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (now.next[c - 'a'] == null)
					now.next[c - 'a'] = new tNode();
				now = now.next[c - 'a'];
			}
			now.isEnd = true;
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			tNode now = root;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (now.next[c - 'a'] == null)
					break;
				now = now.next[c - 'a'];
				if (j == str.length() - 1 && now.isEnd)
					count++;
			}
		}
		System.out.println(count);
	}

	static class tNode {
		public tNode next[] = new tNode[26];
		public boolean isEnd;
	}
}

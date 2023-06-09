import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		boolean a[] = new boolean[21];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			if (str.equals("all")) {
				for (int j = 1; j < 21; j++)
					a[j] = true;
				continue;
			} else if (str.equals("empty")) {
				for (int j = 1; j < 21; j++)
					a[j] = false;
				continue;
			}
			int x = Integer.parseInt(st.nextToken());
			if (str.equals("add"))
				a[x] = true;
			else if (str.equals("remove"))
				a[x] = false;
			else if (str.equals("check")) 
				bw.write((a[x] ? "1" : "0") + "\n");
			else if (str.equals("toggle"))
				a[x] = !a[x];
		}
		bw.flush();
		bw.close();
	}
}

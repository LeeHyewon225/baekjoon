import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> a = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			a.put(site, password);
		}
		for(int i=0;i<M;i++) {
			String str = bf.readLine();
			bw.write(a.get(str) + "\n");
		}
		bw.flush();
		bw.close();
	}
}

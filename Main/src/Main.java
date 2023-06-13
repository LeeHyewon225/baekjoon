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
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		for(int i=0;i<gcd(A, B);i++) {
			bw.write("1");
		}
		bw.flush();
		bw.close();

	}

	static long gcd(long a, long b) {
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}
}
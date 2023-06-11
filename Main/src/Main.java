import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 0;
		while (A < B) {
			if (B % 10 == 1)
				B /= 10;
			else if(B % 2 == 1)
				break;
			else
				B /= 2;
			count++;
		}
		System.out.println(A == B ? count + 1 : -1);
	}
}
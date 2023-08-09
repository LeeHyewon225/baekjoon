import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int card[] = new int[N];
		int card_count[] = new int[20000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			card[i] = a;
			card_count[a + 10000000]++;
		}
		Arrays.sort(card);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < M; i++) {
			int card_num = Integer.parseInt(st.nextToken());
			int s = 0;
			int e = N - 1;
			int count = 0;
			while (s <= e) {
				int m = (s + e) / 2;
				if (card[m] == card_num) {
					count = card_count[card_num + 10000000];
					break;
				} else if (card[m] < card_num)
					s = m + 1;
				else
					e = m - 1;
			}
			bw.append(count + " ");
		}
		bw.flush();
	}
}

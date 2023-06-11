import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> a = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++)
			a.add(Integer.parseInt(br.readLine()));
		int result = 0;
		while (a.size() > 1) {
			int sum = a.remove() + a.remove();
			a.add(sum);
			result += sum;
		}
		System.out.println(result);

	}
}
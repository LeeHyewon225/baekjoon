import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue1 = new PriorityQueue<>();
		PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
		boolean zero = false;
		int one_count = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num < 0)
				queue1.add(num);
			else if (num > 1)
				queue2.add(num);
			else if (num == 0)
				zero = true;
			else
				one_count++;

		}
		int result = 0;
		while (queue1.size() > 1)
			result += queue1.remove() * queue1.remove();
		while (queue2.size() > 1)
			result += queue2.remove() * queue2.remove();
		if (queue2.size() == 1)
			result += queue2.remove();
		if (queue1.size() == 1 && !zero)
			result += queue1.remove();
		System.out.println(result + one_count);
	}
}
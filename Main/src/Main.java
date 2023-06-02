import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		queue.poll();
		for (int i = 0; i < N - 2; i++) {
			queue.add(queue.poll());
			queue.poll();
		}
		System.out.println(N == 1 ? 1 : queue.poll());
	}
}

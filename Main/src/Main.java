import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) == Math.abs(o2))
				return o1 < o2 ? -1 : 1;
			else
				return Math.abs(o1) - Math.abs(o2);
		});
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(bf.readLine());
			if (a != 0)
				queue.add(a);
			else {
				System.out.println(!queue.isEmpty() ? queue.poll() : 0);
			}
		}
	}
}

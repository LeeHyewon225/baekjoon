import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Stack<Integer> stack = new Stack<>();
		int A[] = new int[N];
		int answer[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				answer[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] != 0 ? answer[i] + " " : -1 + " ");
		}
		System.out.print(sb);
	}
}

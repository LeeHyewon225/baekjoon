import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<>();
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int num = 1;
		boolean result = true;
		for (int i = 0; i < n; i++) {
			if (A[i] >= num) {
				while (A[i] >= num) {
					stack.add(num);
					num++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			else {
				if(stack.peek() == A[i]) {
					stack.pop();
					sb.append("-\n");
				}
				else {
					System.out.println("NO");
					result = false;
					break;
				}
			}
		}
		if(result)
			System.out.println(sb);
	}
}

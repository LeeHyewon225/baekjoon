import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int tree[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new int[26][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A';
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			tree[root][0] = l == '.' ? -1 : l;
			tree[root][1] = r == '.' ? -1 : r;
		}
		preOrder('A');
		System.out.println();
		inOrder('A');
		System.out.println();
		postOrder('A');
	}

	static void preOrder(int n) {
		System.out.print((char) n);
		if (tree[n - 'A'][0] != -1)
			preOrder(tree[n - 'A'][0]);
		if (tree[n - 'A'][1] != -1)
			preOrder(tree[n - 'A'][1]);
	}

	static void inOrder(int n) {
		if (tree[n - 'A'][0] != -1)
			inOrder(tree[n - 'A'][0]);
		System.out.print((char) n);
		if (tree[n - 'A'][1] != -1)
			inOrder(tree[n - 'A'][1]);
	}

	static void postOrder(int n) {
		if (tree[n - 'A'][0] != -1)
			postOrder(tree[n - 'A'][0]);
		if (tree[n - 'A'][1] != -1)
			postOrder(tree[n - 'A'][1]);
		System.out.print((char) n);
	}
}

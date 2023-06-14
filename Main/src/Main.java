import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int answer = 0;
	static int R_answer = 0;
	static int B_answer = 0;
	static int diretion_list[][] = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int clean[][] = new int[N][M];
		for (int i = 0;i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0;j < M;j++)
				clean[i][j] = Integer.parseInt(st.nextToken());
	}

	int count = 0;
	int direction[][] = new int[4][4];

	// back
	direction[0][0]=1;direction[0][1]=0;direction[1][0]=0;direction[1][1]=-1;direction[2][0]=-1;direction[2][1]=0;direction[3][0]=0;direction[3][1]=1;

	// left
	direction[0][2]=0;direction[0][3]=-1;direction[1][2]=-1;direction[1][3]=0;direction[2][2]=0;direction[2][3]=1;direction[3][2]=1;direction[3][3]=0;

	while(true)
	{
		if (clean[r][c] == 0) {
			count++;
			clean[r][c] = 2;
		}
		if (clean[r][c - 1] != 0 && clean[r][c + 1] != 0 && clean[r + 1][c] != 0 && clean[r - 1][c] != 0) {
			if (clean[r + direction[d][0]][c + direction[d][1]] == 1)
				break;
			else {
				r += direction[d][0];
				c += direction[d][1];
				continue;
			}
		}
		if (clean[r + direction[d][2]][c + direction[d][3]] == 0) {
			r += direction[d][2];
			c += direction[d][3];
		}
		d -= 1;
		d = (d < 0) ? 3 : d;
	}System.out.println(count);
}}

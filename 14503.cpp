#include <iostream>
using namespace std;

int main() {
	int N, M, r, c, d;
	cin >> N >> M >> r >> c >> d;;

	int clean[51][51];
	for (int i = 0;i < N;i++)
		for (int j = 0;j < M;j++)
			cin >> clean[i][j];

	int count = 0;
	int direction[4][4]; 

	//back
	direction[0][0] = 1;
	direction[0][1] = 0;
	direction[1][0] = 0;
	direction[1][1] = -1;
	direction[2][0] = -1;
	direction[2][1] = 0;
	direction[3][0] = 0;
	direction[3][1] = 1;

	//left
	direction[0][2] = 0;
	direction[0][3] = -1;
	direction[1][2] = -1;
	direction[1][3] = 0;
	direction[2][2] = 0;
	direction[2][3] = 1;
	direction[3][2] = 1;
	direction[3][3] = 0;

	while (true) {
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
	}
	cout << count;
}
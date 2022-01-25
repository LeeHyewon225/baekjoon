#include <iostream>
#include<queue>
using namespace std;

queue<int> snake_r;
queue<int> snake_c;

int main() {
	int N, K;
	cin >> N >> K;

	int board[101][101];

	for (int i = 0;i < N;i++) 
		for (int j = 0;j < N;j++) 
			board[i][j] = 0;

	for (int i = 0;i < K;i++) {
		int r, c;
		cin >> r >> c;
		board[r - 1][c - 1] = 1;
	}

	int L;
	cin >> L;

	int next_diretion[101][2];
	int diretion_index = 0;
	for (int i = 0;i < L;i++) {
		char c;
		cin >> next_diretion[i][0] >> c;
		next_diretion[i][1] = (c == 'D') ? 1 : 0;
	}
	
	int present_diretion = 1;
	int present_c = 0;
	int present_r = 0;

	snake_r.push(present_r);
	snake_c.push(present_c);
	board[present_r][present_c] = 2;

	int diretion[4][2];
	diretion[0][0] = -1;
	diretion[0][1] = 0;
	diretion[1][0] = 0;
	diretion[1][1] = 1;
	diretion[2][0] = 1;
	diretion[2][1] = 0;
	diretion[3][0] = 0;
	diretion[3][1] = -1;

	int time = 0;

	while (true) {
		present_r += diretion[present_diretion][0];
		present_c += diretion[present_diretion][1];

		if (board[present_r][present_c] == 2 || present_c >= N || present_r >= N || present_c < 0 || present_r < 0) {
			time++;
			break;
		}

		snake_r.push(present_r);
		snake_c.push(present_c);

		if (board[present_r][present_c] != 1) {
			int r = snake_r.front();
			snake_r.pop();
			int c = snake_c.front();
			snake_c.pop();
			board[r][c] = 0;
		}

		board[present_r][present_c] = 2;
		time++;

		if (time == next_diretion[diretion_index][0]) {
			present_diretion = (next_diretion[diretion_index][1] == 1) ? (present_diretion + 1) % 4 : (present_diretion - 1);
			present_diretion = (present_diretion < 0) ? 3 : present_diretion;
			diretion_index++;
		}
	}
	cout << time;
	return 0;
}
#include <iostream>
using namespace std;

int N, M;
int answer = 0;
int R_answer = 0;
int B_answer = 0;
int diretion_list[5][2] = { {0,0},{-1,0},{0,1},{1,0},{0,-1} };

void marble(int R_row, int R_col, int B_row, int B_col, char map[11][11], int count, int diretion) {
	if (count == 10)
		return;
	if (answer == 1)
		return;
	char present_map[11][11];
	for (int i = 0;i < N;i++)
		for (int j = 0;j < M;j++)
			present_map[i][j] = map[i][j];
	R_answer = 0;
	int R_row_copy = R_row, R_col_copy = R_col, B_row_copy = B_row, B_col_copy = B_col;
	for (int i = 1;i <= N;i++) {
		present_map[R_row][R_col] = '.';
		if (present_map[R_row + diretion_list[diretion][0]][R_col + diretion_list[diretion][1]] == 'O') {
			R_answer = 1;
			break;
		}
		else if (present_map[R_row + diretion_list[diretion][0]][R_col + diretion_list[diretion][1]] != '#') {
			R_row += diretion_list[diretion][0];
			R_col += diretion_list[diretion][1];
		}
		else {
			present_map[R_row][R_col] = 'R';
			break;
		}
	}
	for (int i = 1;i <= N;i++) {
		present_map[B_row][B_col] = '.';
		if (present_map[B_row + diretion_list[diretion][0]][B_col + diretion_list[diretion][1]] == 'O')
			return;
		else if (present_map[B_row + diretion_list[diretion][0]][B_col + diretion_list[diretion][1]] != '#') {
			B_row += diretion_list[diretion][0];
			B_col += diretion_list[diretion][1];
		}
		else {
			present_map[B_row][B_col] = 'B';
			break;
		}
	}	

	answer = R_answer == 1 ? 1 : 0;
	if (answer == 1)
		return;

	if (R_row == B_row && R_col == B_col) {
		if (diretion == 1) {
			if (R_row_copy > B_row_copy) 
				R_row++;
			else 
				B_row++;
		}
		else if (diretion == 3) {
			if (R_row_copy > B_row_copy)
				B_row--;
			else
				R_row--;
		}
		if (diretion == 2) {
			if (R_col_copy > B_col_copy)
				B_col--;
			else
				R_col--;
		}
		else if (diretion == 4) {
			if (R_col_copy > B_col_copy)
				R_col++;
			else
				B_col++;
		}
		present_map[R_row][R_col] = 'R';
		present_map[B_row][B_col] = 'B';
	}
	if (diretion != 1)
		marble(R_row, R_col, B_row, B_col, present_map, count + 1, 1);
	if (diretion != 2)
		marble(R_row, R_col, B_row, B_col, present_map, count + 1, 2);
	if (diretion != 3)
		marble(R_row, R_col, B_row, B_col, present_map, count + 1, 3);
	if (diretion != 4)
		marble(R_row, R_col, B_row, B_col, present_map, count + 1, 4);
}

int main() {
	cin >> N >> M;
	char map[11][11];
	int R_row, R_col, B_row, B_col;
	for(int i=0;i<N;i++)
		for (int j = 0;j < M;j++) {
			cin >> map[i][j];
			if (map[i][j] == 'R') {
				R_row = i;
				R_col = j;
			}
			else if (map[i][j] == 'B') {
				B_row = i;
				B_col = j;
			}
		}
	marble(R_row, R_col, B_row, B_col, map, 0, 1);
	marble(R_row, R_col, B_row, B_col, map, 0, 2);
	marble(R_row, R_col, B_row, B_col, map, 0, 3);
	marble(R_row, R_col, B_row, B_col, map, 0, 4);
	cout << answer;
	return 0;
}
#include <iostream>
#include<algorithm>
using namespace std;

int N, M;
int combi_list[2501];
int chicken[2501][2];
int chicken_index = 0;
int home[2501][2];
int home_index = 0;
int min_city_distance = 999999999;

int difference(int a, int b) {
	return (a - b >= 0) ? a - b : b - a;
}

void calculate_chicken_street(int chicken_M[14]) {
	int city_distance = 0;
	for (int i = 0;i < home_index;i++) {
		int min_distance = 9999;
		for (int j = 0;j < M;j++) {
			int distance = difference(home[i][0], chicken[chicken_M[j]][0]) + difference(home[i][1], chicken[chicken_M[j]][1]);
			if (distance < min_distance)
				min_distance = distance;
		}
		city_distance += min_distance;
	}
	min_city_distance = (min_city_distance > city_distance) ? city_distance : min_city_distance;
}

void combination(int depth, int combi[2501], int next) {
	if (depth == M) {
		calculate_chicken_street(combi);
		return;
	}
	int c[2501];
	copy(combi, combi + chicken_index, c);
	for (int i = next;i < chicken_index;i++) {
		c[depth] = i;
		combination(depth + 1, c, i + 1);
	}
}

int main() {
	cin >> N >> M;
	int map[51][51];
	for (int i = 0;i < N;i++) {
		for (int j = 0;j < N;j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				home[home_index][0] = i;
				home[home_index][1] = j;
				home_index++;
			}
			else if (map[i][j] == 2) {
				chicken[chicken_index][0] = i;
				chicken[chicken_index][1] = j;
				combi_list[chicken_index] = 0;
				chicken_index++;
			}
		}
	}
	combination(0, combi_list, 0);
	cout << min_city_distance;
	
}
#include <iostream>
using namespace std;


int main() {
	int A, B;
	cin >> A >> B;
	int sum = 0;
	int count = 0;
	for (int i = 1;i <= 1000;i++) 
		for (int j = 1;j <= i;j++) {
			if (count > B) {
				cout << sum;
				return 0;
			}
			count++;
			if (A <= count && B >= count) 
				sum += i;
		}	
	return 0;
}
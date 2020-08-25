#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

/*
	그리디
	자리수 채우기
	큰자리수 부터 올리기
*/


int seg[10] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

int main() {
	int N;
	cin >> N;
	
	// n의 자리수
	int n = N/2;
	int r = N%2;
		
	vector<int> display;
	display.assign(n, 1);
	

	for(int i=0; i<n; i++) {
		if(r<1) {
			break;
		} else if(1<=r<4){
			display[i] = 7;
			r -= 1;
		} else if(4<=r){
			display[i] = 9;
			r -= 4;
		}
	}
	int max = 0;
	for(int e: display){
		max += e * pow(10, n-1);
		n--;
	}
	cout << max << endl;
	return 0;
}
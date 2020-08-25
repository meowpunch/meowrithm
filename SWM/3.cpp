/*
    모든 연속하는 두쌍에 대하여 차를 구하고
    큰거 K개 sum해줌.
    전체의 최대 최소의 차에서 sum을 빼줌. 
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K;
vector<int> arr; 
vector<int> sub; 

int main() {
	
    cin >> N;
    cin >> K;
    arr.assign(N, -1);
    sub.assign(N-1, 0);

    for(int i=0; i<N; i++){
        cin >> arr[i];
        if(i>0) {
            sub[i-1] = arr[i] - arr[i-1];
        }
    }

    sort(sub.begin(), sub.end(), greater<int>());

    int result = arr[N-1] - arr[0];

    for(int i=0; i<K-1; i++){
        result -= sub[i];
    }

    cout<< result<< endl;
    
	return 0;
}
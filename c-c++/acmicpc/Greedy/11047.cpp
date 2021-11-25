/*
    동전 0
*/

#include <iostream>
#include <vector>

using namespace std;

int N, K;
vector<int> coin;

int main() {
    cin>> N >> K;

    coin.assign(N, 0);
    for(int i=0; i<N; i++){
        cin>> coin[i];
    }

    int sol = 0;
    for(int i=N-1; i>=0; i--){
        //cout<< sol << coin[i] << endl;
        sol += K/coin[i];
        K = K%coin[i];
    }

    cout<< sol;

    return 0;
}
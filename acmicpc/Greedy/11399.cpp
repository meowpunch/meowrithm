/*
    ATM
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
vector<int> seq;

int main() {
    cin>> N;

    seq.assign(N, 0);
    for(int i=0; i<N; i++){
        cin>> seq[i];
    }

    sort(seq.begin(), seq.end(), less<int>());

    int sum = 0;
    int sol = 0;
    for(int e: seq) {
        sum = sum + e;
        sol += sum;
    }
       
    cout<<sol;

    return 0;
}
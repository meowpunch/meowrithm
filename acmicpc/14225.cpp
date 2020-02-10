/*
    부분수열의 합
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    int N;
    cin>> N;

    vector<int> seq(N,0);
    for(int i=0; i<N; i++) cin>> seq[i];

    sort(seq.begin(), seq.end());

    for(int e: seq) printf("%d ", e);

    return 0;
}
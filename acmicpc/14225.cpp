/*
    부분수열의 합
    same as Greedy 2437.cpp 
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

    // for(int e: seq) printf("%d ", e);

    /*
        when we can make the 1~k sum of subsequence 
        e<=k+1 -> 1~k+e
        e>k+1 -> 1~k
    */

    int k=0;
    for(int e: seq) {
        if(e<=k+1) k=k+e;
        else k=k;
    }

    cout<< k+1;
    return 0;
}
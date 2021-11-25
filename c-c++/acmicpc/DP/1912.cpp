/*
    연속합
    The maximum sum of contiguous subsequence
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<int> seq;
vector<int> opt;

int main() {

    cin>>N;
    seq.assign(N,-1);
    opt.assign(N,0);

    for(int i=0; i<N; i++) cin>>seq[i];

    // OPT(i) is the max sum of contigous subsequence ending at i
    opt[0] = seq[0];
    for(int i=1; i<N; i++) {
       opt[i] = max(opt[i-1] + seq[i], seq[i]);
    }

    int sol = -1001; // sol is more than -1001
    for(int e: opt) {
        if(sol<e) sol = e;
    }

    cout<<sol;

    return 0;
}
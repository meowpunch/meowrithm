/*
    포도주 시식

    opt(i): the max sum of subsequence endingAt i with conditions

    opt(i,0) = max( opt(i-2,0), opt(i-2,1) )
    opt(i,1) = opt(i-1,0)

    Be careful about `Non-negative integer` not `positive integer`
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> seq;
vector<vector<int>> opt;


int main() {
    cin>> n;

    seq.assign(n,0);
    opt.assign(n, vector<int>(2, 0));

    for(int i=0; i<n; i++){
        cin>> seq[i];
    }

    // case: n>=2 initialize

    if(n==1) {
        cout<< seq[0];
        return 0;
    }
    opt[0][0] = seq[0];
    opt[0][1] = 0;

    if(n==2) {
        cout<< seq[0] + seq[1];
        return 0;
    }
    opt[1][0] = seq[1];
    opt[1][1] = opt[0][0] + seq[1];

    opt[2][0] = max(opt[0][0], opt[0][1]) + seq[2];
    opt[2][1] = opt[1][0] + seq[2];

    for(int i=3; i<n; i++) {
        /* if(seq[i] == 0) {
            opt[i][0] = max(opt[i-1][0], opt[i-1][1]);
            continue;
        } */
        

        opt[i][0] = max(opt[i-3][1], max(opt[i-2][0], opt[i-2][1])) + seq[i];
        opt[i][1] = opt[i-1][0] + seq[i];   
    }

    /* for(vector<int> e: opt){
        for(int l: e)printf("%d ",l);
        printf("\n");
    } */

    cout<< max(opt[n-2][1], max(opt[n-1][0], opt[n-1][1]));
    return 0;
}


/*

TEST CASE

6

2 1 0 0 8 9

answer: 21


*/
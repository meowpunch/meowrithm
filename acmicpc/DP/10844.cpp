/*
    쉬운 계단수
*/

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    vector<vector<int>> opt;
    // vector<int> flag;

    cin>> N;
    opt.assign(N+1, vector<int>(10,0));
    // flag.assign(N+1, 0);

    opt[1][0] = 0;
    for(int i=1; i<10; i++){
        opt[1][i] = 1;
    }

    if(N==1) {
        cout<<'9';
        return 0;
    }

    for(int i=2; i<=N; i++) {
        opt[i][0] = opt[i-1][1];
        opt[i][1] = (opt[i-1][0] + opt[i-1][2]) % 1000000000;
        opt[i][2] = (opt[i-1][1] + opt[i-1][3]) % 1000000000;
        opt[i][3] = (opt[i-1][2] + opt[i-1][4]) % 1000000000;
        opt[i][4] = (opt[i-1][3] + opt[i-1][5]) % 1000000000;
        opt[i][5] = (opt[i-1][4] + opt[i-1][6]) % 1000000000;
        opt[i][6] = (opt[i-1][5] + opt[i-1][7]) % 1000000000;
        opt[i][7] = (opt[i-1][6] + opt[i-1][8]) % 1000000000;
        opt[i][8] = (opt[i-1][7] + opt[i-1][9]) % 1000000000;
        opt[i][9] = opt[i-1][8];
    }

    int sol = 0;

    for(int e: opt[N]) {
        sol = (sol + e) % 1000000000;
    }

    cout<< sol;


    return 0;
}

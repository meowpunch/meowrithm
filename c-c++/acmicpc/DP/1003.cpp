/*
    피보나치 함수
*/

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T;
    cin>> T;

    vector<vector<int>> opt(41, vector<int>(2,0));
    /*
        opt(0) <- 1 0
        opt(1) <- 0 1
        opt(2) <- 1 1
        opt(3) <- 1 2
    */
    opt[0][0] = 1;
    opt[0][1] = 0;

    opt[1][0] = 0;
    opt[1][1] = 1;

    for(int i=2; i<=40; i++) {
        opt[i][0] = opt[i-1][0] + opt[i-2][0];
        opt[i][1] = opt[i-1][1] + opt[i-2][1];
    }

    for(int t=0; t<T; t++){
        int n;
        cin>> n;

        printf("%d %d\n", opt[n][0], opt[n][1]);

    }

    return 0;
}
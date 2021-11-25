/* 
    이친수
    DP 
*/

// OPT(i,0) & OPT(i,1) means the number of the i length arrays satisfying the conditions '이친수', ending with 0 & 1 

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    scanf("%d", &N);

    vector<vector<long long>> opt;
    opt.assign(N, vector<long long>(2,-1));

    if(N<=2) {printf("1"); return 0;}
    if(N==3) {printf("2"); return 0;}
    opt[0][0] = -1;
    opt[0][1] = 1;
    opt[1][0] = 1;
    opt[1][1] = -1;
    opt[2][0] = 1;
    opt[2][1] = 1;

    for(int i=3; i<N; i++){
        opt[i][0] = opt[i-1][0] + opt[i-1][1];
        opt[i][1] = opt[i-1][0];
    }

    //if(N<=2) printf("1");
    if(N>3)printf("%lld", opt[N-1][0] + opt[N-1][1]);

    return 0;
}
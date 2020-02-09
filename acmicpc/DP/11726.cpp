/*
    2xn 타일
*/

#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> opt;

int main() {
    cin>> N;
    opt.assign(N+1, -1);

    /*
        OPT(i) = OPT(i-1) + OPT(i-2);
        
        case ending at vertical tile(2x1): OPT(i-1)
                
        case ending at horizontal tile(1x2): OPT(i-2)
    */
    opt[0] = 0;
    opt[1] = 1;
    
    if(N<2) {
        cout<< opt[N];
        return 0;
    }

    opt[2] = 2;
    for(int i=3; i<=N; i++){
        opt[i] = (opt[i-1] + opt[i-2]) % 10007;
    }

    cout<< opt[N] ;

    return 0;
}
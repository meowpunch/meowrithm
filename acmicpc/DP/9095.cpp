/*
    1, 2, 3 더하기
*/

#include <iostream>
#include <vector>

using namespace std;

int T;

int main() {
    cin>> T;
    vector<int> opt(12,0);

    opt[1] = 1;
    opt[2] = 2;
    opt[3] = 4;

    /*
        3: 1+2/ 1+1+1, 2+1/ 3
        
        OPT(i) = OPT(i-1) + OPT(i-2) + OPT(i-3)
        
        add '+1' to every sequence in OPT(i-1)
        add '+2' to every sequence in OPT(i-2)
        add '+3' to every sequence in OPT(i-3)
    */

    for(int i=0; i<T; i++) {
        int n;
        cin>> n;

        
        if(n<=3) {
            cout<< opt[n]<< '\n';
            continue;
        }

        for(int j=4; j<=n; j++) {
            opt[j] = opt[j-1] + opt[j-2] + opt[j-3];
        }

        cout<< opt[n]<< '\n';

    }


    return 0;
}
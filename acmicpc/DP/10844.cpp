/*
    쉬운 계단수
*/

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    vector<int> opt;
    vector<int> flag;

    cin>> N;
    opt.assign(N+1, 0);
    flag.assign(N+1, 0);

    /*
        j=0
        OPT(i,j) = 2*OPT(i-1,j)
        j=1 ()
        OPT(i,j) =  
    */


    return 0;
}

/*
    저울

    In the case that i can estimate 1~K weight,
    e<=K+1 => can estimate 1~K+e weight
    e>K+1 => sol = K+1
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<int> seq;

int main() {
    cin>> N;

    seq.assign(N,0);
    for(int i=0; i<N; i++){
        cin>> seq[i];
    }

    sort(seq.begin(), seq.end());

    int K=0;

    /*
        1~K까지 만들수있음
        K+1<e 이면 fail
        K+1>=e K+e까지 만들 수 있음.
    */
 
    for(int i=0; i<N; i++) {
        if(seq[i]<=K+1) K+=seq[i];
        else break;
    }

    cout<< K+1;

    return 0;
}
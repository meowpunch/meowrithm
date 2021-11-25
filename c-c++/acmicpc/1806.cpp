/*
    부분합
*/

#include <iostream>
#include <vector>

using namespace std;

int main() {

    int N, S;
    cin>> N>> S;

    vector<int> seq(N,0);
    vector<int> sum(N,0);

    // O(N)
    for(int i=0; i<N; i++){
        cin>> seq[i];
        if(i==0){
            sum[i] = seq[i];
        } else if(i>0){
            sum[i] = sum[i-1] + seq[i];
        }
    }

    int minL = 100001;
    if(sum[0] >= S) minL=1;

    // O(N^2) 10^10 -> LTE
    for(int i=0; i<N; i++) {
        for(int j=0; j<=i; j++){
            if(S<=sum[i]-sum[j] && i-j < minL) minL = i-j;
        }
    }

    cout << minL;


    return 0;
}
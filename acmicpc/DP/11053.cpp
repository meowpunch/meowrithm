/* 
    가장 긴 증가하는 부분 수열
    DP 
*/

// OPT(i): longest increasing array, ending at i 

#include <iostream>
#include <vector>

using namespace std;

int main() {
    
    int N;
    vector<int> arr;  
    
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        int x;
        scanf("%d", &x);
        arr.push_back(x);
    }

    vector<vector<int>> opt;
    opt.assign(N, vector<int>(2, -1));

    opt[0][0] = 1;
    opt[0][1] = arr[0];
    
    // implement the DP algorithm in a 'bottom up' way
    for(int i=1; i<N; i++){
        for(int j=0; j<i; j++){
            if(arr[i]>opt[j][1] && opt[i][0]<opt[j][0] + 1) {
                opt[i][0] = opt[j][0] + 1;
                opt[i][1] = arr[i];
            }
        }
        if(opt[i][0] == -1) {
            opt[i][0] = 1;
            opt[i][1] = arr[i];
        }
    }

    /* for(vector<int> e: opt) {
        for(int l: e) printf("%d ", l);
        printf("\n");
    } */
    int maxLength = -1;
    for(vector<int> e: opt) {
        if(maxLength<e[0])maxLength=e[0];
    }
    printf("%d", maxLength);

    return 0;
}
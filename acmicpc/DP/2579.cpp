/* 
    계단 오르기
    DP
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> mem;
vector<int> stair;

int calMax(int n) {

}


int main() {
    
    int N;
    scanf("%d", &N);

    // to get max => intialize '-1'
    mem.assign(N, vector<int>(2, -1));

    for(int i=0; i<N; i++) {
        int x;
        scanf("%d", &x);
        stair.push_back(x);
    }

    // for(int e: stair) printf("%d\n", e);

    // [i][0] => 2 steps | [i][1] => 1 steps 
    mem[0][1] = -1;
    mem[0][0] = stair[0];

    mem[1][1] = mem[0][0] + stair[1];
    mem[1][0] = stair[1];

    
    //for 문으로 구현
    for(int i=2; i<N; i++) {
        if(mem[i-1][0] != -1) mem[i][1] = mem[i-1][0] + stair[i];

        mem[i][0] = max(mem[i-2][1], mem[i-2][0]) + stair[i];
    }

    /* for(vector<int> e: mem){
        for(int l: e){
            printf("%d ", l);
        }
        printf("\n");
    } */
    
    printf("%d\n",max(mem[N-1][1], mem[N-1][0]));

    return 0;
}
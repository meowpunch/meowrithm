/* 
    계단 오르기
    DP
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> mem, mem2;
vector<int> stair;

// Bottom up
int calMax1(int N) {
     // [i][0] => 2 steps | [i][1] => 1 steps 
    mem[0][1] = -1;
    mem[0][0] = stair[0];

    mem[1][1] = mem[0][0] + stair[1];
    mem[1][0] = stair[1];

    
    for(int i=2; i<N; i++) {
        mem[i][1] = mem[i-1][0] + stair[i];
        mem[i][0] = max(mem[i-2][1], mem[i-2][0]) + stair[i];
    }

    return max(mem[N-1][1], mem[N-1][0]);
}


// Top down
int calMax2(int n, int c) {

    if(n==0 && c==0) return mem2[n][c] = stair[0];
    else if(n==0 && c==1)return mem2[n][c] = -1;
    else if(n==1 && c==0) return mem2[n][c] = stair[1];
    else if(n==1 && c==1)return mem2[n][c] = calMax2(0,0) + stair[1];
    else if(n<0) {
        return -1;
    }

    if(mem2[n][c] != -1) return mem2[n][c];

    if(c==0)return mem2[n][c] = max(calMax2(n-2,0), calMax2(n-2,1)) + stair[n];
    else if(c==1){
        // printf("%d %d %d\n", n, c, calMax2(n-1, 0) + stair[n]);
        return mem2[n][c] = calMax2(n-1, 0) + stair[n];
        
    }
}

int main() {
    
    int N;
    scanf("%d", &N);

    // to get max => intialize '-1'
    mem.assign(N, vector<int>(2, -1));
    mem2.assign(N, vector<int>(2, -1));


    for(int i=0; i<N; i++) {
        int x;
        scanf("%d", &x);
        stair.push_back(x);
    }

    printf("%d\n", calMax1(N));
    printf("%d\n", max(calMax2(N-1,0), calMax2(N-1,1)));

    /* for(vector<int> e: mem){
        for(int l: e){
            printf("%d ", l);
        }
        printf("\n");
    }
    for(vector<int> e: mem2){
        for(int l: e){
            printf("%d ", l);
        }
        printf("\n");
    } */

    return 0;
}
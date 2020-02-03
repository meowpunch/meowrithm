/* 
    1로 만들기
*/
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> mem;

// Dynamic Programming (DP) with memoizaion

int calMin(int n, int count){
    printf("%d %d\n", n, count);
    if(n==1) return 0;

    if(mem[n] != 1000000) return mem[n];

    if(n%3==0 && n%2==0) return mem[n] = min( min(calMin(n/3, count+1), calMin(n/2, count+1)), calMin(n-1, count+1)) + 1;
    else if(n%2==0) return mem[n] = min(calMin(n/2, count+1), calMin(n-1, count+1)) + 1 ;
    else if(n%3==0) return mem[n] = min(calMin(n/3, count+1), calMin(n-1, count+1)) + 1;
    else return mem[n] = calMin(n-1, count+1) + 1;
}


// BFS is more faster than DP in this problem.
vector<int> v; // represent notVisited(== -1) & count(> -1)

int isValidPos(int x, int n){
    if(0<x&&x<=n)return 1;
    else return 0;
}
int calMin2(int n) {
    v.assign(n+1,-1);

    queue<int> q;

    q.push(n);
    v[n] = 0;

    while(!q.empty() && q.front() != 1) {
        int cur = q.front();
        // cout<<q.size()<<endl;
        q.pop();

        if(cur%3==0 && isValidPos(cur/3, n)==1 && v[cur/3]==-1){
            q.push(cur/3);
            v[cur/3] = v[cur] + 1;
        }
        if(cur%2==0 && isValidPos(cur/2, n)==1 && v[cur/2]==-1){
            q.push(cur/2);
            v[cur/2] = v[cur] + 1;
        }
        if(isValidPos(cur-1, n)==1 && v[cur-1]==-1){
            q.push(cur-1);
            v[cur-1] = v[cur] + 1;
        }
    }

    return v[1];
}

int main() {

    int N;
    scanf("%d", &N);

    mem.assign(N+1, 1000000);

    // printf("%d\n", calMin(N, 0));
    printf("%d\n", calMin2(N));

    return 0;
}
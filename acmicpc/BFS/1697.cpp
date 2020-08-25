/* 
    숨박꼭질

    DP/1463.cpp '1로 만들기' 와 비교
*/

#include <iostream>
#include <vector>
#include <queue>

using namespace std; 

int N, K; // str: N, end: K

// int mov[3] = {-1, +1};
vector<int> mem;
vector<int> visited;
vector<int> count;

int isValidPos(int x){
    if(0<=x&&x<=100000)return 1;
    else return 0;
}

void calMin() {
    
    queue<int> q;
    q.push(N);
    visited[N]=1;
    count[N]=0;

    while(!q.empty() && q.front() != K){

        int curPos = q.front();
        // cout<< curPos << endl;
        q.pop();

        if(isValidPos(curPos+1) == 1 && visited[curPos+1] != 1) {
            q.push(curPos+1);
            visited[curPos+1] = 1;
            count[curPos+1] = count[curPos] + 1;
        } 
        if(isValidPos(curPos-1) == 1 && visited[curPos-1] != 1) {
            q.push(curPos-1);
            visited[curPos-1] = 1;
            count[curPos-1] = count[curPos] + 1;
        }
        if(isValidPos(curPos*2) == 1 && visited[curPos*2] != 1) {
            q.push(curPos*2);
            visited[curPos*2] = 1;
            count[curPos*2] = count[curPos] + 1;
        }
    }
}

int main() {

    scanf("%d %d", &N, &K);
    visited.assign(100001, 0);
    count.assign(100001,-1);

    calMin();

    printf("%d", count[K]);

    return 0;
}
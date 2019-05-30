#include <string>
#include <vector>
#include <iostream>

using namespace std;

int count = 0;

void dfs(int N,vector<int> num, int target,int flag) {

    int sum = 0;
    for(int i=0; i<N; i++) sum += num[i];
    if(sum==target) count++;

    for(int i=flag; i<N; i++) {
        //printf("i: %d ", i);
        vector<int> temp(num);
        temp[i] = -temp[i];
        dfs(N, temp, target, i+1);
    }
}

void dfs2(int N,vector<int> num, int target,int flag) {

    if(flag == N) {
        int sum = 0;
        for(int i=0; i<N; i++) sum += num[i];
        if(sum==target) count++;
    } else {
        dfs2(N, num, target, flag+1);
        num[flag] *= -1;
        dfs2(N, num, target, flag+1);
    }
}

int solution(vector<int> numbers, int target) {
    //int answer = 0;
    int size = numbers.size();
    dfs(size, numbers, target, 0);
    return count;
}

int main() {

    vector<int> n;
    n.push_back(1);
    n.push_back(1);
    n.push_back(1);
    n.push_back(1);
    n.push_back(1);

    int answer = solution(n, 3);
    printf("%d", answer);

    return 0;
}

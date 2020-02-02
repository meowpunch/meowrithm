#include <iostream>
#include <vector>
#include <algorithm>

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

int main() {

    int N;
    scanf("%d", &N);

    mem.assign(N+1, 1000000);

    printf("%d", calMin(N, 0));

    return 0;
}
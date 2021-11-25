/*
    소수 찾기
*/

#include <iostream>

using namespace std;

int main () {
    int N, count;
    scanf("%d", &N);
    
    count = 0;
    for(int i=0; i<N; i++){
        int x;
        scanf("%d", &x);

        if(x==1)continue;
        count++;
        for(int e=2; e<x; e++){
            if(x%e==0) {
                count--;
                break;
            }
        }
    }

    cout<<count;

    return 0;
}
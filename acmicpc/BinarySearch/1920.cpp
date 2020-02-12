/*
    수 찾기
    binary search

    cin cout -> time out
    solve by using printf scanf... ;;
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, M;

    scanf("%d", &N);

    vector<int> seq(N);
    for(int i=0; i<N; i++){
        scanf("%d",&seq[i]);
    }

    sort(seq.begin(),seq.end(), less<int>());
    // for(int e: seq) cout<< e;

    

    scanf("%d", &M);
    vector<int> com(M); 
    
    // sort(com.begin(), com.end()); // default: less -> 1 2 3 4 5 ~
    for(int i=0; i<M; i++){
        scanf("%d",&com[i]);
    }

    for(int i=0; i<M; i++) {
        int obj = com[i];
        int s = 0;
        int e = N-1;
        int flag = 0;

        while(s<=e){
            int m = (s+e)/2;


            if(obj==seq[m]) {
                flag = 1;
                break;
            } else if(obj<seq[m]) {
                s = s;
                e = m - 1;
            } else if(obj>seq[m]) {
                s = m + 1;
                e = e;
            }
        }

        if(flag == 1) printf("1\n");
        else printf("0\n");
    }
    

    return 0;
}
/* 
    상자넣기 

    Longest increasing subsquence
*/

#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> seq;
vector<int> opt;

int findLIS() {
    int length = 0;

    opt[0] = 1;
    for(int i=1;i<N;i++){
        int max = -1;
        for(int j=0;j<i;j++){
            if(seq[i]>seq[j]&&opt[j]>max){
                max = opt[j];
            }
        }
        if(max==-1){
            opt[i] = 1;
        } else opt[i] = max + 1;
    }
    
    for(int e: opt){
        if(length<e)length = e;
    }    

    return length;
}

int main() {

    scanf("%d", &N);

    seq.assign(N,0);
    opt.assign(N,-1);

    for(int i=0; i<N; i++){
        scanf("%d", &seq[i]);
    }
    
    printf("%d\n", findLIS());

    return 0;
}
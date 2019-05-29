#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    vector<int> answer;

    int C[31];
    for(int i = 1;  i<n+1; i++) C[i] = 1;

    while(!reserve.empty()) {
        C[reserve.back()]++;
        reserve.pop_back();
    }

    while(!lost.empty()) {
        int i = lost.back();
        C[i]--;
        lost.pop_back();
    }

    for(int index=1; index<n+1; index++) {
        if(C[index] == 0) {
            if(C[index-1] == 2){
                C[index-1]--;
                C[index]++;
            } else if(C[index+1] == 2){
                C[index+1]--;
                C[index]++;
            } else{
                answer.push_back(index);
            }
        }
    }

    return n - answer.size();
}

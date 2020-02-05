/*
    방 배정
    KOI 초등부
*/

#include <iostream>
#include <vector>

using namespace std;

int N, K;
vector<vector<int>> stu;

int main() {
    cin>> N >> K;

    stu.assign(7, vector<int>(2, 0)); // stu[i][0] => The number of female students in i grade
    for(int i=0; i<N; i++){
        int sex, grade;
        cin>> sex>> grade;

        stu[grade][sex]++;
    }

    int rooms = 0;
    for(vector<int> e: stu) {
        rooms += e[0]/K;
        rooms += e[1]/K;

        if(e[0]%K>0)rooms++;
        if(e[1]%K>0)rooms++;
    }

    cout<<rooms;

    return 0;   
}
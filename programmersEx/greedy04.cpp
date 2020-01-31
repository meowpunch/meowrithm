/* 효율성 검사 통과 못함
#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;



int solution(vector<int> people, int limit) {

    int answer = 0;
    priority_queue<int> pq;
    queue<int> spare;

    while(!people.empty()) {
        pq.push(people.back());
        people.pop_back();
    }

    int cur;    //현재 수용가능 무게
    int count = 0;

    while(!pq.empty()){
        count = 0;
        cur = limit;
        answer++;
        while(!pq.empty()){
            //cout<< pq.top() <<"\n";
            if(count == 2) break;
            if(pq.top()<=cur) { //들어가는 경우 제외
                cur -= pq.top();
                cout<< pq.top() <<"해결! \n";
                pq.pop();
                count++;
            }else { // 안들어가는 경우 spare에 넣어준다.
                spare.push(pq.top());
                pq.pop();
            }
        }

        while(!spare.empty()){ //한 사이클 마치기전에 spare에 있는 것 모두 pq에 넣어주기.
            pq.push(spare.front());
            spare.pop();
        }
    }

    return answer;
}


int solution(vector<int> people, int limit) {
    priority_queue<int> pq;

    while(!people.empty()) {
        pq.push(people.back());
        people.pop_back();
    }
    vector<pair<int,int>> boat; //first 현재수용가능무게, second 현재수용가능인원
    int flag = 0;
    while(!pq.empty()) { // O(N^2) 시간 복잡도
        if(flag == 1) flag = 0;
        else { boat.push_back(make_pair(limit,2)); }
        for(int i=0; i<boat.size(); i++) {
            if(boat[i].second > 0 && pq.top()<=boat[i].first) {
                boat[i].first -= pq.top();
                boat[i].second--;
                flag = 1;
                //cout<<pq.top()<< " ";
                pq.pop();
                break;
            }
        //cout<<boat[i].first << boat[i].second<<" ";
        }
        printf("\n");
    }

    return boat.size();
}

*/

// 구명보트
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end(), greater<int>());
    int left = 0;
    int right = people.size() - 1;
    int total = 0;
    /*
        가장 큰 것을 가장 작은 것부터 짝을 찾으면서 가능하면 바로 boat에 태움
        짝이 없다 혼자 태움.

        짝으로 배에 태운다면 "최대"는 "최소"와 짝을 이룸
        2명이 최대기 때문에 가능한 알고리즘.
    */
    while(left<=right){
        if(people[left]+people[right]<=limit){ // 짝 맞으면 같이 태움.
            right--; left++;
        } else { // 짝 안맞으면 큰애 혼자 태움.
            left++;
        }
        total++;
    }
    return total;
}

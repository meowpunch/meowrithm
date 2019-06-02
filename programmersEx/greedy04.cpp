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

*/

#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> people, int limit) {
    vector<pair<int,int>> boat; //first 현재수용가능무게, second 현재수용가능인원
    while(!people.empty()) {
        boat.push_back(make_pair(limit,2));
        for(int i=0; i<boat.size(); i++) {
            if(people.back()<=boat[i].first && boat[i].second > 0) {
                boat[i].first -= people.back();
                boat[i].second--;
                people.pop_back();
            }
        }
    }
    return boat.size();
}

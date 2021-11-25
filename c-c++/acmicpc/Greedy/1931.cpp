#include <iostream>
#include <queue>

using namespace std;

class Conference{
    public:
        int str;
        int end;    

    Conference(int str, int end) {
        this->str = str;
        this->end = end;
    };

    bool operator< (const Conference& a) const {
        return (end > a.end || (end == a.end && str > a.str)) ;
    };
    
};

int N;

int main() {
    
    cin>> N;

    priority_queue<Conference> pq;

    for(int i=0; i<N; i++) {
        int s,e;
        cin>> s >> e;

        pq.push(Conference(s,e));
    }
    
    int endTime = -1;
    int count = 0;
    while(!pq.empty()) {
        Conference curCon = pq.top();
        pq.pop();

        if(curCon.str >= endTime) {
            // cout<< curCon.str << curCon.end << endl;
            endTime = curCon.end;
            count++;
        }
    }

    cout<<count;
    
    return 0;
}


/*
 TEST CASE

 9
8 8
5 8
3 4
2 5
2 7
8 8
1 10
3 3
10 10

answer: 6

If u implement Greedy Algorithm just sorting endTime, ur output maybe 5.
*/
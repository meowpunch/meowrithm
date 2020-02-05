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
        return end > a.end;
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
            endTime = curCon.end;
            count++;
        }
    }

    cout<<count;
    
    return 0;
}
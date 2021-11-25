/*
    강의실
*/

#include <iostream>
#include <queue>

using namespace std;

class Lecture
{
public:
    int num;
    int str;
    int end;
    bool visitied = false;

    Lecture(int num, int str, int end)
    {
        this->num = num;
        this->str = str;
        this->end = end;
    };
    bool operator<(const Lecture &b) const
    {
        return end > b.end;
    };
};

int N;

int main()
{
    cin >> N;

    priority_queue<Lecture> pq;
    vector<vector<Lecture>> rooms;

    for (int i = 0; i < N; i++)
    {
        int num, str, end;
        cin >> num >> str >> end;
        pq.push(Lecture(num, str, end));
    }

    // cout << pq.top().end << endl;

    int endTime;
    //rooms.assign(100001, vector<Lecture>());

    int numR = 0;
    vector<Lecture> tmp;
    tmp.push_back(pq.top());
    rooms.push_back(tmp);
    pq.pop();

    while (!pq.empty())
    {

        Lecture curL = pq.top();
        pq.pop();

        int flag = 0;
        for (vector<Lecture> &room : rooms)
        {   
            // cout<< "*";
        
            if (room.back().end <= curL.str)
            {
                room.push_back(curL);
                flag = 1;
            }
        }

        if (flag == 0)
        {
            //cout<<"??"<<endl;
            rooms.push_back(vector<Lecture>(1, curL));
            // rooms[++numR].push_back(curL);
        }
    }

    for (vector<Lecture> x : rooms)
    {
        //cout<< x.size() << endl;
        for (Lecture y : x)
        {
            cout << y.num;
        }
        cout << endl;
    }
    cout << endl;

    cout << rooms.size();
    return 0;
}
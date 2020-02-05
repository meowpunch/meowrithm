/*
    방 배정
    KOI 중등부
*/

#include <iostream>
#include <vector>

using namespace std;

int N, K;
vector<vector<int>> stu;

int main()
{
    cin >> N >> K;
    stu.assign(3, vector<int>(2)); // stu[class][sex] : class 0 => 1~2 grade
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin>>x>>y;

        if (x)
        {
            if (y == 1 || y == 2)
                stu[0][1]++;
            if (y == 3 || y == 4)
                stu[1][1]++;
            if (y == 5 || y == 6)
                stu[2][1]++;
        }
        else
        {
            if (y == 1 || y == 2)
                stu[0][0]++;
            if (y == 3 || y == 4)
                stu[1][0]++;
            if (y == 5 || y == 6)
                stu[2][0]++;
        }
    }

    int rooms = 0;

    for (int i = 0; i < 3; i++)
    {
        if (i == 0){       
            int tmp = stu[i][1] + stu[i][0];
            rooms += tmp / K + (tmp % K > 0 ? 1 : 0);
        } else {
            int tmp0 = stu[i][0];
            int tmp1 = stu[i][1];
            rooms += tmp0 / K + (tmp0 % K > 0 ? 1 : 0);
            rooms += tmp1 / K + (tmp1 % K > 0 ? 1 : 0);
        }
    }

    cout<< rooms;
    return 0;
}

/*
int main() {
    cin>> N >> K;

    stu.assign(7, vector<int>(2, 0)); // stu[i][0] => The number of female students in i grade
    for(int i=0; i<N; i++){
        int sex, grade;
        cin>> sex>> grade;

        stu[grade][sex]++;
    }

    int rooms = 0;
    
    int tmp = stu[1][0] + stu[1][1] + stu[2][0] + stu[2][1];
    rooms += tmp/K;
    if(tmp%K>0)rooms++;

    int m34 = stu[3][1] + stu[4][1];
    int w34 = stu[3][0] + stu[4][0];
    rooms += m34/K;
    rooms += w34/K;
    if(m34%K>0) rooms++;
    if(w34%K>0) rooms++;

    int m56 = stu[5][1] + stu[6][1];
    int w56 = stu[5][0] + stu[6][0];
    rooms += m56/K;
    rooms += w56/K;
    if(m56%K>0) rooms++;
    if(w56%K>0) rooms++;
    

    cout<<rooms;

    return 0;   
}
*/
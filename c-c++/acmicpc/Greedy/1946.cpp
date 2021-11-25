/*
    신입사원
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int T;

int main()
{

    cin >> T;

    for (int i = 0; i < T; i++)
    {
        int N;
        cin >> N;

        vector<pair<int, int>> applicant(N);

        for (int j = 0; j < N; j++)
        {
            int f, s;
            cin >> f >> s;
            applicant[j] = make_pair(f, s);
        }

        sort(applicant.begin(), applicant.end());

        // for(pair<int,int> e: applicant) printf("%d %d \n", e.first, e.second);

        pair<int, int> top = applicant.front();

        int sol = 0;
        int std = top.second;
        for (pair<int, int> e : applicant){
            if (e.second <= std)
            {
                std = e.second;
                sol++;
            }
        }

        cout << sol << endl;
    }

    return 0;
}
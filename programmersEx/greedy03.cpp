// 큰수만들기

#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string number, int k) {
    int S = number.size();
    int count = 0;

    while(number.size() > S-k) {

        int minV = 1000001;
        int minIndex = 0;
        int i = 0;

        /*
            앞에서 부터 number.size() - count 번째 index까지 탐색하면서
            이전값보다 커지는 값이 있을때, 이전 값을 제거한다.
        */

        while(minV >= number[i] && i < number.size()) {
            minV = number[i];
            minIndex = i;
            i++;
        }

        //answer.push_back(maxV);
        number.erase(minIndex,1);
        count++;

        //cout<< number << "\n";
    }
    return number;
}

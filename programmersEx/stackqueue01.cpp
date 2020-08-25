// 쇠막대기

#include <string>
#include <vector>
#include <iostream>

using namespace std;

/* '('나오면 스텍에 집어넣고 ')'나오면 스택에서 '('꺼낸다.*/
int solution(string arrangement) {
    string str(arrangement);
    //cout<<str;
    int answer = 0;
    vector<char> s;

    int num = 0; // 자르는 막대수
    int count = 0; // 잘린 총 막대수
    int flag = 0; // '('이면 0 , ')'이면 1  => 이전에 무엇이 나왔는지 확인하는데 사용
    for(int i=0; i<str.length(); i++) {
        if(str[i] == '(') {
            s.push_back('(');
            flag = 0;
            //num++;
        } else {
            s.pop_back(); // ')'가 나오면 '(' 하나 팝해준다.

            if(flag == 0) { // 전에 '(' 였으면 레이저 생긴 것이고 잘라진 개수를 count 해준다.
                //num--;
                //printf("%d 개 잘림", num);
                count += s.size();
            } else{ // 전에 ')' 였으면 나무 막대 하나 끝난 것임.
                //num--;
                count++; // 꼬다리들
            }
            flag = 1;
        }
    }
    return count;
}

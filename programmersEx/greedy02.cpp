#include <string>
#include <vector>
#include <iostream>

using namespace std;

//아스키 코드 A:97

int solution(string name) {
    int count = 0;
    int size = name.length();

    // cout<<name;
    // printf("%d", name[0] - 'A');
    // printf("%c", name[size-1]);

    // step 1) 문자 바꾼 회수
    for(int i=0; i<size; i++) {
        if(name[i] - 'A' < 'Z' - name[i] + 1) count += name[i] - 'A';
        else count += 'Z' - name[i] + 1;
    }

    printf("알파벳 카운트: %d \n", count);

    // step 2) 이동 회수

    if(size == 1) return count;

    int left = 1;
    int right = 1;
    int flag = 0;

    for(int i=1; i<size; i++){ // 왼쪽에서 부터 A가 아닌 것꺼자 거리
        if(name[i] != 'A'){ flag=1; break; }
        left++;
    }

    for(int i=size-1; i>0; i--){ // 오른쪽에서 부터 A가 아닌 것꺼자 거리
        if(name[i] != 'A'){ flag=1; break; }
        right++;
    }

    printf("right: %d left: %d \n", right, left);

    if(flag == 0) {printf("??"); return count; }
    else if(left > right) {printf("여긴데"); return count + size-left; }
    else { printf("gg"); return count + size-right; }



}

//ABAAAB 경우 해결하지 못함 최적해는 5인데 내 알고리즘으로는 7이 나옴

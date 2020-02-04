/*
    정사각형
    
    기하 알고리즘
*/

#include <iostream>
#include <cmath>
#include <vector>
#include <queue>

using namespace std;

int N;
vector<vector<int>> p(4, vector<int>(2));

/* int checkRec(vector<vector<int>> p) {
    
    long long check;
    for(int e=0; e<6; e++) {
        check = 1;
        long long l = calDis(p[seq[e][3]], p[seq[e][0]]);
        for(int i=0; i<3; i++) {
            // cout<< l << endl;
            if(calDis(p[seq[e][i]],p[seq[e][i+1]]) != l) check = 0;
            l = calDis(p[seq[e][i]],p[seq[e][i+1]]); 
        }   
        if(check==1)return check;
    }0

    return check;
}
 */


long long calDis(vector<int> p1, vector<int> p2){
    return pow(p1[0] - p2[0],2) + pow(p1[1] - p2[1],2);
}

int ch1() {
    int check = 1;

    for(int i=0; i<4; i++){
        priority_queue<int, vector<int>, greater<int>> pq;

        for(int j=0; j<4; j++){
            pq.push(calDis(p[i],p[j]));
        }

        pq.pop();
        int a = pq.top();
        pq.pop();
        int b = pq.top();
        pq.pop();
        int c = pq.top();
        pq.pop();
        // cout<< a<< b<< c<< endl;

        if(!(c==a+b && a==b)) check = 0;
    }

    return check;
}



int main() {
    scanf("%d", &N);

    for(int i=0; i<N; i++) {
        for(int j=0; j<4; j++){
            scanf("%d %d", &p[j][0], &p[j][1]);
        }

        //printf("%lf\n", calDis(p[0], p[1]));
        printf("%d\n", ch1());
    }

    return 0;
}


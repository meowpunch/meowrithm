#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[])
{
    int a,b,c;

    cin >> a >> b >> c;

    while (!(a==0&&b==0&&c==0)) {
        priority_queue<int> q;
        q.push(a);
        q.push(b);
        q.push(c);

        a = q.top();
        q.pop();
        b = q.top();
        q.pop();
        c = q.top();
        q.pop(); 

        if(a*a == b*b + c*c) cout << "right" << endl;
        else cout << "wrong" << endl;

        cin >> a >> b >> c;
    }

    return 0;
}

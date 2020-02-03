/* 
    줄세우기 
*/

#include <iostream>
#include <vector>
#include <list>

using namespace std;

int main() {

    list<int> l;
    
    l.push_back(4);
    l.push_back(3);
    l.push_back(2);
    l.push_back(1);

    list<int>::iterator head = l.begin();
    l.insert(++head,10);

    cout<<*head<<endl;

    for(list<int>::iterator head = l.begin(); head != l.end(); head++){
        *head = 1;
        printf("%d ", *head);
    }

    for(int e: l){
        printf("%d ", e);
    }


    /* 
    // error
    for(list<int>::iterator i: l){
        printf("%d ", *i);
    } 
    */


    vector<int> v;
    v.push_back(4);
    v.push_back(3);
    v.push_back(2);
    v.push_back(1);

    // vector<int>::iterator head = v.begin();
    
    return 0;
}
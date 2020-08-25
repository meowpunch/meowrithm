#include <iostream>
#include <vector>

using namespace std;

void foo1(int *arr) { arr[1] = 0;cout << sizeof(arr) << '\n'; }
void foo2(int arr[]) { arr[2] = 0; cout << sizeof(arr) << '\n'; } // call by reference
void foo3(int arr[10]) { arr[3] = 0;cout << sizeof(arr) << '\n'; }
void foo4(int (&arr)[10]) { arr[4] = 0;cout << sizeof(arr) << '\n'; }

void changeVector1(vector<int> v) { //call by value
    v[0] = 1;
    cout<<sizeof(v)<<endl;
}

void changeVector2(vector<int> &v) {
    v[0] = 1;
    cout<<sizeof(v)<<endl;
}

int main()
{
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    foo1(arr);
    for(int e: arr){
        cout<< e;
    }
    cout<< endl;

    foo2(arr);
    for(int e: arr){
        cout<< e;
    }
    cout<< endl;

    foo3(arr);
    for(int e: arr){
        cout<< e;
    }
    cout<< endl;

    foo4(arr);
    for(int e: arr){
        cout<< e;
    }
    cout<< endl;


    vector<int> vec1(3,0);
    changeVector1(vec1);
     for(int e: vec1){
        cout<< e;
    }
    cout<<endl;

    vector<int> vec2(3,0);
    changeVector2(vec2);
     for(int e: vec2){
        cout<< e;
    }
    cout<<endl;

   
}
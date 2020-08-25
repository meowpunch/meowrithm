#include <iostream>


int main() {

    int N, grade;

    scanf("%d", &N);

    if(100>=N&&N>=90) printf("A");
    else if(89>=N&&N>=80) printf("B");
    else if(79>=N&&N>=70) printf("C");
    else if(69>=N&&N>=60) printf("D");
    else printf("F");

    return 0;
}
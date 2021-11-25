#include <iostream>
#include <cmath>

using namespace std;

const double pi = acos(-1);

int main() {
    double R;
    scanf("%lf", &R);

    printf("%0.6lf\n", R*R*pi);
    printf("%0.6lf\n", 2*R*R);

    return 0;
}
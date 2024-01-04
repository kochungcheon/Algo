#include <iostream>

int main() {
    int A, B, C, N;
    std::cin >> A >> B >> C >> N;

    int a, b, c;
    bool flag = false;

    for (int i = 0; i <= 300; ++i) {
        a = A * i;
        for (int j = 0; j <= 300; ++j) {
            b = B * j;
            for (int h = 0; h <= 300; ++h) {
                c = C * h;
                if (a + b + c == N) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        if (flag) break;
    }

    if (flag)
        std::cout << 1 << std::endl;
    else
        std::cout << 0 << std::endl;

    return 0;
}

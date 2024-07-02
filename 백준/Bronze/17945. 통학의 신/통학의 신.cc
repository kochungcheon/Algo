#include <iostream>

using namespace std;

int main() {
  int a;
  int b;
  cin >> a >> b;
  for (int i=-1001; i<=1000; i++) {
    if (i * i + 2 * i * a + b == 0) {
      cout << i << " ";
    }
  }
  return 0;
}
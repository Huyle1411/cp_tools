#include <bits/stdc++.h>
using i64 = long long;

#ifdef DEBUG
#include "debugutil.h"
#else
#define debug(...) 666
#define debugArr(arr, n) 666
#endif

class Solution {
   public:
    void solve(int testNum) {

    }
};

int32_t main() {
    std::cin.tie(nullptr)->sync_with_stdio(false);
    std::cin.exceptions(std::cin.failbit);

    int T = 1;
    std::cin >> T;
    for (int i = 1; i <= T; ++i) {
        Solution solution;
        solution.solve(i);
    }
    return 0;
}

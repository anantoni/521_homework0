#include <iostream>
#include <vector>
#include <map>
#include <cstdlib>
using namespace std;

int main() {
    char delim;
    int p1, p2;
    vector<vector<int> > output;
    map<int, map<int, int> > map1;

    while (cin >> p1 >> delim >> p2) {
        if (map1.find(p1) == map1.end()) {
            map<int, int> map2;
            map1[p1] = map2;
        }

        int seqNumber;
        map<int, int> &temp = map1[p1];
        if (temp.find(p2) == temp.end()) {
            seqNumber = temp.size() + 1;
            temp[p2] = seqNumber;
        }
        else
            seqNumber = temp[p2];

        int a[] = {p1, p2, seqNumber};
        vector<int> v(a, a+3);
        output.push_back(v);
    }

    for (vector<vector<int> >::iterator it = output.begin(); it != output.end(); ++it)
        cout << (*it)[0] << "|" << (*it)[1] << "[" << (*it)[2] << " of " << map1[(*it)[0]].size() << "]" << endl;
    return 0;
}

#include <iostream>
#include <vector>
#include <map>
#include <cstdlib>
using namespace std;

void dual_split(string s, string delim, string* elements) {
    elements[0] = s.substr(0, s.find(delim));
    elements[1] = s.substr(s.find(delim)+1, s.length()-1);
}

int main() {
    string line, pieces[2];
    vector<vector<int> > output;
    map<int, map<int, int> > map1;

    while (getline(cin, line)) {
        dual_split(line, "|", pieces);
        pair<int, int> parts(atoi(pieces[0].c_str()), atoi(pieces[1].c_str()));

        if (map1.find(parts.first) == map1.end()) {
            map<int, int> map2;
            map1[parts.first] = map2;
        }

        int seqNumber;
        map<int, int> &temp = map1[parts.first];
        if (temp.find(parts.second) == temp.end()) {
            seqNumber = temp.size() + 1;
            temp[parts.second] = seqNumber;
        }
        else
            seqNumber = temp[parts.second];
        vector<int> v;
        v.push_back(parts.first);
        v.push_back(parts.second);
        v.push_back(seqNumber);
        output.push_back(v);
    }

    for (vector<vector<int> >::iterator it = output.begin(); it != output.end(); ++it)
        cout << (*it)[0] << "|" << (*it)[1] << "[" << (*it)[2] << " of " << map1[(*it)[0]].size() << "]" << endl;

    return 0;
}

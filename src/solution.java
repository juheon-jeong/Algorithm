import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = {};
        Map<Integer, Integer> map0 = new HashMap<>();
        Map <Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < 3; i++) {
            if(map0.containsKey(v[i][0])){
                int temp = map0.get(v[i][0]);
                map0.put(v[i][0], temp + 1);
            }
            else{
                map0.put(v[i][0], 1);
            }
            if(map1.containsKey(v[i][1])){
                int temp1 = map1.get(v[i][0]);
                map1.put(v[i][1], temp1 + 1);
            }
            else{
                map1.put(v[i][1], 1);
            }
        }

    for(Integer k : map0.keySet()){
        if(map0.get(k) != 2) {
            answer[0] = k;
            break;
        }
    }
    for(Integer s : map1.keySet()){
        if(map1.get(s) != 2) {
            answer[1] = s;
            break;
        }
    }
    return answer;
                }
                }
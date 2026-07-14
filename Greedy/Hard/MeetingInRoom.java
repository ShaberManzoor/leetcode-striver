package Greedy.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Meeting {
    int num, start, end;
    Meeting(int n, int s, int e){
        num = n;
        start = s;
        end = e; 
    }
}
public class MeetingInRoom {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        Meeting[] meetings = new Meeting[s.length];

        for(int i=0;i<s.length;i++){
            meetings[i] = new Meeting(i+1, s[i], f[i]);
        }

        Arrays.sort(meetings, (a, b) -> {
            if(a.end==b.end) return Integer.compare(a.num, b.num);
            return Integer.compare(a.end, b.end);
        });

        int lastEnd = -1;
        ArrayList<Integer> res = new ArrayList<>();

        for(Meeting m: meetings){
            if(m.start>lastEnd) {
                res.add(m.num);
                lastEnd = m.end;
            }
        }

        Collections.sort(res);
        return res;
    }
}

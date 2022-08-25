package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author eachenkuang
 * @date 2022/8/25 7:36 PM
 * @description:
 */
public class FindItinerary {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) {
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<List<String>>() {{
            add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
            add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
            add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
            add(new ArrayList<>(Arrays.asList("LHR", "SFO")));
        }};
        FindItinerary solution = new FindItinerary();
        System.out.print(solution.findItinerary(tickets));
    }
}

package com.eachenkuang.nowcode.jerryio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author eachenkuang
 * @date 2022/9/3 16:50
 * @description:
 *
 */
class RangeList {

    private TreeMap<Integer, Integer> map;

    public RangeList() {
        map = new TreeMap<>();
        // it is use for default value to avoid null index in map
        map.put(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /**
     * Adds a range to the list
     * @param range Array of two integers that specif beginning and end of range.
     * @throws Exception See @validateRange function
     */
    public void add(int[] range) throws Exception {
        validateRange(range);
        if (range[0] == range[1]) {
            return;
        }

        Integer former = map.floorKey(range[0]);
        Integer latter = map.floorKey(range[1]);
        // current range is in one same block
        if (Objects.equals(former, latter)) {
            if (range[0] > map.get(former)) {
                map.put(range[0], range[1]);
            } else if (range[1] >= map.get(latter)){
                map.put(former, range[1]);
            }
            return;
        }
        // current range is in several blocks
        int largerEnd = Math.max(map.get(latter), range[1]);
        if (range[0] > map.get(former)) {
            removeKey(former+1, latter);
            map.put(range[0], largerEnd);
        } else {
            removeKey(former, latter);
            map.put(former, largerEnd);
        }
    }

    /**
     * Removes a range from the list
     * @param range Array of two integers that specify beginning and end of range.
     * @throws Exception See @validateRange function
     */
    public void remove(int[] range) throws Exception {
        validateRange(range);
        if (range[0] == range[1]) {
            return;
        }
        Integer former = map.floorKey(range[0]);
        Integer latter = map.floorKey(range[1]);
        // current range is in one same block
        if (Objects.equals(former, latter)) {
            if (range[0] >= map.get(former)) {
                return;
            }
            if (range[0] == former) {
                if (range[1] >= map.get(latter)) {
                    removeKey(former, latter);
                } else {
                    int value = map.get(former);
                    removeKey(former, latter);
                    map.put(range[1], value);
                }
            } else {
                if (range[1] >= map.get(latter)) {
                    map.put(former, range[0]);
                } else {
                    map.put(range[1], map.get(former));
                    map.put(former, range[0]);
                }
            }
            return;
        }
        // current range is in several blocks
        if (range[0] == former) {
            removeKey(former, latter-1);
        } else if (range[0] > former && range[0] < map.get(former)) {
            removeKey(former+1, latter-1);
            map.put(former, range[0]);
        } else {
            removeKey(former+1, latter-1);
        }
        if (range[1] > latter && range[1] < map.get(latter)) {
            map.put(range[1], map.get(latter));
            removeKey(latter, latter);
        } else if (range[1] > map.get(latter)) {
            removeKey(latter, latter);
        }
    }
    /**
     * Prints out the list of ranges in the range list
     */
    public void print() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()
             ) {
            if (entry.getKey() == Integer.MIN_VALUE) {
                continue;
            }
            sb.append(String.format("[%d, %d) ", entry.getKey(), entry.getValue()));
        }
        System.out.println(sb.toString());
    }

    /**
     * validating range
     * 1. Param range must contain two elements and
     * 2. The former should not larger than the latter
     * @param range
     */
    private void validateRange(int[] range) throws Exception {
        if (range.length != 2) {
            throw new Exception("the element number of range is not two!");
        }
        if (range[0] > range[1]) {
            throw new Exception("the former element should not larger than the latter in range!");
        }
    }

    /**
     * remove entry in tree map
     * @param from
     * @param to
     */
    private void removeKey(Integer from, Integer to) {
        List<Integer> list = new ArrayList<>(map.navigableKeySet());
        for (Integer key: list) {
            if (key >= from && key <= to) {
                map.remove(key);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        RangeList rangeList = new RangeList();
        rangeList.add(new int[]{1,5});
        rangeList.print();
        rangeList.add(new int[]{10,20});
        rangeList.print();
        rangeList.add(new int[]{20,20});
        rangeList.print();
        rangeList.add(new int[]{20,21});
        rangeList.print();
        rangeList.add(new int[]{2,4});
        rangeList.print();
        rangeList.add(new int[]{3,8});
        rangeList.print();
        rangeList.remove(new int[]{10,10});
        rangeList.print();
        rangeList.remove(new int[]{10,11});
        rangeList.print();
        rangeList.remove(new int[]{15,17});
        rangeList.print();
        rangeList.remove(new int[]{3,19});
        rangeList.print();
    }
}


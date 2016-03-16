package jianzhioffer;

import java.util.LinkedList;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * Created by lizhaoz on 2016/3/16.
 */

public class GetMedian {

    LinkedList<Integer> list = new LinkedList<Integer>();

    public void Insert(Integer num) {
        if (list.size()==0||num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean insertFlag = false;
            for (Integer e : list) {
                if (num < e) {
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag) {
                list.addLast(num);
            }
        }

    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            Double a = Double.valueOf(list.get(i - 1) + list.get(i));
            return a / 2;
        }
        list.get(0);
        Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));

    }
}

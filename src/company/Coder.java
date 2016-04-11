package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，
 * 并将其作为一个新的数组返回。结果字符串的顺序按照"Coder"出现的次数递减排列，若两个串中"Coder"出现的次数相同，
 * 则保持他们在原数组中的位置关系。
 给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。同时保证一定存在
 包含coder的字符串。
 * Created by lizhaoz on 2016/4/8.
 */

public class Coder {
    public String[] findCoder(String[] A, int n) {
        ArrayList<Recorder> result=new ArrayList<Recorder>();
        for (int i = 0; i < n; i++) {
            String a=A[i].toLowerCase();//遍历转小写。
            if (a.contains("coder")){
                //初始化
                int count=0;
                int start=0;
                //找出所有的coder
                while (a.indexOf("coder",start)>=0&&start<a.length()){
                    count++;
                    start=a.indexOf("coder",start)+"coder".length();
                }
                result.add(new Recorder(A[i],i,count));
            }
        }
        //排序并制定排序策略
        Collections.sort(result, new Comparator<Recorder>() {
            @Override
            public int compare(Recorder o1, Recorder o2) {

                if (o1.getCount()!=o2.getCount())
                    return o2.getCount()-o1.getCount();
                else return o1.getIndex()-o2.getIndex();
            }
        });
        String[] sorted=new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            String s=result.get(i).getData();
            sorted[i]=s;
        }
        return sorted;
    }
    class Recorder{
        private String data; //字符串
        private int index; //在原数组中的位置
        private int count;  //含有多少个coder-1
        public Recorder(String data, int index, int count){
            this.data = data;
            this.index = index;
            this.count = count;
        }
        public String getData(){return data;}
        public int getIndex(){return index;}
        public int getCount(){return count;}
    }
}

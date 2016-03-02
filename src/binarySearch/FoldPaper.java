package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 *

 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 测试样例：
 1
 返回：["down"]
 * Created by lizhaoz on 2016/1/18.
 */

public class FoldPaper {
    public String[] foldPaper(int n) {
        List<String> list=new ArrayList<String>();
        fold(1,n,true,list);
        String[] strings=new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strings[i]=list.get(i);
        }
        return  strings;
    }

    /*
      遵循右中左的先序遍历打印即可
     */
    private void fold(int i, int n, boolean down, List<String> list) {
       if(i>n)return;
        fold(i+1,n,true,list);
        list.add(down?"down":"up");
        fold(i+1,n,false,list);
    }
}

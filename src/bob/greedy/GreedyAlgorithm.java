package bob.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.BranchElement;

/* 
贪心算法
贪心策略适用的前提是：局部最优策略能导致产生全局最优解。
从问题的某一初始解出发：
while (朝给定总目标前进一步)
{
利用可行的决策，求出可行解的一个解元素。
}
由所有解元素组合成问题的一个可行解；

贪婪算法(贪心算法)是指在对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而使结果是最好或者最优的算法。
贪心算法的结果并不一定是最优解，但都是近似最优解的结果。

问题：
假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有的地区都可以接收到信号。



*/
public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台,放入到 Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>(); // 将各个电台放入到 broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        // 加入到 map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        // allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        greedy1(broadcasts, allAreas);

    }

    public static <T> int greedy2(HashMap<T, HashSet<T>> broadcasts, HashSet<T> allAreas) {

        // 目标：覆盖所有城市,allAreas为空
        // 未被覆盖的城市 HashSet<T> allAreas
        // 子问题：每次覆盖最多(电台与剩余城市交集最大)的城市
        HashSet<T> tempUnion = new HashSet<>(); // 当前电台与剩余交集
        HashSet<T> maxUnionCast = new HashSet<>(); // 存储最大交集的电台
        T maxKey = null; // 最大交集的key
        int maxUnion = 0;
        while (!allAreas.isEmpty()) {
            maxKey = null;
            maxUnion = 0;
            for (Map.Entry<T, HashSet<T>> broadcast : broadcasts.entrySet()) {
                tempUnion.clear();
                tempUnion.addAll(broadcast.getValue());
                tempUnion.retainAll(allAreas);
                if ((!tempUnion.isEmpty()) && tempUnion.size() > maxUnion) {
                    maxKey = broadcast.getKey();
                    maxUnion = tempUnion.size();
                }
            }
            if (maxKey != null) {
                maxUnionCast.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
                broadcasts.remove(maxKey);
            }
        }
        System.out.println(maxUnionCast.toString());

        return 0;
    }

    public static <T> int greedy1(HashMap<T, HashSet<T>> broadcasts, HashSet<T> allAreas) {

        List<T> selects = new ArrayList<T>(); // 存储遍历的时候，被选中的电台
        HashSet<T> tempSet = new HashSet<T>(); // tempSet 存储当前电台与剩余所有城市交集

        T maxKey = null; // 选中覆盖最大的电台Key
        int maxRetain = 0; // 最大覆盖
        // 问题终点：把所有地市覆盖
        while (allAreas.size() != 0) {
            maxRetain = 0;
            maxKey = null;
            // 子问题：每次覆盖最多城市
            for (T key : broadcasts.keySet()) { // 每次都需要遍历所有集合
                tempSet.clear();
                // tempSet 求交集，覆盖最多的剩余城市
                HashSet<T> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);

                if ((!tempSet.isEmpty()) && (tempSet == null || tempSet.size() > maxRetain)) {
                    maxRetain = tempSet.size();
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
                broadcasts.remove(maxKey);
            }
        }
        System.out.println(selects.toString());
        return 0;
    }

}

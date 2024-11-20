package learningExperience;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

public class map {
    public static void main(String[] args) {
        // 创建一个 HashMap
        Map<String, Integer> map = new HashMap<>();

        // 向 HashMap 中添加元素
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Orange", 5);
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Orange", 20);
        map.put("Apple", 15); // 更新 Apple 对应的值为 15
        System.out.println(map);

        // 获取键对应的值
        System.out.println("Apple: " + map.get("Apple"));

        // 检查键是否存在
        if (map.containsKey("Banana")) {
            System.out.println("Banana exists");
        }
        System.out.println(map.containsKey("asijfsdopihng"));


        System.out.println(map.containsValue(5));
        System.out.println(map.containsValue(6));
        System.out.println("map.size() = " + map.size());
        System.out.println("map.isEmpty() = " + map.isEmpty());
        System.out.println("map.keySet() = " + map.keySet());
        System.out.println("map.values() = " + map.values());
        System.out.println("map.entrySet() = " + map.entrySet());
        System.out.println("map.getOrDefault(\"Banana\", 0) = " + map.getOrDefault("Banana", 0));
        // 遍历所有键值对
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//
        // 删除一个键值对
        map.remove("Orange");

        // 查看更新后的 Map
        System.out.println("Updated Map: " + map);
    }
}

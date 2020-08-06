```

public class LRUCache {
    public static final int NOTFOUND = -1;
    int capacity = 0;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = NOTFOUND;
        if (!map.containsKey(key))
            return value;
        value = map.get(key);
        map.remove(key);
        // 保证 访问过的 元素 放在末尾
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}

```

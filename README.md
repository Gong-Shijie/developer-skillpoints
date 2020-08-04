# 1.操作系统

## 进程管理 

##  [内存管理](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%86%85%E5%AD%98%E7%AE%A1%E7%90%86.md)

## 进程间通信

## 输入输出 

## 文件系统

## 网络系统 

# 2. 计算机网络 

## [概述](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E7%BD%91%E7%BB%9C%E6%A6%82%E8%BF%B0.md)  

## [应用层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%BA%94%E7%94%A8%E5%B1%82.md)   

## [网络层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E7%BD%91%E7%BB%9C%E5%B1%82.md)   

## [传输层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E4%BC%A0%E8%BE%93%E5%B1%82.md)  

## [数据链路层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E6%95%B0%E6%8D%AE%E9%93%BE%E8%B7%AF%E5%B1%82.md)  

## 物理层

## HTTP/HTTPS

# 3. 数据结构 

## 链表 

## [树](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E6%A0%91.md)

## 栈/队列 

## 哈希表 

## 字符串 

## 数组 

## 图 

# 4. Java

## 语法 

## jvm 

## 数据结构 

#### HashMap  
   
HashMap内部就是一个Node的数组，不过是根据 HashCode 映射下标 

Node  
可能是一个**节点**  
可能是一个**链表结构**  
可能是一个**TreeNode继承自Node**  

![HashMap](https://upload-images.jianshu.io/upload_images/19741117-25a24c11f1f3beec.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)    

![下标](https://upload-images.jianshu.io/upload_images/19741117-eb5c1cbbfa7dd9c5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![put](https://upload-images.jianshu.io/upload_images/19741117-ae3aec17e0d9aa84.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  

![get](https://upload-images.jianshu.io/upload_images/19741117-ba5531c950fed405.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 源码  
***
```    

Node  
TreeNode  
Node<K,V>[] table;
Set<Map.Entry<K,V>> entrySet;  
    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The bin count threshold for using a tree rather than list for a
     * bin.  Bins are converted to trees when adding an element to a
     * bin with at least this many nodes. The value must be greater
     * than 2 and should be at least 8 to mesh with assumptions in
     * tree removal about conversion back to plain bins upon
     * shrinkage.
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * The bin count threshold for untreeifying a (split) bin during a
     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
     * most 6 to mesh with shrinkage detection under removal.
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

```   
***

```
    static final int hash(Object key) {
        int h;  
        // hashCode 高位和低位 均顾 可以有效保证随机 降低冲突的概率
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

``` 
***
```
    //  hash 如何 映射到下标  n --> tab.length
    tab[(n - 1) & hash])
```
***
```

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

```  
***
```
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

```  
***
```

    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

```


#### LRUCache  
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

## [并发](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%B9%B6%E5%8F%91.md)  

# 5. Android

## Activity 

## Service 

## ContentProvider 

## BroadCast 

## 界面布局 

## JetPack 

## Binder

## Handler 

# 6. 设计模式

# 7. 算法题

## 数据结构类 

### 链表 

### 树 

### 栈/队列 

### 哈希表 

### 字符串 

### 数组 矩阵 

[415\. 字符串相加](https://leetcode-cn.com/problems/add-strings/)  

![](https://upload-images.jianshu.io/upload_images/19741117-f1c2dcbbde6b1929.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```

    public String addStrings(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0, add2 = 0, add1 = 0, sum = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            add1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            add2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum = (add1 + add2 + carry);
            carry = sum / 10;
            result.append(sum % 10);
            i--;
            j--;
        }
        return result.reverse().toString();
    }

```


### 图 

### 位运算 

## 算法思想类 

### 广度搜索 

### 深度搜索  

[46\. 全排列](https://leetcode-cn.com/problems/permutations/)
![](https://upload-images.jianshu.io/upload_images/19741117-5924eee9ff1c236a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
```
    int[] mem;
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> path = new Stack<>();

    public List<List<Integer>> permute1(int[] nums) {
        mem = new int[nums.length];
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int i) {
        if (path.size() == mem.length) {
            result.add(new ArrayList<>(path));
        }
        for (int j = 0; j < mem.length; j++) {
            if (mem[j] == 0) {
                mem[j] = 1;
                path.push(nums[j]);
                dfs(nums, i++);
                path.pop();
                mem[j] = 0;
            }
        }
    }
    
```

### 动态规划 

### 排序 

### [双指针](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%8F%8C%E6%8C%87%E9%92%88.md)


### 贪心 

### 二分 

### 分治

### 数学


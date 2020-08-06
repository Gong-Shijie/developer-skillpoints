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

## [Handler](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/Handler.md) 

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


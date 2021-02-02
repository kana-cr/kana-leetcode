package 其他;

//不使用任何内建的哈希表库设计一个哈希集合
//具体地说，你的设计应该包含以下的功能
//    add(value)：向哈希集合中插入一个值。
//    contains(value) ：返回哈希集合中是否存在这个值。
//    remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
public class 设计哈希集合 {

    class MyHashSet {
        int[] hash;
        /** Initialize your data structure here. */
        public MyHashSet() {;
            hash = new  int[1000002];
        }

        public void add(int key) {
            hash[key] = 1;
        }

        public void remove(int key) {
            hash[key] = 0;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return hash[key] == 1;
        }
    }

}

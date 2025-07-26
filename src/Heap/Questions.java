package Heap;

import java.util.PriorityQueue;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;

    }
// Url : https://leetcode.com/problems/kth-largest-element-in-an-array/
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr){
            minHeap.add(val);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int stone : stones){
            maxHeap.add(-1 * stone);
        }
        int ans = 0;
        while (maxHeap.size() > 1){
            int y = maxHeap.poll()*-1;
            int x = maxHeap.poll()*-1;
            if (x != y) {
                maxHeap.add(-(y - x));
            }
        }
        return  maxHeap.size() < 0 ? 0 : maxHeap.peek();
    }

}

package sword.数组;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuyang
 * @create 2019-08-11 10:16
 */
public class j数据流中的中位数 {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
    private void modifyTwoHeapsSize() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public void Insert(Integer num) {
        //第一个数放入大根堆
        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
            return;
        }

        if (this.maxHeap.peek() >= num) {
            this.maxHeap.add(num);
        } else {
            if (this.minHeap.isEmpty()) {
                this.minHeap.add(num);
                return;
            }
            if (this.minHeap.peek() > num) {
                this.maxHeap.add(num);
            } else {
                this.minHeap.add(num);
            }
        }
        modifyTwoHeapsSize();
    }

    public Double GetMedian() {
        int maxHeapSize = this.maxHeap.size();
        int minHeapSize = this.minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
        Integer maxHeapHead = this.maxHeap.peek();
        Integer minHeapHead = this.minHeap.peek();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return ((maxHeapHead + minHeapHead) / 2.0);
        }
        return maxHeapSize > minHeapSize ? maxHeapHead*1.0 : minHeapHead*1.0;
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

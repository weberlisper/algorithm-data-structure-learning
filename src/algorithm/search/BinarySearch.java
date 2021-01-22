package algorithm.search;

public class BinarySearch {

    public static <E extends Comparable<E>> int search(E[] data, E target) {

        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    public static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        }

        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }

        return searchR(data, l, mid - 1, target);
    }

    // 查找有序数组data中大于target的最小值的索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {

        int l = 0, r = data.length;
        // 循环不变量：在l到r的区间内，查找比target大的最小值。
        // 在这里需要注意的是，对于右边界的初始值，使用的data.length，
        // 表示如果target>=data[data.length-1]时，那么r就是超过数组边界的非法值，这里取data.length
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 当l==r的时候，就是查找处的元素
        return l;
    }

    // 如果数组中存在元素，则返回该元素在数组中的最大索引
    // 如果数组中不存在该元素，则返回该元素的upper
    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u != 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    // 如果数组中存在元素，则返回该元素在数组中的最小索引
    // 如果数组中不存在该元素，则返回该元素的upper
    public static <E extends Comparable<E>> int lower_cell(E[] data, E target) {
        int l = 0, r = data.length;
        // 循环不变量：在l到r的区间内，查找比target大的最小值。
        // 在这里需要注意的是，对于右边界的初始值，使用的data.length，
        // 表示如果target>=data[data.length-1]时，那么r就是超过数组边界的非法值，这里取data.length
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 相较于upper，这里不丢弃=target的元素
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 当l==r的时候，就是查找处的元素
        return l;
    }

    // 查找小于target的最大值
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;
        // 在l .. r的区间内，查找<target的最大元素，
        // 这里要注意，对于左边界，表示如果我们给定的target<=data[0]，那索引就是非法的，
        // 我们定义为-1，以使我们的操作统一。
        while (l < r) {
            // 需要注意的是，这里之所以这样取mid值，是因为l+(r - l)这样的操作会向下取整，当l和r相邻的时候，mid就等于l了会导致进入死循环
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) >= 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    // 如果存在，返回最小索引
    // 如果不存在，返回lower
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
        int l = lower(data, target);
        if (l != data.length - 1 && data[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    // 如果存在，返回最大索引
    // 如果不存在，返回lower
    // 求 <= target的最大索引
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
        int l = -1, r = data.length - 1;
        // 在l .. r的区间内，查找<target的最大元素，
        // 这里要注意，对于左边界，表示如果我们给定的target<=data[0]，那索引就是非法的，
        // 我们定义为-1，以使我们的操作统一。
        while (l < r) {
            // 需要注意的是，这里之所以这样取mid值，是因为l+(r - l)这样的操作会向下取整，当l和r相邻的时候，mid就等于l了会导致进入死循环
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 1, 2, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(upper_floor(nums, i) + " ");
        }
    }

}

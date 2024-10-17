package learningExperience;

public class MergeSort {

    // 主方法
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("原始数组：");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("排序后的数组：");
        printArray(array);
    }

    // 归并排序方法
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 递归排序左右半部分
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // 合并已排序的部分
            merge(array, left, mid, right);
        }
    }

    // 合并两个已排序的子数组
    public static void merge(int[] array, int left, int mid, int right) {
        // 计算子数组的大小
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 拷贝数据到临时数组
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // 合并临时数组
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 拷贝剩余的元素
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // 打印数组
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

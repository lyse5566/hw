import java.awt.*;
import javax.swing.*;
import java.time.Instant;
import java.util.*;
public class mergeSort extends MyPanel implements Runnable {
    mergeSort(int data[],String sortname){
        super(data,sortname);
    }
    public void run() {
            mergeSort(getData(),0, getData().length - 1);
    }
    public void merge(int arr[], int arrStartIndex, int middleIndex, int arrEndIndex) {
        // 計算左右兩陣列的長度
        int leftArrLength = middleIndex - arrStartIndex + 1;
        int rightArrLength = arrEndIndex - middleIndex;

        // 製作左右兩陣列
        int LeftArr[] = new int[leftArrLength];
        int RightArr[] = new int[rightArrLength];

        // 將資料放入左右兩陣列
        for (int i = 0; i < leftArrLength; i++) {
            // 從 arrStarIndex 開始
            LeftArr[i] = arr[arrStartIndex + i];
        }

        for (int j = 0; j < rightArrLength; j++) {
            // 從 middleIndex 開始
            RightArr[j] = arr[middleIndex + 1 + j];
        }

        int leftArrIndex = 0, rightArrIndex = 0;
        // 合併後的大陣列 index
        int mergedArrIndex = arrStartIndex;

        while (leftArrIndex < leftArrLength && rightArrIndex < rightArrLength) {
            if (LeftArr[leftArrIndex] <= RightArr[rightArrIndex]) {
                arr[mergedArrIndex] = LeftArr[leftArrIndex];
                leftArrIndex++;
            } else {
                arr[mergedArrIndex] = RightArr[rightArrIndex];
                rightArrIndex++;
            }

            mergedArrIndex++;
        }

        while (leftArrIndex < leftArrLength) {
            arr[mergedArrIndex] = LeftArr[leftArrIndex];
            leftArrIndex++;
            mergedArrIndex++;
        }

        while (rightArrIndex < rightArrLength) {
            arr[mergedArrIndex] = RightArr[rightArrIndex];
            rightArrIndex++;
            mergedArrIndex++;

        }
    }

    public void mergeSort(int arr[], int arrStartIndex, int arrEndIndex) {
        if (arrStartIndex < arrEndIndex) {
            int middleIndex = (arrStartIndex + arrEndIndex) / 2;
            mergeSort(arr, arrStartIndex, middleIndex);
            mergeSort(arr, middleIndex + 1, arrEndIndex);
            try {
                Thread.sleep(ran[(int)(Math.random()*10)]);
                endtime= Instant.now();
                setData(arr);
                repaint();
            } catch (InterruptedException e) {
            }
            merge(arr, arrStartIndex, middleIndex, arrEndIndex);
        }
    }
}

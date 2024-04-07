import java.awt.*;
import java.time.Instant;
import javax.swing.*;
public class bubbleSort extends MyPanel implements Runnable {
    bubbleSort(int data[],String sortname){
        super(data,sortname);
    }

    @Override
    public void run() {
        dobubblesort(getData());
    }

    public void dobubblesort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //交換元素
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            try {
                Thread.sleep(ran[(int)(Math.random()*10)]);
                endtime= Instant.now();
                setData(arr);
                repaint();
            } catch (InterruptedException e) {
            }
        }

    }
}

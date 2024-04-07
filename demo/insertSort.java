import java.awt.*;
import javax.swing.*;
import java.time.Instant;
import java.util.*;
public class insertSort extends MyPanel implements Runnable {
    insertSort(int data[],String sortname){
        super(data,sortname);
    }
    public void run() {
            insertsort(getData());
    }
    public void insertsort(int []arr) {
        for(int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
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

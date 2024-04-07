import java.time.Instant;

public class selectionSort extends MyPanel implements Runnable {

        selectionSort(int data[],String sortname){
        super(data,sortname);
    }
        public void run() {
                selection_sort(getData());
        }

    public void selection_sort(int num[]){
        for(int i = 0; i < num.length - 1; i++) {
            int m = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[m]) m = j;
            }
            if (i != m) {
                int temp = num[i];
                num[i] = num[m];
                num[m] = temp;
            }
            try {
                Thread.sleep(ran[(int)(Math.random()*10)]);
                endtime= Instant.now();
                setData(num);
                repaint();
            } catch (InterruptedException e) {
            }
        }
    }

}


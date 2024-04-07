import java.time.Instant;

public class heapSort extends MyPanel implements Runnable{
    heapSort(int data[],String sortname){
        super(data,sortname);
    }

    @Override
    public void run() {
        HeapSort(getData());
    }
    public void HeapSort(int[] list) {
        int N = list.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(list, N, i);
        for (int i = N - 1; i > 0; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            try {
                Thread.sleep(ran[(int)(Math.random()*10)]);
                endtime= Instant.now();
                setData(list);
                repaint();
            } catch (InterruptedException e) {
            }
            heapify(list, i, 0);
        }
    }
    void heapify(int[] list, int N, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < N && list[l] > list[largest])
            largest = l;
        if (r < N && list[r] > list[largest])
            largest = r;
        if (largest != i) {
            int swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;
            heapify(list, N, largest);
        }
    }
}

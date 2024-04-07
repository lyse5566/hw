import java.time.Instant;

public class quickSort extends MyPanel implements Runnable{
    quickSort(int data[],String sortname){
        super(data,sortname);
    }

    @Override
    public void run() {

        sort(0,getData().length-1,getData());
    }

    public void sort(int left, int right, int arr[]) {
        if(left < right) {
            int i = left;
            int j = right + 1;
            while(true) {
                while( i+1 < arr.length && arr[++i] < arr[left]);
                while( j-1 >= 0 && arr[--j] > arr[left]);
                if( i >= j) break;
                swap(i , j,arr);
            }
            swap(left , j,arr);
            sort(left , j - 1,arr);
            try {
                Thread.sleep(ran[(int)(Math.random()*10)]);
                endtime= Instant.now();
                setData(arr);
                repaint();
            } catch (InterruptedException e) {
            }
            sort(j + 1 , right,arr);
        }
    }

    public void swap(int i, int j,int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

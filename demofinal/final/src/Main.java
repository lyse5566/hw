import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;
public class Main extends JFrame{
    public static void main (String[] args) throws IOException{
        int data[]=new int[100000] , data2[] = new int[100000] , data3[] = new int[100000];
        int data4[] = new int[100000] , data5[] = new int[100000],data6[] = new int[100000];
        int count=0;
        FileReader fr = new FileReader("final.txt");
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            data[count]=Integer.parseInt(br.readLine());
            data2[count]=data[count];
            data3[count]=data[count];
            data4[count]=data[count];
            data5[count]=data[count];
            data6[count]=data[count];
            count++;
        }
        fr.close();
        JFrame j1 = new JFrame("資料結構-期末作業-C110151147");
        j1.setLayout(new FlowLayout(FlowLayout.LEFT));
        j1.setSize(1600,350);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bubbleSort bubblesort=new bubbleSort(data,"BubbleSort");
        bubblesort.setPreferredSize(new Dimension(250,300));
        Thread sort1=new Thread(bubblesort);

        selectionSort selectionsort=new selectionSort(data2,"SelectionSort");
        selectionsort.setPreferredSize(new Dimension(250,300));
        Thread sort2=new Thread(selectionsort);

        quickSort quicksort=new quickSort(data3,"QuickSort");
        quicksort.setPreferredSize(new Dimension(250,300));
        Thread sort3=new Thread(quicksort);

        insertSort insertsort=new insertSort(data4,"InsertSort");
        insertsort.setPreferredSize(new Dimension(250,300));
        Thread sort4=new Thread(insertsort);

        mergeSort mergesort=new mergeSort(data5,"MergeSort");
        mergesort.setPreferredSize(new Dimension(250,300));
        Thread sort5=new Thread(mergesort);

        heapSort heapsort=new heapSort(data6,"HeapSort");
        heapsort.setPreferredSize(new Dimension(250,300));
        Thread sort6=new Thread(heapsort);

        j1.add(bubblesort);
        j1.add(selectionsort);
        j1.add(quicksort);
        j1.add(insertsort);
        j1.add(mergesort);
        j1.add(heapsort);
        j1.setVisible(true);
        sort1.start();
        sort2.start();
        sort3.start();
        sort4.start();
        sort5.start();
        sort6.start();
    }
}


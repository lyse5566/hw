import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

class MyPanel extends JPanel{
    public int ran[]=new int[]{1,1,1,1,1,1,1,1,1,1};
    private int data[] = new int[50000];
    private String Whatsort="";
    public Instant endtime;
    public Instant nowtime=Instant.now();
    public MyPanel(int data[],String Whatsort) {
        setData(data);
        setWhatsort(Whatsort);
    }
    public void setData(int data[]){
        this.data=data;
    }

    public int[] getData() {
        return data;
    }

    public void setWhatsort(String whatsort) {
        Whatsort = whatsort;
    }

    public String getWhatsort() {
        return Whatsort;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(Duration.between(nowtime,endtime).toSeconds()+"s", 180, 10);
        for (int i =0; i < data.length-10000; i++) {
                int x = i / 400;
                int y = 250-(data[i] / 400);
                g.fillOval(x, y, 3, 3);
        }
        g.setColor(Color.BLUE);
        g.setFont(new Font("楷體", Font.BOLD, 20));
        g.drawString(getWhatsort(), 0, 245);

    }
}
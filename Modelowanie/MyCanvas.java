package modelowanie;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyCanvas extends Canvas {
JData tempmatrix;


//--------------------------------------------------
public MyCanvas(JData drawmatrix){
tempmatrix = new JData(drawmatrix.maxx,drawmatrix.maxy);
tempmatrix=drawmatrix;
}


//--------------------------------------------------
private void drawCircle(int x, int y, int radius,int numer, Graphics g){
if (numer==1){
g.setColor(Color.YELLOW);   
g.fillOval(x - radius,y - radius, radius*2+1, radius*2+1);
g.setColor(Color.GREEN);   
g.drawOval(x - radius, y - radius, radius*2, radius*2);
}
if (numer==2){
g.setColor(Color.MAGENTA);   
g.fillOval(x - radius,y - radius, radius*2+1, radius*2+1);
g.setColor(Color.BLUE);   
g.drawOval(x - radius, y - radius, radius*2, radius*2);
 }
if (numer==3){
g.setColor(Color.CYAN);   
g.fillOval(x - radius,y - radius, radius*2+1, radius*2+1);
g.setColor(Color.BLUE);   
g.drawOval(x - radius, y - radius, radius*2, radius*2);
}
}

//--------------------------------------------------
public void paint(Graphics graphics) {
Graphics2D g = (Graphics2D) graphics;
for (int y = 0; y < tempmatrix.maxy; y++){
for (int x = 0; x < tempmatrix.maxx; x++){
if (tempmatrix.matrix[x][y]>0) { drawCircle(x,y,3,tempmatrix.matrix[x][y],g);}
}   
}

}
//-------------------------------------------------- 

}





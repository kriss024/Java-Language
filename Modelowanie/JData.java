package modelowanie;


public class JData {
int[][] matrix;
byte[][] temp1;
byte[][] temp2;
int maxx;
int maxy;
public JData(int maxx, int maxy){
    matrix = new int [maxx][maxy];
    temp1 = new byte [maxx][maxy];
    temp2 = new byte [maxx][maxy];
    this.maxx = maxx;
    this.maxy = maxy;
    for (int y = 0; y < maxy; y++){
    for (int x = 0; x < maxx; x++){
    matrix[x][y]=0;
    temp1[x][y]=0;
    temp2[x][y]=0;
    }   
    }
    }
//--------------------------------------------------    
public void cls(){
    for (int y = 0; y < this.maxy; y++){
    for (int x = 0; x < this.maxx; x++){
    matrix[x][y]=0;
    }   
    }
    }


//public int check_neighbourhood (int x,int y,byte tab) {
//if (tab==1) { return 1; }

//if (tab==2) { return 2; }

}



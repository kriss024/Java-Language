
public class bbSort {
		
	public double[][] Run(double[][] macierz,int kolumna){
        
		int n = macierz.length;
		double[] t,t1;
		
		do
		{
			for (int i = 0; i < n-1; i++){
				if (macierz[i][kolumna]>macierz[i+1][kolumna]) {
					t=macierz[i];
					t1=macierz[i+1];	
					macierz[i]=t1;
					macierz[i+1]=t;
				}
			}
			n = n-1;
		}while(n > 1);
		
		return macierz;
	}
	
	public static void main(String[] args) {
		
		double[][] matrix = {{4,0,0,0,0,0,0},{2,1,1,1,1,1,1},{0,2,2,2,2,2,2},{-1,3,3,3,3,3,3},{-2,4,4,4,4,4,4}};
		
		double[][] out;

		for(double wiersz[]: matrix){
			for(double element: wiersz) {
		    System.out.print(element+", "); }
			System.out.println();
		}
		
		System.out.println();
		
		bbSort sort = new bbSort();
	  
		out = sort.Run(matrix, 0);

		for(double wiersz[]: out){
			for(double element: wiersz) {
		    System.out.print(element+"; "); }
			System.out.println();
		}
		
		
		}
	}


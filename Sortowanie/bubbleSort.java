
public class bubbleSort {
		
	public double[] Run(double[] macierz){
    
		int n = macierz.length;
		double t,t1;
		
		do
		{
			for (int i = 0; i < n-1; i++){
				if (macierz[i]>macierz[i+1]) {
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
		
		double[] matrix = {-2,4,6,5,4,3,7,-1,2,5,7,8,-4,6,7,8,4,-5,9,8,-1,9,8,9,3,4,6,-3};

		for(double element: matrix){
		    System.out.print(element+", ");
		    }

		System.out.println();
		
		bubbleSort bs = new bubbleSort();
		
		for(double element: bs.Run(matrix)){
		    System.out.print(element+"; ");
		}	


	}
	}


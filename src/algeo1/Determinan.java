package algeo1;

import java.lang.Math;

public class Determinan {
	public static void solDetOBE(double[][] matrix) {
		double det = Segiatas(matrix);
		int o = Menu.menuOutput();
		if (o == 1) {
			System.out.println("Determinan = " + det);
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFileDet(file, det);
		}
		Menu.startAgain();
	}
	
	public static void solDetCofactor(double[][] matrix) {
		double det = detCofactor(matrix);
		int o = Menu.menuOutput();
		if (o == 1) {
			System.out.println("Determinan = " + det);
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFileDet(file, det);
		}
		Menu.startAgain();
	}
	
	public static double det2by2(double[][] matrix) {
		return (matrix[0][0]*matrix[1][1] - (matrix[0][1]*matrix[1][0]));
	}
	
	public static double detCofactor(double[][] matrix) {
		double det = 0.0d;
		if (matrix.length == 1 && matrix[0].length == 1) {
			return matrix[0][0];
		} else if (matrix.length == 2 && matrix[0].length == 2) {
			return det2by2(matrix);
		}
		
		for (int i=0; i<matrix[0].length; i++) {
			det += Math.pow((-1), i)*matrix[0][i]*detCofactor(Matriks.getMinor(matrix, 0, i));
		}
		
		return det;
	}
	
	public static double Segiatas(double[][] M){
		/* M terdefinisi, IsBujurSangkar(M) */
		/* Menghitung nilai determinan matriks M dengan metode segitiga atas. 
		Menulis ke layar matriks segitiga atas yang terbentuk dan determinan matriks awal. */
		int n, i, j; 
		double line1, line2;
		double count = 1;
		boolean found;
		for (n = 0; n < M.length; n++){
			if (M[n][n] == 0){
			    found = false;
			      i = n+1;
			      while (!found && i < M.length){
			        if (M[i][n] != 0){
			            found = true;
			            for (j = n; j < M[0].length; j++){
			                M[n][j] += M[i][j];
			            }
			         }
			         i++;
			     }
			    // Matriks mat = new Matriks();
			    if (!found){
			        count = 0;
			        n = M.length;
			        return count;
			    }  
			}
			   for (i = n+1; i < M.length; i++){       
			      if (M[i][n] != 0){        
			         line1 = M[n][n];
			         line2 = M[i][n]; 
			        for (j = n; j < M[0].length; j++){
			            M[n][j] /= line1;
			            M[i][j] /= line2;
			            M[i][j] -= M[n][j];
			        }
			        count *= (line1 * line2);
			    }
			}
			count *= M[n][n];
		}
		return count;
	}
}
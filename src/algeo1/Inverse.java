package algeo1;

import java.lang.Math;

public class Inverse {

	public static void solInvAdjoint(double[][] matrix) {
		double[][] inverse = inverseAdjoint(matrix);
		int o = Menu.menuOutput();
		if (o == 1) {
			System.out.println("Matriks balikan:");
			Matriks.printMatrix(inverse);
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFileInv(file, inverse);
		}
		Menu.startAgain();
	}
	
	public static void solInvGJ (double[][] matrix) {
		double[][] extended = extendIdentitas(matrix);
		extended = SPL.GaussJordan(extended);
		double[][] inverse = new double[matrix.length][matrix[0].length];
		for (int i=0; i<inverse.length; i++) {
			for (int j=0; j<inverse[0].length; j++) {
				inverse[i][j] = extended[i][j+inverse[0].length];
			}
		}
		int o = Menu.menuOutput();
		if (o == 1) {
			System.out.println("Matriks balikan:");
			Matriks.printMatrix(inverse);
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFileInv(file, inverse);
		}
		Menu.startAgain();
	}
	
	public static double[][] inverseAdjoint(double[][] matrix) {
		double[][] mCofactor = new double[matrix.length][matrix[0].length];
		
		for (int i=0; i<mCofactor.length; i++) {
			for (int j=0; j<mCofactor[0].length; j++) {
				mCofactor[i][j] = Math.pow(-1, i+j)*Determinan.detCofactor(Matriks.getMinor(matrix, i, j));
			}
		}
		
		double[][] inverse = Matriks.Transpose(mCofactor);
		double det = Determinan.detCofactor(matrix);
		for (int i=0; i<inverse.length; i++) {
			for (int j=0; j<inverse[0].length; j++) {
				inverse[i][j] /= det;
			}
		}
		return inverse;
	}

	public static double[][] extendIdentitas (double[][] matrix){
		int i,j;
		double[][] m = new double[matrix.length][2*matrix[0].length];
		for (i=0; i <m.length; i++){
			for (j=0; j<m[0].length; j++){
				if (j < matrix[0].length){
					m[i][j] = matrix[i][j];
				}else {
					if ((j- matrix[0].length) == i){
						m[i][j] = 1.0;
					}else {
						m[i][j] = 0.0;
					}				
				}
			}
		}
		return m;
	}
}
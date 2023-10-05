package algeo1;

public class Matriks {
	
	public static boolean isSquare(double[][] M){
	    /* Mengirimkan true jika M adalah matriks dg ukuran baris dan kolom sama */
	    return (M.length == M[0].length);
	}
	
	public static double[][] KaliMatriks (double[][] M1, double[][] M2){
	    int k;
	    double el;
	    double[][] M3 = new double[M1.length][M2[0].length];
	    for(int i = 0; i < M3.length; i++){
	        for (int j = 0; j < M3[0].length; j++){
	            el = 0;
	            for (k = 0 ; k < M1[0].length; k++){
	                el += M1[i][k]*M2[k][j];
	            }
	            M3[i][j] = el;
	        }
	    }
	    return M3;
	}
	
	public static double[][] Transpose(double[][] M){
	    double[][] M2 = new double[M.length][M[0].length];
	    int i,j;
	    for (i = 0; i < M2.length; i++)
	    {
	        for (j = 0; j < M2[0].length; j++)
	        {
	            M2[i][j] = M[j][i] ;
	        }
	    }
	    return M2;
	}
	
	public static double[][] PKaliKons(double[][] M, double K)
	{
	    int i,j;
	    for (i = 0; i < M.length; i++)
	    {
	        for (j = 0; j < M[0].length; j++)
	        {
	            M[i][j] = M[i][j] * K;
	        }
	    }
	    return M;
	}
	
	public static boolean IsPunyaInvers (double[][] M) {
	    return (Determinan.detCofactor(M) != 0);
	}
	
	public static double[][] CopyMatriks(double[][] MIn){
	    int i,j;
	    double[][] MHsl = new double[MIn.length][MIn[0].length];
	    for (i=0; i< MIn.length; i++){
	        for (j=0; j< MIn[0].length; j++){
	             MHsl[i][j] = MIn[i][j];
	        }
	    }
	    return MHsl;
	}
	
	public static double[][] TukarBaris(double[][] M, int i1, int i2) {
	    int j;
	    double temp; 
	    for(j=0;j < M[0].length;j++){
	        temp = M[i1][j];
	        M[i1][j] = M[i2][j];
	        M[i2][j] = temp;
	    } 
	    return M;
	}

	public boolean IsTidakAdaSolusi(double[][] M){
	    double[][] M2 = CopyMatriks(M);
	    M2 = SPL.GaussJordan(M2);
	    M2 = SPL.eliminasiBaris(M2);
	    int i,j;
	    boolean solusi, hasil;
	    hasil = false;
	    for (i=0; i< M2.length; i++){
	        solusi = true;
	        for (j=0; j< M2[0].length-1; j++){
	             if (M2[i][j] != 0){
	                solusi = false;
	             }
	        }
	        if (solusi){
	            if (M2[i][j] != 0){
	                hasil = true;
	            }
	        }
	    }
	    return hasil;
	}
	
	public static double[][] BagiBaris(double[][] M, int i){
	    int j, j1, j2;
	    double penyebut;
	    j = 0;
	    //boolean a = true;
	    for (j2=0;j2<M[0].length;j2++){
	        if (M[i][j2] >= -0.00000000000001 && M[i][j2] < 0 ){
	            M[i][j2] = 0;
	        }
	    }
	    while (j < M[0].length){
	    	if (M[i][j] == 0) {
	    		j++;
	    	} else {
	    		break;
	    	}
	    }
	    if (j < M[0].length){
	        penyebut = M[i][j];
	        for (j1 = j; j1 < M[0].length;j1++){
	            M[i][j1] = M[i][j1]/penyebut;
	        }
	    }
	    return M;
	}
	
	public static int IndeksKolom(double[][] M, int i){
	    //  mencari indeks kolom yang berawal nilai 0 
	    int j, idxKol;
	    boolean isKetemu;
	    isKetemu = false;
	    j = 0;
	    idxKol = 0;
	    while ( j < M[0].length && !isKetemu){
	        if (M[i][j] != 0){
	            isKetemu = true;
	            idxKol = j;
	        } else {
	            j +=1;
	        }
	    } 
	    if (j >= M[0].length){
	        idxKol = M[0].length;
	    }
	    return idxKol;
	    
	}
	
	public static double[][] SortBaris(double[][] M){
	    int i, j; 
	    for (i= 0; i < M.length-1; i++){
	        for (j = i+1; j < M.length; j++){
	            if (IndeksKolom(M,i) > IndeksKolom(M,j)){
	                TukarBaris(M,i,j);
	            }
	        }
	    }
	    return M;
	}
	
	public static double[][] getA(double[][] augmented) {
		int row = augmented.length, col = augmented[0].length-1;
		double[][] A = new double[row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				A[i][j] = augmented[i][j];
			}
		}
		return A;
	}
	
	public static double[] getb(double[][] augmented) {
		int row = augmented.length;
		double[] b = new double[row];
		for (int i=0; i<row; i++) {
			b[i] = augmented[i][augmented[0].length-1];
		}
		return b;
	}
	
	public static double[][] getMinor(double[][] matrix, int row, int col) {
		double[][] minor = new double[matrix.length-1][matrix[0].length-1];
		int ic = 0, jc = 0;
		for (int i=0; i<minor.length; i++) {
			if (ic == row) {
				ic += 1;
			}
			for (int j=0; j<minor[0].length; j++) {
				if (jc == col) {
					jc += 1;
				}
				minor[i][j] = matrix[ic][jc];
				jc += 1;
			}
			jc = 0;
			ic += 1;
		}
		return minor;
	}
	
	public static void printMatrix(double[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.printf("%.4f", matrix[i][j]);
				if (j < matrix[0].length-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static double[][] deleteLast(double[][] matrix) {
		double[][] m = new double[matrix.length-1][matrix[0].length];
		for (int i=0; i<m.length; i++) {
			for (int j=0; j<m[0].length; j++) {
				m[i][j] = matrix[i][j];
			}
		}
		return m;
	}
	
}
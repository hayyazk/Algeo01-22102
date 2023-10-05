package algeo1;

public class SPL {
	
	public static void SPLGauss(double[][] matrix) {
		int o = Menu.menuOutput();
		double[][] mgauss = GaussSPL(matrix);
		String[] sol = solusiGauss(mgauss);
		if (o == 1) {
			for (int i=0; i<sol.length; i++) {
				if (sol[i] != null) {
					System.out.println(sol[i]);
				}
			}
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFileSPL(file, sol);
		}
		Menu.startAgain();
		
	}
	
	public static void SPLGaussJordan(double[][] matrix) {
		int o = Menu.menuOutput();
		double[][] mGJ = GaussJordan(matrix);
		mGJ = eliminasiBaris(mGJ);
		String[] sol = solusiGaussJordan(mGJ);
		if (o == 1) {
			for (int i=0; i<sol.length; i++) {
				if (sol[i] != null) {
					System.out.println(sol[i]);
				}
			}
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFileSPL(file, sol);
		}
		Menu.startAgain();
	}
	
	public static void SPLInverse(double[][] matrix) {
		int o = Menu.menuOutput();
		double[][] A = Matriks.getA(matrix);
		double[] b = Matriks.getb(matrix);
		double det = Determinan.detCofactor(A);
		double[] sol = new double[A.length];
		if (det != 0 && A.length == A[0].length) {
			double[][] inverse = Inverse.inverseAdjoint(A);
			for (int i=0; i<inverse.length; i++) {
				sol[i] = 0;
				for (int j=0; j<inverse[0].length; j++) {
					sol[i] += inverse[i][j]*b[j];
				}
			}
			if (o == 1) {
				InputOutput.writeSolSPL("unique", sol);
			} else {
				String file = Menu.inputFile();
				InputOutput.tulisFileSPL("exists", file, sol);
			}
		} else {
			if (o == 1) {
				InputOutput.writeSolSPL("none", sol);
			} else {
				String file = Menu.inputFile();
				InputOutput.tulisFileSPL("none", file, sol);
			}
		}
		Menu.startAgain();
	}
	
	public static void SPLCramer(double[][] matrix) {
		int o = Menu.menuOutput();
		double[][] A = Matriks.getA(matrix);
		double[] b = Matriks.getb(matrix);
		double det = Determinan.detCofactor(A);
		double[] sol = new double[A.length];
		if (det!=0 && A.length==A[0].length) {
			for (int j=0; j<A.length; j++) {
				double[][] An = Matriks.CopyMatriks(A);
				for (int i=0; i<A.length; i++) {
					An[i][j] = b[i];
				}
				double detn = Determinan.detCofactor(An);
				sol[j] = detn/det;
			}
			if (o == 1) {
				InputOutput.writeSolSPL("unique", sol);
			} else {
				String file = Menu.inputFile();
				InputOutput.tulisFileSPL("exists", file, sol);
			}
		} else {
			if (o == 1) {
				InputOutput.writeSolSPL("none", sol);
			} else {
				String file = Menu.inputFile();
				InputOutput.tulisFileSPL("none", file, sol);
			}
		}
		Menu.startAgain();
	}

	public static double[][] EliminasiOBE(double[][] M, int indeks){
		// Prekondisi bahwa matriks udah di sort
		//  Matriks 
		// dieliminasikan baris dengan indeks indeks
		int i,j,a; 
		// buat semua dimulai dengan angka 1 
		for (i=0; i < M.length; i++){
			M = Matriks.BagiBaris(M,i);
		}
		j=0;
		while (M[indeks][j] != 1 && j < M[0].length){
			j+=1;
		}
		if (j < M[0].length){
			for (i=indeks+1;i < M.length;i++){
				if (M[i][j] == 1){
					for (a=j; a < M[0].length; a++){
						M[i][a] -= M[indeks][a];
					}
				}
			}
		}
		return M;

	}

	public static double[][] EliminasiOBEjordan(double[][] M , int indeks){
		// INPUTAN Matriks dan Indeks yang akan menjadi acuan untuk dikurangi 
		// semua diatas angka 1 adalah 0 
		int i,j,a;
		double kali; 
		j = 0;
		while (j < M[0].length){
			if (M[indeks][j] != 1) {
				j++;
			} else {
				break;
			}
		}
		if (j < M[0].length){
			for (i=0; i < indeks; i++){
				if (M[i][j] != 0){
					kali = M[i][j];
					for (a=j; a < M[0].length; a++){
						if (j < M[0].length -1){
							M[i][a] = M[i][a] - (M[indeks][a] * kali);
						}
					}
				}
			}
		}
		return M;
	}

	public static double[][] GaussSPL(double[][] M){
		// Matriks M 
		// Matriks echelon
		int i;
		for (i = 0; i < M.length-1; i++){
			// kurangkan semua
			M = Matriks.SortBaris(M); 
			M = EliminasiOBE(M,i);
			// SortBaris(M); 
		}
		M = Matriks.BagiBaris(M,i);
		return M;
	}

	public static double[][] GaussJordan(double[][] M){
		// Matriks M
		// matriks echelon tereduksi 
		int i;
		M = GaussSPL(M);
		for (i = 1; i < M.length; i++){
			M = EliminasiOBEjordan(M, i);
		}
		return M;
	}


	public static double[][] eliminasiBaris(double[][] M){
		// menngeliminasi baris yang isallzero
		int i,j, eliminasi;
		eliminasi = 0;
		for (i = 0; i < M.length; i++){
			if (isAllZero(M,i)){
				eliminasi +=1;
			}
		}
		i =0;
		double[][] M1 = new double[M.length-eliminasi][M[0].length];
		for (i=0; i < M1.length; i++){
			for (j=0; j< M1[0].length; j++){
				M1[i][j] = M[i][j];
			}
		}
		// Copy matriks 
		M = Matriks.CopyMatriks(M1);
		return M;
	}

	public static boolean isFree(double[][] M, int j){
		//  APAKAH Matriks dengan indeks  kolom j free
		int i;
		boolean isfree = true;
		for (i=0; i < M.length; i++ ){
			if (M[i][j]  != 0){
				isfree = false;
			}
		}
		return isfree;

	}

	public static boolean isAllZero(double[][] M, int i){
		// apakah pada baris tersebut semuanya bernilai 0
		int j;
		boolean isZero = true;
		for (j =0; j <M[0].length; j++){
			if (M[i][j] != 0){
				isZero = false;
			}
		}
		return isZero;
	}

	public static String[] solusiGauss(double[][] M){

		//  Matriks M 
		// SOLUSI DARI Matriks 
		//Matriks Gauss = new Matriks();
		double[][] Gauss = Matriks.CopyMatriks(M);
		int i,j,now;
		boolean firstparam;
		String[] solusi = new String[100];
		for (i = 1; i < M.length; i++){
			M = EliminasiOBEjordan(M, i);
		}
		M = eliminasiBaris(M);
		// variabel yang sebenarnya tidak berguna
		for (j=0; j < M[0].length - 1; j++){
			if (isFree(M,j)){
				solusi[j] = "Free";
			} else {
				solusi[j] = ParametrikOrUnik(M,j);
			}
		}
		for (i=0; i < M.length; i++){
			now = 99;
			firstparam = true;
			for (j=0; j <M[0].length-1; j++){
				if (M[i][j]!= 0){
					if (solusi[j] == "Unik" && now != 99){
						solusi[j] = "Parametrik";
					}
					if (solusi[j] == "Unik" && M[i][j]==1){
						now = j ;
						if (M[i][M[0].length-1]==0){
							solusi[j] ="X"+String.valueOf(j+1)+" :" +" 0" ;
						} else {
							solusi[j] ="X"+String.valueOf(j+1)+" : " + String.format("%.4f",M[i][M[0].length-1]);
						}
					}
					if (solusi[j] == "Parametrik"){
						if (firstparam && M[i][M[0].length-1]==0){
							solusi[now] = solusi[now] +" "+String.format("%.4f",M[i][j]*-1)+"X"+String.valueOf(j+1);
							firstparam = false;
						} else {
							solusi[now] = solusi[now] +" + "+String.format("%.4f",M[i][j]*-1)+"X"+String.valueOf(j+1);
						} 
					}
				}
			}
		}
		for (j=0; j < M[0].length - 1; j++){
			if (solusi[j]=="Free" || solusi[j]=="Parametrik"){
				solusi[j] = "X"+String.valueOf(j+1)+" : " + "Free";
			}
		}
        M = Matriks.CopyMatriks(Gauss);
        return solusi;
	}


	public static String ParametrikOrUnik(double[][] M, int j){
		//  APAKAH Matriks dengan indeks  kolom parametrik
		int i, notzero, satu;
		notzero = 0;
		satu = 0;
		for (i=0; i < M.length; i++ ){
			if (M[i][j]  != 0){
				notzero = notzero + 1;
			}
			if (M[i][j]  == 1){
				satu = satu + 1;
			}
		}
		if (satu ==1 && notzero ==1){
			return "Unik";
		} else {
			return "Parametrik";
		}
	}

	public static String[] solusiGaussJordan(double[][] M){
		// Matriks M 
		// SOLUSI DARI Matriks 
		int i,j,now;
		boolean firstparam;
		String[] solusi = new String[100];
		
		// variabel yang sebenarnya tidak berguna
		for (j=0; j < M[0].length - 1; j++){
			if (isFree(M,j)){
				solusi[j] = "Free";
			} else {
				solusi[j] = ParametrikOrUnik(M,j);
			}
		}
		for (i=0; i < M.length; i++){
			now = 99;
			firstparam = true;
			for (j=0; j <M[0].length-1; j++){
				if (M[i][j]!= 0){
					if (solusi[j] == "Unik" && now != 99){
						solusi[j] = "Parametrik";
					}
					if (solusi[j] == "Unik" && M[i][j]==1){
						now = j ;
						if (M[i][M[0].length-1]==0){
							solusi[j] ="X"+String.valueOf(j+1)+" :"+" 0"  ;
						} else {
							solusi[j] ="X"+String.valueOf(j+1)+" : " + String.format("%.4f",M[i][M[0].length-1]);
						}
					}
					if (solusi[j] == "Parametrik"){
						if (firstparam && M[i][M[0].length-1]==0){
							solusi[now] = solusi[now] +" "+String.format("%.4f",M[i][j]*-1)+"X"+String.valueOf(j+1);
							firstparam = false;
						} else {
							solusi[now] = solusi[now] +" + "+String.format("%.4f",M[i][j]*-1)+"X"+String.valueOf(j+1);
						} 
					}
				}
			}
		}
		for (j=0; j < M[0].length - 1; j++){
			if (solusi[j]=="Free" || solusi[j]=="Parametrik"){
				solusi[j] = "X"+String.valueOf(j+1)+" : " + "Free";
			}
		}
		return solusi;
	}
}

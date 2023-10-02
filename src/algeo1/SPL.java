package algeo1;
import java.util.*;
//import algeo1.Matriks;

public class SPL {
    public static final Scanner userInput = new Scanner(System.in);
    public static final Matriks Met = new Matriks();
    public static final Inputan input = new Inputan();
    public static final Menu menu = new Menu();
    public static final Determinan determinan = new Determinan();

    public void menuSPL(){
		Matriks Maug = new Matriks();
		int op,op2,op3;
		System.out.println("Anda telah memilih menu SPL");
		System.out.println("Silahkan pilih metode pembacaan matriks [1= file, 2= keyboard, 3= matriks hilbert] ");
		System.out.print("Masukkan pilihan : ");
		op = userInput.nextInt();
		System.out.println("");
		while (op != 1 && op !=2 && op !=3){
			System.out.println("Pilihan salah !! Silahkan pilih metode pembacaan matriks [1= file, 2= keyboard, 3= matriks hilbert]");
			System.out.print("Masukkan pilihan : ");
			op = userInput.nextInt();
			System.out.println("");
		}
       
		if (op==2) {
			Met.MAug(Maug);
		} else if (op==1){
			input.bacaFile(Maug);
		} else if (op==3){
			Met.Hilbert(Maug);
		}

		if (Met.IsTidakAdaSolusi(Maug)){
			System.out.println("Matriks tidak konsisten sehingga tidak memiliki solusi");
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			menu.daftarMenu();
		}
		System.out.println("Silahkan pilih metode penyelesaian SPL [1= Gauss, 2= Gauss Jordan, 3= Invers, 4= Metode Cramer ]");
		System.out.print("Masukkan pilihan : ");
		op2 = userInput.nextInt();
		while (op2 != 1 && op2 != 2 && op2 != 3 && op2 != 4){
			System.out.println("Pilihan salah !! Silahkan pilih metode penyelesaian SPL [1= Gauss, 2= Gauss Jordan, 3= Invers, 4= Metode Cramer ]");
			System.out.print("Masukkan pilihan : ");
			op2 = userInput.nextInt();
			System.out.println("");
		}
		if (op2 == 1) {
			// Gauss
			GaussSPL(Maug);
			System.out.println("Matriks Hasil Eliminasi Gaussnya adalah");
			Met.ketikMatriks(Maug);
			System.out.println("");
			solusiGauss(Maug);
		} else if (op2 == 2){
			// Gauss Jordan
			GaussJordan(Maug);
			System.out.println("Matriks Hasil Gauss Jordannya adalah");
			Met.ketikMatriks(Maug);
			System.out.println("");
			eliminasiBaris(Maug);
			solusiGaussJordan(Maug);
		} else if (op2 == 3 || op2==4){
			if (Maug.kolom-1 > Maug.baris){
				System.out.println("Tidak punya determinan karena matriks koefisien bukan matriks persegi");
				System.out.println("Silahkan gunakan metode lain untuk menyelesaikan");	
				System.out.println("Kembali ke Menu Utama");
				System.out.println("");
				menu.daftarMenu();
			} else {	
				Matriks MH = new Matriks();
				Matriks MK = new Matriks();
				GetMATRIKSHasil(Maug, MH);
				GetMATRIKSKoefisien(Maug, MK);
				if (!Met.IsPunyaInvers(MK)) {
					System.out.println("Tidak bisa menggunakan metode cramer maupun metode invers karena determinannya 0");
					System.out.println("Silahkan gunakan metode lain untuk menyelesaikan");	
					System.out.println("Kembali ke Menu Utama");
					System.out.println("");
                    menu.daftarMenu();
				} else {
					if (op2 ==3 ){
						SPLInvers(Maug, MK, MH);
					} else if (op2 ==4){
						MetodeCramer(Maug, MK, MH);
					}
				}
			}
		}
		System.out.println("Apakah anda ingin menyimpan hasil kedalam file? [1= ya, 2= tidak]");
		System.out.print("Masukkan pilihan : ");
		op3 = userInput.nextInt();
		while (op3 != 1 && op3 != 2){
			System.out.println("Pilihan salah !! Apakah anda ingin menyimpan hasil kedalam file? [1= ya, 2= tidak]");
			System.out.print("Masukkan pilihan : ");
			op3 = userInput.nextInt();
			System.out.println("");
		}
		if (op3 == 1) {
			input.TulisFileDesc(Maug);
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			menu.daftarMenu();
		} else {
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			menu.daftarMenu();
		}
	}

	public void GetMATRIKSKoefisien (Matriks MAug, Matriks MK){	
		int i,j;
		Met.buatMatriks(MAug.kolom-1, MAug.kolom-1, MK);
		for (i=0; i< MK.baris;i++){
			for (j=0; j< MK.kolom;j++){
				MK.matriks[i][j] = MAug.matriks[i][j];
			}
		}
	}

	public void GetMATRIKSHasil (Matriks MAug, Matriks MH) {
		// Reihan Andhika Putra, Checked
		/* I.S. MAug, dan MH terdefinisi */
		/* F.S. membentuk matriks MK berukuran Nx1 yang berisikan bagian konstanta dari MAug */
		int i;
		Met.buatMatriks(MAug.kolom-1, 1, MH);
		for (i=0; i< MAug.baris; i++){
			MH.matriks[i][0]=MAug.matriks[i][MAug.kolom-1];
		}
	}

	
	public Matriks MATRIKSCramer(Matriks MK, Matriks MH, int kol) {
		Matriks Cramer = new Matriks();
		int i;
		Met.buatMatriks(MK.baris, MK.kolom, Cramer);
		//Met.CopyMatriks(MK, Cramer);
        Met.CopyMatriks(MK, Cramer);
		for (i=0; i< Cramer.baris; i++){
			Cramer.matriks[i][kol] = MH.matriks[i][0];
		}
		return Cramer;
	}

	public void MetodeCramer (Matriks Maug, Matriks MK, Matriks MH) {
		/*Menyelesaikan SPL dengan metode Cramer */
		double[] solusi = new double[100];
		int i;
		System.out.println("Matriks Koef");
		Met.ketikMatriks(MK);
		System.out.println();
		System.out.println("Matriks Hasil");
		Met.ketikMatriks(MH);
		System.out.println();
		System.out.println("Nilai koef");
		Maug.NDesc = MK.baris+1;
		Maug.desc[0] = "Diselesaikan dengan metode cramer";
		for (i=0; i < MK.kolom; i++){
			solusi[i] = determinan.Kofaktor(MATRIKSCramer(MK, MH, i))/determinan.Kofaktor(MK);
			System.out.printf("x"+ String.valueOf(i+1)+": "+ String.format("%.2f",solusi[i]));
			Maug.desc[i+1] = "\nx"+ String.valueOf(i+1)+": "+ String.format("%.2f",solusi[i]);
			System.out.println("");
		}
	}

	public void EliminasiOBE(Matriks M, int indeks){
		// Prekondisi bahwa matriks udah di sort
		//  Matriks 
		// dieliminasikan baris dengan indeks indeks
		int i,j,a; 
		// buat semua dimulai dengan angka 1 
		for (i=0; i < M.baris; i++){
			M.BagiBaris(M,i);
		}
		j=0;
		while (M.matriks[indeks][j] != 1 && j < M.kolom){
			j+=1;
		}
		if (j < M.kolom){
			for (i=indeks+1;i < M.baris;i++){
				if (M.matriks[i][j] == 1){
					for (a=j; a < M.kolom; a++){
						M.matriks[i][a] -= M.matriks[indeks][a];
					}
				}
			}
		}

	}

	public void EliminasiOBEjordan(Matriks M , int indeks){
		// INPUTAN Matriks dan Indeks yang akan menjadi acuan untuk dikurangi 
		// semua diatas angka 1 adalah 0 
		int i,j,a;
		double kali; 
		j = 0;
		while (M.matriks[indeks][j] != 1 && j < M.kolom){
			j+=1;
		}
		if (j < M.kolom){
			for (i=0; i < indeks; i++){
				if (M.matriks[i][j] != 0){
					kali = M.matriks[i][j];
					for (a=j; a < M.kolom; a++){
						if (j < M.kolom -1){
							M.matriks[i][a] = M.matriks[i][a] - (M.matriks[indeks][a] * kali);
						}
					}
				}
			}
		}
	}

	public void GaussSPL(Matriks M){
		// Matriks M 
		// Matriks echelon
		int i;
		for (i = 0; i < M.baris-1; i++){
			// kurangkan semua
			Met.SortBaris(M); 
			EliminasiOBE(M,i);
			// SortBaris(M); 
		}
		Met.BagiBaris(M,i);
	}

	public void GaussJordan(Matriks M){
		// Matriks M
		// matriks echelon tereduksi 
		int i;
		GaussSPL(M);
		for (i = 1; i < M.baris; i++){
			EliminasiOBEjordan(M, i);
		}
	}


	public void SPLInvers (Matriks Maug, Matriks MK, Matriks MH) {
		// Reihan Andhika Putra, Checked
		/* Maug terdefinisi */
		/* Menyelesaikan SPL dengan metode invers */
		int i ;
		Matriks Solusi = new Matriks();
		System.out.println("Matriks Koef");
		Met.ketikMatriks(MK);
		System.out.println();
		System.out.println("Matriks Hasil");
		Met.ketikMatriks(MH);
		Met.buatMatriks(MK.baris, MH.kolom, Solusi);
		System.out.println();
		MK = Met.Inverse(MK);
		Solusi = Met.KaliMatriks(MK, MH);
		Maug.NDesc = MK.baris+1;
		Maug.desc[0] = "Diselesaikan dengan Invers SPL";
		for (i = 0 ; i< MK.baris; i++){
			System.out.printf("x"+ String.valueOf(i+1)+": "+ String.format("%.2f",Solusi.matriks[i][0]));
			System.out.println("");
			Maug.desc[i+1] = "\nx"+ String.valueOf(i+1)+": "+ String.format("%.2f",Solusi.matriks[i][0]);
		}
	}
	public void eliminasiBaris(Matriks M){
		// menngeliminasi baris yang isallzero
		int i,j, eliminasi;
		Matriks M1 = new Matriks();
		eliminasi = 0;
		for (i = 0; i < M.baris; i++){
			if (isAllZero(M,i)){
				eliminasi +=1;
			}
		}
		i =0;
		// BUAT matriks baru 
		Met.buatMatriks(M.baris - eliminasi, M.kolom, M1);
		for (i=0; i < M1.baris; i++){
			for (j=0; j< M1.kolom; j++){
				M1.matriks[i][j] = M.matriks[i][j];
			}
		}
		// Copy matriks 
		Met.buatMatriks(M1.baris, M1.kolom, M);
		for (i=0; i < M1.baris; i++){
			for (j=0; j< M1.kolom; j++){
				M.matriks[i][j] = M1.matriks[i][j];
			}
		}
	}

	public Boolean isFree(Matriks M, int j){
		//  APAKAH Matriks dengan indeks  kolom j free
		int i;
		boolean isfree;
		isfree = true;
		for (i=0; i < M.baris; i++ ){
			if (M.matriks[i][j]  != 0){
				isfree = false;
			}
		}
		return isfree;

	}

	public boolean isAllZero(Matriks M, int i){
		// apakah pada baris tersebut semuanya bernilai 0
		int j;
		boolean isZero = true;
		for (j =0; j <M.kolom; j++){
			if (M.matriks[i][j] != 0){
				isZero = false;
			}
		}
		return isZero;
	}

	public void solusiGauss(Matriks M){

		//  Matriks M 
		// SOLUSI DARI Matriks 
		Matriks Gauss = new Matriks();
		M.CopyMatriks(M, Gauss);
		int i,j,now;
		boolean firstparam;
		String[] solusi = new String[100];
		for (i = 1; i < M.baris; i++){
			EliminasiOBEjordan(M, i);
		}
		eliminasiBaris(M);
		// variabel yang sebenarnya tidak berguna
		for (j=0; j < M.kolom - 1; j++){
			if (isFree(M,j)){
				solusi[j] = "Free";
			} else {
				solusi[j] = ParametrikOrUnik(M,j);
			}
		}
		for (i=0; i < M.baris; i++){
			now = 99;
			firstparam = true;
			for (j=0; j <M.kolom-1; j++){
				if (M.matriks[i][j]!= 0){
					if (solusi[j] == "Unik" && now != 99){
						solusi[j] = "Parametrik";
					}
					if (solusi[j] == "Unik" && M.matriks[i][j]==1){
						now = j ;
						if (M.matriks[i][M.kolom-1]==0){
							solusi[j] ="X"+String.valueOf(j+1)+" :" +" 0" ;
						} else {
							solusi[j] ="X"+String.valueOf(j+1)+" : " + String.format("%.2f",M.matriks[i][M.kolom-1]);
						}
					}
					if (solusi[j] == "Parametrik"){
						if (firstparam && M.matriks[i][M.kolom-1]==0){
							solusi[now] = solusi[now] +" "+String.valueOf(M.matriks[i][j]*-1)+"X"+String.valueOf(j+1);
							firstparam = false;
						} else {
							solusi[now] = solusi[now] +" + "+String.valueOf(M.matriks[i][j]*-1)+"X"+String.valueOf(j+1);
						} 
					}
				}
			}
		}
		System.out.println("Solusinya adalah :");
		for (j=0; j < M.kolom - 1; j++){
			if (solusi[j]=="Free" || solusi[j]=="Parametrik"){
				solusi[j] = "X"+String.valueOf(j+1)+" : " + "Free";
			}
			System.out.println(solusi[j]);
			M.desc[j] = "\n" + solusi[j];
		}
		M.NDesc = M.kolom - 1;
	//	Met.CopyMatriks(Gauss, M);
        Met.CopyMatriks(Gauss, M);
	}


	public String ParametrikOrUnik(Matriks M, int j){
		//  APAKAH Matriks dengan indeks  kolom parametrik
		int i, notzero, satu;
		notzero = 0;
		satu = 0;
		for (i=0; i < M.baris; i++ ){
			if (M.matriks[i][j]  != 0){
				notzero = notzero + 1;
			}
			if (M.matriks[i][j]  == 1){
				satu = satu + 1;
			}
		}
		if (satu ==1 && notzero ==1){
			return "Unik";
		} else {
			return "Parametrik";
		}
	}

	public void solusiGaussJordan(Matriks M){
		// Matriks M 
		// SOLUSI DARI Matriks 
		int i,j,now;
		boolean firstparam;
		String[] solusi = new String[100];
		
		// variabel yang sebenarnya tidak berguna
		for (j=0; j < M.kolom - 1; j++){
			if (isFree(M,j)){
				solusi[j] = "Free";
			} else {
				solusi[j] = ParametrikOrUnik(M,j);
			}
		}
		for (i=0; i < M.baris; i++){
			now = 99;
			firstparam = true;
			for (j=0; j <M.kolom-1; j++){
				if (M.matriks[i][j]!= 0){
					if (solusi[j] == "Unik" && now != 99){
						solusi[j] = "Parametrik";
					}
					if (solusi[j] == "Unik" && M.matriks[i][j]==1){
						now = j ;
						if (M.matriks[i][M.kolom-1]==0){
							solusi[j] ="X"+String.valueOf(j+1)+" :"+" 0"  ;
						} else {
							solusi[j] ="X"+String.valueOf(j+1)+" : " + String.format("%.2f",M.matriks[i][M.kolom-1]);
						}
					}
					if (solusi[j] == "Parametrik"){
						if (firstparam && M.matriks[i][M.kolom-1]==0){
							solusi[now] = solusi[now] +" "+String.valueOf(M.matriks[i][j]*-1)+"X"+String.valueOf(j+1);
							firstparam = false;
						} else {
							solusi[now] = solusi[now] +" + "+String.valueOf(M.matriks[i][j]*-1)+"X"+String.valueOf(j+1);
						} 
					}
				}
			}
		}
		System.out.println("Solusinya adalah :");
		for (j=0; j < M.kolom - 1; j++){
			if (solusi[j]=="Free" || solusi[j]=="Parametrik"){
				solusi[j] = "X"+String.valueOf(j+1)+" : " + "Free";
			}
			System.out.println(solusi[j]);
			M.desc[j] = "\n" + solusi[j];
		}
		M.NDesc = M.kolom - 1;
	}
}

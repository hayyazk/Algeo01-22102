package Algeo1;

import java.util.*;
import java.lang.Math;
import Algeo1.Menu;
import Algeo1.*;

public class Matriks {

        /* Tipe data matriks */
        
            public double [][] matriks = new double[100][100]; 
            public int baris;
            public int kolom; 
            public String [] desc = new String[100];
            public int NDesc;
        
        public final Scanner userInput = new Scanner(System.in);
        
    
        /* *** Konstruktor membentuk MATRIKS *** */
        public void buatMatriks(int nbaris, int nkolom, Matriks M) { 
           M.baris= nbaris;
           M.kolom= nkolom;
           
         }
        
        //public final Determinan de = new Determinan();
        public final Inputan input = new Inputan();
        
         /* ********** KELOMPOK BACA/TULIS ********** */
        public void BacaMatriks(Matriks M){
            int i,j,n;
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan jumlah baris dan kolom matriks ( n x n) : ");
            n = input.nextInt();
            System.out.println("masukan isi Matriks " + n + " x " + n + " : ");
            for(i = 0; i < n; i++){
                for (j = 0; j < n; j++){
                    M.matriks[i][j]= input.nextDouble();
                }
            }
            buatMatriks(n,n,M);
            System.out.println("Matriks yang anda masukkan adalah :");
            ketikMatriks(M);
            System.out.println();
        }
    
        public void MAug(Matriks M){
            System.out.print("Masukkan ordo matriks mxn : ");
            baris = userInput.nextInt();
            kolom = userInput.nextInt();
            System.out.println("Tulis Elemen Matriks ");
            for(int i = 0; i < baris; i++){
                for (int j = 0; j < kolom; j++){
                 //   M.matriks[i][j]= userInput.nextDouble();
                    M.matriks[i][j]= userInput.nextDouble();
                }
            }
            buatMatriks(baris,kolom,M);
            System.out.println("Matriks yang anda masukkan adalah :");
            ketikMatriks(M);
            System.out.println();
        }
    
        public void Hilbert (Matriks MAug){
          int n;
          double d;
            
            System.out.print("Masukkan jumlah baris dan kolom ( n x n ) untuk matriks koefisien dari matriks Hilbert: ");
          Scanner input = new Scanner(System.in);
          n = input.nextInt();
          for (int i = 0; i < n; i ++) {
                for (int j = 0; j <= n ; j ++) {
                    d = i + 1 + j; 
                    if (j != n ) {
                        MAug.matriks[i][j] = (1/(d));
                    } 
                    else
                    {
                        if (i == 0) {
                            MAug.matriks[i][j] = 1;
                        }
                        else 
                        {
                            MAug.matriks[i][j] = 0;
                        }
                    }
                }
            }
            buatMatriks(n, n+1, MAug);
            System.out.println("Matriks yang anda masukkan adalah :");
            ketikMatriks(MAug);
            System.out.println();
    
        }
        
        public void ketikMatriks (Matriks M){
           
            int i,j ;
            for(i = 0; i <= M.baris-1; i++){
                for (j = 0; j <= M.kolom-1; j++){
                    if (M.matriks[i][j]==-0.0){
                        M.matriks[i][j]= -0.0 + 0.0;
                    }
                    if (j == (M.kolom-1) && i == (M.baris-1)) {
                        System.out.printf("%.2f", M.matriks[i][j]);
                    } else if (j == (M.kolom-1)){
                        System.out.printf("%.2f", M.matriks[i][j]);
                        System.out.println();
                    } else {
                        System.out.printf("%.2f", M.matriks[i][j]);
                        System.out.print(" ");
                    }
                }
            }
        }
    
        /* ********** KELOMPOK OPERASI TERHADAP MATRIKS ********** */
        public static boolean bentukMatriks(Matriks M){
            /* Mengirimkan true jika M adalah matriks dg ukuran baris dan kolom sama */
            return (M.baris == M.kolom);
        }
    
        public Matriks KaliMatriks (Matriks M1, Matriks M2){
            /* Prekondisi : Ukuran kolom efektif M1 = ukuran baris efektif M2 */
            /* Mengirim hasil perkalian matriks: salinan M1 * M2 */
            int k;
            double el;
            Matriks M3 = new Matriks();
            buatMatriks(M1.baris,M2.kolom,M3);
            for(int i = 0; i <= M3.baris-1; i++){
                for (int j = 0; j <= M3.kolom-1; j++){
                    el = 0;
                    for (k = 0 ; k <= M1.kolom; k++){
                        el = el + M1.matriks[i][k]*M2.matriks[k][j];
                    }
                    M3.matriks[i][j] = el;
                }
            }
            return M3;
        }
    
        public void Transpose(Matriks M){
            /*  M terdefinisi dan IsBujursangkar(M) */
            /* M "di-transpose", yaitu setiap elemen M(i,j) ditukar nilainya dengan elemen M(j,i) */
            Matriks M3 = new Matriks();
            int i,j;
            buatMatriks(M.baris,M.kolom,M3);
            for (i = 0; i < M.baris; i++)
            {
                for (j = 0; j < M.kolom; j++)
                {
                    M3.matriks[i][j] = M.matriks[j][i] ;
                }
            }
            M.matriks = M3.matriks;
        }
    
        public Matriks Inverse (Matriks M){
            /* M terdefinisi dan pasti punya invers */
            /* return Matriks hasil inverse */
            Matriks Invers = new Matriks();
            Invers = MatriksKofaktor(M);
            Transpose(Invers);
            double perdet ;
            Determinan determinan = new Determinan();
            perdet = 1/determinan.Kofaktor(M);
            PKaliKons(Invers, perdet);
            return (Invers);	
        }

        public Matriks MatriksKofaktor(Matriks M){
            /* M terdefinisi */
            /* Mengeluarkan Matriks kofaktor dari sebuah matriks */
            
            int i,j;
            Matriks Kofaktor = new Matriks();
          //  Matriks det = Kofaktor.KofakElmt( M, i, j);
            Kofaktor.buatMatriks(M.baris,M.kolom,Kofaktor);
            for (i = 0; i < M.baris; i++)
            {
                for (j = 0; j < M.kolom; j++)
                {
                    Kofaktor.matriks[i][j] = KofakElmt(M, i, j);
                    
                }
            }
            return Kofaktor;
        }
        Determinan determinan = new Determinan();
        public double KofakElmt(Matriks M, int i, int j){
            /* M terdefinisi, i, j dalam range matriks */
            /* Mengeluarkan elemen kofaktor(i,j) dari sebuah matriks */
            Matriks Minor = new Matriks();
            buatMatriks((M.baris - 1), (M.kolom - 1), Minor);
            int ii, jj, mi, mj;
            double koef = Math.pow(-1, (i+j+2)) ;
            mi = 0; 
            mj = 0;
            for (ii = 0; ii < M.baris; ii++) {
                for (jj = 0; jj < M.kolom; jj++) {
                    if (ii != i && jj != j) {
                        Minor.matriks[mi][mj] = M.matriks[ii][jj];
                        mj = mj + 1;
                        if (mj > M.baris - 2) {
                            mi = mi + 1;
                            mj = 0;
                        }
                    }
                }
            }
            return determinan.Kofaktor(Minor)*koef ;			
        }

        public void PKaliKons(Matriks M, double K)
        {
            /* M terdefinisi, K terdefinisi */
            /* Mengalikan setiap elemen M dengan K */
            int i,j;
            for (i = 0; i < M.baris; i++)
            {
                for (j = 0; j < M.kolom; j++)
                {
                    M.matriks[i][j] = M.matriks[i][j] * K;
                }
            }
        }
    
        public boolean IsPunyaInvers (Matriks M) {
            /* M terdefinisi */
            /* Mereturn true apabila Matriks m matrikspunyai invers */
            return (determinan.Kofaktor(M) != 0);
        }
    
        public void CopyMatriks(Matriks MIn, Matriks MHsl){
            /* MIn, dan MHsl terdefinisi */
            /* Melakukan assignment MHsl  MIn */
            int i,j;
            buatMatriks(MIn.baris, MIn.kolom, MHsl);
            for (i=0; i< MIn.baris; i++){
                for (j=0; j< MIn.kolom; j++){
                     MHsl.matriks[i][j] = MIn.matriks[i][j];
                }
         }
        }
    
        public void TukarBaris(Matriks M, int i1, int i2) {
            int j;
            double temp; 
            for(j=0;j < M.kolom;j++){
                temp = M.matriks[i1][j];
                M.matriks[i1][j] = M.matriks[i2][j];
                M.matriks[i2][j] = temp;
            } 
        }
    
        SPL spl = new SPL();
        public boolean IsTidakAdaSolusi(Matriks M){
            Matriks M2 = new Matriks();
            CopyMatriks(M, M2);
            spl.GaussJordan(M2);
            spl.eliminasiBaris(M2);
            int i,j;
            boolean solusi, hasil;
            hasil = false;
            for (i=0; i< M2.baris; i++){
                solusi = true;
                for (j=0; j< M2.kolom-1; j++){
                     if (M2.matriks[i][j] != 0){
                        solusi = false;
                     }
                }
                if (solusi){
                    if (M2.matriks[i][j] != 0){
                        hasil = true;
                    }
                }
            }
            return hasil;
        }
    
        public void BagiBaris(Matriks M, int i){
            int j, j1, j2;
            double penyebut;
            j = 0;
            boolean a = true;
            for (j2=0;j2<M.kolom;j2++){
                if (M.matriks[i][j2] >= -0.00000000000001 && M.matriks[i][j2] < 0 ){
                    M.matriks[i][j2] = 0;
                }
            }
            while (M.matriks[i][j] == 0 && j < M.kolom){
                j +=1; 
            }
            if (j < M.kolom){
                penyebut = M.matriks[i][j];
                for (j1 = j; j1 < M.kolom;j1++){
                    M.matriks[i][j1] = M.matriks[i][j1]/penyebut;
                }
            }
        }
    
        public int IndeksKolom(Matriks M, int i){
            //  mencari indeks kolom yang berawal nilai 0 
            int j, idxKol;
            boolean isKetemu;
            isKetemu = false;
            j = 0;
            idxKol = 0;
            while ( j < M.kolom && !isKetemu){
                if (M.matriks[i][j] != 0){
                    isKetemu = true;
                    idxKol = j;
                } else {
                    j +=1;
                }
            } 
            if (j >= M.kolom){
                idxKol = M.kolom;
            }
            return idxKol;
            
        }
    
        public void SortBaris(Matriks M){
            int i, j; 
            for (i= 0; i < M.baris-1; i++){
                for (j = i+1; j < M.baris; j++){
                    if (IndeksKolom(M,i) > IndeksKolom(M,j)){
                        TukarBaris(M,i,j);
                    }
                }
            }
        }

        public class Determinan {
    public double Kofaktor(Matriks M)
	{
		/* Menghitung nilai determinan M menggunakan ekspansi kofaktor pada baris ke-1 */
		if (M.baris == 1)
		{
			return M.matriks[0][0];
		}
		else
		{
			Matriks Minor = new Matriks();
			buatMatriks((M.baris - 1), (M.kolom - 1), Minor);
			int i, j, k, ci, cj;
			double det;
			int koef = 1;

			det = 0;
			if (M.baris == 2)
			{
				det = M.matriks[0][0] * M.matriks[1][1] - M.matriks[0][1] * M.matriks[1][0];
				return det;
			}
			else
			{
				for (i = 0; i < M.baris; i++)
				{
					ci = 0; 
					cj = 0;
					for (j = 0; j < M.baris; j++)
					{
						for (k = 0; k < M.baris; k++)
						{
							if (j != 0 && k != i)
							{
								Minor.matriks[ci][cj] = M.matriks[j][k];
								cj = cj + 1;
								if (cj > M.baris - 2)
								{
									ci = ci + 1;
									cj = 0;
								}
							}
						}
					}
					det = det + koef * ((M.matriks[0][i]) * Kofaktor(Minor));
					koef = -1 * koef;
				}
			}
			return det;
		}
	}
}

public void MenuDeterminan(){
    //Scanner userInput = new Scanner(System.in);
    Matriks M = new Matriks();
    int op,op2,op3;
    System.out.println("Anda telah memilih menu Determinan");
    System.out.println("Silahkan pilih metode pembacaan matriks");
    System.out.println("\n1. Input dari Keyboard");
	System.out.println("2. Input dari File\n==============");
    System.out.println("3. Kembali ke menu utama");
    System.out.print("Masukkan pilihan : ");
    op = userInput.nextInt();
    System.out.println("");
    while (op != 1 && op !=2){
        System.out.println("Pilihan salah !! Silahkan pilih metode pembacaan matriks");
        System.out.println("\n1. Input dari Keyboard");
	    System.out.println("2. Input dari File\n==============");
        System.out.println("3. Kembali ke menu utama");
        System.out.print("Masukkan pilihan : ");
        op = userInput.nextInt();
        System.out.println("");
    }
    if (op == 3) {
        Menu daftar = new Menu();
        daftar.daftarMenu();
    }
    else if(op==2) {
        Matriks m = new Matriks();
        m.BacaMatriks(M);
    } else if (op==1){
        Inputan hasil = new Inputan();
        hasil.bacaFile(M);
    }


    if (!bentukMatriks(M)){
        System.out.println("Tidak punya determinan karena bukan matriks persegi");
        System.out.println("Kembali ke Menu Utama");
        System.out.println("");
        Menu daftar = new Menu();
        daftar.daftarMenu();
    } else {
        System.out.println("Silahkan pilih metode pencarian determinan [1= Ekspansi Kofaktor, 2= Segitiga Atas, 3=Segitiga Bawah]");
        System.out.print("Masukkan pilihan : ");
        op2 = userInput.nextInt();
        while (op2 != 1 && op2 != 2 && op2 != 3){
            System.out.println("Pilihan salah !! Silahkan pilih metode pencarian determinan [1= Ekspansi Kofaktor, 2= Segitiga Atas, 3=Segitiga Bawah]");
            System.out.print("Masukkan pilihan : ");
            op2 = userInput.nextInt();
            System.out.println("");
        }
       // Determinan determinan = new Determinan();
        if (op2 == 1) {
            DeterminanKofaktor(M);
        } else if (op2 == 2){
            Segiatas(M);
        } else if (op2 == 3){
            Segibawah(M);
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
            input.TulisFileDesc(M);
            System.out.println("Kembali ke Menu Utama");
            System.out.println("");
            Menu menu = new Menu();
            menu.daftarMenu();
        } else {
            System.out.println("Kembali ke Menu Utama");
            System.out.println("");
            Menu menu = new Menu();
            menu.daftarMenu();
        }
    }
}	
public void DeterminanKofaktor (Matriks M ){
    Matriks ketik = new Matriks();
    double det = determinan.Kofaktor(M);
    MATRIKSKofaktor2(M);
    System.out.println("Matriks kofaktornya adalah: ");
    ketik.ketikMatriks(M);
    System.out.println("");
    System.out.print("Determinannya adalah: ");
    System.out.println(det);
    M.NDesc = 1;
    M.desc[0] = "Matriks Kofaktor, Determinannya adalah " + String.valueOf(det);
}

public void MATRIKSKofaktor2 (Matriks M){
    /* Mengeluarkan Matriks kofaktor dari sebuah matriks */
    Matriks Kofaktor = new Matriks();
    Kofaktor.buatMatriks(M.baris,M.kolom,Kofaktor);
    for (int i = 0; i < M.baris; i++)
    {
        for (int j = 0; j < M.kolom; j++)
        {
            Kofaktor.matriks[i][j] = KofakElmt(M, i, j);
        }
    }
    M.matriks = Kofaktor.matriks;
}

public void Segiatas(Matriks M){
    /* M terdefinisi, IsBujurSangkar(M) */
    /* Menghitung nilai determinan matriks M dengan metode segitiga atas. 
       Menulis ke layar matriks segitiga atas yang terbentuk dan determinan matriks awal. */
    int n, i, j; 
    double line1, line2;
    float count = 1;
    boolean found;
    for (n = 0; n < M.baris; n++){
        if (M.matriks[n][n] == 0){
            found = false;
              i = n+1;
              while (!found && i < M.baris){
                if (M.matriks[i][n] != 0){
                    found = true;
                    for (j = n; j < M.kolom; j++){
                        M.matriks[n][j] += M.matriks[i][j];
                    }
                 }
                 i++;
            }
            Matriks mat = new Matriks();
            if (!found){
                count = 0;
                n = M.baris;
                System.out.println("Matriks tidak dapat membentuk matriks segitiga atas.");
                System.out.println("Kondisi matriks setelah melakukan OBE:");
                mat.ketikMatriks(M);
                System.out.println();
                System.out.println("Determinan matriks = 0.0");
            }  
        }
           for (i = n+1; i < M.baris; i++){       
              if (M.matriks[i][n] != 0){        
                 line1 = M.matriks[n][n];
                 line2 = M.matriks[i][n]; 
                for (j = n; j < M.kolom; j++){
                    M.matriks[n][j] /= line1;
                    M.matriks[i][j] /= line2;
                    M.matriks[i][j] -= M.matriks[n][j];
                }
                count *= (line1 * line2);
            }
        }
        count *= M.matriks[n][n];
    }
    Matriks mat = new Matriks();
    if (count != 0){
        System.out.println("Matriks segitiga atas berhasil terbentuk.");
        System.out.println("Matriks segitiga atas tersebut adalah:");
        mat.ketikMatriks(M);
        System.out.println();
        System.out.println("Determinan matriks = " + count);
        M.NDesc = 1;
        M.desc[0] = "Matriks Segitiga Atas, Determinannya adalah " + String.valueOf(count);
    }
}

public void Segibawah(Matriks M){
    /* Menghitung nilai determinan matriks M dengan metode segitiga bawah. 
       Menulis ke layar matriks segitiga bawah yang terbentuk dan determinan matriks awal. */
    int n, i, j; 
    double line1, line2;
    float count = 1;
    boolean found;
    for (n = M.baris-1; n >= 0; n--){
        if (M.matriks[n][n] == 0){
            found = false;
              i = n-1;
              while (!found && i >= 0){
                if (M.matriks[i][n] != 0){
                    found = true;
                    for (j = n; j >= 0; j--){
                        M.matriks[n][j] += M.matriks[i][j];
                    }
                 }
                 i--;
            }
            Matriks mat = new Matriks();
            if (!found){
                count = 0;
                n = -1;
                System.out.println("Matriks tidak dapat membentuk matriks segitiga bawah.");
                System.out.println("Kondisi matriks setelah melakukan OBE:");
                mat.ketikMatriks(M);
                System.out.println();
                System.out.println("Matriks Segitiga Bawah, Determinan matriks = 0.0");
            }  
        }
           for (i = n-1; i >= 0; i--){       
              if (M.matriks[i][n] != 0){        
                 line1 = M.matriks[n][n];
                 line2 = M.matriks[i][n]; 
                for (j = n; j >= 0; j--){
                    M.matriks[n][j] /= line1;
                    M.matriks[i][j] /= line2;
                    M.matriks[i][j] -= M.matriks[n][j];
                }
                count *= (line1 * line2);
            }
        }
        count *= M.matriks[n][n];
    }
    Matriks mat = new Matriks();
    if (count != 0){
        System.out.println("Matriks segitiga bawah berhasil terbentuk.");
        System.out.println("Matriks segitiga bawah tersebut adalah:");
        mat.ketikMatriks(M);
        System.out.println();
        System.out.println("Determinan matriks = " + count);
        M.NDesc = 1;
        M.desc[0] = "Matriks Segitiga Bawah, Determinannya adalah " + String.valueOf(count);
    }
}

}

package algeo1;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Matriks {

    public static final double decPoint = 10000000000d;
    Scanner userInput = new Scanner(System.in);
    public int bmin = 0;
    public int kmin = 0;
    public int baris;
    public int kolom;
    public double[][] matriks;

    // Method untuk mengisi baris dan kolom matriks
    public void inputMatriks() {
        System.out.println("Masukan jumlah baris matriks : ");
        int baris = userInput.nextInt();
        System.out.println("Masukan jumlah kolom matriks : ");
        int kolom = userInput.nextInt();

        this.inputMatriks(baris,kolom);
    }

    // isi/bentukan metriks
    public void inputMatriks(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;

        System.out.println("Masukan matriks " + baris + " x " + kolom + " :") ;
        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                this.matriks[i][j] = userInput.nextDouble();
            }
        }
    }

    // Konstruktornya
    public Matriks(int baris, int kolom){
        this.baris = baris; //banyak baris
        this.kolom = kolom; //banyak kolom
        this.matriks = new double[baris][kolom];
    }

    //Tabel
    public Matriks(Matriks ini){
        this.baris = ini.baris;
        this.kolom = ini.kolom;
        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                this.matriks[i][j] = ini.matriks[i][j];
            }
        }
    }

    public Matriks(String file_name) throws FileNotFoundException {// Membaca Matriks dari sebuah file
        ArrayList<ArrayList<Double>> matriks = new ArrayList<ArrayList<Double>>();
        File file = new File(file_name);
        Scanner userInput = new Scanner(file);
        int baris = -1;
        int kolom = -1;
        while (userInput.hasNextLine()) {
            baris++;
            matriks.add(new ArrayList<Double>());
            String Baris = userInput.nextLine();
            Scanner scanBaris = new Scanner(Baris);
            while (scanBaris.hasNextDouble()) {
                Double element = scanBaris.nextDouble();
                matriks.get(baris).add(element);
            }
        }

        if (baris == 0) {
            System.out.println("Maaf file yang anda input tidak salah");
        } else {
            kolom = matriks.get(0).size();
            this.matriks = new double[matriks.size()][matriks.get(0).size()];
            for (int i = bmin; i <= baris; i++) {
                for (int j = kmin; j < kolom; j++) {
                    this.matriks[i][j] = matriks.get(i).get(j);
                }
            }
            this.baris = baris + 1;
            this.kolom = kolom;
        }
    }

    public int barisAwal(Matriks M) {
        return bmin;
    }

    public int kolomAwal(Matriks M) {
        return kmin;
    }

    public int barisAkhir(Matriks M) {
        return M.baris - 1;
    }

    public int kolomAkhir(Matriks M) {
        return M.kolom - 1;
    }

    public int bnykElmn(Matriks M) {
        return (M.baris * M.kolom);
    }

    public static Matriks Identitas(int x) {
        Matriks I = new Matriks(x, x);
        for (int i = 0; i < x; i++)
            I.matriks[i][i] = 1;
        return I;
    }

    public static Matriks Hilbert(int x) {
        Matriks H = new Matriks(x, x + 1);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                H.matriks[i][j] = 1.0 / (i + j + 1);
            }
        }
        return H;
    }

    public void BacaInputan() {
        System.out.println("Silahkan masukan Matriks : ");
        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                this.matriks[i][j] = userInput.nextDouble();
            }
        }
        System.out.print("\n");
    }

    
    public void tulisInputan() {
        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                this.matriks[i][j] += 0; // Agar tidak ada (-0)
                System.out.printf("%.2f ", this.matriks[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static Matriks Kali(Matriks M, double k) {
        Matriks user = new Matriks(M.baris, M.kolom);
        for (int i = 0; i < M.baris; i++) {
            for (int j = 0; j < M.kolom; j++) {
                user.matriks[i][j] = M.matriks[i][j] * k;
               // user.matriks[i][j] = M.matriks[i][j] * k;
            }
        }
        return user;
    }

    public void Kali(double k) {
        this.matriks = Kali(this, k).matriks;
    }

    public static Matriks Kali(Matriks M, Matriks N) {
        Matriks user = new Matriks(M.baris, N.kolom);

        for (int i = 0; i < user.baris; i++) {
            for (int j = 0; j < user.kolom; j++) {
                user.matriks[i][j] = 0;
                for (int k = 0; k < M.kolom; k++) {
                    user.matriks[i][j] += M.matriks[i][k] * N.matriks[k][j];
                }
            }
        }

        return user;
    }

    //OPERASI BARIS ELEMENTER 
    // Swap Baris
    public void Swap(int Brs1, int Brs2) {
        double[] ganti = matriks[Brs1];
      //  matriks[Brs1] = matriks[Brs2];
        matriks[Brs1] = matriks[Brs2];
        matriks[Brs2] = ganti;
    }

    public void perkalianBaris(int Baris, double x) {
        for (int i = 0; i < kolom; i++) {
           // matriks[Baris][i] *= x;
            matriks[Baris][i] *= x;
        }
    }

    public void tmbhbrssblh(int Baris1, int Baris2, double n) {
        // Baris ke-a ditambah dengan bilangan di baris ke-b
        for (int i = 0; i < kolom; i++) {
            matriks[Baris1][i] += matriks[Baris2][i] * n;
        }
    }

    public void tmbhbrssblh(int Baris1, int Baris2) {
        // Baris ke-a ditambah dengan bilangan di baris ke-b
        tmbhbrssblh(Baris1, Baris2, 1);
    }

    public void kuranginbrssblh(int a, int b, double n) {
        // Baris ke-a dikurangi dengan bilangan di baris ke-b * k
        tmbhbrssblh(a, b, -n);
    }

    public void kuranginbrssblh(int a, int b) {
        // Baris ke-a dikurangi dengan bilangan di baris ke-b
        kuranginbrssblh(a, b, 1);
    }

    public static boolean Identitas(Matriks M) {
        boolean user = true;
        for (int i = 0; i < M.baris; i++) {
            for (int j = 0; j < M.kolom; j++) {
                if (!(((i == j) && M.matriks[i][j] == 1) || ((i != j) && M.matriks[i][j] == 0))) {
                    user = false;
                }
            }
        }
        return user;
    }

    // Determinan
    public double DeterminanOBE(Matriks M) {
    Matriks N = deter(M);

    // Proses mengurutkan baris
    int[] zeroCount = new int[N.baris];
    int swapCount = 0;
    for (int i = 0; i < N.baris; i++) { // Kalkulasi jumlah 0
        zeroCount[i] = 0;
        int j = 0;
        while (j < N.kolom && N.matriks[i][j] == 0) {
            zeroCount[i]++;
            j++;
        }
    }
    for (int i = 0; i < N.baris; i++) { // Algoritma Pengurutan
        for (int j = 0; j < N.baris - 1; j++) {
            if (zeroCount[j] > zeroCount[j + 1]) {
                int temp;
                N.Swap(j, j + 1);
                swapCount++;
                temp = zeroCount[j];
                zeroCount[j] = zeroCount[j + 1];
                zeroCount[j + 1] = temp;
            }
        }
    }
    
    // Proses mereduksi baris
    int indent = 0;

    for (int i = 0; i < N.baris; i++) {
        // Mencari sel bernilai
        while (i + indent < N.kolom && N.matriks[i][i + indent] == 0) {
            indent++;
        }

        if (i + indent < N.kolom) {
            // Pengurangan baris dibawahnya
            for (int j = i + 1; j < N.baris; j++) {
                N.kuranginbrssblh(j, i, N.matriks[j][i + indent] / N.matriks[i][i + indent]);

            }
        }
    }

    // Proses menghitung jumlah diagonal
    double det = N.matriks[0][0];
    for (int i = 1; i < N.baris; i++) {
        det *= N.matriks[i][i];
    }
    det *= ((swapCount & 2) == 0) ? 1 : -1;
    return det;
    }

    public double DeterminanCofaktor(Matriks M) {
    /* Prekondisi: M bujur sangkar */
    /* Menghitung nilai determinan M */
    double det;

    if ((M.baris == 1) && (M.kolom == 1)) // Basis 1x1
        det = M.matriks[0][0];
    else { // Rekurens nxn
        det = 0;
        for (int i = barisAwal(M); i <= barisAkhir(M); i++)
            det += M.matriks[i][kolomAwal(M)] * kofaktor(M, i, kolomAwal(M));
    }

    return det;
    }

    private double kofaktor(Matriks M, int i, int j) {
    return DeterminanCofaktor(Manipulasi(M, i, j)) * (((i + j) % 2 == 0) ? 1 : -1);
    }   

    private Matriks Manipulasi(Matriks M, int b, int k) {
        // Minor M(i,j) dari matriks M
        Matriks Manipulasi = new Matriks(M.baris - 1, M.kolom - 1);
        int bmb, kmb, bm, km;
       // bmi = barisAwal(Manipulasi);
        bmb = barisAwal(Manipulasi);
        for (bm = barisAwal(M); bm <= barisAkhir(M); bm++)
            if (bm != b) {
                kmb = kolomAwal(Manipulasi);
                for (km = kolomAwal(M); km <= kolomAkhir(M); km++)
                    if (km != k) {
                      //  Manipulasi.matriks[bmb][kmb] = M.matriks[bm][km];
                        Manipulasi.matriks[bmb][kmb] = M.matriks[bm][km];
                        kmb++;
                    }
                bmb++;
            }
        return Manipulasi;
    }

    public void Transpose() {

        Matriks M1 = new Matriks(this.kolom, this.baris);

        for (int i = barisAwal(M1); i <= barisAkhir(M1); i++) {
            for (int j = kolomAwal(M1); j <= kolomAkhir(M1); j++) {
                M1.matriks[i][j] = this.matriks[j][i];
            }
        }

        this.baris = M1.baris;
        this.kolom = M1.kolom;
        //this.matriks = M1.matriks;
        this.matriks = M1.matriks;
    }

    public void MatKofaktor() {
        Matriks M = new Matriks(this.kolom, this.baris);
        for (int i = barisAwal(this); i <= barisAkhir(this); i++)
            for (int j = kolomAwal(this); j <= kolomAkhir(this); j++) {
                M.matriks[i][j] = kofaktor(this, i, j);
            }
        this.matriks = M.matriks;
    }

    public void Adjoin() {
        if (this.bnykElmn(this) != 1) {
            this.MatKofaktor();
            this.Transpose();
        } else {
            this.matriks[0][0] = 1;
        }
    }

    public static boolean InversGaussJordan(Matriks in, Matriks out) {
        // in terdefinisi dan IsBujurSangkar(in), Program menghasilkan invers dari in
        // dengan Eliminasi Gauss-Jordan
        // Jika gagal maka out = in
        Matriks M = deter(in);

        M = bentukHorizontal(M, Identitas(M.baris));
        M = EliminasiGaussJordan(M);

        Matriks N = new Matriks(in.baris, in.kolom);
        for (int i = 0; i < N.baris; i++) {
            for (int j = 0; j < N.kolom; j++) {
                N.matriks[i][j] = M.matriks[i][j];
            }
        }

        if (Identitas(N)) {
            deter(in, out);

            for (int i = 0; i < out.baris; i++) {
                for (int j = 0; j < out.kolom; j++) {
                    out.matriks[i][j] = M.matriks[i][j + out.kolom];
                }
            }
            return true;
        } else {
            deter(in, out);
            return false;
        }
    }

    public boolean MatriksBalikanAdjoin(Matriks in, Matriks out) {
        deter(in, out);
        double det = DeterminanCofaktor(out);
        if (det != 0) {
            out.Adjoin();
            out.Kali(1 / det);
            return true;
        } else {
            return false;
        }
    }

    public static Matriks EliminasiGauss(Matriks in) {
        // I.S. M terdefinisi
        // F.S. M diubah menjadi matriks eselonnya
        // Proses: Eliminasi Gauss

        // Inisialisasi
        Matriks M = new Matriks(1, 1);
        M = deter(in);

        // Proses mengurutkan baris
        int[] zeroCount = new int[M.baris];
        for (int i = 0; i < M.baris; i++) { // Kalkulasi jumlah 0
            zeroCount[i] = 0;
            int j = 0;
            while (j < M.kolom && M.matriks[i][j] == 0) {
                zeroCount[i]++;
                j++;
            }
        }
        for (int i = 0; i < M.baris; i++) { // Algoritma Pengurutan
            for (int j = 0; j < M.baris - 1; j++) {
                if (zeroCount[j] > zeroCount[j + 1]) {
                    int temp;
                    M.Swap(j, j + 1);
                    temp = zeroCount[j];
                    zeroCount[j] = zeroCount[j + 1];
                    zeroCount[j + 1] = temp;
                }
            }
        }

        // Proses mereduksi baris
        int indent = 0;

        for (int i = 0; i < M.baris; i++) {
            // Mencari sel bernilai
            while (i + indent < M.kolom && M.matriks[i][i + indent] == 0) {
                indent++;
            }

            if (i + indent < M.kolom) {
                // Ubah angka depan jadi 1
                M.perkalianBaris(i, 1 / M.matriks[i][i + indent]);

                // Pengurangan baris dibawahnya
                for (int j = i + 1; j < M.baris; j++) {
                    if (M.matriks[j][i + indent] != 0) {
                        M.perkalianBaris(j, 1 / M.matriks[j][i + indent]);
                        M.kuranginbrssblh(j, i);
                    }
                }
            }
        }
        M.kira();

        return M;
    }

    public static Matriks EliminasiGaussJordan(Matriks in) {
        // I.S. M terdefinisi
        // F.S. M diubah menjadi matriks eselon-terreduksinya
        // Proses: Eliminasi Gauss Jordan

        // Proses
        Matriks M = EliminasiGauss(in);
        int indent = 0;

        for (int i = 0; i < M.baris; i++) {
            // Pencarian sel tidak nol
            while (i + indent < M.kolom && M.matriks[i][i + indent] == 0) {
                indent++;
            }

            if (i + indent < M.kolom) {

                // Pengurangan baris diatasnya
                for (int j = i - 1; j >= 0; j--) {
                    if (M.matriks[j][i + indent] != 0) {
                        M.kuranginbrssblh(j, i, M.matriks[j][i + indent]);
                    }
                }
            }
        }

        M.kira();
        return M;
    }

    public static void deter(Matriks dari, Matriks ke) {
        // I.S. dari dan ke terdefinisi
        // F.S. ke berisi sama dengan dari
        ke.baris = dari.baris;
        ke.kolom = dari.kolom;
        ke.matriks = new double[dari.baris][dari.kolom];

        for (int i = 0; i < ke.baris; i++) {
            for (int j = 0; j < ke.kolom; j++) {
                ke.matriks[i][j] = dari.matriks[i][j];
            }
        }
    }

    // Varian fungsi dari Copy Matriks diatas
    public static Matriks deter(Matriks dari) {
        Matriks ke = new Matriks(1, 1);
        deter(dari, ke);
        return ke;
    }

    private static double kira(double x) {
        return (Math.round(x * decPoint) / decPoint);
    }

    private void kira() {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                matriks[i][j] = kira(matriks[i][j]);
            }
        }
    }

     // Menyambungkan matriks M dan N
     public static Matriks bentukHorizontal(Matriks M, Matriks N) {
        // M dan N terdefinisi dan jumlah baris sama, fungsi mengoutput hasil gabungan M
        // dan N
        Matriks out = new Matriks(M.baris, M.kolom + N.kolom);

        for (int i = 0; i < out.baris; i++) {
            for (int j = 0; j < out.kolom; j++) {
                if (j < M.kolom) {
                    out.matriks[i][j] = M.matriks[i][j];
                } else {
                    out.matriks[i][j] = N.matriks[i][j - M.kolom];
                }
            }
        }

        return out;
    }

    public static void ketikFile(String file, Matriks M) {
        try {
            File input = new File(file);
            if (!(input.exists())) {
                input.createNewFile();
            }

            FileWriter inputFile = new FileWriter(file);
            PrintWriter print = new PrintWriter(inputFile);

            for (int i = 0; i < M.baris; i++) {
                for (int j = 0; j < M.kolom; j++) {
                    M.matriks[i][j] += 0;
                    print.printf("%.2f ", M.matriks[i][j]);
                }
                print.printf("\n");
            }

            print.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h() {
        this.matriks[bmin][kolomAkhir(this)] = 1;
    }
}

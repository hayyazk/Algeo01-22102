package algeo1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//import algeo1.*;

public class Inputan {

	public Scanner userInput = new Scanner(System.in);
	public static final Matriks Met = new Matriks();
	/**
	 *
	 */
	public final Menu menu = new Menu();
    public Menu getMenu() 
	{
		menu.daftarMenu();
		return menu;
	}

	public void bacaFile(Matriks M){
		// Reihan Andhika P checked
		// I.S. M masih kosong
		// F.S. M berisi matriks yang ada di file , tiap orang pathnya bisa beda beda
		int i,j,NB,NK;
		String baris1, barismatriks;
		try {
			System.out.print("Tulis nama file beserta extension : ");
			String reipath = "../test/";
			File file = new File(reipath + userInput.next());
			System.out.println(file.getAbsolutePath());
			Scanner CountNB = new Scanner(file);
			NB = 0; 
			while (CountNB.hasNextLine()) {
				CountNB.nextLine();
				NB = NB + 1;
			}
			CountNB.close();

			NK = 0;
			Scanner CountNK = new Scanner(file);
			if (CountNK.hasNextLine()) {
				baris1 = CountNK.nextLine();
				Scanner hitungNK = new Scanner(baris1);
				while(hitungNK.hasNextDouble()){
					hitungNK.nextDouble();
					NK = NK +1;
				}
				hitungNK.close();
			}
			CountNK.close();
			Met.buatMatriks(NB,NK,M);
			Scanner baca = new Scanner(file);
			i = 0;

			while (baca.hasNextLine()) {
				barismatriks = baca.nextLine();
				Scanner bacamatriks = new Scanner(barismatriks);
				j = 0;
				while(bacamatriks.hasNextDouble()){
					M.matriks[i][j] = bacamatriks.nextDouble();
					j = j + 1;
				}
				i = i + 1;
				bacamatriks.close();
			}
			baca.close();
			System.out.println("Matriks yang ada di file adalah :");
			Met.ketikMatriks(M);
			System.out.println();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File tidak ada atau nama file salah, Kadang ada bug terhadap pathnya, minta tolong lapor ke pembuat jangan di 0 in :)");
			e.printStackTrace();
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			getMenu();
		}
	}

	public  void TulisFile(Matriks M){
		// M matriks dengan elemen
		// Isi matriks disalin ke file .txt
		PrintWriter writer;
	 
		try
		{
			System.out.print("Tulis nama file beserta extension : ");
			String reipath = "../output/";
			writer = new PrintWriter(reipath + userInput.next());
			for (int i = 0; i < M.baris; i++){
				for(int j = 0; j < M.kolom; j++){
					writer.printf("%.2f", M.matriks[i][j]);
					writer.print(" ");
				}
				writer.println();
			}	
			writer.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Terjadi kesalahan");
			e.printStackTrace();
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			getMenu();			
		}
	}

	public  void TulisFileDesc(Matriks M){
		// M matriks dengan elemen
		// Isi matriks dan deskripsi disalin ke file .txt
		PrintWriter writer;
	 
		try
		{
			System.out.print("Tulis nama file beserta extension : ");
			String reipath = "../output/";
			writer = new PrintWriter(reipath + userInput.next());
			for (int i = 0; i < M.baris; i++){
				for(int j = 0; j < M.kolom; j++){
					writer.printf("%.2f", M.matriks[i][j]);
					writer.print(" ");
				}
				writer.println();
			}
			for (int i = 0; i < M.NDesc; i++){
					writer.print(M.desc[i]);
			}		
			writer.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Terjadi kesalahan, Kadang ada bug terhadap pathnya, minta tolong lapor ke pembuat jangan di 0 in :)");
			e.printStackTrace();
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			getMenu();			
		}
	}

	public  void TulisDesc(Matriks M){
		// M matriks dengan elemen
		// Isi deskripsi disalin ke file .txt
		PrintWriter writer;
	 
		try
		{
			System.out.print("Tulis nama file beserta extension : ");
			String reipath = "../output/";
			writer = new PrintWriter(reipath + userInput.next());
			for (int i = 0; i < M.NDesc; i++){
					writer.print(M.desc[i]);
			}		
			writer.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Terjadi kesalahan, Kadang ada bug terhadap pathnya, minta tolong lapor ke pembuat jangan di 0 in :)");
			e.printStackTrace();			
		}
	}
}

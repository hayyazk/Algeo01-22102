package algeo1;

import java.util.Scanner;

public class Menu {
	
	public static int menuInput() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);
		System.out.println("\n1. Input dari Keyboard");
		System.out.println("2. Input dari File");
		System.out.println("3. Kembali ke menu sebelumnya\n==============");
		System.out.print("Masukan : ");

		subMenu = userInput.nextInt();
		
		while (subMenu < 1 || subMenu > 3) {
			System.out.println("Masukan salah, silahkan ulangi input.");
			System.out.println("\n1. Input dari Keyboard");
			System.out.println("2. Input dari File");
			System.out.println("3. Kembali ke menu sebelumnya\n==============");
			System.out.print("Masukan : ");

			subMenu = userInput.nextInt();
		}

		return subMenu;
	}
	
	public static int menuOutput() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);
		System.out.println("\n1. Output ke Terminal");
		System.out.println("2. Output ke File\n==============");
		System.out.print("Masukan : ");

		subMenu = userInput.nextInt();
		
		while (subMenu < 1 || subMenu > 2) {
			System.out.println("Masukan salah, silahkan ulangi input.");
			System.out.println("\n1. Output ke Terminal");
			System.out.println("2. Output ke File\n==============");
			System.out.print("Masukan : ");

			subMenu = userInput.nextInt();
		}

		return subMenu;
	}
	
	public static String inputFile() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("\nMasukkan path file : ");

		String file = userInput.nextLine();
		
		return file;
	}
	
	public static void startAgain() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("\n===================");
		System.out.println("Kembali ke menu utama? (1 = iya, 2 = tidak)");
		System.out.print("Input = ");
		int a = userInput.nextInt();
		while (true) {
			if (a == 1) {
				daftarMenu();
				break;
			} else if (a == 2) {
				System.exit(0);
				break;
			} else {
				System.out.println("Input tidak dikenal, silahkan ulangi masukan.");
				System.out.println("Kembali ke menu utama? (iya = y, tidak = n)");
				System.out.print("Input = ");
				a = userInput.nextInt();
			}
		}
	}

	public static void menuSPL() {
		int subMenu, a;
		String file;
		double[][] matrix;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode eliminasi Gauss\n"
				+ "2. Metode eliminasi Gauss-Jordan\n"
				+ "3. Metode matriks balikan\n"
				+ "4. Kaidah Cramer\n"
				+ "5. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		
		while (subMenu < 1 || subMenu > 6) {
			System.out.println("Masukan tidak valid, silahkan ulangi.");
			System.out.println("MENU\n"
					+ "1. Metode eliminasi Gauss\n"
					+ "2. Metode eliminasi Gauss-Jordan\n"
					+ "3. Metode matriks balikan\n"
					+ "4. Kaidah Cramer\n"
					+ "5. Kembali ke menu utama");
			System.out.print("Pilihan metode : ");
			subMenu = userInput.nextInt();
			System.out.println();
		}
		
		switch(subMenu) {
		case 1:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan jumlah baris: ");
				int m = userInput.nextInt();
				System.out.println("Masukkan jumlah kolom: ");
				int n = userInput.nextInt();
				matrix = InputOutput.readKeyboard(m, n);
				SPL.SPLGauss(matrix);
				
			} else if (a == 2) {
				file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				SPL.SPLGauss(matrix);
			} else if (a == 3) {
				menuSPL();
			}
			break;
		case 2:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan jumlah baris: ");
				int m = userInput.nextInt();
				System.out.println("Masukkan jumlah kolom: ");
				int n = userInput.nextInt();
				matrix = InputOutput.readKeyboard(m, n);
				SPL.SPLGaussJordan(matrix);
				
			} else if (a == 2) {
				file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				SPL.SPLGaussJordan(matrix);
			} else if (a == 3) {
				menuSPL();
			}
			break;
		case 3:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan jumlah baris: ");
				int m = userInput.nextInt();
				System.out.println("Masukkan jumlah kolom: ");
				int n = userInput.nextInt();
				if (m != n-1) {
					System.out.println("Solusi tidak dapat ditemukan dengan metode ini, silahkan gunakan metode yang lain.");
					menuSPL();
					break;
				}
				matrix = InputOutput.readKeyboard(m, n);
				SPL.SPLInverse(matrix);
				
			} else if (a == 2) {
				file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				if (matrix.length != matrix[0].length-1) {
					System.out.println("Solusi tidak dapat ditemukan dengan metode ini, silahkan gunakan metode yang lain.");
					menuSPL();
					break;
				}
				SPL.SPLInverse(matrix);
			} else if (a == 3) {
				menuSPL();
			}
			break;
		case 4:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan jumlah baris: ");
				int m = userInput.nextInt();
				System.out.println("Masukkan jumlah kolom: ");
				int n = userInput.nextInt();
				if (m != n-1) {
					System.out.println("Solusi tidak dapat ditemukan dengan metode ini, silahkan gunakan metode yang lain.");
					menuSPL();
					break;
				}
				matrix = InputOutput.readKeyboard(m, n);
				SPL.SPLCramer(matrix);
			} else if (a == 2) {
				file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				if (matrix.length != matrix[0].length-1) {
					System.out.println("Solusi tidak dapat ditemukan dengan metode ini, silahkan gunakan metode yang lain.");
					menuSPL();
					break;
				}
				SPL.SPLCramer(matrix);
			} else if (a == 3) {
				menuSPL();
			}
			break;
		case 5:
			daftarMenu();
			break;
		}
		return;
	}

	public static void menuDeterminan() {
		int subMenu;
		double[][] matrix;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode reduksi baris\n"
				+ "2. Metode ekspansi kofaktor\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		while (subMenu < 1 || subMenu > 3) {
			System.out.println("Masukan tidak valid, silahkan ulangi.");
			System.out.println("MENU\n"
					+ "1. Metode reduksi baris\n"
					+ "2. Metode ekspansi kofaktor\n"
					+ "3. Kembali ke menu utama");
			System.out.print("Pilihan metode : ");
			subMenu = userInput.nextInt();
			System.out.println();
		}
		int a = 0;
		switch (subMenu) {
		case 1:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan ukuran matriks: ");
				int n = userInput.nextInt();
				matrix = InputOutput.readKeyboard(n, n);
				Determinan.solDetOBE(matrix);
			} else if (a == 2) {
				String file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				Determinan.solDetOBE(matrix);
			} else if (a == 3) {
				menuDeterminan();
			}
			break;
		case 2:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan ukuran matriks: ");
				int n = userInput.nextInt();
				matrix = InputOutput.readKeyboard(n, n);
				Determinan.solDetCofactor(matrix);
			} else if (a == 2) {
				String file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				Determinan.solDetCofactor(matrix);
			} else if (a == 3) {
				menuDeterminan();
			}
			break;
		case 3:
			daftarMenu();
			break;
		}
	}

	public static void menuInverse() {
		int subMenu;
		double[][] matrix;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode eliminiasi Gauss-Jordan\n"
				+ "2. Metode adjoint\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		while (subMenu < 1 || subMenu > 3) {
			System.out.println("Masukan tidak valid, silahkan ulangi.");
			System.out.println("MENU\n"
					+ "1. Metode eliminiasi Gauss-Jordan\n"
					+ "2. Metode adjoint\n"
					+ "3. Kembali ke menu utama");
			System.out.print("Pilihan metode : ");
			subMenu = userInput.nextInt();
			System.out.println();
		}
		int a = 0;
		switch (subMenu) {
		case 1:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan ukuran matriks: ");
				int n = userInput.nextInt();
				matrix = InputOutput.readKeyboard(n, n);
				Inverse.solInvGJ(matrix);
			} else if (a == 2) {
				String file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				Inverse.solInvGJ(matrix);
			} else if (a == 3) {
				menuInverse();
			}
			break;
		case 2:
			a = menuInput();
			if (a == 1) {
				System.out.println("Masukkan ukuran matriks: ");
				int n = userInput.nextInt();
				matrix = InputOutput.readKeyboard(n, n);
				Inverse.solInvAdjoint(matrix);
			} else if (a == 2) {
				String file = inputFile();
				matrix = InputOutput.bacaFileSPL(file);
				Inverse.solInvAdjoint(matrix);
			} else if (a == 3) {
				menuInverse();
			}
		case 3:
			daftarMenu();
			break;
		}
	}
	
	public static void menuInterPolinom() {
		int a;
		double x;
		double[][] titik;
		Scanner userInput = new Scanner(System.in);
		a = menuInput();
		if (a == 1) {
			System.out.println("Masukkan banyak titik: ");
			int n = userInput.nextInt();
			System.out.println("Masukkan titik-titik yang akan diinterpolasi: ");
			titik = InputOutput.readKeyboard(n, 2);
			System.out.println("Masukkan x yang akan ditaksir fungsinya: ");
			x = userInput.nextDouble();
			InterPolinom.solInterPolinom(titik, x);
		} else if (a == 2) {
			String file = inputFile();
			titik = InputOutput.bacaTitik(file);
			x = titik[titik.length-1][0];
			titik = Matriks.deleteLast(titik);
			InterPolinom.solInterPolinom(titik, x);
		} else if (a == 3) {
			daftarMenu();
			return;
		}
	}

/*	public static void menuInterBS() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "0. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		if (subMenu == 0) {
			daftarMenu();
		}
	}

	public static void menuRegresi() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "0. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		if (subMenu == 0) {
			daftarMenu();
		}
	} */
	
	public static void daftarMenu() {
		int menu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU");
		System.out.println("1. Sistem Persamaaan Linier\n"
				+ "2. Determinan\n"
				+ "3. Matriks balikan\n"
				+ "4. Interpolasi Polinom\n"
				+ "5. Interpolasi Bicubic Spline\n"
				+ "6. Regresi linier berganda\n"
				+ "7. Keluar");

		System.out.print("Pilihan menu : ");
		menu = userInput.nextInt();
		System.out.println();

		while (menu < 1 || menu > 7) {
			System.out.println("Input tidak valid.");
			System.out.print("Pilihan menu: ");
			menu = userInput.nextInt();
		}

		switch (menu) {
			case 1:
				menuSPL();
				break;
			case 2:
				menuDeterminan();
				break;
			case 3:
				menuInverse();
				break;
			case 4:
				menuInterPolinom();
				break;
			case 5:
				 
				break;
			case 6:
				 
				break;
			case 7:
				System.exit(0);
				break;
		}

	}
}

package algeo1;

import java.util.Scanner;

public class Menu {

	public static void menuSPL() {
		int submenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode eliminasi Gauss\n"
				+ "2. Metode eliminasi Gauss-Jordan\n"
				+ "3. Metode matriks balikan\n"
				+ "4. Kaidah Cramer\n"
				+ "5. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		submenu = userInput.nextInt();
		System.out.println();
		if (submenu == 5) {
			daftarMenu();
		}
	}

	public static int menuInput() {
		int submenu;

		Scanner userInput = new Scanner(System.in);
		System.out.println("\n1. Input dari Keyboard");
		System.out.println("2. Input dari File\n==============");
		System.out.print("Masukan : ");

		submenu = userInput.nextInt();

		return submenu;

	}

	public static String inputFile() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("\nMasukkan nama file (.txt) (Cth : a1.txt) : ");

		String submenu = userInput.nextLine();

		return submenu;
	}

	public static void menuDeterminan() {
		int submenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode reduksi baris\n"
				+ "2. Metode ekspansi kofaktor\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		submenu = userInput.nextInt();
		System.out.println();
		if (submenu == 3) {
			daftarMenu();
		}
	}

	public static void menuInverse() {
		int submenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode eliminiasi Gauss-Jordan\n"
				+ "2. Metode adjoint\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		submenu = userInput.nextInt();
		System.out.println();
		if (submenu == 3) {
			daftarMenu();
		}
	}

	public static void menuInterPolinom() {
		int submenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "0. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		submenu = userInput.nextInt();
		System.out.println();
		if (submenu == 0) {
			daftarMenu();
		}
	}

	public static void menuInterBS() {
		int submenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "0. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		submenu = userInput.nextInt();
		System.out.println();
		if (submenu == 0) {
			daftarMenu();
		}
	}

	public static void menuRegresi() {
		int submenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "0. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		submenu = userInput.nextInt();
		System.out.println();
		if (submenu == 0) {
			daftarMenu();
		}
	}
	
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
				int a = menuInput();
				if (a == 1) {
					// Scanner userInput = new Scanner(System.in);
					// userInput = nextInt();
					System.out.println("untuk Mengisi SPL Matriks");
				} else if (a == 2) {
					inputFile();

				}

				break;
			case 2:
				menuDeterminan();
				int b = menuInput();
				if (b == 1) {
					// Scanner userInput = new Scanner(System.in);
					// userInput = nextInt();
					System.out.println("untuk Mengisi Determinan");
				} else if (b == 2) {
					inputFile();

				}
				break;
			case 3:
				menuInverse();
				int c = menuInput();
				if (c == 1) {
					// Scanner userInput = new Scanner(System.in);
					// userInput = nextInt();
					System.out.println("untuk Mengisi Invers");
				} else if (c == 2) {
					inputFile();

				}
				break;
			case 4:
				 menuInterPolinom();
				int d = menuInput();
				if (d == 1) {
					// Scanner userInput = new Scanner(System.in);
					// userInput = nextInt();
					System.out.println("untuk Mengisi Interpolarisai Polinom");
				} else if (d == 2) {
					inputFile();

				}
				break;
			case 5:
				 menuInterBS();
				int e = menuInput();
				if (e == 1) {
					// Scanner userInput = new Scanner(System.in);
					// userInput = nextInt();
					System.out.println("untuk Mengisi Interpolasi Bicubic Spline");
				} else if (e == 2) {
					inputFile();

				}
				break;
			case 6:
				 menuRegresi();
				int f = menuInput();
				if (f == 1) {
					// Scanner userInput = new Scanner(System.in);
					// userInput = nextInt();
					System.out.println("untuk Mengisi Regresi linier berganda");
				} else if (f == 2) {
					inputFile();

				}
				break;
			case 7:
				System.exit(0);
				break;
		}

	}
}

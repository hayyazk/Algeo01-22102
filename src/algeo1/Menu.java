package Algeo1;

import java.util.Scanner;
//import Algeo1.SPL;

public class Menu {

	/*
	public static int menuSPL() {
		int subMenu;

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
		if (subMenu == 5) {
			daftarMenu();
		}
		return subMenu;
	}

	public static int menuInput() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);
		System.out.println("\n1. Input dari Keyboard");
		System.out.println("2. Input dari File\n==============");
		System.out.print("Masukan : ");

		subMenu = userInput.nextInt();

		return subMenu;

	}

	public static String inputFile() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("\nMasukkan nama file (.txt) (Cth : a1.txt) : ");

		String subMenu = userInput.nextLine();

		return subMenu;
	}

	public static int menuDeterminan() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode reduksi baris\n"
				+ "2. Metode ekspansi kofaktor\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		if (subMenu == 3) {
			daftarMenu();
		}

		return subMenu;
	}

	public static void menuInverse() {
		int subMenu;

		Scanner userInput = new Scanner(System.in);

		System.out.println("MENU\n"
				+ "1. Metode eliminiasi Gauss-Jordan\n"
				+ "2. Metode adjoint\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode : ");
		subMenu = userInput.nextInt();
		System.out.println();
		if (subMenu == 3) {
			daftarMenu();
		}
	}

	public static void menuInterPolinom() {
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

	public static void menuInterBS() {
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
	}

	public static void outputFile(Matriks M) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Apakah Anda ingin menyimpannya dalam file (y/n)? ");
        char text = userInput.next().charAt(0);
        if (text == 'y' || text == 'Y') {
            System.out.print("Masukan nama file (.txt): ");
            String file = userInput.next();
            Matriks.ketikFile(file, M);
        }
    }
	 */
	public static void daftarMenu() {
		Algeo1.SPL spl = new Algeo1.SPL();
		Algeo1.Matriks M = new Algeo1.Matriks();
		int menu;
		boolean gas = true;

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
		
		while(gas){
		switch (menu) {
			case 1:
				//SPL spl = new SPL();
				spl.menuSPL();
				/*int a = menuSPL();
				if (a == 1) {
                    int inputspl = menuInput();
                    if (inputspl == 1) {
                        SPL.SPLGauss("x");
                    } else if (inputspl == 2) {
                        String filename = inputFile();
                        try {
                           Matriks inputFileSPL = new Matriks(filename);
                            SPL.SPLGauss(inputFileSPL, "x");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (a == 2) {
                    int inputspl = menuInput();
                    if (inputspl == 1) {
                        SPL.SPLGaussJordan("x");
                    } else if (inputspl == 2) {
                        String filename = inputFile();
                        try {
                            Matriks inputFileSPL = new Matriks(filename);
                            SPL.SPLGaussJordan(inputFileSPL, "x");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                } else if (a == 3) {
                    int inputspl = menuInput();
                    if (inputspl == 1) {
                        SPL.SPLInvers("x");
                    } else if (inputspl == 2) {
                        String filename = inputFile();
                        try {
                            Matriks inputFileSPL = new Matriks(filename);
                            SPL.SPLInvers(inputFileSPL, "x");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (a == 4) {
                    SPL.SPLCramer("x");
                } else {
                    System.out.println("Perintah tidak tersedia");
                }*/
				break;
			case 2:

				M.MenuDeterminan();
				
				break;
			case 3:
				/*menuInverse();
				int c = menuInverse();
					if (c == 1) {
					int Invers.InversAdjoin();
					} else if (c == 2) {
					int Invers.InversGaussJordan();
					} else {
						System.out.println("Perintah tidak tersedia");
					}
				*/
				break;
			case 4:
				/*menuInterPolinom();
				int d = menuInterPolinom();
					if (d == 1) {
					int Invers.InversAdjoin();
					} else if (d == 2) {
					int Invers.InversGaussJordan();
					} else {
						System.out.println("Perintah tidak tersedia");
					}
				*/
				break;
			case 5:
				 /*menuInterBS();
				int e = menuInterBS();;
					if (c == 1) {
					int Invers.InversAdjoin();
					} else if (c == 2) {
					int Invers.InversGaussJordan();
					} else {
						System.out.println("Perintah tidak tersedia");
					}
				*/
				break;
			case 6:
				/* menuRegresi();
				int f = menuRegresi();
					if (c == 1) {
					int Invers.InversAdjoin();
					} else if (c == 2) {
					int Invers.InversGaussJordan();
					} else {
						System.out.println("Perintah tidak tersedia");
					}
				*/
				break;
			case 7:
				System.exit(0);
				break;
			default : 
			System.out.println();
			System.out.println("Menu Tidak Valid");
			}

			System.out.println();
            System.out.print("Apakah anda ingin Memulai lagi perhitungannya(y/n) ? ");
            char mulai = userInput.next().charAt(0);
            if (mulai != 'y' && mulai != 'Y') {
                gas = false;
            }
		}

	}
}

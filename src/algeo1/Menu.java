package algeo1;

import java.util.Scanner;

public class Menu {
	
	public static void menuSPL() {
		int submenu;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("MENU\n"
				+ "1. Metode eliminasi Gauss\n"
				+ "2. Metode eliminasi Gauss-Jordan\n"
				+ "3. Metode matriks balikan\n"
				+ "4. Kaidah Cramer\n"
				+ "5. Kembali ke menu utama");
		System.out.print("Pilihan metode: ");
		submenu = s.nextInt();
		System.out.println();
		if (submenu == 5) {
			daftarMenu();
		}
	}
	
	public static void menuDeterminan() {
		int submenu;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("MENU\n"
				+ "1. Metode reduksi baris\n"
				+ "2. Metode ekspansi kofaktor\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode: ");
		submenu = s.nextInt();
		System.out.println();
		if (submenu == 3) {
			daftarMenu();
		}
	}
	
	public static void menuInverse() {
		int submenu;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("MENU\n"
				+ "1. Metode eliminiasi Gauss-Jordan\n"
				+ "2. Metode adjoint\n"
				+ "3. Kembali ke menu utama");
		System.out.print("Pilihan metode: ");
		submenu = s.nextInt();
		System.out.println();
		if (submenu == 3) {
			daftarMenu();
		}
	}
	
	public static void daftarMenu() {
		int menu;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("MENU");
		System.out.println("1. Sistem Persamaaan Linier\n"
				+ "2. Determinan\n"
				+ "3. Matriks balikan\n"
				+ "4. Interpolasi Polinom\n"
				+ "5. Interpolasi Bicubic Spline\n"
				+ "6. Regresi linier berganda\n"
				+ "7. Keluar");
		
		System.out.print("Pilihan menu: ");
		menu = s.nextInt();
		System.out.println();
		
		while (menu < 1 || menu > 7) {
			System.out.println("Input tidak valid.");
			System.out.print("Pilihan menu: ");
			menu = s.nextInt();
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
		case 7:
			System.exit(0);
			break;
		}
		
	}
}
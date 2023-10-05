package algeo1;

import java.lang.Math;

public class InterPolinom {
	public static void solInterPolinom(double[][] m, double x) {
		double[][] maug = makeAugment(m);
		double[] sol = solSPL(maug);
		
		double y = 0;
		for (int i=0; i<sol.length; i++) {
			y += Math.pow(x, i)*sol[i];
		}
		
		int o = Menu.menuOutput();
		
		if (o == 1) {
			System.out.println("Persamaan polinom:");
			System.out.print("f(x) = ");
			for (int i=0; i<sol.length; i++) {
				if (i == 0 && i != sol.length-1) {
					System.out.printf("%.4f", sol[i]);
					System.out.print(" + ");
				} else if (i == sol.length-1) {
					System.out.println(String.format("%.4f", sol[i]) + "x^" + i);
				} else {
					System.out.print(String.format("%.4f", sol[i]) + "x^" + i + " + ");
				}
			}
			System.out.println("Hasil taksiran: ");
			System.out.println("f(" + x + ") = " + String.format("%.4f", y));
		} else {
			String file = Menu.inputFile();
			InputOutput.tulisFilePol(file, sol, x, y);
		}
		Menu.startAgain();
		
	}
	
	public static double[] solSPL(double[][] m) {
		double[][] A = Matriks.getA(m);
		double[] b = Matriks.getb(m);
		double det = Determinan.detCofactor(A);
		double[] sol = new double[A.length];
		for (int j=0; j<A.length; j++) {
			double[][] An = Matriks.CopyMatriks(A);
			for (int i=0; i<A.length; i++) {
				An[i][j] = b[i];
			}
			double detn = Determinan.detCofactor(An);
			sol[j] = detn/det;
		}
		return sol;
	}
	
	public static double[][] makeAugment(double[][] m) {
		int n = m.length;
		double x;
		double[][] maug = new double[n][n+1];
		
		for (int i=0; i<n; i++) {
			x = m[i][0];
			for (int j=0; j<n+1; j++) {
				if (j < n) {
					maug[i][j] = Math.pow(x, j);
				} else {
					maug[i][j] = m[i][1];
				}
			}
		}
		return maug;
	}
}
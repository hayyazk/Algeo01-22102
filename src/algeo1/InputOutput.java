package algeo1;

import java.util.Scanner;
import java.io.*;

public class InputOutput {

	public static double[][] bacaFileSPL(String file){
		int[] size = countMSize(file);
		int m = size[0], n = size[1];
		double[][] matrix = new double[m][n];
		try {
			File filematrix = new File(file);
				
			Scanner scanElmt = new Scanner(filematrix);
				
			for(int i=0; i<m; i++) {
				String row = scanElmt.nextLine();
				String[] rowElmt = row.split(" ");
				for (int j=0; j<n; j++) {
					matrix[i][j] = Double.parseDouble(rowElmt[j]);
				}
			}
			scanElmt.close();
			
		} catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		return matrix;
	}
	
	public static double[][] bacaTitik(String file) {
		int[] size = countMSize(file);
		int m = size[0], n = 2;
		double[][] matrix = new double[m][n];
		try {
			File filematrix = new File(file);
				
			Scanner scanElmt = new Scanner(filematrix);
				
			for(int i=0; i<m; i++) {
				String row = scanElmt.nextLine();
				if (i < m-1) {
					String[] rowElmt = row.split(" ");
					for (int j=0; j<n; j++) {
						matrix[i][j] = Double.parseDouble(rowElmt[j]);
					}
				} else {
					matrix[i][0] = Double.parseDouble(row);
					matrix[i][1] = 0;
				}
			}
			scanElmt.close();
			
		} catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		return matrix;
	}
	
	public static int[] countMSize(String file) {
		int[] size = new int[2];
		int rows = 0;
		try {
			File filematrix = new File(file);
			Scanner scan = new Scanner(filematrix);
			while (scan.hasNextLine()) {
				rows++;
				String line = scan.nextLine();
				String[] splitline = line.split(" ");
				size[1] = splitline.length;
			}
			size[0] = rows;
			scan.close();
		} catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		return size;
	}

	public static void tulisFileSPL(String type, String file, double[] sol){
		try {
		      File myObj = new File(file);
		      if (myObj.createNewFile()) {
		    	  System.out.println("File created: " + myObj.getName());
		      } else {
		    	  System.out.println("File already exists. It will be overwritten.");
		      }
		      FileWriter Writer = new FileWriter(file);
		      if (type == "exists") {
		    	  for (int i = 0; i < sol.length; i++) {
			    	  Writer.write("x" + (i+1) + "=" + sol[i] + ((i != sol.length - 1) ? " " : "\n"));
			      }
		      } else {
		    	  Writer.write("SPL tidak memiliki solusi.\n");
		      }
		      Writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void tulisFileSPL(String file, String[] sol){
		try {
		      File myObj = new File(file);
		      if (myObj.createNewFile()) {
		    	  System.out.println("File created: " + myObj.getName());
		      } else {
		    	  System.out.println("File already exists. It will be overwritten.");
		      }
		      FileWriter Writer = new FileWriter(file);
		      for (int i = 0; i < sol.length; i++) {
		    	  if (sol[i] != null) {
		    		  Writer.write(sol[i] + ((i != sol.length - 1) ? " " : "\n"));
		    	  }
		      }
		      Writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void tulisFileDet(String file, double det) {
		try {
		      File myObj = new File(file);
		      if (myObj.createNewFile()) {
		    	  System.out.println("File created: " + myObj.getName());
		      } else {
		    	  System.out.println("File already exists. It will be overwritten.");
		      }
		      FileWriter Writer = new FileWriter(file);
		      Writer.write("Determinan dari matriks adalah " + det);
		      Writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void tulisFileInv(String file, double[][] inv) {
		try {
		      File myObj = new File(file);
		      if (myObj.createNewFile()) {
		    	  System.out.println("File created: " + myObj.getName());
		      } else {
		    	  System.out.println("File already exists. It will be overwritten.");
		      }
		      FileWriter Writer = new FileWriter(file);
		      for (int i=0; i<inv.length; i++) {
		    	  for (int j=0; j<inv[0].length; j++) {
		    		  Writer.write(inv[i][j] + ((j != inv[0].length - 1) ? " " : "\n"));
		    	  }
		      }
		      Writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void tulisFilePol(String file, double[] sol, double x, double y) {
		try {
		      File myObj = new File(file);
		      if (myObj.createNewFile()) {
		    	  System.out.println("File created: " + myObj.getName());
		      } else {
		    	  System.out.println("File already exists. It will be overwritten.");
		      }
		      FileWriter Writer = new FileWriter(file);
		      Writer.write("Persamaan polinom:\n");
		      Writer.write("f(x) = ");
		      for (int i=0; i<sol.length; i++) {
		    	  if (i == 0 && i != sol.length-1) {
		    		  Writer.write(String.format("%.4f", sol[i]) + " + ");
		    	  } else if (i == sol.length-1) {
		    		  Writer.write(String.format("%.4f", sol[i]) + "x^" + i + "\n");
		    	  } else {
		    		  Writer.write(String.format("%.4f", sol[i]) + "x^" + i + " + ");
		    	  }
		      }
		      Writer.write("Hasil taksiran: \n");
		      Writer.write("f(" + x + ") = " + String.format("%.4f", y) + "\n");
		      Writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void writeSolSPL(String type, double[] solution) {
		if (type == "none") {
			System.out.println("Persamaan tidak memiliki solusi.");
		} else if (type == "unique") {
			System.out.println("Solusi persamaan tersebut adalah:");
			for (int i=0; i<solution.length; i++) {
				System.out.println("x" + (i+1) + " = " + solution[i]);
			}
		} 
	}
	
	public static double[][] readKeyboard(int row, int col) {
		double[][] Matrix;
		
		Scanner s = new Scanner(System.in);
		Matrix = new double[row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				Matrix[i][j] = s.nextDouble();
			}
		}
		
		return Matrix;
	}
}



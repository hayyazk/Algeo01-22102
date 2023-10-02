package Algeo1;

//import algeo1.Matriks;


public class Determinan{

	public Matriks Met = new Matriks();
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
		//	Minor.buatMatriks((M.baris - 1), (M.kolom - 1), Minor);
            Met.buatMatriks((M.baris - 1), (M.kolom - 1), Minor);
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

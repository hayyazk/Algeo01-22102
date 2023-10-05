# Tugas Besar 1 Aljabar Linier dan Geometri
Anggota kelompok:
| No. | Nama | NIM |
| --- | --- | --- |
|1 | Hayya Zuhailii Kinasih | 13522102|
|2 | Irfan | 10023176 |

# Aljabar Linear dan Geometri - Tubes 1

## SPESIFIKASI TUGAS
Buatlah program dalam Bahasa Java untuk :
1. Menghitung solusi SPL dengan metode eliminasi Gauss, metode Eliminasi Gauss-Jordan, metode matriks balikan, dan kaidah Cramer (kaidah Cramer khusus untuk SPL dengan n peubah dan n persamaan).
2. Menyelesaikan persoalan interpolasi dan regresi linier.
3. Menghitung matriks balikan
4. Menghitung determinan matriks dengan berbagai metode (reduksi baris dan ekspansi kofaktor).

5. ## Menu
Menu dalam program :
1.  Sistem Persamaan Linear
    - Eliminasi Gauss
    - Eliminasi Gauss Jordan
    - Metode Cramer
    - Metode Invers
2.  Determinan
    - Ekspansi Kofaktor
    - Segitiga Atas (OBE)
    - Segitiga Bawah (OBE)
3.  Invers
    - Adjoint
    - Eliminasi Gauss Jordan
4.  Interpolasi Polinom
    - Sama seperti SPL
5. Interpolasi bicubi spline
6.  Regresi Linear Berganda
    - Eliminasi Gauss
    - Eliminasi Gauss Jordan
7.  Keluar

## Note : tetapi untuk interpolasi bicubic spline dan regresi linear berganda kami belum berhasil membuatnya

## Cara Run Program
1.  Run Program 
    - Masuk ke dalam folder bin dan jalankan perintah di CMD ketik "java algeo1/Main"
    - Apabila ingin mengcompile ulang, sangat disarankan untuk jangan mengcompile ulang karena sering kali error :)
    - Apabila akan di run menggunakan IDE atau aplikasi lainnya maka caranya mengikuti aplikasi tersebut

2.  Masukkan menu dan submenu penyelesaian matriks yang diinginkan dengan mengetik angka 1-9
> :exclamation: Input menu yang diijinkan adalah integer sehingga apabila anda menginput string saat pilihan menu maka program akan error dan auto exit
3.  Masukkan cara pembacaan matriks , ada 2 cara untuk membaca matriks
    - Keyboard
    - File
> :exclamation: File yang digunakan sebagai input matriks wajib berada di dalam folder src/test <br/>
> :exclamation: Dalam mengetikkan nama file, wajib sertakan extension file (.txt)
4. Tergantung situasi dan kondisi maka matriks anda bisa saja diselesaikan ataupun ditolak karena penggunaan metode yang tidak cocok, input matriks yang tidak valid, dan beberapa alasan lainnnya
> :exclamation: Dalam menulis input/output ke layar kami membulatkan ke 2 angka dibelakang koma supaya tidak terlalu banyak angka, namun terkadang ada interpretasi angka yang ambigu (0.0004 menjadi 0.00) harap dimaklumi !
5. Apabila matriks anda berhasil diselesaikan, maka output yang bersesuaian akan muncul di layar , dan anda dapat memilih untuk save matriks di file atau tidak
6. Anda bisa mengulangi proses diatas sesuai kebutuhan
7. Jika dirasa sudah cukup, pilih menu keluar untuk keluar dari program

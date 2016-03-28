import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuDataMahasiswaMethod {
	public static void main(String... args) {
		ArrayList<String> listNim = new ArrayList<String>();
		ArrayList<ArrayList<String>> listDetail = new ArrayList<ArrayList<String>>();
		
		Byte menuChoice = 0;
		Scanner inScan = new Scanner(System.in);
		StringBuilder pilihLagi = new StringBuilder(1);
		do {
			if (menuChoice == 0) {
				System.out.println("");
				System.out.println("");
				System.out.println("        MENU UTAMA");
				System.out.println("========================");
				System.out.println("1. Entry Data Mahasiswa");
				System.out.println("2. Cari Data Mahasiswa");
				System.out.println("3. Keluar Proram (EXIT)");
				System.out.println("========================");
				System.out.println("");
				System.out.println("");
				
				inScan = new Scanner(System.in);
				System.out.print("Pilih menu : ");			
				menuChoice = inScan.nextByte();
			} else if (menuChoice == 1) {
				do {
					System.out.println("----------------------------------");
					System.out.println("     Input Data Mahasiswa");
					System.out.println("----------------------------------");
					
					listNim.add(insertDataNim().toString());
					listDetail.add(insertDataDtl());
					
					inScan = new Scanner(System.in);
					System.out.print("Ulangi entry data mahasiswa (Y/N) : ");
					pilihLagi.replace(0, 1, inScan.nextLine());
				} while (pilihLagi.toString().toUpperCase().equals("Y"));
				
				menuChoice = 0;
			} else if (menuChoice == 2) {
				do {
					System.out.println("  Cari data Mahasiswa");
					System.out.println("************************");
					System.out.print("Nomor Induk Mahasiswa (NIM) : ");
					
					findData (listNim, listDetail);
					
					inScan = new Scanner(System.in);
					System.out.print("Ulangi pencarian (Y/N) : ");
					pilihLagi.replace(0, 1, inScan.nextLine());
					System.out.println("pilihLagi : "+ pilihLagi);
				} while (pilihLagi.toString().toUpperCase().equals("Y"));
				
				menuChoice = 0;
			}
		} while (menuChoice != 3);
	}
	
	private static StringBuilder insertDataNim () {
		Pattern ptrNim = Pattern.compile("A\\d{2}\\.\\d{4}\\.\\d{4}");
		StringBuilder nim = new StringBuilder(14);
		Scanner inScan = new Scanner(System.in);
		System.out.print("Nomor Induk Mahasiswa (NIM)       : "); nim.append(inScan.next(ptrNim));
		return nim;
	}
	
	private static ArrayList<String> insertDataDtl () {
		Pattern ptrNoTlp = Pattern.compile("\\d+");
		Pattern ptrSex = Pattern.compile("P|W");
		
		StringBuilder nama = new StringBuilder();
		StringBuilder almtJln = new StringBuilder();
		StringBuilder almtKota = new StringBuilder();
		StringBuilder almtPropinsi = new StringBuilder();
		StringBuilder asalJln = new StringBuilder();
		StringBuilder asalKota = new StringBuilder();
		StringBuilder asalPropinsi = new StringBuilder();
		StringBuilder noTlp = new StringBuilder();
		StringBuilder sex = new StringBuilder(1);
		
		Scanner inScan = new Scanner(System.in);
		
		System.out.print("Nama Lengkap                      : "); nama.replace(0, nama.length(), inScan.nextLine());
		System.out.println("Alamat Tinggal");
		System.out.print("    Jalan                         : "); almtJln.replace(0, almtJln.length(), inScan.nextLine());
		System.out.print("    Kota                          : "); almtKota.replace(0, almtKota.length(), inScan.nextLine());
		System.out.print("    Propinsi                      : "); almtPropinsi.replace(0, almtPropinsi.length(), inScan.nextLine());
		System.out.println("Alamat Asal");
		System.out.print("    Jalan                         : "); asalJln.replace(0, asalJln.length(), inScan.nextLine());
		System.out.print("    Kota                          : "); asalKota.replace(0, asalKota.length(), inScan.nextLine());
		System.out.print("    Propinsi                      : "); asalPropinsi.replace(0, asalPropinsi.length(), inScan.nextLine());
		System.out.print("No Tlp. / HP                      : "); noTlp.replace(0, noTlp.length(), inScan.next(ptrNoTlp));
		System.out.print("Jenis Kelamin P(Pria) / W(Wanita) : "); sex.replace(0, sex.length(), inScan.next(ptrSex));
		System.out.println("----------------------------------");
		
		ArrayList<String> listData = new ArrayList<String>();
		listData.add(nama.toString());
		listData.add(almtJln.toString());
		listData.add(almtKota.toString());
		listData.add(almtPropinsi.toString());
		listData.add(asalJln.toString());
		listData.add(asalKota.toString());
		listData.add(asalPropinsi.toString());
		listData.add(noTlp.toString());
		listData.add(sex.toString());
		
		return listData;
	}
	
	private static void findData (ArrayList<String> listNim, ArrayList<ArrayList<String>> listDetail) {
		Scanner inScan = new Scanner(System.in);
		StringBuilder jurusan = new StringBuilder(23);
		StringBuilder jnsKelamin = new StringBuilder(6);
		StringBuilder pilihLagi = new StringBuilder(1);
		ArrayList<String> listData = new ArrayList<String>();
		int pos;
		
		inScan = new Scanner(System.in);
		pos = listNim.indexOf(inScan.nextLine());
		
		if (pos > -1) {
			switch (listNim.get(0).substring(0, 3)) {
				case "A11": jurusan.replace(0, jurusan.length(), "Teknik Informatika (S1)");
							break;
				case "A12": jurusan.replace(0, jurusan.length(), "Sistem Informasi (S1)");
							break;
				case "A13": jurusan.replace(0, jurusan.length(), "Teknik Informatika (D3)");
							break;
				case "A14": jurusan.replace(0, jurusan.length(), "Sistem Informasi (D3)");
							break;
				default   : jurusan.replace(0, jurusan.length(), "????");
			}
			
			listData = listDetail.get(pos);
			if (listData.get(8).equals("P")) {
				jnsKelamin.replace(0, jnsKelamin.length(), "Pria");
			} else {
				jnsKelamin.replace(0, jnsKelamin.length(), "Wanita");
			}
			
			System.out.println("Jurusan        : "+ jurusan);
			System.out.println("Angkatan       : "+ listNim.get(0).substring(4, 8));
			System.out.println("Nama Lengkap   : "+ listData.get(0));
			System.out.println("Alamat tinggal : "+ listData.get(1));
			System.out.println("                 "+ listData.get(2) +", "+ listData.get(3));
			System.out.println("Alamat asal    : "+ listData.get(4));
			System.out.println("                 "+ listData.get(5) +", "+ listData.get(6));
			System.out.println("No. Telp.      : "+ listData.get(7));
			System.out.println("Jenis Kelamin  : " + jnsKelamin);
			System.out.println("************************");
			System.out.print("");
		} else {
			System.out.println("Data yang Anda cari, belum terdaftar!");
		}
	}
}
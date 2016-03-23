import java.util.Scanner;
import java.util.regex.Pattern;

class DataMahasiswa {
	public static void main(String... args) {
		Scanner inNoInduk = new Scanner(System.in);
		Pattern ptrNoInduk = Pattern.compile("A\\d{2}\\.\\d{4}\\.\\d{4}");
		System.out.print("Masukkan no induk anda :");
		String noInduk = inNoInduk.next(ptrNoInduk);
		
		Scanner inNama = new Scanner(System.in);
		System.out.print("Masukkan nama lengkap :");
		String nama = inNama.nextLine();
		
		System.out.println("Masukkan alamat tinggal");
		Scanner inAlmtJln = new Scanner(System.in);
		System.out.print("Jalan :");
		String almtJln = inAlmtJln.nextLine();
		Scanner inAlmtKota = new Scanner(System.in);
		System.out.print("Kota :");
		String almtKota = inAlmtKota.nextLine();
		Scanner inAlmtPropinsi = new Scanner(System.in);
		System.out.print("Propinsi :");
		String almtPropinsi = inAlmtPropinsi.nextLine();
		
		System.out.println("Masukkan alamat asal");
		Scanner inAsalJln = new Scanner(System.in);
		System.out.print("Jalan :");
		String asalJln = inAsalJln.nextLine();
		Scanner inAsalKota = new Scanner(System.in);
		System.out.print("Kota :");
		String asalKota = inAsalKota.nextLine();
		Scanner inAsalPropinsi = new Scanner(System.in);
		System.out.print("Propinsi :");
		String asalPropinsi = inAsalPropinsi.nextLine();
		
		Scanner inNoTlp = new Scanner(System.in);
		Pattern ptrNoTlp = Pattern.compile("\\d+");
		System.out.print("Masukkan no. telepon / HP :");
		String noTlp = inNoTlp.next(ptrNoTlp);
		
		Scanner inSex = new Scanner(System.in);
		Pattern ptrSex = Pattern.compile("P|W");
		System.out.print("Masukkan Jenis Kelamin P(Pria) / W(Wanita) :");
		String sex = inSex.next(ptrSex);
		
		System.out.println(noInduk.substring(0, 3));
		
		String kodeJurusan="", jurusan = "";
		kodeJurusan = noInduk.substring(0, 3);
		System.out.println("Kode Jurusan        : "+ kodeJurusan);
		
		if (noInduk.substring(0, 3).equals("A11"))
			jurusan = "Teknik Informatika (S1)";
		else if (noInduk.substring(0, 3).equals("A12"))
			jurusan = "Sistem Informasi (S1)";
		else if (noInduk.substring(0, 3).equals("A13"))
			jurusan = "Teknik Informatika (D3)";
		else if (noInduk.substring(0, 3).equals("A14"))
			jurusan = "Sistem Informasi (D3)";
		else
			jurusan = "????";
		
		String angkatan = noInduk.substring(4, 8);
		
		String jnsKelamin;		
		if (sex == "P")
			jnsKelamin = "Pria";
		else
			jnsKelamin = "Wanita";
		
		System.out.println("");
		System.out.println("");
		System.out.println("==========================================");
		System.out.println("           Data Mahasiswa");
		System.out.println("==========================================");
		System.out.println("NIM            : "+ noInduk);
		System.out.println("Jurusan        : "+ jurusan);
		System.out.println("Angkatan       : "+ angkatan);
		System.out.println("Nama Lengkap   : "+ nama);
		System.out.println("Alamat Tinggal : "+ almtJln);
		System.out.println("                 "+ almtKota +", "+ almtPropinsi);
		System.out.println("Alamat Asal    : "+ asalJln);
		System.out.println("                 "+ asalKota +", "+ asalPropinsi);
		System.out.println("No. Telepon    : "+ noTlp);
		System.out.println("Jenis Kelamin  : "+ jnsKelamin);
		System.out.println("==========================================");
	}
}
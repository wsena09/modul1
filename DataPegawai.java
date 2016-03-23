import java.util.Scanner;
import java.util.regex.Pattern;

class DataPegawai {
	public static void main(String... args) {
		Scanner inNoInduk = new Scanner(System.in);
		Pattern ptrNoInduk = Pattern.compile("\\p{javaUpperCase}+\\.\\d{3}\\.\\d{4}\\.\\d{4}");
		System.out.print("Masukkan no induk anda :");
		String noInduk = inNoInduk.next(ptrNoInduk);
		
		Scanner inNama = new Scanner(System.in);
		System.out.print("Masukkan nama lengkap :");
		String nama = inNama.nextLine();
		
		Scanner inUsia = new Scanner(System.in);
		System.out.print("Usia :");
		Byte usia = inNama.nextByte();
		
		Scanner inSex = new Scanner(System.in);
		Pattern ptrSex = Pattern.compile("P|W");
		System.out.print("Masukkan Jenis Kelamin P(Pria) / W(Wanita) :");
		String sex = inSex.next(ptrSex);
		
		Scanner inIpk = new Scanner(System.in);
		Pattern ptrIpk = Pattern.compile("\\d{2}\\.\\d{2}");
		System.out.print("Masukkan Nilai IPK :");
		String ipk = inIpk.next(ptrIpk);
		
		System.out.println("");
		System.out.println("");
		System.out.println("     Data Pegawai");
		System.out.println("======================");
		System.out.println("No. Induk     : "+ noInduk);
		System.out.println("Nama          : "+ nama);
		System.out.println("Usia          : "+ usia);
		System.out.println("Jenis Kelamin : "+ sex);
		System.out.println("Nilai IPK     : "+ ipk);
		System.out.println("======================");
	}
}
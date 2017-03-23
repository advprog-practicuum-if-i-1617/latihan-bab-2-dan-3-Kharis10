package latihan;
import java.util.Scanner;

public class AngkaHuruf {

    private String[] huruf = {"", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"};

    public String ubah(int h) {
        if (h >= 0 && h <= 11) {
            return huruf[h];
        } else if (h >= 12 && h <= 19) {
            return huruf[h % 10] + " belas";
        } else if (h >= 20 && h <= 99) {
            return ubah(h / 10) + " puluh " + ubah(h % 10);
        } else if (h >= 100 && h <= 199) {
            return "seratus " + ubah(h % 100);
        } else if (h >= 200 && h <= 999) {
            return ubah(h / 100) + " ratus " + ubah(h % 100);
        } else if (h == 1000) {
            return "seribu";
        } else {
            return "ERROR";
        }
    }

    public String ubah(String a) {
        for (int i = 0; i <= 1000; i++) {
            String hasil = a.trim();
            String ahasil = ubah(i).trim();
            if (hasil.equalsIgnoreCase(ahasil)) {
                return Integer.toString(i);
            } else if (hasil.equalsIgnoreCase("nol")) {
                return Integer.toString(0);
            }
        }
        return "ERROR";
    }
}

class AngkaHurufMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AngkaHuruf obj = new AngkaHuruf();
        System.out.println("1. Konversi angka ke huruf terbilang");
        System.out.println("2. Konversi huruf terbilang ke angka");
        System.out.print("Masukkan pilihan : ");
        int pilihan = in.nextInt();
        in.nextLine();
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Angka : ");
                int a = in.nextInt();
                in.nextLine();
                System.out.print("Terhitung : ");
                if (a == 0) {
                    System.out.println("nol");
                } else {
                    System.out.println(obj.ubah(a));
                }
                break;
            case 2:
                System.out.print("Masukkan huruf terbilang : ");
                String ht = in.nextLine();
                System.out.print("Angka : ");
                System.out.println(obj.ubah(ht));
                break;
            default:
                System.out.println("Pilihan salah");
        }
    }
}

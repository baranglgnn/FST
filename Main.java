package _21010310028_Baran_Gulegen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dosyaAdi = "FST.txt";

        FST fst = FileReader.okuFST(dosyaAdi);
        if (fst == null) {
            System.out.println("FST dosyas� okunamad�.");
            return;
        }

        System.out.println("L�tfen birinci giri�i giriniz:");
        String giris1 = scanner.nextLine();
        String cikis1 = fst.girisIsle(giris1);
        System.out.println("Durumlar�n s�ras�: " + fst.getDurumDizisi());
        System.out.println("��kt�: " + cikis1);

        System.out.println("L�tfen ikinci giri�i giriniz:");
        String giris2 = scanner.nextLine();
        String cikis2 = fst.girisIsle(giris2);
        System.out.println("Durumlar�n s�ras�: " + fst.getDurumDizisi());
        System.out.println("��kt�: " + cikis2);

        scanner.close();
    }
}
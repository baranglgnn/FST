package _21010310028_Baran_Gulegen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dosyaAdi = "FST.txt";

        FST fst = FileReader.okuFST(dosyaAdi);
        if (fst == null) {
            System.out.println("FST dosyasý okunamadý.");
            return;
        }

        System.out.println("Lütfen birinci giriþi giriniz:");
        String giris1 = scanner.nextLine();
        String cikis1 = fst.girisIsle(giris1);
        System.out.println("Durumlarýn sýrasý: " + fst.getDurumDizisi());
        System.out.println("Çýktý: " + cikis1);

        System.out.println("Lütfen ikinci giriþi giriniz:");
        String giris2 = scanner.nextLine();
        String cikis2 = fst.girisIsle(giris2);
        System.out.println("Durumlarýn sýrasý: " + fst.getDurumDizisi());
        System.out.println("Çýktý: " + cikis2);

        scanner.close();
    }
}
package _21010310028_Baran_Gulegen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static FST okuFST(String dosyaAdi) {
        FST fst = new FST();
        File dosya = new File(dosyaAdi);

        try (Scanner tarayici = new Scanner(dosya, "UTF-8")) {
            while (tarayici.hasNextLine()) {
                String satir = tarayici.nextLine().trim();

                if (satir.startsWith("Q =")) {
                    
                } else if (satir.startsWith("∑ =")) {
                    
                } else if (satir.startsWith("Γ =")) {
                    
                } else if (satir.startsWith("q0 =")) {
                    String baslangicDurumu = satir.split("=")[1].trim();
                    fst.baslangicDurumuAyarla(baslangicDurumu);
                } else if (satir.startsWith("δ")) {
                    
                } else {
                    String[] bolumler = satir.split("\t");
                    if (bolumler.length < 2) {
                        System.out.println("Geçersiz satır formatı: " + satir);
                        continue;
                    }

                    String mevcutDurum = bolumler[0];
                    for (int i = 1; i < bolumler.length; i++) {
                        String girisSimge = String.valueOf(i - 1); 
                        String gecisParcasi = bolumler[i].replaceAll("[()]", "");
                        String[] gecisBolumleri = gecisParcasi.split(",");
                        if (gecisBolumleri.length != 2) {
                            System.out.println("Geçersiz geçiş formatı: " + bolumler[i]);
                            continue;
                        }

                        String sonrakiDurum = gecisBolumleri[0].trim();
                        String cikisSimge = gecisBolumleri[1].trim();

                        fst.gecisEkle(mevcutDurum, girisSimge, new FST.Gecis(sonrakiDurum, cikisSimge));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + dosyaAdi);
            return null;
        }

        return fst;
    }
}
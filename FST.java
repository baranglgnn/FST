package _21010310028_Baran_Gulegen;

import java.util.HashMap;
import java.util.Map;

public class FST {
    Map<String, Map<String, Gecis>> gecisler;
    private String baslangicDurumu;
    private String mevcutDurum;
    private StringBuilder durumDizisi;

    public FST() {
        gecisler = new HashMap<>();
        durumDizisi = new StringBuilder();
    }

    public void baslangicDurumuAyarla(String durum) {
        this.baslangicDurumu = durum;
        this.mevcutDurum = durum;
    }

    public void gecisEkle(String durum, String giris, Gecis gecis) {
        gecisler.computeIfAbsent(durum, k -> new HashMap<>()).put(giris, gecis);
    }

    public String girisIsle(String giris) {
        mevcutDurum = baslangicDurumu;
        durumDizisi.setLength(0);
        StringBuilder cikis = new StringBuilder();

        for (char c : giris.toCharArray()) {
            String girisSimgesi = String.valueOf(c);
            Gecis gecis = gecisler.getOrDefault(mevcutDurum, new HashMap<>()).get(girisSimgesi);

            if (gecis == null) {
                System.out.println("Geçersiz girdi: " + girisSimgesi);
                return null;
            }

            cikis.append(gecis.getCikis());
            mevcutDurum = gecis.getSonrakiDurum();
            durumDizisi.append(mevcutDurum).append(", ");
        }

        
        if (durumDizisi.length() > 0) {
            durumDizisi.setLength(durumDizisi.length() - 2);
        }

        return cikis.toString();
    }

    public String getDurumDizisi() {
        return durumDizisi.toString();
    }

    
    public static class Gecis {
        private String sonrakiDurum;
        private String cikis;

        public Gecis(String sonrakiDurum, String cikis) {
            this.sonrakiDurum = sonrakiDurum;
            this.cikis = cikis;
        }

        public String getSonrakiDurum() {
            return sonrakiDurum;
        }

        public String getCikis() {
            return cikis;
        }
    }
}
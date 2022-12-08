package ogrenci_veritabani_uygulamasi;

public class Ogrenci_Veritabani {
    public static void main(String[] args) {
        Ogrenci ogr = new Ogrenci();
        ogr.ogrenciNoBelirle();
        ogr.dersKaydi();
        ogr.odemeMitari();
        System.out.println(Ogrenci.ANSI_YELLOW + "--------------------------");
        System.out.println(Ogrenci.ANSI_GREEN + Ogrenci.ANSI_BOLD + "Kaydınız başarılı bir şekilde tamamlanmıştır.\nDerslerinizi sorumlu danışmanınıza onaylatınız.");
    }
}
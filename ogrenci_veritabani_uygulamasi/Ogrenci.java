package ogrenci_veritabani_uygulamasi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ogrenci {

    // Renk Kodları
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BOLD = "\u001B[1m";

    // Variable’lar
    private String ilkIsim;
    private String soyIsim;
    private int yil;
    private String ogrenciNo;
    private String dersler = "";
    private double toplamBorc;
    private double dersUcreti = 600;
    private static int id = 1000;
    int sayac = 1;

    // Constructor: İsim, soyisim ve yıl bilgisini al
    public Ogrenci() {
        System.out.println(ANSI_BLACK + ANSI_YELLOW_BACKGROUND + ANSI_BOLD + "---------DERS KAYIT EKRANINA HOŞGELDİNİZ---------\n" + ANSI_RESET);
        Scanner input = new Scanner(System.in);
        System.out.print(ANSI_PURPLE+"Adınızı giriniz: ");
        this.ilkIsim = input.nextLine();

        System.out.print("Soyadınızı giriniz: ");
        this.soyIsim = input.nextLine();

        System.out.print("Kaçıncı sınıftasınız: ");
        int sene = input.nextInt();
        while (sene>4 || sene<1){
            System.out.println(ANSI_YELLOW + "--------------------------");
            System.out.print(ANSI_RED + "Yanlış bilgi girdiniz.\n" + ANSI_PURPLE + "Lütfen 1, 2, 3 veya 4 seçeneklerinden birini giriniz: ");
            sene = input.nextInt();
        }
        this.yil = sene;
    }

    // Öğrenci no oluştur
    public void ogrenciNoBelirle() {
        id++;
        this.ogrenciNo = id +""+ yil;
        System.out.println(ANSI_PURPLE + "Öğrenci Numaranız: " + ogrenciNo);
    }

    // Derse kayıt ol
    public void dersKaydi() {
        boolean flag = true;
        List<String> secilenDersler = new ArrayList<>();
        System.out.println(ANSI_YELLOW + "-----------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("DERS LİSTESİ:" +
                "\n\t101 Tarih" +
                "\n\t103 Matematik" +
                "\n\t105 İngilizce" +
                "\n\t107 Kimya" +
                "\n\t109 Bilgisayar Bilimleri");
        System.out.println(ANSI_YELLOW + "-----------------------------------");
        do {
            System.out.println(ANSI_PURPLE + "Seçmek istediğiniz dersin kodunu giriniz veya çıkış için" + ANSI_RED + " X" + ANSI_PURPLE + "'e basınız: ");
            String ders = input.next().toUpperCase();

            if (!secilenDersler.contains(ders)) {
                secilenDersler.add(ders);
                switch (ders) {
                    case "101":
                        dersler = dersler + sayac + ") 101-Tarih \n\t";
                        System.out.println(ANSI_BLUE + "Seçilen Dersler: \n\t" + dersler);
                        borcuGoster();
                        sayac++;
                        break;
                    case "103":
                        dersler = dersler + sayac + ") 103-Matematik \n\t";
                        System.out.println("Seçilen Dersler: \n\t" + dersler);
                        borcuGoster();
                        sayac++;
                        break;
                    case "105":
                        dersler = dersler + sayac + ") 105-İngilizce \n\t";
                        System.out.println("Seçilen Dersler: \n\t" + dersler);
                        borcuGoster();
                        sayac++;
                        break;
                    case "107":
                        dersler = dersler + sayac + ") 107-Kimya \n\t";
                        System.out.println("Seçilen Dersler: \n\t" + dersler);
                        borcuGoster();
                        sayac++;
                        break;
                    case "109":
                        dersler = dersler + sayac + ") 109-Bilgisayar Bilimleri \n\t";
                        System.out.println("Seçilen Dersler: \n\t" + dersler);
                        borcuGoster();
                        sayac++;
                        break;
                    case "X":
                        flag = false;
                        break;
                    default:
                        System.out.println(ANSI_RED + "Geçersiz işlem yaptınız.");
                }
            }else {
                System.out.println(ANSI_RED + "Bu dersi zaten seçtiniz. Başka bir ders seçiniz.");
            }
        }
        while (flag);
        System.out.println(ANSI_YELLOW + "--------------------------");
        System.out.println(ANSI_BLUE + "Seçilen Dersler: \n\t" + dersler);
        System.out.println(ANSI_RED + ANSI_BOLD + "Toplam Borcunuz: " + toplamBorc + " TL" + ANSI_RESET);
        System.out.println(ANSI_YELLOW+ "--------------------------");
    }

// Toplam borcu görüntüle
    public void borcuGoster(){
        toplamBorc = toplamBorc + dersUcreti;
        System.out.println(ANSI_RED + ANSI_BOLD +"Toplam Borcunuz: " + toplamBorc + "TL" + ANSI_RESET);
        System.out.println(ANSI_YELLOW  + "--------------------------");
    }

// Öğrenciye ne kadar ödeme yapacağını sor ve hesapla
    public void odemeMitari() {
        Scanner input = new Scanner(System.in);
        System.out.print(ANSI_PURPLE + "Ödeyeceğiniz miktarı giriniz: ");
        double odeme = input.nextDouble();
        if (odeme<=toplamBorc && odeme>=0){
            toplamBorc = toplamBorc - odeme;
            System.out.println(ANSI_GREEN + ANSI_BOLD + "Ödeme yaptığınız tutar: " + odeme + " TL'dir." + ANSI_RESET);
            System.out.println(ANSI_RED + "Kalan borcunuz: " + toplamBorc + " TL");
        }else {
            System.out.println(ANSI_YELLOW + "--------------------------");
            System.out.println(ANSI_RED + "Hatalı tutar girdiniz.\nMevcut borcunuz: " + toplamBorc + " TL");
            System.out.println(ANSI_YELLOW + "--------------------------");
            odemeMitari();
        }

    }

// Kayıttan sonra ekranda son durumu göster
    @Override
    public String toString() {
        return "İsim Soyisim: " + ilkIsim + " " +soyIsim +"\n"+
                "Yıl: " + yil +"\n"+
                "Öğrenci no: " + ogrenciNo +"\n"+
                "Kayıt olunan dersler: " + dersler +"\n"+
                "Kalan borç: " + toplamBorc;
    }
}
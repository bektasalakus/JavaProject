package EczaneProje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HastaMenu {
    static Scanner scan = new Scanner(System.in);
    static Map<String, String> hastalarr = new HashMap<>();
    public static void HastaMENU() throws InterruptedException {
        String secim2 = "";
        do {
            System.out.println("-------- HASTA MENU --------\n");
            System.out.println("\t1- Yeni Hasta Ekle");
            System.out.println("\t2- Hastalar Listesi");
            System.out.println("\t3- TC ile Hasta Bul");
            System.out.println("\t4- TC ile Hasta Sil");
            System.out.println("\t5- Ana Menü");
            secim2 = scan.nextLine();

            switch (secim2) {
                case "1":
                    HastaEkle();
                    break;
                case "2":
                    hastalarıGoster();
                    break;
                case "3":
                     TChastaBul();
                    break;
                case "4":
                    TChastaSil();
                    break;
                case "5":
                    Genel.AnaMenuyedon();
                    break;
                default:
                    System.out.println("HATA : Yanlış Tuşlama Yapıldı");
            }
        } while (!secim2.contains("5"));
    }
    public static void HastaEkle() {
        System.out.println("---------- HASTA KAYIT ----------\n");
        System.out.println(" TC Giriniz");
        String TcEkle=scan.nextLine();
        System.out.println(" İsim");
        String İsimEkle=scan.nextLine();
        System.out.println(" Soyisim");
        String SoyEkle=scan.nextLine();
        System.out.println(" Doğum Tarihi (Gün,Ay,Yıl)");
        String DogumYEkle=scan.nextLine();
        System.out.println(" Doğum Yeri");
        String DogumYerEkle=scan.nextLine();

        String valueler = İsimEkle + ", " + SoyEkle+ ", " + DogumYEkle+ ", " + DogumYerEkle;
        hastalarr.put(TcEkle, valueler);
    }
    public static void TChastaSil() throws InterruptedException {

        System.out.println("Silencek Hastanın TC'sini Giriniz");
        String HastaSil= scan.nextLine();
        String HastaValue = hastalarr.get(HastaSil);
        String key= hastalarr.remove(HastaSil);

        try {
            if (key.equals(HastaValue)){
                System.out.println("Hasta Başarıyla Silindi");
            }
        } catch (Exception e) {
            System.out.println(" HASTA Bulunamadı veya Yanlış Giriş");
        }
        Thread.sleep(2000);
    }

    public static void TChastaBul() throws InterruptedException {
        System.out.println("Lütfen Hastanın TC'sini Giriniz");
        String TcBul="";
        TcBul= scan.nextLine();
        Set<Map.Entry<String,String>> hastakonrol= hastalarr.entrySet();
        System.out.println("---------- ARANAN SONUÇ ----------\n");
        System.out.println("    TcNo       İsim     Soyisim      D.Yıl        D.Yeri");

        for (Map.Entry<String,String> each: hastakonrol) {
            String Key=each.getKey();
            String Value=each.getValue();
            String[] arrlist=Value.split(", ");
            try {
                if (TcBul.equalsIgnoreCase(Key)){
                    System.out.printf("%11s %-6s  %-8s %4s    %s \n" , Key,arrlist[0],arrlist[1], arrlist[2],arrlist[3]);
                }
            } catch (Exception e) {
                System.out.println(" HASTA Bulunamadı veya Yanlış Giriş");
            }
        }
        Thread.sleep(3200);
    }

    public static void hastalar() {
        hastalarr.put("12345678903","  Hasan,     Kara,      21.02.1971, Kocasinan");
        hastalarr.put("12565639662","  Şükrü,     Ahkam,     12.06.1982, Kocasinan");
        hastalarr.put("69154740776","  Hakkı,     Kaya,      05.03.1993, Fatih");
        hastalarr.put("31245965211","  Orhan,     Arslan,    07.03.1980, İncesu");
        hastalarr.put("21236710205","  Sevim,     Pulu,      01.09.2000, Melikgazi");
        hastalarr.put("24135688287","  Sare,      Yucel,     07.03.1980, İncesu");
        hastalarr.put("19295348710","  Nil,       Mavi,      01.09.2000, Erkilet");
    }
    public static void hastalarıGoster() throws InterruptedException {

        Set<Map.Entry<String,String>> hastakonrol= hastalarr.entrySet();
        System.out.println("---------- HASTA LİSTE ----------\n");
        System.out.println("    TcNo       İsim     Soyisim      D.Yıl        D.Yeri");

        for (Map.Entry<String,String> each: hastakonrol
        ) {
            String Key=each.getKey();
            String Value=each.getValue();

            String[] arr=Value.split(", ");
            System.out.printf("%11s %-6s  %-8s %4s    %s \n" , Key,arr[0],arr[1], arr[2],arr[3]);
        }
        Thread.sleep(3200);
    }
}
package EczaneProje;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class İlaclar {
    static Scanner scan = new Scanner(System.in);
    static Map<String, String> ilaclar = new HashMap<>();




    public static void İlacMenu() throws InterruptedException {
        String secim3 = "";
        do {

            System.out.println("-------- İLAÇ MENU --------\n");
            System.out.println("\t1- Yeni İlaç Kayıt");
            System.out.println("\t2- İlaçlar Listesi");
            System.out.println("\t3- Stok Kontrol");
            System.out.println("\t4- Barkod ile İlaç Sil");
            System.out.println("\t5- Ana Menü");
            secim3 = scan.nextLine();

            switch (secim3) {
                case "1":
               ilacKayit();
                    break;
                case "2":
                  ilclr();
                    break;
                case "3":
                    StokKontrol();
                    break;
                case "4":
                     ilacSil();
                    break;
                case "5":
                    Genel.AnaMenuyedon();
                    break;
                default:
                    System.out.println("HATA : Yanlış Tuşlama Yapıldı");
            }
        } while (!secim3.contains("5"));
    }



    public static void ilacSil() throws InterruptedException {
        System.out.println(" SİL : BARKOD GİRİNİZ");
        String İlacSil= scan.nextLine();
        String Value = ilaclar.get(İlacSil);
        String key= ilaclar.remove(İlacSil);

        try {
            if (key.equals(Value)){
                System.out.println("İlaç Başarıyla Silindi");
            }
        } catch (Exception e) {
            System.out.println(" BARKOD Bulunamadı veya Yanlış Giriş");
        }
        Thread.sleep(2000);
    }

    public static void StokKontrol() throws InterruptedException {

        System.out.println("BARKOD Giriniz");
        String BrkdBul="";
        BrkdBul= scan.nextLine();
        Set<Map.Entry<String,String>> barkodkon= ilaclar.entrySet();
        System.out.println("                     ---------- ARANAN SONUÇ ----------\n");
        System.out.println("    Barkod         İlaç Adı            Stok Miktarı");

        for (Map.Entry<String,String> each: barkodkon) {
            String Key=each.getKey();
            String Value=each.getValue();
            String[] arrlist=Value.split(", ");
            try {
                if (BrkdBul.equalsIgnoreCase(Key)){
                    System.out.printf("%11s %-6s  %-8s     \n" , Key,arrlist[0],arrlist[1]);
                }
            } catch (Exception e) {
                System.out.println(" BARKOD Bulunamadı veya Yanlış Giriş");
            }
        }
        Thread.sleep(3200);




    }

    public static void ilacKayit() {
       System.out.println("---------- İLAÇ KAYIT ----------\n");
       System.out.println(" BARKOD Giriniz");
       String barkod=scan.nextLine();
       System.out.println(" İlaç Adı");
       String İlacAdi=scan.nextLine();
       System.out.println(" Stok Miktarı");
       String StokM=scan.nextLine();
       System.out.println(" Birim Satış Fiyatı");
       String Satis=scan.nextLine();

       String valueler = İlacAdi + ", " + StokM+ ", " + Satis;
       ilaclar.put(barkod, valueler);

    }


    public static void İlaclarA() throws InterruptedException {

        ilaclar.put("8697927024916", "  EBICOMB 10 MG,              23,                   20 TL");
        ilaclar.put("8681801350710", "  LOCACORTENE,                67,                   52 TL");
        ilaclar.put("8680199571202", "  ESLOTIN 2.5 MG,             12,                   73 TL");
        ilaclar.put("8699578094225", "  TIOPRAM 20 MG,              33,                   91 TL");
        ilaclar.put("8699578092221", "  KETINEL 200 MG,             78,                   46 TL");
        ilaclar.put("8699578092245", "  BUDECORT STERI,             92,                   88 TL");
        ilaclar.put("8699578092283", "  PAROL,                      52,                   40 TL");

    }
    public static void ilclr() throws InterruptedException {

        Set<Map.Entry<String, String>> ILAC = ilaclar.entrySet();
        System.out.println("                     ---------- İLAÇ LİSTE ----------");
        System.out.println("    Barkod         İlaç Adı            Stok Miktarı       Birim Satış Fiyatı");
        for (Map.Entry<String, String> each : ILAC
        ) {
            String Key = each.getKey();
            String Value = each.getValue();

            String arr[] = Value.split(", ");
            System.out.printf("%11s %-6s  %-8s %4s    \n", Key, arr[0], arr[1],arr[2]);
        }
        Thread.sleep(3200);
    }

                                                        //SATIŞ
    public static void satıs() throws InterruptedException {
        System.out.println(" SATIŞ : BARKOD Giriniz");
        String Brkd="";
        Brkd= scan.nextLine();
        Set<Map.Entry<String,String>> barko= ilaclar.entrySet();
        for (Map.Entry<String,String> each: barko) {
            String Key=each.getKey();
            String Value=each.getValue();
            try {
                if (Brkd.equalsIgnoreCase(Key)){
                    String arr[]=Value.split(", ");
                    System.out.println("---------------------- SATIŞ YAPILDI ----------------------\n");
                    System.out.printf("\t  %-6s  %s \n" , arr[0],arr[2]+"\n");
                    System.out.println("________________________ İyi Günler _________________________");

                }
            } catch (Exception e) {
                System.out.println(" BARKOD Bulunamadı veya Yanlış Giriş");
            }

        }
        Thread.sleep(3200);
    }
















}

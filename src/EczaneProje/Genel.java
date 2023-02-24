package EczaneProje;

import java.util.Scanner;

public class Genel {
    static Scanner scan = new Scanner(System.in);

    public static void AnaMenuyedon() throws InterruptedException {

        String secim = "";
        do {
            System.out.println("____________ ECZANE KONTROL PANELİ ____________\n" +
                    "\n" +
                    "\t  1- Hasta Menü\n" +
                    "\t  2- Satış Yap\n" +
                    "\t  3- İlaç Menü\n" +
                    "\t  4- Eczane Bilgileri\n" +
                    "\t  5- Çıkış Yap");
            secim = scan.nextLine();

            switch (secim) {
                case "1":
                    HastaMenu.HastaMENU();
                    break;
                case "2":
                     İlaclar.satıs();
                    break;
                case "3":
                 İlaclar.İlacMenu();
                    break;
                case "4":
                    eczaneBilgiler();
                    break;
            }


        } while (!secim.contains("5"));
        System.out.println(" "+" Başarıyla Çıkış Yaptınız");

    }

    public static void eczaneBilgiler() throws InterruptedException {
        System.out.println("__________ ECZANE BİLGİ __________");
        System.out.println("\t Sahibi : Bektaş Alakuş");
        System.out.println("\t Adres : Kayseri/xxx");
        System.out.println("\t Telefon : 0312xxxxxxx");
        System.out.println("----------------------------------");
        Thread.sleep(2400);
    }
}
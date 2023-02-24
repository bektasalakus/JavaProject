package EczaneProje;

import static EczaneProje.Genel.AnaMenuyedon;
public class CALISTİR {
    public static void main(String[] args) throws InterruptedException {
        İlaclar.İlaclarA();    // Tüm Eczane
        HastaMenu.hastalar(); // Tüm Hasta Menüsü
        AnaMenuyedon();       // Buradan Çalıştır
    }
}

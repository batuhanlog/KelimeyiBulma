import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Metin girin: ");
        String metin = scanner.nextLine();

        // Metni kelimelere ayırma
        String[] kelimeler = metin.split("\\s+");

        // Kelimeleri saymak için bir HashMap oluşturma
        Map<String, Integer> kelimeSayilari = new HashMap<>();

        // Kelimeleri döngüyle tek tek dolaşma
        for (String kelime : kelimeler) {
            // Kelimeyi küçük harfe çevirme (büyük-küçük harf farkını göz ardı etmek için)
            kelime = kelime.toLowerCase();

            if (kelimeSayilari.containsKey(kelime)) {
                // Eğer kelime HashMap'te varsa, sayısını bir artır
                kelimeSayilari.put(kelime, kelimeSayilari.get(kelime) + 1);
            } else {
                // Eğer kelime HashMap'te yoksa, ekleyip sayısını 1 yap
                kelimeSayilari.put(kelime, 1);
            }
        }

        // En çok geçen kelimeleri bulma
        int enCokGecenKelimeSayisi = 0;
        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
            if (entry.getValue() > enCokGecenKelimeSayisi) {
                enCokGecenKelimeSayisi = entry.getValue();
            }
        }

        // En çok geçen kelimeleri ekrana yazdırma
        System.out.println("En çok geçen kelimeler:");
        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
            if (entry.getValue() == enCokGecenKelimeSayisi) {
                System.out.println(entry.getKey() + " (metinde " + entry.getValue() + " kez geçiyor)");
            }
        }

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class test {

    private static final int JUMLAH_DATA = 1000;
    private static final int NILAI_MAKSIMUM = 10000;

    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[JUMLAH_DATA];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < JUMLAH_DATA; i++) {
            int nilai = random.nextInt(NILAI_MAKSIMUM);
            array[i] = nilai;
            arrayList.add(nilai);
        }

        System.out.println("=== PERBANDINGAN ARRAY DAN ARRAYLIST ===");
        System.out.println("Jumlah data awal: " + JUMLAH_DATA);
        System.out.println();

        System.out.println("Data awal Array: "
                + Arrays.toString(Arrays.copyOf(array, 10)) + " ...");

        System.out.println("Data awal ArrayList: "
                + arrayList.subList(0, 10) + " ...");

        int nilaiDicari = array[JUMLAH_DATA / 2];

        System.out.println("\nNilai yang dicari: " + nilaiDicari);

        long mulai = System.nanoTime();
        boolean ditemukanPadaArray = cariArray(array, nilaiDicari);
        long selesai = System.nanoTime();
        long waktuCariArray = selesai - mulai;

        mulai = System.nanoTime();
        boolean ditemukanPadaArrayList = arrayList.contains(nilaiDicari);
        selesai = System.nanoTime();
        long waktuCariArrayList = selesai - mulai;

        System.out.println("Pencarian pada Array: "
                + (ditemukanPadaArray ? "Ditemukan" : "Tidak ditemukan"));
        System.out.println("Pencarian pada ArrayList: "
                + (ditemukanPadaArrayList ? "Ditemukan" : "Tidak ditemukan"));

        System.out.println("\n--- Waktu Pencarian ---");
        System.out.println("Array     : " + waktuCariArray + " ns");
        System.out.println("ArrayList : " + waktuCariArrayList + " ns");

        int indeksPenyisipan = 2;
        int nilaiBaru = 99999;

        mulai = System.nanoTime();
        array = sisipkanPadaArray(array, indeksPenyisipan, nilaiBaru);
        selesai = System.nanoTime();
        long waktuSisipArray = selesai - mulai;

        mulai = System.nanoTime();
        arrayList.add(indeksPenyisipan, nilaiBaru);
        selesai = System.nanoTime();
        long waktuSisipArrayList = selesai - mulai;

        System.out.println("\n--- Setelah Penyisipan ---");
        System.out.println("Array setelah penyisipan: "
                + Arrays.toString(Arrays.copyOf(array, 10)) + " ...");
        System.out.println("ArrayList setelah penyisipan: "
                + arrayList.subList(0, 10) + " ...");

        System.out.println("\n--- Waktu Penyisipan ---");
        System.out.println("Array     : " + waktuSisipArray + " ns");
        System.out.println("ArrayList : " + waktuSisipArrayList + " ns");

        mulai = System.nanoTime();
        array = hapusPadaArray(array, indeksPenyisipan);
        selesai = System.nanoTime();
        long waktuHapusArray = selesai - mulai;

        mulai = System.nanoTime();
        arrayList.remove(indeksPenyisipan);
        selesai = System.nanoTime();
        long waktuHapusArrayList = selesai - mulai;

        System.out.println("\n--- Setelah Penghapusan ---");
        System.out.println("Array setelah penghapusan: "
                + Arrays.toString(Arrays.copyOf(array, 10)) + " ...");
        System.out.println("ArrayList setelah penghapusan: "
                + arrayList.subList(0, 10) + " ...");

        System.out.println("\n--- Waktu Penghapusan ---");
        System.out.println("Array     : " + waktuHapusArray + " ns");
        System.out.println("ArrayList : " + waktuHapusArrayList + " ns");

        int[] arrayUntukDiurutkan = array.clone();
        ArrayList<Integer> arrayListUntukDiurutkan =
                new ArrayList<>(arrayList);

        mulai = System.nanoTime();
        Arrays.sort(arrayUntukDiurutkan);
        selesai = System.nanoTime();
        long waktuSortArray = selesai - mulai;

        mulai = System.nanoTime();
        Collections.sort(arrayListUntukDiurutkan);
        selesai = System.nanoTime();
        long waktuSortArrayList = selesai - mulai;

        System.out.println("\n--- Setelah Pengurutan ---");
        System.out.println("Array terurut: "
                + Arrays.toString(Arrays.copyOf(arrayUntukDiurutkan, 10))
                + " ...");

        System.out.println("ArrayList terurut: "
                + arrayListUntukDiurutkan.subList(0, 10) + " ...");

        System.out.println("\n--- Waktu Pengurutan ---");
        System.out.println("Array     : " + waktuSortArray + " ns");
        System.out.println("ArrayList : " + waktuSortArrayList + " ns");

        System.out.println("\n=== RINGKASAN HASIL ===");
        System.out.printf("%-15s %-15s %-15s%n",
                "Operasi", "Array (ns)", "ArrayList (ns)");
        System.out.printf("%-15s %-15d %-15d%n",
                "Pencarian", waktuCariArray, waktuCariArrayList);
        System.out.printf("%-15s %-15d %-15d%n",
                "Penyisipan", waktuSisipArray, waktuSisipArrayList);
        System.out.printf("%-15s %-15d %-15d%n",
                "Penghapusan", waktuHapusArray, waktuHapusArrayList);
        System.out.printf("%-15s %-15d %-15d%n",
                "Pengurutan", waktuSortArray, waktuSortArrayList);
    }

    public static boolean cariArray(int[] array, int nilai) {
        for (int elemen : array) {
            if (elemen == nilai) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static int[] sisipkanPadaArray(
            int[] array, int indeks, int nilai) {

        int[] hasil = new int[array.length + 1];

        for (int i = 0; i < indeks; i++) {
            hasil[i] = array[i];
        }

        hasil[indeks] = nilai;

        for (int i = indeks; i < array.length; i++) {
            hasil[i + 1] = array[i];
        }

        return hasil;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static int[] hapusPadaArray(int[] array, int indeks) {
        int[] hasil = new int[array.length - 1];

        for (int i = 0; i < indeks; i++) {
            hasil[i] = array[i];
        }

        for (int i = indeks + 1; i < array.length; i++) {
            hasil[i - 1] = array[i];
        }

        return hasil;
    }
}
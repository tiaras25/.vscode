import java.util.ArrayList;

/**
 * Program ini akan:
 * 1. Menampilkan hasil traversal, pencarian, penyisipan, dan penghapusan
 *    pada Array dan ArrayList (sesuai contoh output pada soal).
 * 2. Menjalankan perbandingan waktu eksekusi antara Array dan ArrayList
 *    dengan data yang lebih besar (1000 elemen).
 */
public class Main {

    public static void main(String[] args) {

        // ==========================================================
        // BAGIAN 1: Demo dasar (traversal, pencarian, penyisipan)
        // ==========================================================

        // data awal untuk Array
        int[] array = {10, 20, 30, 40, 50};

        // data awal untuk ArrayList (isinya sama seperti array)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // ---- 1. TRAVERSAL ----
        ArrayOperations.traversal(array);
        ArrayListOperations.traversal(list);
        System.out.println();

        // ---- 2. PENCARIAN ----
        int nilaiDicari = 30;
        int indeksArray = ArrayOperations.linearSearch(array, nilaiDicari);
        int indeksList = ArrayListOperations.cari(list, nilaiDicari);

        System.out.println("Pencarian " + nilaiDicari + " dalam Array: Ditemukan di indeks " + indeksArray);
        System.out.println("Pencarian " + nilaiDicari + " dalam ArrayList: Ditemukan di indeks " + indeksList);
        System.out.println();

        // ---- 3. PENYISIPAN elemen 25 di indeks ke-2 ----
        array = ArrayOperations.insert(array, 2, 25);
        list.add(2, 25);

        System.out.println("Array setelah penyisipan elemen 25: " + ArrayOperations.toArrayString(array));
        System.out.println("ArrayList setelah penyisipan elemen 25: " + list);
        System.out.println();

        // ---- 4. PENGHAPUSAN elemen pada indeks ke-0 ----
        array = ArrayOperations.delete(array, 0);
        list.remove(0); // remove(int index) -> menghapus berdasarkan posisi

        System.out.println("Array setelah penghapusan indeks 0: " + ArrayOperations.toArrayString(array));
        System.out.println("ArrayList setelah penghapusan indeks 0: " + list);
        System.out.println();

        // ---- 5. PENGURUTAN pada ArrayList (pakai Collections.sort) ----
        list.add(5);
        list.add(1);
        System.out.println("ArrayList sebelum diurutkan: " + list);
        ArrayListOperations.urutkan(list);
        System.out.println("ArrayList setelah diurutkan: " + list);
        System.out.println();

        // ---- 6. BINARY SEARCH pada Array (array harus sudah terurut) ----
        int[] arrayTerurut = {10, 20, 25, 30, 40, 50};
        int hasilBinary = ArrayOperations.binarySearch(arrayTerurut, 40);
        System.out.println("Binary Search mencari 40 pada Array terurut: Ditemukan di indeks " + hasilBinary);
        System.out.println();

        // ---- 7. Perbandingan waktu eksekusi PENCARIAN (data kecil, dengancontoh output) ----
        int[] arrayKecil = {10, 20, 25, 30, 40, 50};
        ArrayList<Integer> listKecil = new ArrayList<>();
        for (int nilai : arrayKecil) {
            listKecil.add(nilai);
        }
        Comparison.bandingkanPencarian(arrayKecil, listKecil, 30);

        // ==========================================================
        // BAGIAN 2: Perbandingan dengan data besar (1000 elemen)
        // ==========================================================
        Comparison.bandingkanDataBesar(1000);
    }
}

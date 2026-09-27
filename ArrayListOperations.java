import java.util.Collections;

/**
 * ArrayListOperations
 * Kelas ini berisi kumpulan operasi dasar ArrayList<Integer>.
 * Operasi yang tersedia: traversal, tambah elemen, hapus elemen, pencarian, dan pengurutan.
 *
 * Beda dengan Array biasa, ArrayList ukurannya fleksibel (dinamis),
 * jadi kita tidak perlu bikin objek baru setiap kali menambah/menghapus data.
 */
public class ArrayListOperations {

    // 1. TRAVERSAL
    // Menampilkan semua isi ArrayList Function traversal otomatis membuat
    // ArrayList mempunYai method toString() yang rapi seperti [10, 20, 30]
    public static void traversal(ArrayList<Integer> list) {
        System.out.println("ArrayList Traversal: " + list);
    }

    // 2. Menambahkan elemendi akhir list
    public static void tambah(ArrayList<Integer> list, int value) {
        list.add(value);
    }

    // 2b. Menambahkan elemen di posisi/indeks tertentu (dipakai untuk penyisipan)
    public static void tambahDiIndeks(ArrayList<Integer> list, int index, int value) {
        list.add(index, value);
    }

    // 3. Menghapus elemen berdasarkan posisi/indeks
    public static void hapus(ArrayList<Integer> list, int index) {
        // perhatian: list.remove(int index) akan menghapus posisi
        // sedangkan list.remove(Integer.valueOf(nilai)) menghapus valuenya
        list.remove(index);
    }

    // 4. Pencarian elemen
    // Menggunakan function  bawaan indexOf() dari ArrayList
    public static int cari(ArrayList<Integer> list, int value) {
        return list.indexOf(value); // otomatis return -1 kalau tidak ketemu
    }

    // 5. Pengurut elemen
    // Menggunakan Collections.sort() bawaan Java, jadi tidak perlu bikin algoritma sorting sendiri
    public static void urutkan(ArrayList<Integer> list) {
        Collections.sort(list);
    }
}

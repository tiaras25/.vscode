/**
 * Kelas ArrayOperations
 * Kelas ini berisi kumpulan metode dasar untuk bekerja dengan Array biasa (int[]).
 * Operasi yang tersedia: traversal, pencarian (linear & binary), penyisipan, dan penghapusan.
 *
 * Catatan: Array di Java ukurannya tetap (fixed size), jadi untuk operasi
 * penyisipan dan penghapusan, kita harus membuat array baru dengan ukuran
 * yang berbeda, lalu menyalin isinya menggunakan System.arraycopy().
 */
public class ArrayOperations {

    // Mengubah isi array menjadi bentuk String seperti [10, 20, 30]
    // supaya lebih gampang ditampilkan
    public static String toArrayString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 1. TRAVERSAL
    // Menampilkan semua isi array satu per satu
    public static void traversal(int[] arr) {
        System.out.println("Array Traversal: " + toArrayString(arr));
    }

    // 2. PENCARIAN - Linear Search
    // Mencari nilai dengan mengecek elemen satu per satu dari awal sampai akhir
    // Cocok untuk array yang belum terurut
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // ketemu, langsung kembalikan indeksnya
            }
        }
        return -1; // tidak ketemu
    }

    // 2. PENCARIAN - Binary Search
    // Syarat: array HARUS sudah terurut (ascending)
    // Caranya membagi dua terus data yang dicek, jadi lebih cepat dari linear search
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid; // ketemu di tengah
            } else if (arr[mid] < key) {
                low = mid + 1; // cari di bagian kanan
            } else {
                high = mid - 1; // cari di bagian kiri
            }
        }
        return -1; // tidak ketemu
    }

    // 3. PENYISIPAN
    // Karena ukuran array tidak bisa diubah, kita bikin array baru
    // yang ukurannya lebih besar 1, lalu sisipkan nilai baru di posisi "index"
    public static int[] insert(int[] arr, int index, int value) {
        int[] hasil = new int[arr.length + 1];

        // salin elemen sebelum posisi index
        System.arraycopy(arr, 0, hasil, 0, index);

        // taruh nilai baru di posisi index
        hasil[index] = value;

        // salin sisa elemen setelah posisi index (geser ke kanan 1 posisi)
        System.arraycopy(arr, index, hasil, index + 1, arr.length - index);

        return hasil;
    }

    // 4. PENGHAPUSAN
    // Sama seperti insert, karena ukuran array tetap, kita bikin array baru
    // yang ukurannya lebih kecil 1, tanpa elemen di posisi "index"
    public static int[] delete(int[] arr, int index) {
        int[] hasil = new int[arr.length - 1];

        // salin elemen sebelum posisi index
        System.arraycopy(arr, 0, hasil, 0, index);

        // salin elemen setelah posisi index (geser ke kiri 1 posisi)
        System.arraycopy(arr, index + 1, hasil, index, arr.length - index - 1);

        return hasil;
    }
}

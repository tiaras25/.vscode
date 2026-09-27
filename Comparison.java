import java.util.ArrayList;

/**
 * Kelas Comparison
 * Dipakai untuk membandingkan kinerja (waktu eksekusi) antara
 * Array dan ArrayList ketika melakukan operasi dasar yang sama.
 *
 * Cara mengukur waktu: pakai System.nanoTime() sebelum dan sesudah operasi,
 * lalu selisihnya kita ubah dari nanodetik ke milidetik (dibagi 1.000.000).
 */
public class Comparison {

    // Membandingkan waktu pencarian pada Array vs ArrayList (untuk data kecil,
    // supaya hasilnya mirip seperti pada contoh output di soal)
    public static void bandingkanPencarian(int[] array, ArrayList<Integer> list, int key) {

        // ukur waktu pencarian pada Array
        long mulaiArray = System.nanoTime();
        ArrayOperations.linearSearch(array, key);
        long selesaiArray = System.nanoTime();
        double waktuArray = (selesaiArray - mulaiArray) / 1_000_000.0;

        // ukur waktu pencarian pada ArrayList
        long mulaiList = System.nanoTime();
        ArrayListOperations.cari(list, key);
        long selesaiList = System.nanoTime();
        double waktuList = (selesaiList - mulaiList) / 1_000_000.0;

        System.out.println("Waktu eksekusi pencarian pada Array: " + waktuArray + " ms");
        System.out.println("Waktu eksekusi pencarian pada ArrayList: " + waktuList + " ms");
    }

    // Membandingkan Array vs ArrayList dengan data yang lebih besar (misalnya 1000 elemen)
    // supaya perbedaan waktu eksekusinya lebih terlihat nyata (sesuai tips pengerjaan no.5)
    public static void bandingkanDataBesar(int jumlahData) {

        System.out.println();
        System.out.println("=== Perbandingan Array vs ArrayList dengan " + jumlahData + " elemen ===");

        // siapkan data Array yang sudah terisi angka 0 sampai jumlahData-1
        int[] array = new int[jumlahData];
        for (int i = 0; i < jumlahData; i++) {
            array[i] = i;
        }

        // siapkan data ArrayList dengan isi yang sama
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < jumlahData; i++) {
            list.add(i);
        }

        int kunciDicari = jumlahData - 1; // cari elemen paling akhir (kasus terlama untuk linear search)

        // 1. TRAVERSAL
        long t1 = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            @SuppressWarnings("unused")
            int nilai = array[i]; // hanya membaca, tidak dipakai
        }
        long t2 = System.nanoTime();
        double waktuTraversalArray = (t2 - t1) / 1_000_000.0;

        long t3 = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            @SuppressWarnings("unused")
            int nilai = list.get(i); // hanya membaca, tidak dipakai
        }
        long t4 = System.nanoTime();
        double waktuTraversalList = (t4 - t3) / 1_000_000.0;

        // 2. PENCARIAN (linear search)
        long t5 = System.nanoTime();
        ArrayOperations.linearSearch(array, kunciDicari);
        long t6 = System.nanoTime();
        double waktuCariArray = (t6 - t5) / 1_000_000.0;

        long t7 = System.nanoTime();
        ArrayListOperations.cari(list, kunciDicari);
        long t8 = System.nanoTime();
        double waktuCariList = (t8 - t7) / 1_000_000.0;

        //3. PENYISIPAN di tengah data
        int posisiTengah = jumlahData / 2;

        long t9 = System.nanoTime();
        array = ArrayOperations.insert(array, posisiTengah, 99999);
        long t10 = System.nanoTime();
        double waktuSisipArray = (t10 - t9) / 1_000_000.0;

        long t11 = System.nanoTime();
        list.add(posisiTengah, 99999);
        long t12 = System.nanoTime();
        double waktuSisipList = (t12 - t11) / 1_000_000.0;

        // 4. PENGHAPUSAN di tengah data
        long t13 = System.nanoTime();
        array = ArrayOperations.delete(array, posisiTengah);
        long t14 = System.nanoTime();
        double waktuHapusArray = (t14 - t13) / 1_000_000.0;

        long t15 = System.nanoTime();
        list.remove(posisiTengah);
        long t16 = System.nanoTime();
        double waktuHapusList = (t16 - t15) / 1_000_000.0;

        // ---- Tampilkan hasil dalam bentuk tabel sederhana ----
        System.out.println("+-------------+---------------+---------------+");
        System.out.printf("| %-11s | %-13s | %-13s |%n", "Operasi", "Array (ms)", "ArrayList(ms)");
        System.out.println("+-------------+---------------+---------------+");
        System.out.printf("| %-11s | %-13.4f | %-13.4f |%n", "Traversal", waktuTraversalArray, waktuTraversalList);
        System.out.printf("| %-11s | %-13.4f | %-13.4f |%n", "Pencarian", waktuCariArray, waktuCariList);
        System.out.printf("| %-11s | %-13.4f | %-13.4f |%n", "Penyisipan", waktuSisipArray, waktuSisipList);
        System.out.printf("| %-11s | %-13.4f | %-13.4f |%n", "Penghapusan", waktuHapusArray, waktuHapusList);
        System.out.println("+-------------+---------------+---------------+");
    }
}

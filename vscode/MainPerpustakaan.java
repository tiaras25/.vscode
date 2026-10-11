import java.util.Scanner;

public class MainPerpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList perpustakaan = new LinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Pilihan tidak valid!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    String kodeBuku;
                    // Validasi kodeBuku maksimal 5 karakter
                    do {
                        System.out.print("Masukkan Kode Buku: ");
                        kodeBuku = scanner.nextLine().trim();
                        if (kodeBuku.length() > 5) {
                            System.out.println("Error: Kode buku harus 5 karakter!");
                        } else if (kodeBuku.isEmpty()) {
                            System.out.println("Error: Kode buku tidak boleh kosong!");
                        }
                    } while (kodeBuku.length() > 5 || kodeBuku.isEmpty());

                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine().trim();

                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine().trim();

                    perpustakaan.push(kodeBuku, judul, penulis);

                    if (perpustakaan.getCount() < 5) {
                        System.out.println("[Catatan: Jumlah data saat ini " + perpustakaan.getCount() + " buku. Disarankan minimal 5 buku].");
                    }
                    break;

                    
                case 2:
                    perpustakaan.pop();
                    break;

                case 3:
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String cariKode = scanner.nextLine().trim();
                    perpustakaan.cari(cariKode);
                    break;

                case 4:
                    perpustakaan.display();
                    break;

                case 5:
                    System.out.println("Terima kasih. Program Selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
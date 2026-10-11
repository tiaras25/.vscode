import java.util.Scanner;
public class MainKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
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
                    System.out.print("Masukkan Nomor Antrian: ");
                    String noAntrian = scanner.nextLine().trim();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = 0;
                    if (scanner.hasNextDouble()) {
                        total = scanner.nextDouble();
                        scanner.nextLine();
                    } else {
                        System.out.println("Input total belanja tidak valid!");
                        scanner.nextLine();
                        break;
                    }

                    antrian.enqueue(noAntrian, nama, total);

                    if (antrian.getSize() < 5) {
                        System.out.println("[Catatan: Jumlah antrian saat ini " + antrian.getSize() + " pelanggan. Minimal 5 pelanggan].");
                    }
                    break;

                case 2:
                    CustomerNode served = antrian.dequeue();
                    if (served != null) {
                        System.out.println(" Sedang melayani pelanggan " + served.nomorAntrian + " (" + served.namaPelanggan + ")");
                        riwayat.push(served);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                    antrian.displayQueue();
                    break;
                case 4:
                    riwayat.displayHistory();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Sistem Kasir Toko!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak tersedia!");
            }
        } while (pilihan != 5);

        scanner.close();
}
}

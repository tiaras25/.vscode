public class Stack {
    // Class Stack untuk menangani riwayat transaksi (LIFO)
    private CustomerNode top = null;
    private int size = 0;

    // Menyimpan transaksi yang sudah selesai dilayani(Push)
    public void push(CustomerNode node) {
        if (node == null) return;

        CustomerNode newNode = new CustomerNode(node.nomorAntrian, node.namaPelanggan, node.totalBelanja);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Menampilkan riwayat transaksi dari terbaru ke lama
    public void displayHistory() {
        if (top == null) {
            System.out.println("Tidak ada riwayat transaksi.");
            return;
        }

        System.out.println("\n--- Riwayat Transaksi (Terbaru ke Lama) ---");
        CustomerNode current = top;
        while (current != null) {
            System.out.println("No Antrian: " + current.nomorAntrian + 
                               " | Nama: " + current.namaPelanggan + 
                               " | Total Belanja: Rp " + current.totalBelanja);
            current = current.next;
        }
        System.out.println("Total Riwayat Transaksi: " + size);
}
}

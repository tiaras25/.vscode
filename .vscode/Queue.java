public class Queue {
    // Class Queue untuk menangani antrian pelanggan (FIFO)
    private CustomerNode front = null;
    private CustomerNode rear = null;
    private int size = 0;

    // Tambah antrian pelanggan (Enqueue)
    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        CustomerNode newNode = new CustomerNode(nomorAntrian, namaPelanggan, totalBelanja);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Data pelanggan ditambahkan ke antrian");
    }

    // Melayani pelanggan (Dequeue)
    public CustomerNode dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong! Tidak ada pelanggan untuk dilayani.");
            return null;
        }

        CustomerNode temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return temp;
    }

    // Tampilkan antrian saat ini
    public void displayQueue() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("\n--- Antrian Pelanggan Saat Ini ---");
        CustomerNode current = front;
        while (current != null) {
            System.out.println("No Antrian: " + current.nomorAntrian + 
                               " | Nama: " + current.namaPelanggan + 
                               " | Total Belanja: Rp " + current.totalBelanja);
            current = current.next;
        }
        System.out.println("Total antrian: " + size);
    }

    public int getSize() {
        return size;
}
    
}

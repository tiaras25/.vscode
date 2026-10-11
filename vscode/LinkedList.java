// Class untuk menyimpan daftar buku 
public class LinkedList {
    private Node head;
    private int count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    // Menambah buku di akhir daftar (Push)
    public void push(String kodeBuku, String judul, String penulis) {
        Node newNode = new Node(kodeBuku, judul, penulis);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
        System.out.println("Buku berhasil ditambahkan!");
    }

    // Menghapus buku terakhir dari daftar (Pop)
    public void pop() {
        if (head == null) {
            System.out.println("Tidak ada buku untuk dihapus.");
            return;
        }

        if (head.next == null) {
            System.out.println("Buku dengan kode " + head.kodeBuku + " (" + head.judul + ") berhasil dihapus!");
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku dengan kode " + current.next.kodeBuku + " (" + current.next.judul + ") berhasil dihapus!");
            current.next = null;
        }
        count--;
    }

    // Mencari buku berdasarkan kode
    public void cari(String kodeBuku) {
        if (head == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku Ditemukan:");
                System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // Menampilkan seluruh data buku berdasarkan urutan input
    public void display() {
        if (head == null) {
            System.out.println("Daftar buku kosong.");
            System.out.println("Total Buku: 0");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + count);
    }

    public int getCount() {
        return count;
    }
}
public class CustomerNode {
    // Class Node untuk menyimpan data pelanggan
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    CustomerNode next;

    public CustomerNode(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
}
}

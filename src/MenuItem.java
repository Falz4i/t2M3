class MenuItem {
    private String kode;
    private String nama;
    private double hargaSepiring;
    private double hargaSeporsi; // Seporsi biasanya lebih besar dari sepiring
    private String kategori;

    public MenuItem(String kode, String nama, double hargaSepiring, double hargaSeporsi, String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.hargaSepiring = hargaSepiring;
        this.hargaSeporsi = hargaSeporsi;
        this.kategori = kategori;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHargaSepiring() {
        return hargaSepiring;
    }

    public double getHargaSeporsi() {
        return hargaSeporsi;
    }

    public String getKategori() {
        return kategori;
    }
}

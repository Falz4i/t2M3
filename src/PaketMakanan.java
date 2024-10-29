class PaketMakanan {
    private String kode;
    private String nama;
    private double harga;
    private String deskripsi;

    public PaketMakanan(String kode, String nama, double harga, String deskripsi) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}

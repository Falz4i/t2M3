class OrderItem {
    private MenuItem menuItem;
    private PaketMakanan paket;
    private int jumlah;
    private boolean isPiring; // true untuk sepiring, false untuk seporsi

    public OrderItem(MenuItem menuItem, int jumlah, boolean isPiring) {
        this.menuItem = menuItem;
        this.jumlah = jumlah;
        this.isPiring = isPiring;
        this.paket = null;
    }

    public OrderItem(PaketMakanan paket, int jumlah) {
        this.paket = paket;
        this.jumlah = jumlah;
        this.menuItem = null;
        this.isPiring = false;
    }

    public MenuItem getMenuItem() { return menuItem; }
    public PaketMakanan getPaket() { return paket; }
    public int getJumlah() { return jumlah; }
    public boolean isPiring() { return isPiring; }

    public double getSubtotal() {
        if (paket != null) {
            return paket.getHarga() * jumlah;
        }
        return (isPiring ? menuItem.getHargaSepiring() : menuItem.getHargaSeporsi()) * jumlah;
    }
}

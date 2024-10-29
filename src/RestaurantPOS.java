import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RestaurantPOS {
    private ArrayList<MenuItem> menuItems;
    private ArrayList<PaketMakanan> paketMakanan;
    private ArrayList<OrderItem> currentOrder;
    private Scanner scanner;

    public RestaurantPOS() {
        menuItems = new ArrayList<>();
        paketMakanan = new ArrayList<>();
        currentOrder = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeMenu();
        initializePaket();
    }

    private void initializeMenu() {
        // Lauk Utama
        menuItems.add(new MenuItem("R1", "Rendang", 20000, 35000, "Lauk Utama"));
        menuItems.add(new MenuItem("R2", "Ayam Pop", 15000, 28000, "Lauk Utama"));
        menuItems.add(new MenuItem("R3", "Dendeng Balado", 18000, 32000, "Lauk Utama"));
        menuItems.add(new MenuItem("R4", "Ikan Bakar", 16000, 30000, "Lauk Utama"));

        // Sayur
        menuItems.add(new MenuItem("S1", "Gulai Nangka", 8000, 15000, "Sayur"));
        menuItems.add(new MenuItem("S2", "Gulai Daun Singkong", 7000, 13000, "Sayur"));
        menuItems.add(new MenuItem("S3", "Gulai Pakis", 7000, 13000, "Sayur"));

        // Sambal
        menuItems.add(new MenuItem("B1", "Sambal Ijo", 5000, 10000, "Sambal"));
        menuItems.add(new MenuItem("B2", "Sambal Merah", 5000, 10000, "Sambal"));

        // Minuman
        menuItems.add(new MenuItem("M1", "Es Teh", 5000, 5000, "Minuman"));
        menuItems.add(new MenuItem("M2", "Es Jeruk", 7000, 7000, "Minuman"));
        menuItems.add(new MenuItem("M3", "Air Mineral", 5000, 5000, "Minuman"));
    }

    private void initializePaket() {
        paketMakanan.add(new PaketMakanan("P1", "Paket Rendang", 45000,
                "Nasi + Rendang + Gulai Nangka + Sambal"));
        paketMakanan.add(new PaketMakanan("P2", "Paket Ayam Pop", 38000,
                "Nasi + Ayam Pop + Gulai Daun Singkong + Sambal"));
        paketMakanan.add(new PaketMakanan("P3", "Paket Hemat", 30000,
                "Nasi + Telur Dadar + Gulai Nangka + Sambal"));
    }

    public void tampilkanMenu() {
        System.out.println("\n=== RUMAH MAKAN PADANG SIANG MALAM ===");
        System.out.println("\nPAKET HEMAT:");
        for (PaketMakanan paket : paketMakanan) {
            System.out.printf("%s - %s (Rp %.0f)\n%s\n",
                    paket.getKode(), paket.getNama(), paket.getHarga(), paket.getDeskripsi());
        }

        System.out.println("\nLAUK UTAMA:");
        for (MenuItem item : menuItems) {
            if (item.getKategori().equals("Lauk Utama")) {
                System.out.printf("%s - %s\n  Sepiring: Rp %.0f | Seporsi: Rp %.0f\n",
                        item.getKode(), item.getNama(), item.getHargaSepiring(), item.getHargaSeporsi());
            }
        }

        System.out.println("\nSAYUR:");
        for (MenuItem item : menuItems) {
            if (item.getKategori().equals("Sayur")) {
                System.out.printf("%s - %s\n  Sepiring: Rp %.0f | Seporsi: Rp %.0f\n",
                        item.getKode(), item.getNama(), item.getHargaSepiring(), item.getHargaSeporsi());
            }
        }

        System.out.println("\nSAMBAL:");
        for (MenuItem item : menuItems) {
            if (item.getKategori().equals("Sambal")) {
                System.out.printf("%s - %s\n  Sepiring: Rp %.0f | Seporsi: Rp %.0f\n",
                        item.getKode(), item.getNama(), item.getHargaSepiring(), item.getHargaSeporsi());
            }
        }

        System.out.println("\nMINUMAN:");
        for (MenuItem item : menuItems) {
            if (item.getKategori().equals("Minuman")) {
                System.out.printf("%s - %s (Rp %.0f)\n",
                        item.getKode(), item.getNama(), item.getHargaSepiring());
            }
        }
    }

    private MenuItem findMenuItem(String kode) {
        for (MenuItem item : menuItems) {
            if (item.getKode().equalsIgnoreCase(kode)) {
                return item;
            }
        }
        return null;
    }

    private PaketMakanan findPaket(String kode) {
        for (PaketMakanan paket : paketMakanan) {
            if (paket.getKode().equalsIgnoreCase(kode)) {
                return paket;
            }
        }
        return null;
    }

    public void prosesOrder() {
        boolean lanjutOrder = true;
        while (lanjutOrder) {
            tampilkanMenu();
            System.out.println("\nPilih jenis pesanan:");
            System.out.println("1. Pesan Paket");
            System.out.println("2. Pesan Menu Satuan");
            System.out.println("3. Selesai");
            System.out.print("Pilihan Anda: ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    prosesPaket();
                    break;
                case 2:
                    prosesMenuSatuan();
                    break;
                case 3:
                    lanjutOrder = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        if (!currentOrder.isEmpty()) {
            cetakNota();
            currentOrder.clear();
        }
    }

    private void prosesPaket() {
        System.out.print("\nMasukkan kode paket: ");
        String kodePaket = scanner.next();

        PaketMakanan paket = findPaket(kodePaket);
        if (paket == null) {
            System.out.println("Paket tidak ditemukan!");
            return;
        }

        System.out.print("Jumlah paket: ");
        int jumlah = scanner.nextInt();
        currentOrder.add(new OrderItem(paket, jumlah));
    }

    private void prosesMenuSatuan() {
        System.out.print("\nMasukkan kode menu: ");
        String kodeMenu = scanner.next();

        MenuItem menu = findMenuItem(kodeMenu);
        if (menu == null) {
            System.out.println("Menu tidak ditemukan!");
            return;
        }

        System.out.println("Pilih porsi:");
        System.out.println("1. Sepiring");
        System.out.println("2. Seporsi");
        System.out.print("Pilihan Anda: ");
        int pilihPorsi = scanner.nextInt();

        boolean isPiring = (pilihPorsi == 1);

        System.out.print("Jumlah pesanan: ");
        int jumlah = scanner.nextInt();
        currentOrder.add(new OrderItem(menu, jumlah, isPiring));
    }

    public void cetakNota() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        double total = 0;

        System.out.println("\n========= RUMAH MAKAN PADANG SIANG MALAM =========");
        System.out.println("Tanggal: " + sdf.format(new Date()));
        System.out.println("----------------------------------------");

        // Custom Live Template untuk format currency
        /*
         * Template: formatCurrency
         * Expression: String.format("Rp %,.0f", $AMOUNT$)
         */
        for (OrderItem item : currentOrder) {
            if (item.getPaket() != null) {
                System.out.printf("%s x%d\n",
                        item.getPaket().getNama(),
                        item.getJumlah());
                System.out.printf("  @%s = %s\n",
                        String.format("Rp %,.0f", item.getPaket().getHarga()),
                        String.format("Rp %,.0f", item.getSubtotal()));
            } else {
                System.out.printf("%s (%s) x%d\n",
                        item.getMenuItem().getNama(),
                        item.isPiring() ? "Sepiring" : "Seporsi",
                        item.getJumlah());
                System.out.printf("  @%s = %s\n",
                        String.format("Rp %,.0f", item.isPiring() ?
                                item.getMenuItem().getHargaSepiring() :
                                item.getMenuItem().getHargaSeporsi()),
                        String.format("Rp %,.0f", item.getSubtotal()));
            }
            total += item.getSubtotal();
        }

        System.out.println("----------------------------------------");
        System.out.printf("Total Pembayaran: %s\n",
                String.format("Rp %,.0f", total));
        System.out.println("========= Terima Kasih =========");
        System.out.println("Silakan Datang Kembali!");
    }

    public static void main(String[] args) {
        RestaurantPOS pos = new RestaurantPOS();
        Scanner mainScanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEM POS RUMAH MAKAN PADANG SIANG MALAM ===");
            System.out.println("1. Proses Pesanan Baru");
            System.out.println("2. Keluar");
            System.out.print("Pilihan: ");

            int pilihan = mainScanner.nextInt();
            if (pilihan == 1) {
                pos.prosesOrder();
            } else if (pilihan == 2) {
                break;
            }
        }

        mainScanner.close();
    }
}
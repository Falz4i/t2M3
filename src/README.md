# Restaurant POS - Rumah Makan SIANG MALAM

Sistem Point of Sale (POS) sederhana untuk mengelola pesanan di restoran. Sistem ini memungkinkan pengguna untuk memilih menu satuan atau paket makanan, menghitung subtotal setiap item, dan mencetak nota pembayaran lengkap. Proyek ini ditujukan untuk restoran Rumah Makan SIANG MALAM, dengan kategori menu yang terdiri dari lauk utama, sayur, sambal, dan minuman.

## Fitur

1. **Tampilan Menu** - Menampilkan daftar lengkap dari menu yang tersedia, termasuk paket hemat, lauk utama, sayur, sambal, dan minuman.
2. **Proses Pesanan** - Mengelola pesanan baru, memungkinkan pengguna untuk memilih menu satuan atau paket makanan, serta jumlah dan porsi.
3. **Cetak Nota** - Menghitung subtotal dan total pembayaran, lalu mencetak nota dengan detail lengkap.

## Struktur Kelas

- **MenuItem** - Kelas untuk item menu satuan dengan atribut seperti `kode`, `nama`, `hargaSepiring`, `hargaSeporsi`, dan `kategori`.
- **PaketMakanan** - Kelas untuk paket makanan dengan `kode`, `nama`, `harga`, dan `deskripsi`.
- **OrderItem** - Kelas yang merepresentasikan item pesanan yang dapat berupa `MenuItem` atau `PaketMakanan`, serta menghitung subtotal pesanan.
- **RestaurantPOS** - Kelas utama yang mengatur tampilan menu, pemrosesan pesanan, dan pencetakan nota.

## Cara Menggunakan

1. **Menjalankan Program**:
   - Buka terminal dan arahkan ke folder yang berisi file `RestaurantPOS.java`.
   - Jalankan perintah berikut untuk meng-compile program:
     ```bash
     javac RestaurantPOS.java
     ```
   - Kemudian, jalankan program dengan perintah:
     ```bash
     java RestaurantPOS
     ```

2. **Navigasi di Menu**:
   - Saat program dijalankan, Anda akan melihat menu utama dengan opsi untuk memproses pesanan baru atau keluar dari program.
   - Pilih "1" untuk memulai proses pemesanan.
   - Setelah memilih pesanan baru, Anda dapat:
      - **Memilih Paket** - Dengan memasukkan kode paket (misalnya, `P1` untuk Paket Rendang).
      - **Memilih Menu Satuan** - Dengan memasukkan kode menu (misalnya, `R1` untuk Rendang) dan memilih antara sepiring atau seporsi.

3. **Mencetak Nota**:
   - Setelah selesai memasukkan pesanan, pilih opsi "Selesai" untuk mencetak nota.
   - Nota akan menampilkan tanggal, detail pesanan, subtotal setiap item, dan total pembayaran.

## Contoh Menu

- **Paket Hemat**:
   - P1 - Paket Rendang (Rp 45,000): Nasi + Rendang + Gulai Nangka + Sambal
   - P2 - Paket Ayam Pop (Rp 38,000): Nasi + Ayam Pop + Gulai Daun Singkong + Sambal
   - P3 - Paket Hemat (Rp 30,000): Nasi + Telur Dadar + Gulai Nangka + Sambal

- **Lauk Utama**:
   - R1 - Rendang: Sepiring Rp 20,000 | Seporsi Rp 35,000
   - R2 - Ayam Pop: Sepiring Rp 15,000 | Seporsi Rp 28,000
   - R3 - Dendeng Balado: Sepiring Rp 18,000 | Seporsi Rp 32,000
   - R4 - Ikan Bakar: Sepiring Rp 16,000 | Seporsi Rp 30,000

- **Sayur, Sambal, dan Minuman** juga tersedia dengan variasi harga untuk sepiring dan seporsi.

## Contoh Penggunaan

Contoh input dan output dapat dilihat saat program berjalan, di mana pengguna akan memasukkan kode menu, jumlah item, dan porsi untuk pesanan satuan atau paket makanan. Program akan mencetak nota sebagai berikut:

========= **RUMAH MAKAN SIANG MALAM** =========  
**Tanggal**: dd/MM/yyyy HH:mm:ss

---

**Rendang** (Sepiring) x2  
@Rp 20,000 = Rp 40,000

**Es Teh** x1  
@Rp 5,000 = Rp 5,000

**Paket Rendang** x1  
@Rp 45,000 = Rp 45,000

---

**Total Pembayaran**: Rp 90,000

========= **Terima Kasih** =========  
Silakan Datang Kembali!


## Pengembangan Selanjutnya

Beberapa fitur yang dapat dikembangkan lebih lanjut:
- Opsi pembayaran digital.
- Sistem pengaturan stok dan notifikasi jika stok habis.
- Integrasi dengan database untuk menyimpan data pesanan harian.

## Lisensi

Proyek ini bebas digunakan dan dikembangkan dengan menyertakan atribusi kepada pembuat kode asli.


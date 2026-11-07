public class LahanTanam {
    // State lahan tanam
    private String namaLahan;
    private String namaTanaman;

    // Konstruktor sederhana: inisialisasi nama lahan dan tanaman
    public LahanTanam(String namaLahan, String namaTanaman) {
        this.namaLahan = namaLahan;
        this.namaTanaman = namaTanaman;
    }

    // Getter dan Setter
    public String getNamaLahan() {
        return namaLahan;
    }

    public void setNamaLahan(String namaLahan) {
        this.namaLahan = namaLahan;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public void setNamaTanaman(String namaTanaman) {
        this.namaTanaman = namaTanaman;
    }

    // Menampilkan informasi dasar lahan
    public void tampilkanInformasi() {
        System.out.println("Lahan   : " + namaLahan + " (" + namaTanaman + ")");
    }
}

public abstract class Alat {
    public static final String VENDOR_PERANGKAT = "NVIDIA";
    private final String nomorSeri;
    private String namaPerangkat;

    public Alat(String nomorSeri, String namaPerangkat) {
        this.nomorSeri = nomorSeri;
        this.namaPerangkat = namaPerangkat;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        this.namaPerangkat = namaPerangkat;
    }

    public abstract void prosesData();

    public void cetakInfo() {
        System.out.println("Vendor         : " + VENDOR_PERANGKAT);
        System.out.println("Nomor Seri     : " + nomorSeri);
        System.out.println("Nama Perangkat : " + namaPerangkat);
    }
}

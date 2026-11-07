public abstract class Alat {
    public static final String Vendor_Alat = "NVDIA";
    private final String nomorSeri;
    private String lokasiPemasangan;

    public Alat(String nomorSeri){
        this.nomorSeri=nomorSeri;
        this.lokasiPemasangan = "Belum dipasang";
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public String getLokasiPemasangan() {
        return lokasiPemasangan;
    }

    public void setLokasiPemasangan(String lokasiPemasangan) {
        this.lokasiPemasangan = lokasiPemasangan;
    }
    public abstract void prosesData();
    public void cetakInfo(){
        System.out.println("Vendor: "+Vendor_Alat);
        System.out.println("Nomor Seri: "+nomorSeri);
        System.out.println("Lokasi Pemasangan: "+lokasiPemasangan);

    }
}

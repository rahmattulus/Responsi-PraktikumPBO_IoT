public class PompaAir extends Alat implements Pengendali, DapatDipantau {
    private boolean statusMenyala;

    public PompaAir(String nomorSeri) {
        super(nomorSeri, "Pompa Air");
        this.statusMenyala = false;
    }

    @Override
    public void nyalakan() {
        this.statusMenyala = true;
    }

    @Override
    public void matikan() {
        this.statusMenyala = false;
    }

    @Override
    public String getStatus() {
        return statusMenyala ? "MENYALA" : "MATI";
    }

    @Override
    public void prosesData() {
        if (statusMenyala) {
            System.out.println("Pompa sedang menyiram tanaman.");
        } else {
            System.out.println("Pompa dalam kondisi siaga.");
        }
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Status Pompa   : " + getStatus());
    }

    public boolean isStatusMenyala() {
        return statusMenyala;
    }

    public void setStatusMenyala(boolean status) {
        if (status) {
            nyalakan();
        } else {
            matikan();
        }
    }
}
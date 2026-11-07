public class SensorTanah extends Alat implements DapatDipantau {
    public static final String STATUS_BELUM_DIBACA = "BELUM_DIBACA";
    public static final String STATUS_KERING = "KERING";
    public static final String STATUS_IDEAL = "IDEAL";
    public static final int BATAS_KRITIS_DEFAULT = 40;

    private int kelembapanTanah = 0;
    private int batasKritis = BATAS_KRITIS_DEFAULT;
    private String statusTanah = STATUS_BELUM_DIBACA;
    private boolean sudahDibaca = false;

    public SensorTanah(String nomorSeri) {
        super(nomorSeri, "Sensor Kelembapan Tanah");
    }

    public SensorTanah(String nomorSeri, int batasKritis) {
        super(nomorSeri, "Sensor Kelembapan Tanah");
        setBatasKritis(batasKritis);
    }

    public boolean bacaSensor(int nilai) {
        // Validasi: hanya rentang 0 - 100% yang diterima
        if (nilai < 0 || nilai > 100) {
            return false;
        }
        this.kelembapanTanah = nilai;
        this.sudahDibaca = true;
        prosesData();
        return true;
    }

    @Override
    public void prosesData() {
        if (!sudahDibaca) {
            statusTanah = STATUS_BELUM_DIBACA;
        } else if (kelembapanTanah < batasKritis) {
            statusTanah = STATUS_KERING;
        } else {
            statusTanah = STATUS_IDEAL;
        }
    }

    @Override
    public String getStatus() {
        if (!sudahDibaca) {
            return STATUS_BELUM_DIBACA;
        }
        return statusTanah + " (" + kelembapanTanah + "%)";
    }

    public boolean isKering() {
        return sudahDibaca && STATUS_KERING.equals(statusTanah);
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Batas Kritis   : " + batasKritis + "%");
        System.out.println("Status Sensor  : " + getStatus());
    }

    public int getKelembapanTanah() {
        return kelembapanTanah;
    }

    public void setKelembapanTanah(int nilai) {
        bacaSensor(nilai);
    }

    public int getBatasKritis() {
        return batasKritis;
    }

    public void setBatasKritis(int batas) {
        if (batas >= 0 && batas <= 100) {
            this.batasKritis = batas;
            prosesData();
        }
    }

    public String getStatusTanah() {
        return statusTanah;
    }

    public boolean isSudahDibaca() {
        return sudahDibaca;
    }
}
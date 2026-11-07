public class SensorTanah extends Alat implements PembacaData, PemberiPeringatan{
    private int kelembapanTanah = 0;
    private String statusTanah;
    private int batasKritis;
    private boolean sudahDibaca = false;

    public SensorTanah(String nomoSeri){
        super(nomoSeri);
    }
    public SensorTanah(String nomorSeri,String lokasi){
        super(nomorSeri);
        super.setLokasiPemasangan(lokasi);
    }

    @Override
    public void prosesData() {
        if (!sudahDibaca) {
            statusTanah = "BELUM DICHECK";
        } else if (kelembapanTanah < batasKritis) {
            statusTanah = "KERING";
        } else {
            statusTanah = "IDEAL";
        }
    }

    @Override
    public void bacaSensor(int data) {
        kelembapanTanah = data;
    }

    @Override
    public boolean cekPeringatan() {
        return true;
    }
}

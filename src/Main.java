import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LahanTanam lahan1 = new LahanTanam("Lahan Cabai", "Cabai");
        PompaAir pompa1 = new PompaAir("SN-POMPA-01");
        SensorTanah sensor1 = new SensorTanah("SN-SENSOR-01");
        LahanTanam lahan2 = new LahanTanam("Lahan Padi", "Padi");
        PompaAir pompa2 = new PompaAir("SN-POMPA-02");
        SensorTanah sensor2 = new SensorTanah("SN-SENSOR-02", 60);

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUtama();
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    menuInformasi(lahan1, sensor1, pompa1, lahan2, sensor2, pompa2);
                    break;
                case 2:
                    menuCekKelembapan(input, lahan1, sensor1, pompa1, lahan2, sensor2, pompa2);
                    break;
                case 3:
                    System.out.println("\nTerima kasih telah menggunakan Smart Farming System!");
                    berjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }

        input.close();
    }

    // Menampilkan menu CLI utama
    public static void tampilkanMenuUtama() {
        System.out.println("\n========================================");
        System.out.println("         SMART FARMING SYSTEM");
        System.out.println("     SISTEM PEMANTAUAN KELEMBAPAN");
        System.out.println("========================================");
        System.out.println("1. Lihat Informasi Lahan");
        System.out.println("2. Cek Kelembapan Tanah");
        System.out.println("3. Keluar");
        System.out.println("========================================");
    }

    // Menu 1: Menampilkan informasi kedua lahan
    public static void menuInformasi(LahanTanam lahan1, SensorTanah sensor1, PompaAir pompa1,
                                     LahanTanam lahan2, SensorTanah sensor2, PompaAir pompa2) {
        System.out.println("\n========================================");
        System.out.println("         INFORMASI SELURUH LAHAN");
        System.out.println("========================================");
        tampilkanLahanLengkap(lahan1, sensor1, pompa1);
        System.out.println();
        tampilkanLahanLengkap(lahan2, sensor2, pompa2);
        System.out.println("========================================");
    }

    // Helper untuk menampilkan data lahan, sensor, dan pompa secara terpadu
    public static void tampilkanLahanLengkap(LahanTanam lahan, SensorTanah sensor, PompaAir pompa) {
        System.out.println("--- Informasi Lahan ---");
        lahan.tampilkanInformasi();
        System.out.println("Sensor  : " + sensor.getStatus());
        System.out.println("Pompa   : " + pompa.getStatus());
    }

    // Menu 2: Pengecekan kelembapan tanah dan kontrol pompa
    public static void menuCekKelembapan(Scanner input, LahanTanam lahan1, SensorTanah sensor1, PompaAir pompa1,
                                         LahanTanam lahan2, SensorTanah sensor2, PompaAir pompa2) {
        System.out.println("\n--- CEK KELEMBAPAN TANAH ---");
        System.out.println("1. " + lahan1.getNamaLahan());
        System.out.println("2. " + lahan2.getNamaLahan());
        System.out.print("Pilih lahan (1/2): ");
        int pilihanLahan = input.nextInt();

        // Tentukan objek lahan, sensor, dan pompa yang dipilih
        LahanTanam lahan;
        SensorTanah sensor;
        PompaAir pompa;

        if (pilihanLahan == 1) {
            lahan = lahan1;
            sensor = sensor1;
            pompa = pompa1;
        } else {
            lahan = lahan2;
            sensor = sensor2;
            pompa = pompa2;
        }

        System.out.print("Masukkan kelembapan tanah (0-100): ");
        int nilai = input.nextInt();
        boolean diterima = sensor.bacaSensor(nilai);

        if (diterima) {
            System.out.println("Status tanah: " + sensor.getStatus());

            // Jika tanah kering, tawarkan menyalakan pompa
            if (sensor.isKering()) {
                System.out.println("PERINGATAN: Tanah membutuhkan air!");
                System.out.print("Nyalakan pompa air? (1. Ya / 2. Tidak): ");
                int opsiPompa = input.nextInt();

                if (opsiPompa == 1) {
                    // Persyaratan 9: Polimorfisme Interface Pengendali
                    Pengendali kontrol = pompa;
                    kontrol.nyalakan();
                    pompa.prosesData();

                    tampilkanLahanLengkap(lahan, sensor, pompa);

                    System.out.print("Ketik 1 untuk mematikan pompa: ");
                    int matikan = input.nextInt();
                    if (matikan == 1) {
                        kontrol.matikan();
                        System.out.println("Pompa dimatikan.");
                        tampilkanLahanLengkap(lahan, sensor, pompa);
                    }
                }
            }
        } else {
            System.out.println("Nilai kelembapan tidak valid (harus 0 - 100)!");
        }
    }
}

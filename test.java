import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String file = "./data_mhs.txt";
        List<Mahasiswa> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] row = line.split(", ");
                Mahasiswa m = new Mahasiswa();
                m.setNim(row[0]);
                m.setNama(row[1]);
                m.setTahun(row[2]);
                m.setBeasiswa(row[3]);

                data.add(m);
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("Total Data = " + data.size());
        System.out.println("Data Beasiswa Unggulan : ");
        for (Mahasiswa mhs : data) {
            if (mhs.getBeasiswa().equals("Beasiswa Unggulan")){
                System.out.println("NIM : " + mhs.getNim() + " Nama : " + mhs.getNama() + " Beasiswa : " + mhs.getBeasiswa());
            }
        }
    }
}

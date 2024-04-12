import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    
    public static void ghiTenMonHocVaoFile(String tenMonHoc, String maMonHoc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DsMonHoc.txt", true))) {
            writer.write(tenMonHoc + "\t-\t");
            writer.write(maMonHoc);
            writer.newLine();
            System.out.println("Ghi ten mon hoc vao file thanh cong");
        } catch (IOException e) {
            System.err.println("Loi khi ghi ten mon hoc vao file: " + e.getMessage());
        }
    }

   
    public static void ghiTenDeCuongVaoFile(String tenDeCuong,String heDaoTao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DsDeCuong.txt", true))) {
            writer.write(tenDeCuong + "\t-\t");
            writer.write(heDaoTao);
            writer.newLine();
            System.out.println("Ghi ten de cuong vao file thanh cong");
        } catch (IOException e) {
            System.err.println("Loi khi ghi ten de cuong vao file: " + e.getMessage());
        }
    }

    public static void ghiTenNganhVaoFile(String tenNganh, String heDaoTao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DsNganh.txt", true))) {
            writer.write(tenNganh + "\t-\t");
            writer.write(heDaoTao);
            writer.newLine();
            System.out.println("Ghi ten nganh vao file thanh cong");
        } catch (IOException e) {
            System.err.println("Loi khi ghi ten nganh vao file: " + e.getMessage());
        }
    }

    public static void ghiTenGiaoVienVaoFile(String tenGiaoVien) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DsGiangVien.txt", true))) {
            writer.write(tenGiaoVien);
            writer.newLine();
            System.out.println("Ghi ten giao vien vao file thanh cong");
        } catch (IOException e) {
            System.err.println("Loi khi ghi ten giao vien vao file: " + e.getMessage());
        }
    }
}

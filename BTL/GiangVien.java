import java.util.ArrayList;
import java.util.List;

public class GiangVien {
    private static int count;
    private String tenGv;
    private String maGv;
    
    private List<DeCuong> dsDeCuongCuaGv = new ArrayList<>();

    {
        this.maGv = "GV" + String.format("%03d", ++count);
    }

    public String getTenGv() {
        return tenGv;
    }

    public GiangVien(String tenGv) {
        this.tenGv = tenGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }

    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public List<DeCuong> getDsDeCuongCuaGv() {
        return dsDeCuongCuaGv;
    }

    public void setDsDeCuongCuaGv(List<DeCuong> dsDeCuongCuaGv) {
        this.dsDeCuongCuaGv = dsDeCuongCuaGv;
    }

    public void xuatThongTin(){
        System.out.printf("Ten giang vien: %s\n", this.tenGv);
        System.out.printf("Ma giang vien: %s\n", this.maGv);
        System.out.println();
    }

    public void addDeCuong(DeCuong... dc){
        dsDeCuongCuaGv.addAll(List.of(dc));
    }

    public void removeDeCuong(DeCuong... dc){
        dsDeCuongCuaGv.removeAll(List.of(dc));
    }

    public void hienThiDanhSachDc(){
        this.dsDeCuongCuaGv.forEach(s -> s.hienThiDeCuongOfGv());
    }
}

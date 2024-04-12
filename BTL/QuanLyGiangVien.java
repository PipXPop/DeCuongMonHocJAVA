import java.util.ArrayList;
import java.util.List;

public class QuanLyGiangVien extends QuanLy<GiangVien> {
    private List<GiangVien> dsGiangVien = new ArrayList<>(); 
    public void add(GiangVien... gv){
        dsGiangVien.addAll(List.of(gv));
    }

    public void remove(GiangVien... gv){
        dsGiangVien.removeAll(List.of(gv));
    }

    public void find(String s){
        List<GiangVien> danhSachTimKiem = new ArrayList<>();
        for (GiangVien x : dsGiangVien) {
            if (x.getTenGv().contains(s) || x.getMaGv().contains(s))
                danhSachTimKiem.add(x);
        }

        if (danhSachTimKiem.isEmpty()) {
            System.out.println("\nKhong tim thay giang vien nao.");
        } else {
            System.out.println("\nDanh sach tim kiem:     ");
            for (var x : danhSachTimKiem) {
                x.xuatThongTin();
                System.out.println();
            }
        }
    }

    public List<GiangVien> getDsGiangVien() {
        return dsGiangVien;
    }

    public void setDsGiangVien(List<GiangVien> dsGiangVien) {
        this.dsGiangVien = dsGiangVien;
    }

    public void hienThiDanhSach(){
        this.dsGiangVien.forEach(s -> s.xuatThongTin());
    }

    public GiangVien tim(String s){
        GiangVien d = null;
        for(GiangVien x :dsGiangVien)
            if(x.getTenGv().equals(s) || x.getMaGv().equals(s))
                return x;
        return d;
    }
}

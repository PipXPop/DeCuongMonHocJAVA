import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuanLyDeCuong extends QuanLy<DeCuong> {

    private List<DeCuong> dsDeCuong = new ArrayList<>();

    @Override
    public void add(DeCuong... dc) {
        dsDeCuong.addAll(List.of(dc));
    }

    @Override
    public void find(String s) {
        List<DeCuong> danhSachTimKiem = new ArrayList<>();
        for (DeCuong x : dsDeCuong) {
            if (x.getMoTaMonHoc().getMaMonHoc().contains(s) || x.getTenMonHoc().contains(s))
                danhSachTimKiem.add(x);
        }

        if (danhSachTimKiem.isEmpty()) {
            System.out.println("\nKhong tim thay giang vien nao.");
        } else {
            System.out.println("\nDanh sach tim kiem:     ");
            for (var x : danhSachTimKiem) {
                if(x.getHeDaoTao()!=null){
                    System.out.printf("Ten mon thuoc thuoc de cuong: %s\t", x.getTenMonHoc());
                    System.out.printf("He dao tao: %s", x.getHeDaoTao().name());
                    System.out.println();
                }
            }
                
        }
    }

    @Override
    public void remove(DeCuong... dc) {
        dsDeCuong.removeAll(List.of(dc));
    }

    @Override
    public void hienThiDanhSach() {
        System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s", "Ten Mon Hoc", "Ma Mon Hoc", "He Dao Tao",
                "Nganh", "So tin chi"));

        this.dsDeCuong.forEach(s -> s.xuatThongTin());
    }

    public List<DeCuong> dsDCGiamDanSoTinChi() {
        List<DeCuong> dsGiamDan = this.dsDeCuong;
        Collections.sort(dsGiamDan);
        return dsGiamDan;
    }

    public DeCuong tim(String s,String h) {
        DeCuong d = null;
        for (DeCuong x : this.dsDeCuong)
            if ((x.getTenMonHoc().equals(s) || x.getMaMonHoc().equals(s)) && x.getHeDaoTao()!=null && x.getHeDaoTao().name().equals(h))
                    return x;
        return d;
    }

    public DeCuong tim(String s, HeDaoTao h) {
        
        for (DeCuong x : this.dsDeCuong)
            if ((x.getTenMonHoc().equals(s) || x.getMaMonHoc().equals(s)) && x.getHeDaoTao()==null){
                return this.layDc(this.timViTri(dsDeCuong, x));
            } 
        return null;
    }

    // public DeCuong tim2(String s, HeDaoTao h) {
        
    //     for (DeCuong x : this.dsDeCuong)
    //         if ((x.getTenMonHoc().equals(s) || x.getMaMonHoc().equals(s)) && x.getHeDaoTao()!=null && x.getHeDaoTao()==h){
    //             return this.layDc(this.timViTri(dsDeCuong, x));
    //         } 
    //     return null;
    // }

    public <T> int timViTri(List<T> danhSach, T phanTu) {
        return danhSach.indexOf(phanTu);
    }

    public DeCuong layDc(int stt){
        return this.getDsDeCuong().get(stt);
    }

    public DeCuong tim(String s) {
        DeCuong d = null;
        for (DeCuong x : this.dsDeCuong)
            if (x.getTenMonHoc().equals(s) || x.getMaMonHoc().equals(s))
                return x;
        return d;
    }

    // hỏi nhập số tín
    // cho xuất ra, nếu dsDeCuongTheoSoTin không có cái nào thì xuất ra kh có và kêu
    // enter hay gì đó
    public List<DeCuong> dsDeCuongTheoSoTinChi(int x) {
        List<DeCuong> dsDeCuongTheoSoTin = new ArrayList<>();
        for (DeCuong d : dsDeCuong) {
            if (d.getMoTaMonHoc().getTongSoTinChi() == x)
                dsDeCuongTheoSoTin.add(d);
        }
        return dsDeCuongTheoSoTin;
    }

    public List<DeCuong> getDsDeCuong() {
        return dsDeCuong;
    }

    public void setDsDeCuong(List<DeCuong> dsDeCuong) {
        this.dsDeCuong = dsDeCuong;
    }

    public void ds_MHlaMH_TQ_or_LT(String maMH) {// nay la mon hoc
        // la mon hoc tien quyet
        List<DeCuong> resulfTQ = new ArrayList<DeCuong>();
        List<DeCuong> resulfTruoc = new ArrayList<DeCuong>();
        for (DeCuong a : this.dsDeCuong) {// lay cai dc ra mon a
            for (DeCuong b : a.getTQ()) { // lay ds mh tien quyet ra
                if (b.getMaMonHoc() == maMH) {// xem trong ds mh tq do co mon do kh-> neu co ->
                    resulfTQ.addAll(Arrays.asList(a));//
                }
            }
            for (DeCuong b : a.getHTruoc()) {
                if (b.getMaMonHoc() == maMH) {
                    resulfTruoc.addAll(Arrays.asList(a));
                }
            }
        }
        if (resulfTQ != null) {
            System.out.println("Ds cac mon la mon Tien Quyet");
            resulfTQ.forEach(s -> s.xuatThongTin());
        } else
            System.out.println("Mon Nay khong nam trong mh tien quyet nao");

        if (resulfTruoc != null) {
            System.out.println("Ds cac mon la mon Truoc");
            resulfTruoc.forEach(s -> s.xuatThongTin());
        } else
            System.out.println("Mon Nay khong nam trong mon hoc truoc nao");
    }
    
    
    

}

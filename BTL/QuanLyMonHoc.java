import java.util.ArrayList;
import java.util.List;

public class QuanLyMonHoc extends QuanLy<MonHoc> {
    private List<MonHoc> dsMonHoc = new ArrayList<>();

    @Override
    public void add(MonHoc... mh) {
        dsMonHoc.addAll(List.of(mh));
        
    }

    @Override
    public void find(String s) {
        List<MonHoc> danhSachTimKiem = new ArrayList<>();
        for (MonHoc x : dsMonHoc) {
            if (x.getTenMonHoc().contains(s) || x.getMoTaMonHoc().getMaMonHoc().contains(s))
                danhSachTimKiem.add(x);
        }

        if (danhSachTimKiem.isEmpty()) {
            System.out.println("\nKhong tim thay mon hoc nao nao.");
        } else {
            System.out.println("\nDanh sach tim kiem:     ");
            for (var x : danhSachTimKiem) {
                x.xuatThongTin();
                System.out.println();
            }
        }
    }

    @Override
    public void hienThiDanhSach() {
        this.dsMonHoc.forEach(s -> s.xuatThongTin());
    }

    @Override
    public void remove(MonHoc... mh) {
        dsMonHoc.removeAll(List.of(mh));
    }

    public List<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(List<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public MonHoc tim(String s){
        MonHoc d = null;
        for(MonHoc x :dsMonHoc)
            if(x.getTenMonHoc().equals(s)||x.getMaMonHoc().equals(s))
                return x;
        return d;
    }
}

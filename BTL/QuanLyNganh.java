import java.util.ArrayList;
import java.util.List;

public class QuanLyNganh extends QuanLy<Nganh>{
    private List<Nganh> dsNganh = new ArrayList<>();
    
    @Override
    public void add(Nganh... t) {
        dsNganh.addAll(List.of(t));
    }

    @Override
    public void remove(Nganh... t) {
        dsNganh.removeAll(List.of(t));
    }
    
    @Override
    public void find(String s) {
        List<Nganh> danhSachTimKiem = new ArrayList<>();
        for (Nganh x : dsNganh) {
            if (x.getTenNganh().contains(s))
                danhSachTimKiem.add(x);
        }

        if (danhSachTimKiem.isEmpty()) {
            System.out.println("\nKhong tim thay nganh nao nao.");
        } else {
            System.out.println("\nDanh sach tim kiem:     ");
            for (var x : danhSachTimKiem) {
                x.hienThiNganh();
                System.out.println();
            }
        }
    }

    @Override
    public void hienThiDanhSach() {
        this.dsNganh.forEach(s -> s.hienThiNganh());
    }

    public List<Nganh> getDsNganh() {
        return dsNganh;
    }

    public void setDsNganh(List<Nganh> dsNganh) {
        this.dsNganh = dsNganh;
    }

    public Nganh tim(String s){
        Nganh d = null;
        for(Nganh x :dsNganh)
            if(x.getTenNganh().equals(s))
                return x;
        return d;
    }
    
}

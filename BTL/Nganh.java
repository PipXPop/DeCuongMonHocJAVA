import java.util.ArrayList;
import java.util.List;

public class Nganh {
    private String tenNganh;
    private List<MonHoc> dsMonHoc = new ArrayList<>();
    private HeDaoTao heDaoTao;

    public Nganh(String tenNganh,HeDaoTao heDaoTao) {
        this.tenNganh = tenNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public List<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public Nganh(String ten){
        this.tenNganh = ten;
    }
    public void setDsMonHoc(List<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public Nganh(String tenNganh, List<MonHoc> dsMonHoc) {
        this.tenNganh = tenNganh;
        this.dsMonHoc = dsMonHoc;
    }

    public void addDsMonHoc(MonHoc mh){
        dsMonHoc.addAll(List.of(mh));
    }

    public void hienThiNganh(){
        System.out.println(this.tenNganh);
        System.out.println(this.heDaoTao.name());
        System.out.println();
    }

    public void hienThiDsMonHoc(){
        System.out.printf("Danh sach mon hoc cua nganh %s :", this.tenNganh);
        this.dsMonHoc.forEach(s -> s.hienThiMonHoc());
    }

    
}

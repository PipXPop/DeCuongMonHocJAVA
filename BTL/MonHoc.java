import java.util.ArrayList;
import java.util.List;

public class MonHoc {
    
    private String tenMonHoc; 
    private MoTaMonHoc moTaMonHoc;
    private List<Nganh> dsNganh= new ArrayList<Nganh>();

    public MonHoc(String tenMonHoc, MoTaMonHoc moTaMonHoc) {
        this.tenMonHoc = tenMonHoc;
        this.moTaMonHoc = moTaMonHoc;
    }

    public MonHoc() {
    }

    public MonHoc(String ten3) {
        this.tenMonHoc = ten3;
    }

    public void hienThi(){
        System.out.printf("Ten mon hoc: %s\n", this.tenMonHoc);
        System.out.printf("Mo ta mon hoc: %s\n", this.moTaMonHoc);
        System.out.printf("Tin chi: %s\n", this.moTaMonHoc.hienThiTinChi());
        System.out.println("Cac nganh: ");
        this.dsNganh.forEach(s -> s.hienThiNganh());
    }

    public void hienThiDeCuong(){
        System.out.printf("Ten mon hoc: %s\n", this.tenMonHoc);
        System.out.printf("Ma mon hoc: %s\n", this.moTaMonHoc.getMaMonHoc());
        System.out.printf("Tin chi: %s\n",this.moTaMonHoc.hienThiTinChi());
    }

    public void hienThiMonHoc(){
        System.out.println(this.tenMonHoc);
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaMonHoc() {
        return this.moTaMonHoc.getMaMonHoc();
    }

    public void setMoTaMonHoc(MoTaMonHoc moTaMonHoc) {
        this.moTaMonHoc = moTaMonHoc;
    }

    public List<Nganh> getDsNganh() {
        return dsNganh;
    }

    public void setDsNganh(List<Nganh> dsNganh) {
        this.dsNganh = dsNganh;
    }

    public void xuatThongTin(){
        System.out.printf("Ten mon hoc: %s\n", this.getTenMonHoc());
        System.out.printf("Ma mon hoc: %s\n", this.getMaMonHoc());
        System.out.println();
    }

    public MoTaMonHoc getMoTaMonHoc(){
        return moTaMonHoc;
    }

    
    
}

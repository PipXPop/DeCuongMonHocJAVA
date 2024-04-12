import java.util.ArrayList;
import java.util.List;

public class DeCuong extends MonHoc implements Comparable<DeCuong> {
    private List<DeCuong> dsMonHocTruoc = new ArrayList<>();
    private List<DeCuong> dsMonHocTienQuyet = new ArrayList<>();
    private MucTieuMonHoc mucTieu;
    private Nganh nganh;
    private GiangVien gv;
    
    public MucTieuMonHoc getMucTieu() {
        return mucTieu;
    }
    public DeCuong(String s, MoTaMonHoc m){
        this.setTenMonHoc(s);
        this.setMoTaMonHoc(m);
    }
    public void setMucTieu(MucTieuMonHoc mucTieu) {
        this.mucTieu = mucTieu;
    }
    public DeCuong(String s){
        this.setTenMonHoc(s);
    }
    public Nganh getNganh() {
        return nganh;
    }



    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public GiangVien getGv() {
        return gv;
    }

    public void setGv(GiangVien gv) {
        this.gv = gv;
    }

    private HeDaoTao heDaoTao;

    public DeCuong() {}

    public void hienThiDeCuong(){
        super.hienThiDeCuong();
        System.out.printf("%s\n", this.getMucTieu().toStringMucTieuMonHoc());
        System.out.printf("He dao tao: %s\n", this.getHeDaoTao().name());
        System.out.printf("Nganh: %s\n", this.getNganh().getTenNganh());
        System.out.printf("Giang vien phu trach: %s\n", this.getGv().getTenGv());  
        System.out.println("Cac mon hoc truoc:\n");
        this.dsMonHocTruoc.forEach(s -> s.xuatThongTin());
        System.out.println("Cac mon hoc tien quyet:\n");
        this.dsMonHocTienQuyet.forEach(s -> s.xuatThongTin());
        System.out.println("---------------------------------------------------------------------------------------------------------------------");  
    }

    public DeCuong(HeDaoTao heDaoTao, Nganh nganh, GiangVien gv) {
        this.heDaoTao = heDaoTao;
        this.nganh = nganh;
        this.gv = gv;
    }

    // public DeCuong(MonHoc mh2, HeDaoTao heDaoTao, Nganh nganh, GiangVien gv) {
    //     this.monHoc = mh2;
    //     this.heDaoTao = heDaoTao;
    //     this.nganh = nganh;
    //     this.gv = gv;
    // }
    // public String inMonHoc(List<DeCuong> s){
    //     String a;
    //     return String.format(getMaMonHoc(), null)
    // }

    public void setHeDaoTao(HeDaoTao heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public HeDaoTao getHeDaoTao() {
        return heDaoTao;
    }

    public void xuatThongTin(){
        if(this.getHeDaoTao()!=null&&this.getNganh()!=null&&this.getMucTieu()!=null)
            System.out.printf("%-25s%-25s%-25s%-25s%-25d\n", this.getTenMonHoc(),this.getMaMonHoc(),this.getHeDaoTao().name(),this.nganh.getTenNganh(),this.getMoTaMonHoc().getTongSoTinChi());
        
    }

    public void addMonHocTruoc(DeCuong... mh){
        dsMonHocTruoc.addAll(List.of(mh));
    }

    public void addMonHocTienQuyet(DeCuong... mh){
        dsMonHocTienQuyet.addAll(List.of(mh));
    }

    public int compareTo(DeCuong other) {
        //sapxep so tin chi giam dan
        int ssTinChi = Integer.compare(this.getMoTaMonHoc().getTongSoTinChi(), other.getMoTaMonHoc().getTongSoTinChi());
        if(ssTinChi != 0){
            return ssTinChi;
        }
        //sapseptheo ma mon hoc
        return this.getMoTaMonHoc().getMaMonHoc().compareTo(other.getMoTaMonHoc().getMaMonHoc());
    }

    public void hienThiDeCuongOfGv(){
        System.out.println(this.getTenMonHoc());
        System.out.println();
    }
    
    public List<DeCuong> getTQ(){
        return this.dsMonHocTienQuyet;
    }

    public List<DeCuong> getHTruoc(){
        return dsMonHocTruoc;
    }

    
}

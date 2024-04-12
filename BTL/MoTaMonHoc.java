import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoTaMonHoc {
    private static int count;
    private String moTaMonHoc;
    private List<LoaiTinChi> tinChi = new ArrayList<>();
    private String maMonHoc;

    {
        this.maMonHoc= String.format("%03d", ++count);
    }
    
    public String getMoTaMonHoc() {
        return moTaMonHoc;
    }

    public void setMoTaMonHoc(String moTaMonHoc) {
        this.moTaMonHoc = moTaMonHoc;
    }

    public List<LoaiTinChi> getTinChi() {
        return tinChi;
    }

    public void setTinChi(List<LoaiTinChi> tinChi) {
        this.tinChi = tinChi;
    }

   

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public MoTaMonHoc() {
    }

    public MoTaMonHoc(String moTaMonHoc, LoaiTinChi... loaiTinChi) {
        this.tinChi.addAll(Arrays.asList(loaiTinChi));
        this.moTaMonHoc = moTaMonHoc;
    }

    public int getTongSoTinChi() {
        int a = 0;
        for (LoaiTinChi motloaitinchi : this.tinChi) {
            a += motloaitinchi.getSoTinChi();
        }
        return a;
    }

    public String tongSoTinChi() {
        return String.format("Tong so tin chi: %d", this.getTongSoTinChi());
    }

    public String hienThiTinChi() {
        String a = new String(this.tongSoTinChi()) + "\n";
        for (LoaiTinChi t : this.tinChi) {
            a += t.toString() + "\n";
        }
        return a;
    }
}

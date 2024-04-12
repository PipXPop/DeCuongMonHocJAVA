public class LoaiTinChi {
    private String tenTinChi;
    private int soTinChi;

    public String getTenTinChi() {
        return tenTinChi;
    }

    public void setTenTinChi(String tenTinChi) {
        this.tenTinChi = tenTinChi;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public LoaiTinChi(String tenTinChi, int soTinChi) {
        this.tenTinChi = tenTinChi;
        this.soTinChi = soTinChi;
    }

    public String toString() {
        return String.format("%s: %d", this.tenTinChi, this.soTinChi);
    }
}

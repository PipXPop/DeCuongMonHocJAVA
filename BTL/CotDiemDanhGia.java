public class CotDiemDanhGia {
    String tenCotDiem;
    String pPDanhGia;
    String nDDanhGia;

    //getter setter
    public String getTenCotDiem() {
        return this.tenCotDiem;
    }
    public String getpPDanhGia() {
        return this.pPDanhGia;
    }
    public String getnDdanhGia() {
        return this.nDDanhGia;
    }
    public void setTenCotDiem(String tenCotDiem) {
        this.tenCotDiem = tenCotDiem;
    }

    public void setpPDanhGia(String pPDanhGia) {
        this.pPDanhGia = pPDanhGia;
    }

    public void setnDDanhGia(String nDDanhGia) {
        this.nDDanhGia = nDDanhGia;
    }

    //constructor
    public CotDiemDanhGia(){}
    
    public CotDiemDanhGia(String ten, String pP, String nD){
        this.tenCotDiem = ten;
        this.pPDanhGia = pP;
        this.nDDanhGia = nD;
    }


    
}

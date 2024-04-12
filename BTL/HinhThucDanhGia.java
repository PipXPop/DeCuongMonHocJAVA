public class HinhThucDanhGia extends CotDiemDanhGia{

	private int tiTrong;//don vi %

	public HinhThucDanhGia(){}

	public HinhThucDanhGia (String tenCotDiem, String pPDanhGia, String nDDanhGia, int tiTrong){
		this.tenCotDiem = tenCotDiem;
		this.pPDanhGia = pPDanhGia;
		this.nDDanhGia = nDDanhGia;
		this.tiTrong = tiTrong;
	}
	
	//getter setter
	public String getTenCotDiem() {
		return this.tenCotDiem;
	}

	public String getpPDanhGia() {
		return this.pPDanhGia;
	}

	public String getnDDanhGia(){
		return this.nDDanhGia;
	}

	public int getTiTrong() {
		return this.tiTrong;
	}
	
	public void setTiTrong(int tiTrong) {
		this.tiTrong = tiTrong;
	}

	public String toStringHinhThucDanhGia(){
		String a = String.format("%-25s%-50s%-50s%-25s\n","Ten cot diem","Phuong phap danh gia", "Noi dung danh gia","Ti trong(%)");
		return a + String.format("  %-25s%-50s%-50s%-25d\n",this.getTenCotDiem(),this.getpPDanhGia(), this.getnDdanhGia(),this.getTiTrong());
	}

	public void Menu(int stt){
		System.out.println("\nThao tac voi Hinh Thuc Danh Gia: So " + stt);
		System.out.println(toStringHinhThucDanhGia());
		System.out.println("\t 1) Doi ten cot diem");
		System.out.println("\t 2) Doi pp danh gia");
		System.out.println("\t 3) Doi nD danh gia");
		System.out.println("\t 4) Doi ti trong diem");
		System.out.println("\t 5) Thoat");
	}

}

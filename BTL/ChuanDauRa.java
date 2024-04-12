import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChuanDauRa {

	private List<HinhThucDanhGia> cacHinhThucDG = new ArrayList<HinhThucDanhGia>();

	private double diemChuanDauRa;
//constructor
	public ChuanDauRa(){}

	public ChuanDauRa(double diemChuanDauRa, HinhThucDanhGia...hinhThucDG){
		this.diemChuanDauRa = diemChuanDauRa;
		this.addHinhThuoc(hinhThucDG);
	}
///add
	public void addHinhThuoc(HinhThucDanhGia ... hinhThucDG) {
		this.cacHinhThucDG.addAll(Arrays.asList(hinhThucDG));
	}
//getter
	public List<HinhThucDanhGia> getCacHinhThucDG() {
		return this.cacHinhThucDG;
	}

	public double getDiemChuanDauRa() {
		return this.diemChuanDauRa;
	}

	public void setDiemChuanDauRa(double diemChuan){
		this.diemChuanDauRa = diemChuan;
	}

	public void sapXepHTDG(){
		Collections.sort(this.cacHinhThucDG, Comparator.comparing(HinhThucDanhGia:: getTiTrong).thenComparing(HinhThucDanhGia:: getTenCotDiem));
	}

	public String toStringChuanDauRa(){
		String a = new String("================================================ Danh Sach Cac Hinh Thuc Danh Gia ================================================\n");
		String a2= new String("==================================================================================================================================\n");
		a += String.format("%-25s%-50s%-50s%-25s\n","Ten cot diem","Phuong phap danh gia", "Noi dung danh gia","Ti trong(%)");
		String b = new String();
		int dem = 0;
		this.sapXepHTDG();
		for(HinhThucDanhGia i : this.getCacHinhThucDG()){
			dem++;// a += " " + i.getTenCotDiem() + "\t\t\t" + i.getpPDanhGia() + "\t\t\t" + i.getnDdanhGia() + "\t\t\t" + i.getTiTrong() + "%\n";
			b += String.format("%d) %-25s%-50s%-50s%-25d\n",dem,i.getTenCotDiem(),i.getpPDanhGia(), i.getnDdanhGia(),i.getTiTrong());
		}
		return a + b +a2;
	}
}

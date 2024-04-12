
public class MucTieuMonHoc extends ChuanDauRa {

	private String mucTieuMH;
	//constructor
	public MucTieuMonHoc(){}

	public MucTieuMonHoc(String mucTieuMH, double diemchuan, HinhThucDanhGia ... HTDG){
		super(diemchuan, HTDG);
		this.mucTieuMH = mucTieuMH;
	}

	
	//getters and setters
	public String getMucTieuMH(){
		return this.mucTieuMH;
	}

	public int getTongTiLe(){
		int tiTrong = 0;
		for(HinhThucDanhGia a : this.getCacHinhThucDG()){
			tiTrong += a.getTiTrong();
		}
		return tiTrong;
	}

	public int getTongTiLe_Sau(int stt, int titrongmoinhap){
		int tiTrong = 0;
		int dem = 0;
		for(HinhThucDanhGia a : this.getCacHinhThucDG()){
			dem++;
			if(dem == stt){
				tiTrong += titrongmoinhap;
			} else{
				tiTrong += a.getTiTrong();
			}
		}
		return tiTrong;
	}

	public void setMucTieuMonHoc(String mucTieuMonHoc){
		this.mucTieuMH = mucTieuMonHoc;
	}
	////
	public String toStringMucTieuMonHoc(){
		String resuft = String.format("Muc tieu mon hoc: %s\nDiem Chuan dau ra: %.2f\n",this.mucTieuMH,this.getDiemChuanDauRa());
		return resuft + this.toStringChuanDauRa();
	}

	////ham check 
	public boolean SL_hinhThucToiThieu(){//
		if(this.getCacHinhThucDG().size() == 2 ){
			return false;
		}
		return true;
	}

	public boolean SL_hinhThucToiDa(){
		if(this.getCacHinhThucDG().size() == 4 ){
			return true;
		}
		return false;
	}

	public Boolean checkTiTrongDiemTruoc(){//trc khi them va sua
		if(this.getTongTiLe() == 100){
			return false;//da du ti trong
		}
		return true;//chua du ti trong < 100
	}

	public Boolean checkTiTrongDiemSau(int stt, int titrongmoinhap){/// sau khi them va sua
		if(this.getTongTiLe_Sau(stt, titrongmoinhap) > 100){
			System.out.println("Ti trong vua nhap lam tong ti trong vuc qua 100%, ban van muon giu no?");
			if(CauHinh.banChacChua() == 1)
				return true;//da du ti trong
			else 
				return false;//chua du ti trong
		}
		return true;//chua du ti trong < 100
	}
	//canrh bao
	public boolean Warming4(){
		if(this.SL_hinhThucToiDa()){
			System.out.println("So luong hinh thuc danh gia da dat toi da(4)");
			System.out.println("Vui long xoa hoac sua doi Hinh Thuc Danh Gia");
			return true;
		}
		return false;//chua du ti trong
	}

	public boolean Warming2(){
		if(this.SL_hinhThucToiDa()){
			System.out.println("So luong hinh thuc danh gia hien tai da dat so luong toi thieu, khong the xoa");
			System.out.println("Vui long Them hoac sua doi Hinh Thuc Danh Gia");
			return true;
		}
		return false;//chua du ti trong
	}
	//ca ham chuc nang
	public void xoaHinhThuc(HinhThucDanhGia HTDG){
		System.out.println(HTDG.toStringHinhThucDanhGia());
		System.out.print("Ban co chac muon xoa Hinh Thuc Nay: ");
		if(CauHinh.banChacChua() == 1){
			this.getCacHinhThucDG().remove(HTDG);
		}
	}

	public void them(){
		System.out.println("Nhap cac thong tin co ban: ");
		System.out.print("Ten cot diem: "); String ten = CauHinh.sc.nextLine();
		System.out.print("Phuong Phap Danh Gia: "); String pp = CauHinh.sc.nextLine();
		System.out.print("Noi Dung Can Danh Gia: "); String nd = CauHinh.sc.nextLine();
		int titrong = -1;
		do{
			try{
				System.out.print("Nhap ti trong cua cot diem nay: ");
				titrong = Math.abs(Integer.parseInt(CauHinh.sc.nextLine()));
			}catch(NumberFormatException e){
				System.out.println("Nhap khong hop le, nhap lai");
				titrong = -1;
			}
			if(this.getTongTiLe() + titrong > 100){
				System.out.println("Ti trong vua them vuot qua 100%, ban co muon tiep tuc khong");
				if(CauHinh.banChacChua() != 1){
					break;
				}
			}
			if(titrong > 0){
				HinhThucDanhGia HTDG = new HinhThucDanhGia(ten,pp,nd,titrong);
				this.addHinhThuoc(HTDG);
				System.out.println("Nhap Them thanh cong!!!!");
			}
		} while (titrong == -1);
	}

	public int chonHinhThucDanhGia(){
		System.out.println(this.toStringChuanDauRa());
		System.out.print("Chon ra hinh thuc ban muon (nhap 0 de thoat): ");
		int stt = -1;
			try{
				stt = Math.abs(Integer.parseInt(CauHinh.sc.nextLine()));
				try{
					this.getCacHinhThucDG().get(stt-1);
				}catch (IndexOutOfBoundsException e) {
					System.out.println("Error: nhap STT khong co trong Danh Sach HTDG");
					return this.chonHinhThucDanhGia();
				}
			}catch(NumberFormatException e){
				System.out.println("Error: nhap STT khong co");
				return this.chonHinhThucDanhGia();
			}
			return stt;
	}

	public HinhThucDanhGia LayHinhThucDanhGia(int stt){
		return this.getCacHinhThucDG().get(stt-1);
	}

	public boolean isCheckNull(){
		if(this.getCacHinhThucDG() == null){
			return true;
		}
		return false;
	}

	public void Menu(){
			System.out.println("\nHay Chon thao tac voi Muc Tieu Mon Hoc: ");
			System.out.println("\t 1) Sua Muc Tieu mon Hoc");
			System.out.println("\t 2) Them Hinh Thuc Danh Gia");
			System.out.println("\t 3) Thay doi Hinh Thuc Danh Gia");
			System.out.println("\t 4) Xoa Hinh Thuc Danh Gia");
			System.out.println("\t 5) Thay doi Diem Chuan cua mon hoc");
			System.out.println("\t 6) Thoat");
		}
//thao tac voi muc tieu mon hoc
	public void ThaoTac(){
		int Stop = -1;
		do{
			CauHinh.cls();
			System.out.println(this.toStringMucTieuMonHoc());
			Menu();
			int choice = CauHinh.Choice(6);
			switch (choice) {
				case 1:
					CauHinh.cls();
					System.out.println(this.getMucTieuMH());
					System.out.println("Ban da chon doi Muc Tieu Mon Hoc: ");
					System.out.print("Hay nhap Muc Tieu Mon Hoc moi: ");
					String a = CauHinh.sc.nextLine();
					System.out.println("Ban chac rang muon thay doi Muc Tieu Mon Hoc khong?");
					if(CauHinh.banChacChua()== 1){
						this.setMucTieuMonHoc(a);
						break;
					}
					break;
				case 2:
					if(this.Warming4()){
						break;
					}
					this.them();
					break;
				case 3:
					int stt3 = this.chonHinhThucDanhGia();
					if(stt3 != 0){
						this.ThaoTac1(this.LayHinhThucDanhGia(stt3), stt3);
					}
					break;
				case 4:
					if(this.isCheckNull()){
						System.out.println("Danh sach rong!");
						break;
					}

					if(this.Warming2()){
						break;
					}
					int stt4 = this.chonHinhThucDanhGia();
					if(stt4==0)
						break;
					this.xoaHinhThuc(this.LayHinhThucDanhGia(stt4));
					break;
				case 5:
					CauHinh.cls();
					System.out.println(this.getMucTieuMH());
					System.out.println("Ban da chon Doi Diem Chuan Dau Ra: ");
					System.out.print("Hay nhap Diem Chuan Dau Ra moi: ");
					double a5 = Double.parseDouble(CauHinh.sc.nextLine());
					System.out.printf("Ban chac rang muon thay doi Diem Chuan Dau Ra, tu (%f) thanh (%f) khong?", this.getDiemChuanDauRa(), a5);
					if(CauHinh.banChacChua()== 1){
						this.setDiemChuanDauRa(a5);
						break;
					}
					break;
				case 6:
					System.out.println("Thoat Chuong Trinh");
					Stop = 2;
					break;
				default:
					CauHinh.cls();
					System.out.println("So Nhap Khong hop le, vui long chon lai");
					break;
			}
		}while(Stop == -1);
	}
/// thao tac hinh thuc danh gia
    public void ThaoTac1(HinhThucDanhGia HTDG,int stt){
		int stop = 1;
		do{
			System.out.print(this.toStringChuanDauRa());
			HTDG.Menu(stt);
			int choice = CauHinh.Choice(5);
			switch (choice) {
				case 1:
					CauHinh.cls();
					System.out.println(HTDG.toStringHinhThucDanhGia());
					System.out.println("Ban da chon doi ten cot diem: ");
					System.out.print("Hay nhap ten cot diem moi: ");
					String x = CauHinh.sc.nextLine();
					System.out.printf("Ban co chac muon doi (%s) thanh (%s) hay khong\n", HTDG.getTenCotDiem(), x);
					if(CauHinh.banChacChua()==1){
						HTDG.setTenCotDiem(x);
						CauHinh.cls();
						break;
					}
					break;
				case 2:
					CauHinh.cls();
					System.out.println(HTDG.toStringHinhThucDanhGia());
					System.out.println("Ban da chon doi phuong phap danh gia: ");
					System.out.print("Hay nhap phuong phap danh gia moi: ");
					String y = CauHinh.sc.nextLine();
					System.out.printf("Ban co chac muon doi phuong phap danh gia (%s) thanh (%s) hay khong\n", HTDG.getpPDanhGia(), y);
					if(CauHinh.banChacChua()==1){
						HTDG.setpPDanhGia(y);
						CauHinh.cls();
						break;
					}
					break;

				case 3:
					CauHinh.cls();
					System.out.println(HTDG.toStringHinhThucDanhGia());
					System.out.println("Ban da chon doi noi dung danh gia: ");
					System.out.print("Hay nhap phuong phap danh gia moi: ");
					String z = CauHinh.sc.nextLine();
					System.out.printf("Ban co chac muon doi phuong phap danh gia (%s) thanh (%s) hay khong\n", HTDG.getnDDanhGia(), z);
					if(CauHinh.banChacChua()== 1){
						HTDG.setnDDanhGia(z);
						CauHinh.cls();
						break;
					}
					break;

				case 4:
					CauHinh.cls();
					System.out.println(HTDG.toStringHinhThucDanhGia());
					System.out.println("Ban da chon doi ti trong cua hinh thuc danh gia: ");
					System.out.print("Hay nhap ti trong moi: ");
					String t = CauHinh.sc.nextLine();
					System.out.printf("Ban co chac muon doi ti trong diem (%s) thanh (%s) hay khong\n", HTDG.getTiTrong(), t);
					if(CauHinh.banChacChua()== 1){
						if(checkTiTrongDiemSau(stt, Integer.parseInt(t))){
								HTDG.setTiTrong(Integer.parseInt(t));
								CauHinh.cls();
						}
						break;
					}
					break;
				case 5:
					System.out.println("Thoat Chuong Trinh");
					stop = 2;
					break;
				default:
					CauHinh.cls();
					System.out.println("So Nhap Khong hop le, vui long chon lai");
					break;
			}
			}while(stop == 1);
	}
}

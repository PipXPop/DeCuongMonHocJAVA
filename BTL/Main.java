import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaiKhoan tk = new TaiKhoan();
        boolean tiepTucChuongTrinh = true;
        boolean tiepTuc = false;

        QuanLyDeCuong qldc = new QuanLyDeCuong();
        QuanLyGiangVien qlgv = new QuanLyGiangVien();
        QuanLyMonHoc qlmh = new QuanLyMonHoc();
        QuanLyNganh qln = new QuanLyNganh();

        do {
            boolean dangNhapThanhCong = false;
            CauHinh.cls();
            System.out
                    .println("Day la he thong quan ly de cuong gianh cho giang vien\nVui long dang nhap de tiep tuc.");

            do {
                System.out.print("Tai khoan: \t");
                String taiKhoan = CauHinh.sc.nextLine();

                System.out.print("Mat khau: \t");
                String matKhau = CauHinh.sc.nextLine();

                if (matKhau != null && taiKhoan != null && taiKhoan.equals(tk.getTaiKhoan())
                        && matKhau.equals(tk.getMatKhau())) {
                    System.out.println("Dang nhap thanh cong!");
                    dangNhapThanhCong = true;
                } else {
                    System.out.println("Dang nhap that bai. Vui long thu lai.");
                }
            } while (!dangNhapThanhCong);
            do {
                try {
                    Menu.hienThi();
                    boolean tiepTucChon = false;
                    do {
                        tiepTucChon = false;
                        System.out.print("Nhap chuc nang muon dung:\t");
                        String chon = CauHinh.sc.nextLine();

                        switch (chon) {
                            case "1": // Them mon hoc
                                tiepTucChon = true;
                                System.out.print("Nhap ten mon hoc:\t");
                                String ten1 = CauHinh.sc.nextLine();

                                System.out.print("Nhap mo ta mon hoc:\t");
                                String moTa1 = CauHinh.sc.nextLine();

                                System.out.println("Nhap so tin chi cua mon hoc");
                                System.out.print("So tin chi ly thuyet:\t");
                                int tinChiLt = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.print("So tin chi thuc hanh:\t");
                                int tinChiTt = Integer.parseInt(CauHinh.sc.nextLine());

                                LoaiTinChi lt = new LoaiTinChi("Ly thuyet", tinChiLt);
                                LoaiTinChi tt = new LoaiTinChi("Thuc hanh", tinChiTt);

                                MoTaMonHoc mtmh1 = new MoTaMonHoc(moTa1, lt, tt);
                                MonHoc mh1 = new MonHoc(ten1, mtmh1);

                                DeCuong dc = new DeCuong();
                                dc.setMoTaMonHoc(mtmh1);
                                dc.setTenMonHoc(ten1);

                                qlmh.add(mh1); // Them mon hoc vao danh sach quan ly
                                qldc.add(dc);

                                System.out.println("Tao mon hoc thanh cong.");
                                File.ghiTenMonHocVaoFile(ten1, mh1.getMoTaMonHoc().getMaMonHoc());
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;
                            case "2": // tao de cuong
                                tiepTucChon = true;
                                boolean tiepTucNhap = false;
                                String ten3;
                                HeDaoTao heDaoTao2 = null;
                                System.out.print("Nhap ten mon hoc muon tao de cuong:\t");
                                do {
                                    tiepTucNhap = false;
                                    ten3 = CauHinh.sc.nextLine();
                                    Menu.hienThiHeDaoTao();

                                    do {
                                        int chonHeDaoTao2 = Integer.parseInt(CauHinh.sc.nextLine());
                                        switch (chonHeDaoTao2) {
                                            case 1:
                                                heDaoTao2 = HeDaoTao.ChinhQuy;
                                                break;
                                            case 2:
                                                heDaoTao2 = HeDaoTao.LienThong;
                                                break;
                                            case 3:
                                                heDaoTao2 = HeDaoTao.DaoTaoTuXa;
                                                break;
                                            default:
                                                System.out.println("He dao tao khong hop le! Nhap lai:");
                                                break;
                                        }

                                        // if(qldc.tim(ten3, heDaoTao2.name()) !=null){
                                        // System.out.println("De cuong mon nay da co he dao tao");
                                        // heDaoTao2=null;
                                        // break;
                                        // }
                                    } while (heDaoTao2 == null);

                                    if (qldc.tim(ten3) != null) {
                                        if (qldc.tim(ten3, heDaoTao2).getHeDaoTao() == null) {

                                            System.out.print("Nhap nganh hoc:\t");
                                            String tenNganh = CauHinh.sc.nextLine();
                                            Nganh nganh1 = new Nganh(tenNganh);

                                            System.out.print("Nhap ten giang vien phu trach:\t");
                                            String tenGv = CauHinh.sc.nextLine();
                                            GiangVien gv1 = new GiangVien(tenGv);

                                            System.out.print("Nhap muc tieu mon hoc:\t");
                                            String mucTieu = CauHinh.sc.nextLine();
                                            MucTieuMonHoc mtmh2 = new MucTieuMonHoc();

                                            qldc.tim(ten3, heDaoTao2).setHeDaoTao(heDaoTao2);
                                            qldc.tim(ten3, heDaoTao2.name()).setMucTieu(mtmh2);
                                            qldc.tim(ten3, heDaoTao2.name()).setGv(gv1);
                                            qldc.tim(ten3, heDaoTao2.name()).setNganh(nganh1);
                                            qldc.tim(ten3, heDaoTao2.name()).getMucTieu().setMucTieuMonHoc(mucTieu);
                                        } else {
                                            tiepTucNhap = true;
                                            System.out.println("He dao tao cua mon hoc nay da co\t");
                                        }
                                    } else {
                                        tiepTucNhap = true;
                                        System.out.println("Khong co mon hoc nay. Nhap lai:");
                                    }
                                } while (tiepTucNhap);
                                DeCuong dc2 = new DeCuong(ten3, qldc.tim(ten3).getMoTaMonHoc());
                                dc2.getMoTaMonHoc().setMaMonHoc(qldc.tim(ten3).getMaMonHoc());
                                qldc.add(dc2);
                                System.out.println("Tao de cuong thanh cong");
                                File.ghiTenDeCuongVaoFile(ten3, heDaoTao2.name());
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;
                            case "3": // sua, thay doi
                                tiepTucChon = true;
                                boolean tiepTucChon3 = true;

                                do {
                                    Menu.hienThiCase3();
                                    System.out.print("Nhap lua chon:\t");
                                    String chon3 = CauHinh.sc.nextLine();
                                    switch (chon3) {
                                        case "1": // mon hoc
                                            Menu.hienThiCase1of3();
                                            String chon13 = CauHinh.sc.nextLine();
                                            System.out.print("Nhap ten mon hoc/ma mon hoc ban muon thay doi:\t");
                                            String code13 = CauHinh.sc.nextLine();
                                            switch (chon13) {
                                                case "1":
                                                    if (qlmh.tim(code13) != null) {
                                                        System.out.print("Nhap ten mon hoc thay doi:\t");
                                                        String ten113 = CauHinh.sc.nextLine();
                                                        qlmh.tim(code13).setTenMonHoc(ten113);
                                                        System.out.println("Thay doi thanh cong");
                                                    } else
                                                        System.out.println("Khong tim thay mon hoc");
                                                    break;
                                                case "2":
                                                    if (qlmh.tim(code13) != null) {
                                                        System.out.print("Nhap mo ta mon hoc thay doi:\t");
                                                        String ten213 = CauHinh.sc.nextLine();
                                                        qlmh.tim(code13).getMoTaMonHoc().setMoTaMonHoc(ten213);
                                                        System.out.println("Thay doi thanh cong");
                                                    } else
                                                        System.out.println("Khong tim thay mon hoc");
                                                    break;
                                                case "3":
                                                    if (qlmh.tim(code13) != null) {
                                                        System.out.print("Nhap ten mon hoc muon xoa:\t");
                                                        String ten313 = CauHinh.sc.nextLine();
                                                        qlmh.remove(qlmh.tim(ten313));
                                                        System.out.println("Xoa thanh cong");
                                                    } else
                                                        System.out.println("Khong tim thay mon hoc");
                                                    break;
                                                case "0":
                                                    break;
                                                default:
                                                    System.out.print("Lua chon khong hop le! Vui long nhap lai:");
                                                    break;
                                            }
                                            break;
                                        case "2": // de cuong
                                            boolean tiepTucChon23 = false;
                                            do {
                                                Menu.hienThiCase2of3();
                                                String chon23 = CauHinh.sc.nextLine();
                                                System.out.print("Nhap ten de cuong ban muon tim:\t");
                                                String code23 = CauHinh.sc.nextLine();
                                                System.out.print("Nhap he dao tao cua de cuong:\t");
                                                String hdt23 = CauHinh.sc.nextLine();
                                                switch (chon23) {
                                                    case "1":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            System.out.print("Nhap ten thay doi:\t");
                                                            String ten123 = CauHinh.sc.nextLine();
                                                            qldc.tim(code23, hdt23).setTenMonHoc(ten123);
                                                            System.out.println("Thay doi thanh cong");
                                                        } else
                                                            System.out.println("Khong tim thay de cuong");
                                                        break;
                                                    case "2":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            System.out.print("Nhap nganh hoc ban muon thay doi:\t");
                                                            String tenNganh223 = CauHinh.sc.nextLine();
                                                            qldc.tim(code23, hdt23).getNganh().setTenNganh(tenNganh223);
                                                            System.out.println("Thay doi thanh cong");
                                                        } else
                                                            System.out.println("Khong tim thay de cuong");
                                                        break;
                                                    case "3":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            System.out.print("Nhap ten giao vien ban muon thay doi:\t");
                                                            String tenGv323 = CauHinh.sc.nextLine();
                                                            qldc.tim(code23, hdt23).getGv().setTenGv(tenGv323);
                                                            System.out.println("Thay doi thanh cong");
                                                        } else
                                                            System.out.println("Khong tin thay de cuong");
                                                        break;
                                                    case "4":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            System.out.println("Nhap ten mon hoc tien quyet:\t");
                                                            String ten423 = CauHinh.sc.nextLine();
                                                            if (qlmh.tim(ten423) != null) {
                                                                qldc.tim(code23, hdt23)
                                                                        .addMonHocTienQuyet(qldc.tim(ten423, hdt23));
                                                                System.out.println("Them thanh cong");
                                                            } else
                                                                System.out.println("Khong tim thay mon hoc");
                                                        } else
                                                            System.out.println("Khong tim thay de cuong");
                                                        break;
                                                    case "5":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            System.out.println("Nhap ten mon hoc truoc:\t");
                                                            String ten523 = CauHinh.sc.nextLine();
                                                            if (qlmh.tim(ten523) != null) {
                                                                qldc.tim(code23, hdt23)
                                                                        .addMonHocTruoc(qldc.tim(ten523, hdt23));
                                                                System.out.println("Them thanh cong");
                                                            } else
                                                                System.out.println("Khong tim thay mon hoc");
                                                        } else
                                                            System.out.println("Khong tim thay de cuong");
                                                        break;
                                                    case "6":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            qldc.tim(code23, hdt23).getMucTieu().ThaoTac();
                                                        }
                                                        break;
                                                    case "7":
                                                        if (qldc.tim(code23, hdt23) != null) {
                                                            System.out.print("Nhap ten de cuong muon xoa:\t");
                                                            String ten323 = CauHinh.sc.nextLine();
                                                            qldc.remove(qldc.tim(ten323, hdt23));
                                                            System.out.println("Xoa thanh cong");
                                                        } else
                                                            System.out.println("Khong tim thay mon hoc");
                                                    case "0":
                                                        tiepTucChon23 = true;
                                                        break;
                                                    default:
                                                        System.out.print("Lua chon khong hop le! Nhap lai:\t");
                                                        break;
                                                }
                                            } while (tiepTucChon23);
                                            break;

                                        case "3": // nganh hoc

                                            Menu.hienThiCase3of3();
                                            System.out.print("Nhap lua chon:\t");
                                            String chon33 = CauHinh.sc.nextLine();
                                            System.out.println("Nhap ten nganh hien tai:\t");
                                            String tenNganh33 = CauHinh.sc.nextLine();
                                            switch (chon33) {
                                                case "1":

                                                    if (qln.tim(tenNganh33) != null) {
                                                        System.out.print("Ten nganh se thay thanh:\t");
                                                        String tenNganhNew133 = CauHinh.sc.nextLine();
                                                        qln.tim(tenNganh33).setTenNganh(tenNganhNew133);
                                                        System.out.println("Thay doi ten nganh thanh cong");
                                                    } else
                                                        System.out.println("Khong tim thay nganh hoc");
                                                    break;
                                                case "2":

                                                    if (qln.tim(tenNganh33) != null) {
                                                        System.out
                                                                .println("Ban muon them may mon hoc vao nganh nay:\t");
                                                        int soNganh = Integer.parseInt(CauHinh.sc.nextLine());
                                                        for (int i = 0; i < soNganh; i++) {
                                                            System.out.printf("Nhap ten mon hoc thu ", i + 1, " :\t");
                                                            String ten33 = CauHinh.sc.nextLine();
                                                            if (qlmh.tim(ten33) != null)
                                                                qln.tim(tenNganh33).addDsMonHoc(qlmh.tim(ten33));
                                                            else
                                                                System.out.println("Khong tim thay mon hoc nay!");
                                                        }
                                                    } else
                                                        System.out.println("Khong tim thay nganh hoc");
                                                    break;
                                                case "3":
                                                    if (qln.tim(tenNganh33) != null) {
                                                        qln.remove(qln.tim(tenNganh33));
                                                        System.out.println("Xoa thanh cong");
                                                        CauHinh.pause();
                                                    } else
                                                        System.out.println("Khong tim thay nganh hoc");
                                                case "0":

                                                    break;
                                                default:
                                                    System.out.println("Lua chon khong hop le!");
                                                    break;
                                            }
                                            break;
                                        case "4": // giang vien
                                            Menu.hienThiCase4of3();
                                            System.out.print("Nhap lua chon:\t");
                                            String chon43 = CauHinh.sc.nextLine();
                                            System.out.print("Nhap ten giang vien:\t");
                                            String tenGv4 = CauHinh.sc.nextLine();
                                            switch (chon43) {
                                                case "1":
                                                    if (qlgv.tim(tenGv4) != null) {
                                                        System.out.print("Nhap ten de cuong:\t");
                                                        String tenDc4 = CauHinh.sc.nextLine();
                                                        System.out.print("Nhap he dao tao cua de cuong:\t");
                                                        String hdt14 = CauHinh.sc.nextLine();
                                                        if (qlgv.tim(tenGv4).getDsDeCuongCuaGv().size() > 4)
                                                            System.out.println(
                                                                    "Danh sach de cuong cua giang vien day day");
                                                        else {
                                                            if (qldc.tim(tenDc4, hdt14) != null) {
                                                                qlgv.tim(tenGv4).addDeCuong(qldc.tim(tenDc4, hdt14));
                                                                System.out.println("Them de cuong thanh cong!");
                                                            } else
                                                                System.out.println("De cuong khong ton tai");
                                                        }
                                                    } else
                                                        System.out.println("Khong tim thay giang vien");
                                                    break;
                                                case "2":
                                                    if (qlgv.tim(tenGv4) != null) {
                                                        System.out.print("Nhap ten de cuong:\t");
                                                        String tenDc24 = CauHinh.sc.nextLine();
                                                        System.out.print("Nhap he dao tao cua de cuong:\t");
                                                        String hdt24 = CauHinh.sc.nextLine();
                                                        if (qldc.tim(tenDc24, hdt24) != null) {
                                                            qlgv.tim(tenGv4).removeDeCuong(qldc.tim(tenDc24, hdt24));
                                                            System.out.println("Xoa de cuong thanh cong!");
                                                        } else
                                                            System.out.println("De cuong khong ton tai");

                                                    } else
                                                        System.out.println("Khong tim thay giang vien");
                                                    break;
                                                case "3":
                                                    if (qlgv.tim(tenGv4) != null) {
                                                        qlgv.remove(qlgv.tim(tenGv4));
                                                        System.out.println("Xoa giang vien thnah cong");
                                                        CauHinh.pause();
                                                    } else {
                                                        System.out.println("Khong tim thay giang vien");
                                                        CauHinh.pause();
                                                    }
                                                    break;
                                                case "0":
                                                    break;
                                                default:
                                                    System.out.println("Lua chon khong hop le!");
                                                    CauHinh.pause();
                                                    break;
                                            }

                                            break;
                                        case "0": // thoat
                                            tiepTucChon3 = false;
                                            break;
                                        default:
                                            System.out.print("Lua chon khong hop le! Nhap lai:\t");
                                            break;
                                    }

                                } while (tiepTucChon3);
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;
                            case "4": // nganh hoc
                                tiepTucChon = true;
                                System.out.print("Nhap ten nganh hoc:\t");
                                String ten4 = CauHinh.sc.nextLine();

                                Menu.hienThiHeDaoTao();
                                int chonHeDaoTao4 = Integer.parseInt(CauHinh.sc.nextLine());
                                HeDaoTao heDaoTao4 = null;
                                do {
                                    switch (chonHeDaoTao4) {
                                        case 1:
                                            heDaoTao4 = HeDaoTao.ChinhQuy;
                                            break;
                                        case 2:
                                            heDaoTao4 = HeDaoTao.LienThong;
                                            break;
                                        case 3:
                                            heDaoTao4 = HeDaoTao.DaoTaoTuXa;
                                            break;
                                        default:
                                            System.out.println("He dao tao khong hop le! Nhap lai:");
                                            break;
                                    }
                                } while (heDaoTao4 == null);

                                Nganh nganh4 = new Nganh(ten4, heDaoTao4);

                                qln.add(nganh4);
                                System.out.println("Tao nganh thanh cong");
                                File.ghiTenNganhVaoFile(ten4, heDaoTao4.name());
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;

                            case "5":
                                tiepTucChon = true;
                                System.out.print("Nhap ten giang vien:\t");
                                String ten5 = CauHinh.sc.nextLine();
                                GiangVien gv4 = new GiangVien(ten5);

                                qlgv.add(gv4);
                                System.out.println("Them giang vien thanh cong");
                                File.ghiTenGiaoVienVaoFile(ten5);
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;
                            case "6":
                                tiepTucChon = true;
                                boolean tiepTucChon6 = false;

                                Menu.hienThiCase6();
                                System.out.print("Nhap lua chon:\t");
                                do {
                                    String chon6 = CauHinh.sc.nextLine();
                                    switch (chon6) {
                                        case "1":
                                            System.out.print("Nhap ten mon hoc/ma mon hoc muon tim:\t");
                                            String timKiem1 = CauHinh.sc.nextLine();
                                            qlmh.find(timKiem1);
                                            CauHinh.pause();
                                            CauHinh.cls();
                                            Menu.hienThi();
                                            break;
                                        case "2":
                                            System.out.print("Nhap ten de cuong ban muon tim:\t");
                                            String timKiem2 = CauHinh.sc.nextLine();
                                            qldc.find(timKiem2);
                                            CauHinh.pause();
                                            CauHinh.cls();
                                            Menu.hienThi();
                                            break;
                                        case "3":
                                            System.out.print("Nhap ten giang vien/ma giang vien ban muon tim:\t");
                                            String timKiem3 = CauHinh.sc.nextLine();
                                            qlgv.find(timKiem3);
                                            CauHinh.pause();
                                            CauHinh.cls();
                                            Menu.hienThi();
                                            break;
                                        case "4":
                                            System.out.print("Nhap ten nganh ban muon tim:\t");
                                            String timKiem4 = CauHinh.sc.nextLine();
                                            qln.find(timKiem4);
                                            CauHinh.pause();
                                            CauHinh.cls();
                                            Menu.hienThi();
                                            break;
                                        case "0":
                                            tiepTuc = true;
                                            tiepTucChon = false;
                                            CauHinh.cls();
                                            break;
                                        default:
                                            tiepTucChon6 = true;
                                            System.out.print("Lua chon khong hop le! Nhap lai:\t");
                                            break;
                                    }
                                } while (tiepTucChon6);
                                break;
                            case "7":
                                tiepTucChon = true;
                                List<DeCuong> dsDeCuongNew = qldc.dsDCGiamDanSoTinChi();
                                System.out.println("Danh sach de cuong da duoc sap xep\n");
                                dsDeCuongNew.forEach(s -> s.xuatThongTin());
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;
                            case "8":
                                tiepTucChon = true;
                                boolean tiepTucChon8 = false;
                                Menu.hienThiCase8();
                                System.out.print("Nhap lua chon:\t");
                                do {
                                    String chon8 = CauHinh.sc.nextLine();
                                    switch (chon8) {
                                        case "1":
                                            System.out.println("Nhap ten giang vien ban muon tim de cuong:\t");
                                            String tenGv8 = CauHinh.sc.nextLine();
                                            if (qlgv.tim(tenGv8) != null) {
                                                if (!qlgv.tim(tenGv8).getDsDeCuongCuaGv().isEmpty()) {
                                                    System.out.printf("Danh sach de cuong:\n");
                                                    qlgv.tim(tenGv8).hienThiDanhSachDc();
                                                } else
                                                    System.out.println("Danh sach trong");
                                            } else
                                                System.out.println("Khong tim thay giang vien");
                                            CauHinh.pause();
                                            break;
                                        case "2":
                                            if (!qldc.getDsDeCuong().isEmpty())
                                                qldc.hienThiDanhSach();
                                            else
                                                System.out.println("Danh sach trong!");
                                            CauHinh.pause();
                                            break;
                                        case "3":
                                            if (!qlmh.getDsMonHoc().isEmpty())
                                                qlmh.hienThiDanhSach();
                                            else
                                                System.out.println("Danh sach trong!");
                                            CauHinh.pause();
                                            break;
                                        case "4":
                                            if (!qln.getDsNganh().isEmpty())
                                                qln.hienThiDanhSach();
                                            else
                                                System.out.println("Danh sach trong!");
                                            CauHinh.pause();
                                            break;
                                        case "5":
                                            if (qlgv.getDsGiangVien().isEmpty())
                                                qlgv.hienThiDanhSach();
                                            else
                                                System.out.println("Danh sach trong!");
                                            CauHinh.pause();
                                            break;
                                        case "6":
                                            System.out.println("Nhap so tin chi:\t");
                                            int soTinChi8 = Integer.parseInt(CauHinh.sc.nextLine());
                                            List<DeCuong> dsDeCuongnew8 = qldc.dsDeCuongTheoSoTinChi(soTinChi8);
                                            if (!dsDeCuongnew8.isEmpty()) {
                                                System.out.println("Danh sach de cuong theo so tin chi:\n");
                                                System.out.println(
                                                        String.format("%-25s%-25s%-25s%-25s%-25s", "Ten Mon Hoc",
                                                                "Ma Mon Hoc", "He Dao Tao", "Nganh", "So tin chi"));
                                                dsDeCuongnew8.forEach(s -> s.xuatThongTin());
                                                CauHinh.pause();
                                            } else {
                                                System.out.println("Danh sach trong");
                                                CauHinh.pause();
                                            }
                                            break;
                                        case "0":
                                            tiepTuc = true;
                                            tiepTucChon = false;
                                            CauHinh.cls();
                                            break;
                                        default:
                                            tiepTucChon8 = true;
                                            System.out.print("Lua chon khong hop le! Nhap lai:\t");
                                            break;
                                    }
                                } while (tiepTucChon8);
                                Menu.hienThi();
                                break;
                            case "9":
                                tiepTucChon = true;
                                System.out.print("Nhap ma mon hoc:\t");
                                String maMh9 = CauHinh.sc.nextLine();
                                System.out.print("Nhap he dao tao:\t");
                                String hdt9 = CauHinh.sc.nextLine();
                                if (qldc.tim(maMh9, hdt9) != null)
                                    qldc.ds_MHlaMH_TQ_or_LT(maMh9);
                                else
                                    System.out.println("Khong tim thay mon hoc!");
                                CauHinh.pause();
                                break;
                            case "10":
                                tiepTucChon = true;
                                System.out.print("Nhap ten de cuong ban muon xuat:\t");
                                String tenDc10 = CauHinh.sc.nextLine();
                                System.out.print("Nhap he dao tao cua de cuong:\t");
                                String hdt10 = CauHinh.sc.nextLine();
                                if (qldc.tim(tenDc10, hdt10) != null) {
                                    System.out.println(
                                            "---------------------------------------------------DE CUONG----------------------------------------------------------");
                                    qldc.tim(tenDc10, hdt10).hienThiDeCuong();
                                } else
                                    System.out.println("Khong tim thay de cuong");
                                CauHinh.pause();
                                CauHinh.cls();
                                Menu.hienThi();
                                break;
                            case "11":
                                tk.doiMatKhau(tk.getMatKhau());
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Khong hop le! Vui long nhap lai.");
                                tiepTucChon = true;
                                break;
                        }
                    } while (tiepTucChon);
                } catch (NumberFormatException e) {
                    System.out.println("Du lieu nhap khong hop le!");
                    CauHinh.pause();
                }
            } while (tiepTuc);
        } while (tiepTucChuongTrinh);
    }
}

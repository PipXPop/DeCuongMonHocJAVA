public class Menu {
    public static void hienThi() {
        CauHinh.cls();
        System.out.println("\nChao mung den voi he thong quan ly de cuong.\n----------------------Chuc Nang------------------------");
        System.out.println("| (1) Tao mon hoc                                     |");
        System.out.println("| (2) Tao de cuong                                    |");
        System.out.println("| (3) Sua/Thay doi                                    |");
        System.out.println("| (4) Them nganh hoc                                  |");
        System.out.println("| (5) Them giang vien                                 |");
        System.out.println("| (6) Tim kiem                                        |");
        System.out.println("| (7) Sap xep danh sach de cuong theo tin chi         |");
        System.out.println("| (8) Danh sach                                       |");
        System.out.println("| (9) Xac dinh danh sach mon hoc truoc/tien quyet     |");
        System.out.println("| (10) Xuat ra de cuong hoan chinh                    |");
        System.out.println("| (11) Doi mat khau                                   |");
        System.out.println("| (0) Thoat                                           |");
    }

    public static void hienThiHeDaoTao(){
        System.out.println("Chon he dao tao");
        System.out.println("(1) Chinh quy");
        System.out.println("(2) Lien Thong");
        System.out.println("(3) Dao Tao Tu Xa");
    }

    public static void hienThiCase3(){
        System.out.println("Ban muon thay doi?");
        System.out.println("(1) Mon hoc");
        System.out.println("(2) De cuong");
        System.out.println("(3) Nganh hoc");
        System.out.println("(4) Giang vien");
        System.out.println("(0) Quay lai");
    }

    public static void hienThiCase1of3(){
        CauHinh.cls();
        System.out.println("Ban muon thay doi?");
        System.out.println("(1) Ten mon hoc");
        System.out.println("(2) Mo ta mon hoc");
        System.out.println("(3) Xoa mon hoc");
        System.out.println("(0) Quay lai");
        System.out.println("Nhap lua chon:\t");
    }

    public static void hienThiCase2of3(){
        CauHinh.cls();
        System.out.println("Ban muon thay doi?");
        System.out.println("(1) Ten mon hoc thuoc de cuong");
        System.out.println("(2) Nganh hoc");
        System.out.println("(3) Giang vien");
        System.out.println("(4) Them mon hoc tien quyet");
        System.out.println("(5) Them mon hoc truoc");
        System.out.println("(6) Muc tieu mon hoc");
        System.out.println("(7) Xoa de cuong");
        System.out.println("(0) Quay lai");
        System.out.println("Nhap lua chon:\t");
    }
    // public static void hienThiCase3of1of3(){
    //     CauHinh.cls();
    //     System.out.println("Ban muon thay doi tin chi nao?");
    //     System.out.println("(1) Ly thuyet");
    //     System.out.println("(2) Thuc hanh");
    //     System.out.println("(0) Quay lai");
    //     System.out.print("Nhap lua chon:\t");
    // }

    public static void hienThiCase3of3(){
        CauHinh.cls();
        System.out.println("(1) Thay doi ten nganh");
        System.out.println("(2) Them danh sach mon hoc thuoc nganh");
        System.out.println("(3) Xoa nganh");
        System.out.println("(0) Quay lai");
    }

    public static void hienThiCase4of3(){
        CauHinh.cls();
        System.out.println("(1) Them de cuong cho giang vien");
        System.out.println("(2) Xoa de cuong cho giang vien");
        System.out.println("(3) Xoa giang vien");
        System.out.println("(0) Quay lai");
    }

    

    public static void hienThiCase6(){
        CauHinh.cls();
        System.out.println("Ban muon tim kiem");
        System.out.println("(1) Mon hoc");
        System.out.println("(2) De cuong");
        System.out.println("(3) Giang vien");
        System.out.println("(4) Nganh hoc");
        System.out.println("(0) Quay lai");
    }

    // public static void hienThiCase7(){
    //     System.out.println("Ban muon sap xep danh sach");
    //     System.out.println("(1) Mon hoc");
    //     System.out.println("(2) De cuong");
    //     System.out.println("(0) Quay lai");
    // }

    public static void hienThiCase8(){
        CauHinh.cls();
        System.out.println("(1) Xem danh sach de cuong theo ma giang vien");
        System.out.println("(2) Xem danh sach de cuong hien tai");
        System.out.println("(3) Xem danh sach mon hoc hien tai");
        System.out.println("(4) Xem danh sach nganh hoc hien tai");
        System.out.println("(5) Xem danh sach giang vien hien tai");
        System.out.println("(6) Xem danh sach cac mon hoc loc theo so tin chi");
        System.out.println("(0) Quay lai");
    }
}

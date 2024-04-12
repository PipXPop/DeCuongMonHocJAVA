public class TaiKhoan {
    private String matKhau = "1";
    private String taiKhoan = "admin";

    public void doiMatKhau(String mk) {
        do {
            System.out.print("Nhap mat khau hien tai: \t");
            String nhap = CauHinh.sc.nextLine();

            if (mk != null && nhap != null && mk.equals(nhap)) {

                System.out.print("Nhap mat khau moi: \t");
                String matKhauMoi = CauHinh.sc.nextLine();
                System.out.print("Nhap lai mat khau moi: \t");
                String nhapLaiMatKhauMoi = CauHinh.sc.nextLine();

                if (matKhauMoi.equals(nhapLaiMatKhauMoi)) {
                    this.matKhau = matKhauMoi;
                    System.out.println("Mat khau da duoc thay doi.");
                    break;
                } else {
                    System.out.println("Mat khau moi khong khop. Vui long nhap lai.");
                }

            } else {
                System.out.println("Mat khau hien tai khong hop le! Vui long nhap lai");
            }
        } while (true);
    }

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}

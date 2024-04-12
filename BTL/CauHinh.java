
import java.util.Scanner;

public class CauHinh {
    public static final Scanner sc = new Scanner(System.in);

    public static void pause() {
        System.out.println("Nhan enter de tiep tuc...");
        sc.nextLine(); 
    }

    public static void cls(){
        System.out.print("\033[H\033[2J"); // Xóa màn hình
        System.out.flush();
    }

    public static int banChacChua(){
        try{
            System.out.println("0) Huy va tro ve (nhap 0 hoac 1 ki tu bat ki)");
            System.out.println("1) Dong y ");
            System.out.print("Lua chon:  ");
            return Integer.parseInt(CauHinh.sc.nextLine()); //
        } catch (NumberFormatException e){
            return 2;
        }
    }

    public static int Choice(int sl_ThaoTac){
		int x = -1;
		do{
			int t ;
			System.out.print("Hay Chon 01 STT Tren Menu de thao tac: ");
			try{
				t = Integer.parseInt(CauHinh.sc.nextLine());
				Math.abs(t);
				x = t;
			} catch(NumberFormatException e){
				return sl_ThaoTac + 10;
			}
		}while(x == -1);
		return x;
    }
}



import java.util.Scanner;

import javax.naming.BinaryRefAddr;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Game {

	Player player;
	Location location;
	Scanner scanner=new Scanner(System.in);
	
	public void Login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Macera Oyununa Hoşgeldiniz!");
		System.out.println("Oyuna başlamadan önce isminizi giriniz: ");
		//String playerName = scanner.nextLine();
		player=new Player("pitman");
		player.SelectCha();
		Start();
	}
	public void Start() {
		while (true) {
			System.out.println("\n==================\n");
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz: ");
			System.out.println("1. Güvenli Ev\t ==> Size ait güvenli bir mekan, düşman yok!");
			System.out.println("2. Mağara\t ==> Karşınıza zombi çıkabilir!");
			System.out.println("3. Orman\t ==> Karşınıza vampir çıkabilir!");
			System.out.println("4. Nehir\t ==> Karşınıza ayı çıkabilir!");
			System.out.println("5. Mağaza\t ==> Silah ve Zırh alabilirsiniz!");
			System.out.print("Gitmek istediğiniz yer: ");
			int selectLocation=scanner.nextInt();
			while (selectLocation<0 || selectLocation>5) {
				System.out.println("Lütfen geçerli bir yer seçiniz: ");
				selectLocation=scanner.nextInt();
				
			}
			
			switch (selectLocation) {
			case 1:
				location=new SafeHouse(player);
				break;
			case 5:
				location=new ToolStore(player);
				break;

			default:
				location=new SafeHouse(player);
				break;
			}
			
			if (!location.GetLocation()) {
				System.out.println("Oyun Bitti!");
				break;
			}		
		}
	}
}

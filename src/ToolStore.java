
public class ToolStore extends NormalLocation{

	ToolStore(Player player) {
		super(player, "Mağaza");
		// TODO Auto-generated constructor stub
	}
	
	public boolean GetLocation() {
		System.out.println("Para: "+player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zırhlar");
		System.out.println("3. Çıkış");
		System.out.print("Seçiminiz: ");
		int selTool=scanner.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID=WeaponMenu();
			BuyWeapon(selItemID);
			break;
		case 2:
			selItemID=ArmorMenu();
			BuyArmor(selItemID);
			break;
		

		default:
			break;
		}
		return true;
	}
	
	public int WeaponMenu() {
		
		System.out.println("1. Tabanca\t <Para:25 - Hasar:2>");
		System.out.println("2. Kılıç\t <Para:35 - Hasar:3>");
		System.out.println("3. Tüfek\t <Para:45 - Hasar:7>");
		System.out.println("4. Çıkış");
		System.out.print("Silah seçiminiz: ");
		int selWeaponID=scanner.nextInt();
		return selWeaponID;
	}
	
	public int ArmorMenu() {
		
		System.out.println("1. Hafif\t <Para:15 - Avoid:1>");
		System.out.println("2. Orta\t <Para:25 - Avoid:3>");
		System.out.println("3. Ağır\t <Para:40 - Avoid:5>");
		System.out.println("4. Çıkış");
		System.out.print("Silah seçiminiz: ");
		int selArmorID=scanner.nextInt();
		return selArmorID;
	}
	
	public void BuyArmor(int itemID) {
		int avoid=0,price=0;
		String armorName=null;
		
			switch (itemID) {
			case 1:
				avoid=1;
				armorName="Hafif Armor";
				price=15;
				break;
			case 2:
				avoid=3;
				armorName="Orta Armor";
				price=25;
				break;
			case 3:
				avoid=5;
				armorName="Ağır Armor";
				price=40;
				break;
			case 4:
				System.out.println("Çıkış yapılıyor...");
				break;
			default:
				System.out.println("Geçersiz işlem!");
				break;
			}
			if (price>0) {
				if (player.getMoney()>=price) {
					player.getInv().setArmor(avoid);
					player.getInv().setArmorName(armorName);
					player.setMoney(player.getMoney()-price);
					System.out.println(armorName+" satın aldınız, Engellenen Hasar: "+player.getInv().getArmor());
					System.out.println("Kalan Para: "+player.getMoney());
				}else {
					System.out.println("Bakiye yetersiz!");
				}
			}
	}
	
	public void BuyWeapon(int itemID) {
		int damage=0,price=0;
		String weaponNamer=null;
		
			switch (itemID) {
			case 1:
				damage=2;
				weaponNamer="Tabanca";
				price=25;
				break;
			case 2:
				damage=3;
				weaponNamer="Kılıç";
				price=35;
				break;
			case 3:
				damage=7;
				weaponNamer="Tüfek";
				price=45;
				break;
			case 4:
				System.out.println("Çıkış yapılıyor...");
				break;
			default:
				System.out.println("Geçersiz işlem!");
				break;
			}
			if (price>0) {
				if (player.getMoney()>=price) {
					player.getInv().setDamage(damage);
					player.getInv().setWeaponName(weaponNamer);
					player.setMoney(player.getMoney()-price);
					System.out.println(weaponNamer+" satın aldınız, Önceki hasar: "+player.getDamage()+" Yeni Hasar: "
							+(player.GetTotalDamage()));
					System.out.println("Kalan Para: "+player.getMoney());
				}else {
					System.out.println("Bakiye yetersiz!");
				}
			}
	}
	
}

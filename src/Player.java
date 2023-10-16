import java.util.Scanner;
import java.util.function.IntConsumer;

public class Player {
	private int Damage, healthy, money, realHealthy;
	private String name, cName; //kullanıcıadı ve karakter adı
	private Inventory inv;//Eşyalar
	Scanner scanner=new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv=new Inventory();
	}
	
	public void SelectCha() {
		switch (ChaMenu()) {
		case 1:
			initPlayer("Samuray", 5, 21, 15);
			break;
		case 2:
			initPlayer("Okçu", 7, 18, 20);
			break;
		case 3:
			initPlayer("Şovalye", 8, 24, 5);
			break;

		default:
			initPlayer("Samuray", 5, 21, 15);
			break;
		}
		System.out.println("Karakter : "+getcName()+ ", Hasar: "+ getDamage()+", Sağlık : "+ getHealthy()+", Para: "+getMoney());
	}
	
	public void initPlayer(String cName, int dmg, int hlthy, int mny) {
		setcName(cName);
		setDamage(dmg);
		setHealthy(hlthy);
		setMoney(mny);
		setRealHealthy(hlthy);
	}
	
	public int ChaMenu(){
		System.out.println("Lütfen bir karakter seçiniz!");
		System.out.println("1- Türü: Samuray, \t Hasar:5,\t Sağlık:21,\t Para:15");
		System.out.println("2- Türü: Okçu,\t\t Hasar:7,\t Sağlık:18,\t Para:20");
		System.out.println("3- Türü: Şovalye, \t Hasar:8,\t Sağlık:24,\t Para:5");
		System.out.print("Karakter Seçiminiz: ");
		int chaID=scanner.nextInt();
		
		while (chaID<1|| chaID>3) {
			System.out.print("Lütfen geçerli bir karakter seçiniz: ");
			chaID=scanner.nextInt();
		}
		
		return chaID;
	}
	
	public int GetTotalDamage() {
		return this.getDamage()+this.getInv().getDamage();
	}
	
	public int getDamage() {
		return Damage;
	}

	public void setDamage(int damage) {
		Damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getRealHealthy() {
		return realHealthy;
	}

	public void setRealHealthy(int realHealthy) {
		this.realHealthy = realHealthy;
	}
	
	
	
}

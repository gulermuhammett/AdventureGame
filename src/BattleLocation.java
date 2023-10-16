
public abstract class BattleLocation extends Location{

	protected Obstacle obstacle;
	protected String award;
	public BattleLocation(Player player, String name, Obstacle obstacle,String award) {
		super(player);
		this.name=name;
		this.obstacle=obstacle;
		this.award=award;
	}
	public  boolean GetLocation() {
		int obsCount= obstacle.ObstacleCount();
		System.out.println("Şuan buradasınız: "+this.getName());
		System.out.println("Dikkatli olun! Burada "+obsCount+" tane "+obstacle.getName()+"yaşıyor!!");
		System.out.print("<S>avaş veya <K>aç: ");
		String selCase=scanner.nextLine();
		selCase=selCase.toUpperCase();
		if (selCase.equals("S")) {
			if(Combat(obsCount)) {
				System.out.println(this.getName()+" bölgesindeki tüm düşmanları temizlediniz!");
				if (this.award.equals("Food") && player.getInv().isFood()==false) {
					System.out.println(this.award+" Kazandınız!");
					player.getInv().setFood(true);
				}else if (this.award.equals("Water") && player.getInv().isWater()==false) {
					System.out.println(this.award+" Kazandınız!");
					player.getInv().setWater(true);
				}else if (this.award.equals("Firewood") && player.getInv().isFirewood()==false) {
						System.out.println(this.award+" Kazandınız!");
						player.getInv().setFirewood(true);
			}
				return true;
				
		}
		if (player.getHealthy()<=0) {
			System.out.println("Öldünüz!");
			return false;
		}
		}
		return true;
	}
	
	public boolean Combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth=obstacle.getHealthy();
			PlayerStats();
			EnemyStats();
			while (player.getHealthy()>0 && obstacle.getHealthy()>0) {
				System.out.print("<V>ur veya <K>aç: ");
				String selCase=scanner.nextLine();
				selCase=selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println("Siz vurdunuz!");
					obstacle.setHealthy(obstacle.getHealthy()-player.GetTotalDamage());
					AfterHit();
					if (obstacle.getHealthy()>0) {
						System.out.println();
						System.out.println(obstacle.getName()+" Size vurdu!");
						player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
						AfterHit();
					}
				}
				else {
					return false;
				}
			}
			if (obstacle.getHealthy()<=0 && player.getHealthy()>0) {
				System.out.println("Düşmanları Yendiniz");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Güncel paranız: "+ player.getMoney());
				obstacle.setHealthy(defObsHealth);
			}else {
				return false;
			}
			System.out.println("------------------------------");
		}
		return true;
		
	}
	public void AfterHit() {
		System.out.println("Oyuncu Canı: "+player.getHealthy());
		System.out.println(obstacle.getName()+" Canı: "+obstacle.getHealthy());
		System.out.println();
	}
	
	public void PlayerStats() {
		System.out.println("Oyuncu Değerleri\n----------");
		System.out.println("Can: "+player.getHealthy());
		System.out.println("Hasar: "+player.GetTotalDamage());
		System.out.println("Para: "+ player.getMoney());
		if (player.getInv().getDamage()>0) {
			System.out.println("Silah: "+player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor()>0) {
			System.out.println("Zırh: "+player.getInv().getArmorName());			
		}
		System.out.println("------------------------------------------");
	}
	
	public void EnemyStats() {
		System.out.println(obstacle.getName()+" Değerleri\n----------");
		System.out.println("Can: "+obstacle.getHealthy());
		System.out.println("Hasar: "+obstacle.getDamage());
		System.out.println("Ödül: "+ obstacle.getAward());
		
	}
}

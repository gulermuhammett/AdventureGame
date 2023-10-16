
public class SafeHouse extends NormalLocation{

	SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}
	
	public boolean GetLocation() {
		player.setHealthy(player.getRealHealthy());
		System.out.println("iyileştiniz!");
		System.out.println("Şu an Güvenli ev adlı yerdesiniz!");
		return true;
	}

}

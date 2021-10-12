import java.util.Random;

public class Minion implements Attacking{

	Random rand = new Random();
	
	public Minion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int attack(int level) {
		// TODO Auto-generated method stub
		
		int atk = level + rand.nextInt(7) + 1;
		
		return atk;
	}

	
}

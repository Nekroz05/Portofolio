import java.util.Random;

public class Boss implements Attacking{

	Random rand = new Random();
	
	public Boss() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int attack(int level) {
		// TODO Auto-generated method stub
		
		int atk = level*5 + rand.nextInt(10) + 1;
		
		return atk;
	}

}

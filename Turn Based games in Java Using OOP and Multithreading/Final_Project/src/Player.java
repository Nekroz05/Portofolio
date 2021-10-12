import java.util.Random;

public class Player implements Attacking{
	
	Random rand = new Random();
	
	private int health = 50,mana = 50,level = 1,money=0, maxHp = 50, maxMana = 50;
	
	private int currExp=0,neededExp=100;


	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int attack(int level) {
		// TODO Auto-generated method stub
		int atk = level*2 + rand.nextInt(10) + 1;
		
		return atk;
	}
	
	// dari sini kebawah cuma getter setter
	
	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public int getCurrExp() {
		return currExp;
	}
	
	public void setCurrExp(int currExp) {
		this.currExp = currExp;
	}
	
	public int getNeededExp() {
		return neededExp;
	}
	
	public void setNeededExp(int neededExp) {
		this.neededExp = neededExp;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

}

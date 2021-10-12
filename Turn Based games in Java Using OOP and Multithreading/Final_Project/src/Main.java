/*Anggota Kelompok :
	1. Adrian Rianto - 2301859335
	2. Jason Honggana - 2301886494
	3. Reinaldy Sukamto - 2301853136
	4. Julian Chrisnanda Kusuma - 2301895385
	5. Samuel Dennis - 2301895744
	6. Wendy Susanto - 2301899313 */

import java.util.Random;
import java.util.Scanner;

public class Main {

	Player hero = new Player();
	Minion underling = new Minion();
	Boss demonLord = new Boss();
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);

	Thread attackPotion = new Thread(new Buff());
	Thread deffensePotion = new Thread(new Buff());
	Thread SpecialBuff = new Thread(new BattleFurys());

	int specialSkill =0;
	int Skill1 = 0,Skill2 = 0;
	int dmgPotion = 1;
	int deffPotion = 1;
	int potion = 3;
	int heroHealth = 0;
	int heroMana = 0;
	int playerElement=0;
	int achievement = 0,x;
	int ending=0;

	String name;
	boolean thread = false;
	boolean thread1 = false;
	boolean bfThread = false;
	/*
	 * 1 itu fire
	 * 2 itu water
	 * 3 itu thunder
	 * 4 itu earth
	 * 5 itu no affinity
	 */

	public Main() {
		// TODO Auto-generated constructor stub

		System.out.println("Player : Where am I? What is happening?");
		Sleep(500);
		System.out.println("Unknown : Welcome young hero, i summoned you to the world of magis");
		Sleep(500);
		System.out.println("Player : What ? Who are you ?");
		Sleep(500);
		System.out.println("Fatalis : My name is Fatalis the Sage. But, it’s before Demon Lord taken and rule this world"); 
		Sleep(500);
		System.out.println("Player : Why am i here? What is this world?");
		Sleep(500);
		System.out.println("Fatalis : I have brought you here to defeat the demon lord.");
		System.out.println(" The demon lord started his invasion a while ago, as such we need a hero to guide us and defeat the demon lord");
		Sleep(500);
		System.out.println("Player : Demon Lord?, Who is that?");
		Sleep(500);
		System.out.println("Fatalis : Yes, i know you must be shocked and tired");

		Sleep(1000);

		System.out.println("Fatalis : Young hero, may i know your name?");

		do{
			System.out.println();
			System.out.print("Name[5-10 Character]: ");

			name = sc.nextLine();

			if(name.length()<5 || name.length()>10){
				System.out.println("Please Tell me Your real name! i want to be friends with you...");
			}
			cls();
		}while(name.length()<5 || name.length()>10);

		Sleep(1000);

		System.out.println();
		System.out.println("one day earlier");

		Sleep(2000);

		System.out.println();
		System.out.println();

		System.out.println("Hendry : Hey "+name+"! Stop daydreaming already!");
		Sleep(500);
		System.out.println(name+" : Huh?");
		Sleep(500);
		System.out.println("Hendry: Cmon! Let’s Play, the others are waiting");
		Sleep(500);
		System.out.println(name+": Yea, yea, sure…");
		Sleep(500);
		System.out.println(name+" Thoughts : (Wait… i was playing with hendry, and then i went home...)");
		Sleep(500);
		System.out.println(name+" Thoughts : (i went to sleep, and then…. i can’t remember anything else….)");

		Sleep(1000);
		System.out.println("Press Enter to continue");

		sc.nextLine();

		cls();

		System.out.println("Fatalis : yes, "+name+" wonderful name!");
		Sleep(500);
		System.out.println("Fatalis : You should go see the knight Commander, he’ll teach you about magic affinity");
		System.out.println();
		Sleep(500);
		System.out.println(name+" goes to meet the Commander");
		Sleep(3000);
		cls();

		System.out.println("Knight Commander : Hello young hero, i’m eldros the knight commander");
		Sleep(500);
		System.out.println("Eldros : In magis there are 4 element of magic, this magic can be used to enchant your sword *\n* Each Element has its strength and weakness");
		Sleep(500);
		System.out.println("Fire Beats Earth");
		System.out.println("Earth Beats Thunder");
		System.out.println("Thunder Beats Water");
		System.out.println("Water Beats Fire");
		Sleep(500);
		System.out.println("Eldros : There are also some that choose to not use magic, this nullify the weakness of magic element, but beware it also nullify the strength of magic too");
		Sleep(500);

		do{
			System.out.println("Eldros : Young hero, What Magic Affinity will you choose?");
			System.out.println();
			System.out.println();
			System.out.println("1. Fire");
			System.out.println("2. Water");
			System.out.println("3. Thunder");
			System.out.println("4. Earth");
			System.out.println("5. No Affinity");
			System.out.print(">> ");

			try {
				playerElement = sc.nextInt(); sc.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}

			cls();
		}while(playerElement<1 || playerElement>5);

		System.out.println("Eldros : Great Choice! I’m sure it will aid you in your journey");
		Sleep(500);
		System.out.println("Eldros : Before you fight the demon lord and his 2 trusted Underling, you must increase your strength by engaging in multiple combat against monster in the forest of death");
		Sleep(500);
		System.out.println("Eldros : I wish You luck Young Hero");
		Sleep(500);
		System.out.println("Achievement unlocked : Journey Start");
		achievement++;
		Sleep(1000);

		System.out.println();
		System.out.println("Press enter to continue");
		sc.nextLine();
		cls();

		int BossDefeated=0;
		int nextMove;
		int day = 1;
		int firstmon =0,defeatfirstMon=0;
//		hero.setMoney(1000);
//		hero.setMaxMana(1000);
		do{
			cls();
			System.out.println("Hi "+name);
			System.out.println("Day   "+day);
			System.out.println("level : "+hero.getLevel());
			System.out.println("exp   : "+hero.getCurrExp()+"/"+hero.getNeededExp());
			System.out.println("Money : "+hero.getMoney());
			System.out.println("======================================");
			System.out.println("1. Fight Next Monster");
			System.out.println("2. Challenge The Boss");
			System.out.println("3. Store");
			System.out.println("4. Help");
			System.out.println("5. Show Inventory");
			System.out.println("6. Exit");
			System.out.println("======================================");
			System.out.println("What's your next move? ");
			System.out.print(">> ");
			try {
				nextMove = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				nextMove = 0;
				sc.nextLine();
			}

			hero.setHealth(hero.getMaxHp());
			hero.setMana(hero.getMaxMana());
			if (nextMove == 1 || nextMove == 2) day++;
			cls();

			if(nextMove==1){

				int monsterLevel = rand.nextInt(5) + hero.getLevel() - 2;
				if(monsterLevel <= 0) monsterLevel = 1;

				int monsterHp = 30 + monsterLevel*10 + rand.nextInt(10);
				int move=0;

				int monsterElement = rand.nextInt(4)+1;
				heroHealth = hero.getHealth();
				heroMana = hero.getMana();
				int monAtk;
				if(firstmon==0) {
					System.out.println(name+ " : What is that thing? I'm supposed to fight that? Screw it, Lets go!");
					firstmon = 1;
					sc.nextLine();
				}
				do{

					cls();
					heroHealth = hero.getHealth();
					heroMana = hero.getMana();
					System.out.println(name+" Hp : "+ heroHealth + " / " + hero.getMaxHp());
					System.out.println(name+" Mana : "+ heroMana  + " / " + hero.getMaxMana());
					System.out.println("Monster Level : "+monsterLevel);
					System.out.println("Monster Hp :"+monsterHp);
					if(monsterElement==1){
						System.out.println("Monster Element : Fire Monster");
					}else if(monsterElement==2){
						System.out.println("Monster Element : Water Monster");
					}else if(monsterElement==3){
						System.out.println("Monster Element : Thunder Monster");
					}else if(monsterElement==4){
						System.out.println("Monster Element : Earth Monster");
					}
					if(attackPotion.isAlive()) System.out.println("Battle Potion : Active");
					else if(!attackPotion.isAlive()) System.out.println("Battle Potion : None");
					if(deffensePotion.isAlive()) System.out.println("Defense Potion : Active");
					else if(!deffensePotion.isAlive()) System.out.println("Defense Potion : None");
					System.out.println("=============================================");
					System.out.println("1. basic attack");
					System.out.println("2. skill");
					System.out.println("3. run");
					System.out.println("4. item");
					System.out.print("your move: ");
					move = sc.nextInt(); sc.nextLine();
					monAtk = underling.attack(monsterLevel);

					if(move==1){

						int heroAtk = PlayerAttack(monsterElement);

						System.out.println("You Deals "+heroAtk+" damage");
						monsterHp -= heroAtk;

						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

						if(monsterHp<1){
							int exp = rand.nextInt(monsterLevel)+1;
							if(defeatfirstMon==0){
								System.out.println("whoa.. That was hard, I need to strengthen myself more.. This feels like a game");
								System.out.print("Achievement Unlocked : First Win");
								defeatfirstMon =1;
								sc.nextLine();
								achievement++;
							}
							//						System.out.println("exp sebelum dikali = " + exp);
							exp = exp * 50;
							//						System.out.println("exp sesudah dikali = " + exp);
							hero.setCurrExp(hero.getCurrExp()+exp);
							//						System.out.println("exp yang di set = " + hero.getCurrExp());
							hero.setMoney(hero.getMoney()+rand.nextInt(41)+10);
							if(hero.getCurrExp()>=hero.getNeededExp()){
								hero.setCurrExp(hero.getCurrExp()-hero.getNeededExp());
								hero.setLevel(hero.getLevel()+1);
								hero.setNeededExp(hero.getNeededExp()+50);
								hero.setMaxHp(hero.getMaxHp()+rand.nextInt(6)+10);
								hero.setHealth(hero.getMaxHp());
								hero.setMaxMana(hero.getMaxMana() + rand.nextInt(5)+10);
								hero.setMana(hero.getMaxMana());
							}
							if(hero.getLevel()==5 && Skill1==0){
								Skill1 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}else if(hero.getLevel()==10 && Skill2==0){
								Skill2 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}
							break;
						}

						monAtk = MonsterAttack(monsterElement,monAtk);

						heroHealth -= monAtk;
						System.out.println("Monster Hit For "+monAtk);
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

						if(heroHealth<1){
							cls();
							System.out.println("You have been defeated...");
							hero.setMoney(0);
							hero.setCurrExp(0);
							hero.setHealth(hero.getMaxHp());
							hero.setMana(hero.getMaxMana());
							System.out.println("Better Luck Next Time!");
							sc.nextLine();
						}

					}else if(move==2){

						int skillChosen=0;
						int heroAtk = 0;

						if(specialSkill==0 && hero.getLevel()<5){
							System.out.println("=============================");
							System.out.println("You Have No Skill Yet!");
							System.out.println("=============================");
							sc.nextLine();
							continue;
						}

						if(playerElement==1){

							if(hero.getLevel()>=5)
								System.out.println("1. Flame Slash [30 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Starfire Fury[100 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury[100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 30) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 30;
									heroAtk = PlayerAttack(monsterElement)+ 30 + rand.nextInt(31);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 100;
									heroAtk = PlayerAttack(monsterElement) + 70 + rand.nextInt(71);
								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}

						}else if(playerElement==2){

							if(hero.getLevel()>=5)
								System.out.println("1. Water Ailment [40 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Tsunami [80 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury [100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 40) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 40;
									heroHealth += 30;
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 80) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 80;
									heroAtk = PlayerAttack(monsterElement) + 50 + rand.nextInt(56);

								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}

							}

						}else if(playerElement==3){

							if(hero.getLevel()>=5)
								System.out.println("1. Thunder Bolt [30 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Zeus Rage [120 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury [100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 30) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 30;
									heroAtk = PlayerAttack(monsterElement) + 30 + rand.nextInt(31);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 120) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 120;
									heroAtk = PlayerAttack(monsterElement) + 40 + rand.nextInt(141);
								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}

						}else if(playerElement==4){

							if(hero.getLevel()>=5)
								System.out.println("1. Tremors[20 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. EarthBound Forces[200 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury[100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 20) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 20;
									heroAtk = PlayerAttack(monsterElement) + 10 + rand.nextInt(21);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 200) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 200;
									heroAtk = PlayerAttack(monsterElement) + 60 + rand.nextInt(100) + rand.nextInt(100);
								}


							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}

						}else if(playerElement==5){

							if(hero.getLevel()>=5)
								System.out.println("1. Alpha Strike[50 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Martial Peak[100 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury[100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 50) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 50;
									heroAtk = PlayerAttack(monsterElement)+ rand.nextInt(20)+ rand.nextInt(20)+ rand.nextInt(20)+ rand.nextInt(20)+ rand.nextInt(10);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 100;
									heroAtk = PlayerAttack(monsterElement) + 85 + rand.nextInt(30);
								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}
						}

						if(skillChosen!=3){
							if(!(playerElement==2 && skillChosen==1)){
								System.out.println("You Deals "+heroAtk+" damage");
								monsterHp -= heroAtk;

								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						}

						if(skillChosen==3 && specialSkill==1){
							System.out.println("You Got attack and defense buff for 10 second!");
							try {
								Thread.sleep(1500);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

						if(playerElement==2 && skillChosen==1 && Skill1==1){
							System.out.println("Health Restored!");
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

						if(monsterHp<1){
							if(defeatfirstMon==0){
								System.out.println("whoa.. That was hard, I need to strengthen myself more.. This feels like a game");
								System.out.print("Achievement Unlocked : First Win");
								defeatfirstMon =1;
								achievement++;
							}
							int exp = rand.nextInt(monsterLevel)+1;
							exp = exp * 50;
							hero.setCurrExp(hero.getCurrExp()+exp);
							hero.setMoney(hero.getMoney()+rand.nextInt(41)+10);
							if(hero.getCurrExp()>=hero.getNeededExp()){
								hero.setCurrExp(hero.getCurrExp()-hero.getNeededExp());
								hero.setLevel(hero.getLevel()+1);
								hero.setNeededExp(hero.getNeededExp()+50);
								hero.setMaxHp(hero.getMaxHp()+rand.nextInt(6)+10);
								hero.setHealth(hero.getMaxHp());
								hero.setMaxMana(hero.getMaxMana()+rand.nextInt(6)+10);
								hero.setMana(hero.getMaxMana());
							}
							if(hero.getLevel()==5 && Skill1==0){
								Skill1 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}else if(hero.getLevel()==10 && Skill2==0){
								Skill2 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}
							break;
						}

						monAtk = MonsterAttack(monsterElement,monAtk);

						heroHealth -= monAtk;
						System.out.println("Monster Hit For "+monAtk);
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

						if(heroHealth<1){
							cls();
							System.out.println("You have been defeated...");
							hero.setMoney(0);
							hero.setCurrExp(0);
							hero.setHealth(hero.getMaxHp());
							hero.setMana(hero.getMaxMana());
							System.out.println("Better Luck Next Time!");
							sc.nextLine();
						}

					}else if(move==3){

						System.out.println("Trying to run away....");
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
						}

						if(heroHealth>monsterHp) {
							if(rand.nextInt(100)<70) {
								System.out.println("You succesfully ran away!");
								try {
									Thread.sleep(1500);
								} catch (Exception e) {
									// TODO: handle exception
								}
								break;
							}
							else {
								System.out.println("You failed to run away!");
								try {
									Thread.sleep(1500);
								} catch (Exception e) {
									// TODO: handle exception
								}
								monAtk = MonsterAttack(monsterElement,monAtk);

								heroHealth -= monAtk;
								System.out.println("Monster Hit For "+monAtk);
								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}

								if(heroHealth<1){
									cls();
									System.out.println("You have been defeated...");
									hero.setMoney(0);
									hero.setCurrExp(0);
									hero.setHealth(hero.getMaxHp());
									hero.setMana(hero.getMaxMana());
									System.out.println("Better Luck Next Time!");
									sc.nextLine();
								}
								continue;
							}
						}
						else if(heroHealth<monsterHp) {
							if(rand.nextInt(100)<45) {
								System.out.println("You succesfully ran away!");
								try {
									Thread.sleep(1500);
								} catch (Exception e) {
									// TODO: handle exception
								}
								break;
							}
							else {
								System.out.println("You failed to run away!");
								try {
									Thread.sleep(1500);
								} catch (Exception e) {
									// TODO: handle exception
								}
								monAtk = MonsterAttack(monsterElement,monAtk);

								heroHealth -= monAtk;
								System.out.println("Monster Hit For "+monAtk);
								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}

								if(heroHealth<1){
									cls();
									System.out.println("You have been defeated...");
									hero.setMoney(0);
									hero.setCurrExp(0);
									hero.setHealth(hero.getMaxHp());
									hero.setMana(hero.getMaxMana());
									System.out.println("Better Luck Next Time!");
									sc.nextLine();
								}
								continue;
							}
						}

					}else if(move==4){
						useItem();
					}
					hero.setHealth(heroHealth);
					hero.setMana(heroMana);

					heroMana+=10;
					if(heroMana>hero.getMaxMana()){
						heroMana = hero.getMaxMana();
					}

				}while(monsterHp> 0 && heroHealth> 0);


			}else if(nextMove==2){
				int bossLevel = 0;
				heroHealth = hero.getHealth();
				heroMana = hero.getMana();
				String bossName = null;
				if(BossDefeated == 0) {
					System.out.println("Demon Tactician : How can a fool like you oppose the demon army? It doesn’t matter, you’re going to die anyway!");
					System.out.println("Press enter to continue");
					sc.nextLine();
					bossName = "The Demon Tactician (Level 5)";
					bossLevel = 5;
				}

				if (BossDefeated == 1) {
					System.out.println("Demon General : Brave hero , You came this Far to meet your own demise");
					System.out.println("Press enter to continue");
					sc.nextLine();
					bossName = "The Demon General (Level 10)";
					bossLevel = 10;
				}

				if(BossDefeated == 2) {
					System.out.println(name+ " : Demon Lord your invasion ends today!");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("Demon Lord : "+name);
					Sleep(500);
					System.out.println(name+ " : How did you know my name?");
					Sleep(500);
					System.out.println("Demon Lord : Been a while hasn't it " +name+ "?");
					Sleep(500);
					System.out.println(name+ " : Hendry.. i.. is that you?");
					Sleep(500);
					System.out.println("Hendry : I am not the Hendry that you know anymore!! I'm the demon lord who will beat you down today");
					if(x==0){
						System.out.println("Achievement unlocked : Friends until death");
						achievement++;
						x=1;
					}
					System.out.println("Press enter to continue");
					sc.nextLine();
					bossName = "The Demon Lord (Level 15)";
					bossLevel = 15;
				}

				if(BossDefeated>10){
					System.out.println("the player became corrupted by the hand of endless void, he became the next demon lord and rule the world of magis with cruelty and slavery");
					System.out.println("Ending unlocked : The Evil Within");
					return;
				}

				if(BossDefeated > 2) {

					System.out.println("Endless Void");
					sc.nextLine();
					bossName = "Endless Void (Level "+((BossDefeated+1)*5)+")";
					bossLevel = (BossDefeated+1)*5;
				}

				int bossHp = 100 + BossDefeated*100;

				int move = 0;
				do{
					cls();
					heroHealth = hero.getHealth();
					heroMana = hero.getMana();
					System.out.println(name+" Hp : "+heroHealth  + " / " + hero.getMaxHp());
					System.out.println(name+" Mana : "+heroMana  + " / " + hero.getMaxMana());
					System.out.println("Boss Name : "+bossName);
					System.out.println("Boss Hp : "+bossHp);
					if(attackPotion.isAlive()) System.out.println("Battle Potion : Active");
					else if(!attackPotion.isAlive()) System.out.println("Battle Potion : None");
					if(deffensePotion.isAlive()) System.out.println("Defense Potion : Active");
					else if(!deffensePotion.isAlive()) System.out.println("Defense Potion : None");
					System.out.println("=============================================");
					System.out.println("1. basic attack");
					System.out.println("2. skill");
					System.out.println("3. item");
					System.out.print("your move: ");
					move = sc.nextInt(); sc.nextLine();
					switch (move) {
					case 1:
						int heroAtk = PlayerAttackBoss();
						System.out.println("You Deals "+heroAtk+" damage");
						bossHp = bossHp - heroAtk;

						if(bossHp<1){
							BossDefeated++;
							int exp = rand.nextInt(bossLevel)+1;
							exp = exp * 100;
							hero.setCurrExp(hero.getCurrExp()+exp);
							if(hero.getCurrExp()>=hero.getNeededExp()){
								hero.setCurrExp(hero.getCurrExp()-hero.getNeededExp());
								hero.setLevel(hero.getLevel()+1);
								hero.setNeededExp(hero.getNeededExp()+50);
								hero.setMaxHp(hero.getMaxHp()+rand.nextInt(6)+10);
								hero.setHealth(hero.getMaxHp());
								hero.setMaxMana(hero.getMaxMana()+rand.nextInt(6)+10);
								hero.setMana(hero.getMaxMana());
								hero.setMoney(hero.getMoney()+rand.nextInt(41)+10);
							}
							if(hero.getLevel()==5 && Skill1==0){
								Skill1 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}else if(hero.getLevel()==10 && Skill2 == 0){
								Skill2 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}
							if(BossDefeated==3){
								cls();
								System.out.println(name+ " : Why Hendry? Why did you have to do this?");
								Sleep(500);
								System.out.println("Hendry : I need to my friend, in order to go back to our world I need to kill you");
								Sleep(500);
								System.out.println(name+ " : What? Who told you that?");
								Sleep(500);
								System.out.println("Hendry : The Voice...");
								Sleep(500);
								System.out.println(name+ " : What voice?");
								Sleep(500);
								System.out.println("Hendry : The Endless Void");
								Sleep(500);
								System.out.println("Hendry died painfully");
								Sleep(500);
								System.out.println(name+ " : Hendry? NOOOO!!!!");
								System.out.println("Achievement unlocked : Demon Killer");
								achievement++;
								System.out.println("Press Enter to continue...");
								sc.nextLine();
								cls();
								System.out.println("Fatalis : Congratulation Hero! You have saved Magis from the demon lord");
								Sleep(500);
								System.out.println("Fatalis : We can send you back to your world. Do you wish to go back or enjoy the life of luxury here?");
								Sleep(500);
								System.out.println(name+ " Thoughts : I want to go back, but I also want to avenge Hendry");
								do {
									System.out.println("Do you wish to go back?");
									System.out.println("1. Go back");
									System.out.println("2. Avenge Hendry");
									System.out.print(">>");
									ending = sc.nextInt();
									sc.nextLine();
								}while(ending>2 || ending<1);
								if(ending == 1) {
									System.out.println(name+ " : I’m sorry Hendry but I miss my family and everyone else");
									Sleep(2000);
									cls();
									System.out.println("In the real world");
									Sleep(2000);
									cls();
									System.out.println(name+ " : Huh ? I'm in my bed? Is that a dream? What about hendry?");
									Sleep(500);
									System.out.println("Unknown: " +name+ "! Let’s play dude!");
									Sleep(500);
									System.out.println(name+ " : Hendry!!?! You’re alive?!?");
									Sleep(500);
									System.out.println("Hendry : What the hell dude? are you still asleep?");
									Sleep(500);
									System.out.println(name+ " : Huh? so it was all just a dream?");
									Sleep(2000);
									System.out.println(name+" hear a faint voice in the distant, it was a voice he recognise");
									Sleep(500);
									System.out.println("Fatalis : Alright then, I guess this is farewell, thank you for your bravery " +name);
									Sleep(500);
									System.out.println("Ending unlocked : Hero of Magis");
									return;
								}
								System.out.println("Achievement unlocked : Avengers");
								achievement++;
								continue;
							}
						}

						int bossAtk = demonLord.attack(bossLevel);
						//		
						if(deffensePotion.isAlive()){ // thread battle potion
							bossAtk = bossAtk * 4 / 5;
						}
						if(SpecialBuff.isAlive()){ // thread battle potion
							bossAtk = bossAtk * 4 / 5;
						}
						heroHealth -= bossAtk;
						System.out.println("Boss Hit For "+bossAtk);
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

						if(heroHealth<1){
							if(x==1){
								System.out.println("Achievement unlocked : Backstabbed");
								achievement++;
								x=2;
							}
							cls();
							System.out.println("You have been defeated...");
							hero.setMoney(0);
							hero.setCurrExp(0);
							hero.setHealth(hero.getMaxHp());
							hero.setMana(hero.getMaxMana());
							System.out.println("Better Luck Next Time!");
							sc.nextLine();
						}
						hero.setHealth(heroHealth);
						hero.setMana(heroMana);
						break;

					case 2 :
						int skillChosen=0;
						heroAtk = 0;

						if(specialSkill==0 && hero.getLevel()<5){
							System.out.println("=============================");
							System.out.println("You Have No Skill Yet!");
							System.out.println("=============================");
							sc.nextLine();
							continue;
						}

						if(playerElement==1){

							if(hero.getLevel()>=5)
								System.out.println("1. Flame Slash [30 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Starfire Fury[100 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury[100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 30) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 30;
									heroAtk = PlayerAttackBoss()+ 30 + rand.nextInt(31);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 100;
									heroAtk = PlayerAttackBoss() + 70 + rand.nextInt(71);
								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}

						}else if(playerElement==2){

							if(hero.getLevel()>=5)
								System.out.println("1. Water Ailment [40 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Tsunami [80 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury [100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 40) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 40;
									heroHealth += 30;
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 80) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 80;
									heroAtk = PlayerAttackBoss() + 50 + rand.nextInt(56);

								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}

							}

						}else if(playerElement==3){

							if(hero.getLevel()>=5)
								System.out.println("1. Thunder Bolt [30 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Zeus Rage [120 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury [100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 30) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 30;
									heroAtk = PlayerAttackBoss() + 30 + rand.nextInt(31);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 120) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 120;
									heroAtk = PlayerAttackBoss() + 40 + rand.nextInt(131);
								}


							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}

						}else if(playerElement==4){

							if(hero.getLevel()>=5)
								System.out.println("1. Tremors[10 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. EarthBound Forces[200 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury[100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 10) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 10;
									heroAtk = PlayerAttackBoss() + 10 + rand.nextInt(21);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 200) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 200;
									heroAtk = PlayerAttackBoss() + 60 + rand.nextInt(100) + rand.nextInt(100);
								}


							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}

						}else if(playerElement==5){

							if(hero.getLevel()>=5)
								System.out.println("1. Alpha Strike[50 mana]");
							if(hero.getLevel()>=10)
								System.out.println("2. Martial Peak[100 mana]");
							if(specialSkill==1)
								System.out.println("3. Battle Fury[100 mana]");
							System.out.print(">> ");
							skillChosen = sc.nextInt(); sc.nextLine();

							if(skillChosen==1){
								if (hero.getMana() < 50) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill1==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 50;
									heroAtk = PlayerAttackBoss()+ rand.nextInt(20)+ rand.nextInt(20)+ rand.nextInt(20)+ rand.nextInt(20)+ rand.nextInt(10);
								}

							}else if(skillChosen==2){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(Skill2==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									heroMana -= 100;
									heroAtk = PlayerAttackBoss() + 85 + rand.nextInt(30);
								}

							}else if(skillChosen==3){
								if (hero.getMana() < 100) {
									System.out.println("Not enough mana !"); sc.nextLine();
								}else if(specialSkill==0){
									System.out.println("You Don't have this skill"); sc.nextLine();
								}
								else {
									if(SpecialBuff.isAlive()) {
										System.out.println("Your buff is on active right now !");
										sc.nextLine();
									}
									else {
										if(!(SpecialBuff.isAlive()) && bfThread == true) {
											SpecialBuff = new Thread(new BattleFurys());
										}
										heroMana -= 100;
										SpecialBuff.start();
										bfThread = true;
									}
								}
							}
						}

						if(skillChosen!=3){
							if(!(playerElement==2 && skillChosen==1)){
								System.out.println("You Deals "+heroAtk+" damage");
								bossHp -= heroAtk;

								try {
									Thread.sleep(1000);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						}

						if(skillChosen==3 && specialSkill==1){
							System.out.println("You Got attack and defense buff for 10 second!");
							try {
								Thread.sleep(1500);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

						if(playerElement==2 && skillChosen==1 && Skill1==1){
							System.out.println("Health Restored!");
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

						if(bossHp<1){
							BossDefeated++;
							int exp = rand.nextInt(bossLevel)+1;
							exp = exp * 100;
							hero.setCurrExp(hero.getCurrExp()+exp);
							hero.setMoney(hero.getMoney()+rand.nextInt(200)+10);
							if(hero.getCurrExp()>=hero.getNeededExp()){
								hero.setCurrExp(hero.getCurrExp()-hero.getNeededExp());
								hero.setLevel(hero.getLevel()+1);
								hero.setNeededExp(hero.getNeededExp()+50);
								hero.setMaxHp(hero.getMaxHp()+rand.nextInt(6)+10);
								hero.setHealth(hero.getMaxHp());
								hero.setMaxMana(hero.getMaxMana()+rand.nextInt(6)+10);
								hero.setMana(hero.getMaxMana());
							}
							if(hero.getLevel()==5 && Skill1==0){
								Skill1 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}else if(hero.getLevel()==10 && Skill2==0){
								Skill2 = 1;
								System.out.println("You Unlock A Skill!");
								sc.nextLine();
							}
							if(BossDefeated==3){
								cls();
								achievement++;
								System.out.println(name+ " : Why Hendry? Why did you have to do this?");
								Sleep(500);
								System.out.println("Hendry : I need to my friend, in order to go back to our world I need to kill you");
								Sleep(500);
								System.out.println(name+ " : What? Who told you that?");
								Sleep(500);
								System.out.println("Hendry : The Voice...");
								Sleep(500);
								System.out.println(name+ " : What voice?");
								Sleep(500);
								System.out.println("Hendry : The Endless Void");
								Sleep(500);
								System.out.println("Hendry died painfully");
								Sleep(500);
								System.out.println(name+ " : Hendry? NOOOO!!!!");
								System.out.println();
								System.out.println("Achievement unlocked : Demon Killer");
								System.out.println("Press Enter to continue...");
								sc.nextLine();
								cls();
								System.out.println("Fatalis : Congratulation Hero! You have saved Magis from the demon lord");
								Sleep(500);
								System.out.println("Fatalis : We can send you back to your world. Do you wish to go back or enjoy the life of luxury here?");
								Sleep(500);
								System.out.println(name+ " Thoughts : I want to go back, but I also want to avenge Hendry");
								do {
									System.out.println("Do you wish to go back?");
									System.out.println("1. Go back");
									System.out.println("2. Avenge Hendry");
									System.out.print(">>");
									ending = sc.nextInt();
									sc.nextLine();
								}while(ending>2 || ending<1);
								if(ending == 1) {
									System.out.println(name+ " : I’m sorry Hendry but I miss my family and everyone else");
									Sleep(2000);
									cls();
									System.out.println("In the real world");
									Sleep(2000);
									cls();
									System.out.println(name+ " : Huh ? I'm in my bed? Is that a dream? What about hendry?");
									Sleep(500);
									System.out.println("Unknown: " +name+ "! Let’s play dude!");
									Sleep(500);
									System.out.println(name+ " : Hendry!!?! You’re alive?!?");
									Sleep(500);
									System.out.println("Hendry : What the hell dude? are you still asleep?");
									Sleep(500);
									System.out.println(name+ " : Huh? so it was all just a dream?");
									Sleep(2000);
									System.out.println(name+" hear a faint voice in the distant, it was a voice he recognise");
									Sleep(500);
									System.out.println("Fatalis : Alright then, I guess this is farewell, thank you for your bravery " +name);
									Sleep(500);
									System.out.println("Ending unlocked : Hero of Magis");			
									return;
								}
								System.out.println("Achievement unlocked : Avengers");
								achievement++;
								continue;
							}
						}

						bossAtk = demonLord.attack(bossLevel);		
						if(deffensePotion.isAlive()){ // thread battle potion
							bossAtk = bossAtk * 4 / 5;
						}
						if(SpecialBuff.isAlive()){ // thread battle potion
							bossAtk = bossAtk * 4 / 5;
						}
						heroHealth -= bossAtk;
						System.out.println("Boss Hit For "+bossAtk);
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
						}

						if(heroHealth<1){
							cls();
							System.out.println("You have been defeated...");
							hero.setMoney(0);
							hero.setCurrExp(0);
							hero.setHealth(hero.getMaxHp());
							hero.setMana(hero.getMaxMana());
							System.out.println("Better Luck Next Time!");
							if(x==1){
								System.out.println("Achievement unlocked : Backstabbed");
								achievement++;
								x=2;
							}
							sc.nextLine();
						}
						hero.setHealth(heroHealth);
						hero.setMana(heroMana);
						break;

					case 3 :
						useItem();
						break;
					}
					heroMana += 10;
					if(heroMana>hero.getMaxMana()){
						heroMana = hero.getMaxMana();
					}
				} while (heroHealth > 0 && bossHp > 0);

			}else if(nextMove==3){
				int tempGold = 0;
				int option = 0;
				System.out.println("StoreKeeper : Welcome! We got everything you need!");
				System.out.println("=======================================");
				System.out.println("|           Swordsman Store           |");
				System.out.println("=======================================");
				System.out.println("|           Item          |   Price   |");
				System.out.println("| 1. Potion               |  15 Gold  |");
				System.out.println("| 2. Battle Potion        |  40 Gold  |");
				System.out.println("| 3. Defense Potion       |  40 Gold  |");
				System.out.println("| 4. Special Skill        | 150 Gold  |");
				System.out.println("=======================================");
				System.out.print("Option [0 to exit]: ");
				do{
					try {
						option = sc.nextInt();
						sc.nextLine();
					} catch (Exception e) {
						// TODO: handle exception
						option = 100;
						sc.nextLine();
					}
				}while(option < 0 || option > 4);
				switch (option){
				case 0:
					break;
				case 1:
					if(hero.getMoney() >= 15){
						potion += 1;
						tempGold = hero.getMoney() - 15;
						hero.setMoney(tempGold);
					}else {
						System.out.println("Not enough gold !!");
						sc.nextLine();
					}
					break;

				case 2:
					if(hero.getMoney() >= 40){
						dmgPotion += 1;
						tempGold = hero.getMoney() - 40;
						hero.setMoney(tempGold);
					}else {
						System.out.println("Not enough gold !!");
						sc.nextLine();
					}
					break;

				case 3:
					if(hero.getMoney() >= 40){
						deffPotion +=1;
						tempGold = hero.getMoney() - 40;
						hero.setMoney(tempGold);
					}else {
						System.out.println("Not enough gold !!");
						sc.nextLine();
					}
					break;

				case 4:
					if(day % 5 == 0) {
						if (hero.getMoney() >= 150) {
							specialSkill = 1;
							tempGold = hero.getMoney() - 150;
							hero.setMoney(tempGold);
						}
						else {
							System.out.println("Not enough gold !!");
							sc.nextLine();
						}
					}
					else {
						System.out.println("You can't buy special skill right now ! Read Help on menu 4");
						sc.nextLine();
					}
					break;
				}

			}else if(nextMove==4){

				System.out.println("Level Up to Defeat The Demon Lord!");
				System.out.println("First You Need to defeat The Demon General and The Demon Tactican");
				System.out.println("But Don't Worry! the Goddess bless you with a powerful skill after you level up for a bit");
				System.out.println("You're still weak so you should train and defeat monster first");
				System.out.println("You can also use potion or other buff");
				System.out.println("Potion and other buff can be bought in the store!");
				System.out.println("Every Fifth day there will be a special skill in store!");
				System.out.println("Buff will remain for 2 minutes each (real world time) , not including special skill buff");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				sc.nextLine();

			}else if(nextMove==5){
				System.out.println("=======================================");
				System.out.printf("|  %14s Inventory           |\n", name);
				System.out.println("=======================================");
				System.out.println("|           Item          |    Qty    |");
				System.out.println("|-------------------------|-----------|");
				System.out.printf("| 1. Potion               |  %2d Item  |\n", potion);
				System.out.printf("| 2. Battle Potion        |  %2d Item  |\n", dmgPotion);
				System.out.printf("| 3. Defense Potion       |  %2d Item  |\n", deffPotion);
				System.out.println("=======================================");
				sc.nextLine();

			}else if(nextMove==6){
				cls();
				System.out.println("the hero fell into depression and decided to kill himself…");
				System.out.println("Magis falls into ruin shortly after");
				System.out.println("Ending Unlock : Depressed Hero");
			}
		}while(nextMove!=6);
		System.out.println(achievement+"/6 Achievement Unlocked");
	}// end of code

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	void cls(){
		for(int zz=0;zz<30;zz++){
			System.out.println();
		}
	}

	void useItem() {
		int potionchoice;
		do {
			System.out.println("1. Health Potion  : " +potion);
			System.out.println("2. Battle Potion  : "+dmgPotion);
			System.out.println("3. Defense Potion : "+deffPotion);
			System.out.println("4. Back");
			System.out.print("Your choice: ");
			try {
				potionchoice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				potionchoice = 0;
				sc.nextLine();
			}


			if(potionchoice == 1) {
				if (potion < 1) {
					System.out.println("Not enough potion!");
					sc.nextLine();
				}
				else {
					heroHealth += 50;
					hero.setHealth(heroHealth);
					if(hero.getHealth() > hero.getMaxHp()) {
						hero.setHealth(hero.getMaxHp());
					}
					heroHealth = hero.getHealth();
					potion -= 1;
					System.out.println("Health restored!");
					sc.nextLine();
				}

			}

			else if(potionchoice == 2) {
				if (dmgPotion < 1) {
					System.out.println("Not enough potion!");
					sc.nextLine();
				}
				else {
					if(attackPotion.isAlive()) {
						System.out.println("You already using a buff!");
						sc.nextLine();
					}
					else {
						if (!(attackPotion.isAlive()) && thread == true){
							attackPotion = new Thread(new Buff());
						}
						attackPotion.start();
						thread = true;
						dmgPotion -= 1;
					}	
				}	
			}	

			else if(potionchoice == 3) {
				if (deffPotion < 1) {
					System.out.println("Not enough potion!");
					sc.nextLine();
				}
				else {
					if(deffensePotion.isAlive()) {
						System.out.println("You already using a buff!");
						sc.nextLine();
					}
					else {
						if (!(deffensePotion.isAlive()) && thread1 == true){
							deffensePotion = new Thread(new Buff());
						}
						deffensePotion.start();
						thread1 = true;
						deffPotion -= 1;
					}	
				}
			}
			else if(potionchoice == 4) {
				break;
			}
		}while(potionchoice<1 || potionchoice>4);
	}

	int MonsterAttack(int monsterElement,int monAtk){
		if(playerElement!=5){ // element buff
			if(playerElement==1 && monsterElement==4){
				monAtk = monAtk /2;								
			}else if(playerElement-monsterElement==1){
				monAtk = monAtk /2;
			}else if(playerElement==4 && monsterElement==1){
				monAtk = monAtk * 3 /2;
			}else if(playerElement-monsterElement== -1){
				monAtk = monAtk * 3 /2;
			}
		}
		if(deffensePotion.isAlive()){ // thread battle potion
			monAtk = monAtk * 4 / 5;
		}
		if(SpecialBuff.isAlive()){ // thread battle potion
			monAtk = monAtk * 4 / 5;
		}
		return monAtk;
	}

	int PlayerAttack(int monsterElement){
		int heroAtk = hero.attack(hero.getLevel());
		if(playerElement!=5){ // element buff
			if(playerElement==1 && monsterElement==4){
				heroAtk = heroAtk * 3 /2;
			}else if(playerElement-monsterElement==1){
				heroAtk = heroAtk * 3 /2;
			}else if(playerElement==4 && monsterElement==1){
				heroAtk = heroAtk /2;
			}else if(playerElement-monsterElement== -1){
				heroAtk = heroAtk /2;
			}
		}
		if(attackPotion.isAlive()){ // thread battle potion
			heroAtk = heroAtk * 6/5;
		}
		if(SpecialBuff.isAlive()){
			heroAtk = heroAtk *6/5;
		}

		return heroAtk;
	}

	int PlayerAttackBoss() {
		int heroAtk = hero.attack(hero.getLevel());

		if(attackPotion.isAlive()){ // thread battle potion
			heroAtk = heroAtk * 6/5;
		}
		if(SpecialBuff.isAlive()){
			heroAtk = heroAtk *6/5;
		}
		return heroAtk;
	}

	void Sleep(int x){
		try {
			Thread.sleep(x);
		} catch (Exception e) {
			// TODO: handle exception
			sc.nextLine();
		}
	}

}

import java.util.*;
import java.io.*;
public class DesertEscape
{   
	/*
	git status --> what is different from online and local
	git add . --> adds everything
	git add blah.java --> adds only one file
	git commit -m "message" --> packages all the changes, ready to be pushed
	git push --> move it online
	*/
	public static String gun ="pistol";
	public static int damage = 50;
	public static int food = 2;
	public static int shots = 2; 
	public static int health = 100;
	public static int bullets = 5;
	public static int money = 500;
	public static int hunger = 0;
	public static int gas = 50;
	public static int day = 1;
	public static int time = 0;
	public static boolean carRepair= false;
	public static Scanner input=new Scanner(System.in);
	public static void printSlowly(String message){
		for(int i=0; i<message.length();i ++){
			System.out.print(message.charAt(i));
			try{
				Thread.sleep(50);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println();
	}
	public static void speak(String speaker, String message){
		System.out.print(speaker+": ");
		try{
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		printSlowly(message);
	}
	public static void welcome(){
		printSlowly("You are in the country of desertland. Bad weather will come in 5 days. You have a jeep, some fuel, 2 days worth of food, and 500 dollars. If you don't cross the country in 10 days you will die.");
		printSlowly("Type /watch to see the day and time");
		printSlowly("Type /items to check inventory");
		printSlowly("Type /stats to check health and hunger");
		printSlowly("You have a gun with 5 bullets, 100 health, 500 dollars, 0 hunger, 50 fuel, and it is day 1.");
	}
	public static void oasisOutpost(){
		System.out.println("You go to the oasis outpost to get some items. A nice man named Buffalo Bill assists you.");
		speak("Buffalo Bill", "Howdy, how may I help you?");
		speak("You", "What items may I buy here?");
		System.out.println("Buffalo Bill points at a board on the wall.");
		try{
			Thread.sleep(500);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║            ~ The Oasis Outpost ~            ║");
        System.out.println("║          ~ Gear Up for the West! ~          ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║                 ITEMS FOR SALE:             ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║  1. 1 pound of Food    - 25 bucks           ║");
        System.out.println("║  2. 20 bullets         - 20 bucks           ║");
        System.out.println("║  3. 50 miles of gas    - 10 bucks           ║");
        // System.out.println("║  4. Car repair kit     - 200 bucks          ║");
        // System.out.println("║  5. Outlaw Shotgun     - 200 bucks          ║");
        // System.out.println("║  6. Random Item        - 100 bucks          ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.println("To get an item type the corresponding number and then you can choose the amount of it(Not all items can be bought twice).");
        System.out.println("When you are finished type 0");
        while(true){
        	System.out.println("What item do you want to purchase?");
        	int choice=readInt();
        	if(choice==0){
        		break;
        	}
        	System.out.println("How much do you want of that item?");
        	int amount=readInt();
        	if(choice==1){
        		if(money<25*amount){
        			System.out.println("Not enough money");
        		}
        		else{
        			money-=25*amount;
        			food+=amount;
        			System.out.println("You have "+ money +" bucks.");
        			System.out.println("You have "+ food +" pounds of food.");
        		}
        	}
        	else if(choice==2){
        		if(money<20*amount){
        			System.out.println("Not enough money");
        		}
        		else{
        			money-=20*amount;
        			bullets+=20*amount;
        			System.out.println("You have "+ money +" bucks.");
        			System.out.println("You have "+ bullets +" bullets.");
        		}
        	}
        	else if(choice==3){
        		if(money<10*amount){
        			System.out.println("Not enough money");
        		}
        		else{
        			money-=10*amount;
        			gas+=50*amount;
        			System.out.println("You have "+ money +" bucks.");
        			System.out.println("You have "+ gas +" miles of gas.");
        		}
        	}
        	else{
        		System.out.println("Not an option");
        	}
        }
        speak("Buffalo Bill", "See You later");
	}
	public static int readInt(){
		if(input.hasNextInt()){
			return input.nextInt();
		}
		String word= input.next();
		if(word.equals("/exit"))
		{
			System.exit(0);
		}
		//make /items and /stats work here
		System.out.println("Not a number.");
		return -1;
	}
	public static boolean roll(int chance){
		return Math.random()<=chance/100.0;
	}
	public static void riverScene(){
		printSlowly("You drive for 50 miles until you come across a river.");
		gas-=50;
		System.out.println("You have "+gas+ " miles of gas left." );
		printSlowly("You have 3 options. The first one is a drawbridge that you can cross. It costs 100 dollars and has a small chance of failure.");
		printSlowly("The second option is to drive through the river and a big chance of drowning.");
		printSlowly("Your last option is to drive around the river and it will take 100 miles of gas.");
		System.out.println("Choose your option.");
		while(true){
			int choice=readInt();
			if(choice==1){
				if(money>=100){
					money-=100;
					if(roll(75)){
						System.out.println("You cross the drawbridge successfully.");
						break;
					}
					else{
						System.out.println("The drawbrige snaps and you die.");
						System.exit(0);
					}
				}
				else{
					System.out.println("You don't have enough money to cross.")
				}
			}
			else if(choice==2){
				if(roll(25)){
					System.out.println("You drove through the river successfully");
					break;
				}
				else{
					System.out.println("You drown and die");
					System.exit(0);
				}
			}
		}	
	}
	public static void main(String[] args)
	{
		//welcome();
		//oasisOutpost();
		riverScene();


	}
}
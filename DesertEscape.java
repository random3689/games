import java.util.*;
import java.io.*;
public class DesertEscape
{   
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
	public static void printSlowly(String message) throws InterruptedException{
		for(int i=0; i<message.length();i ++){
			System.out.print(message.charAt(i));
			Thread.sleep(50);
		}
		System.out.println();
	}
	public static void speak(String speaker, String message)throws InterruptedException{
		System.out.print(speaker+": ");
		Thread.sleep(1000);
		printSlowly(message);
	}
	public static void welcome() throws InterruptedException{
		printSlowly("You are in the country of desertland. Bad weather will come in 5 days. You have a jeep, some fuel, 2 days worth of food, and 500 dollars. If you don't cross the country in 10 days you will die.");
		printSlowly("Type watch to see the day and time");
		printSlowly("Type items to check inventory");
		printSlowly("Type stats to check health and hunger");
		printSlowly("You have a gun with 5 bullets, 100 health, 500 dollars, 0 hunger, 50 fuel, and it is day 1.");
	}
	public static void oasisOutpost() throws InterruptedException{
		System.out.println("You go to the oasis outpost to get some items. A nice man named Buffalo Bill assists you.");
		speak("Buffalo Bill", "Howdy, how may I help you?");
		speak("You", "What items may I buy here?");
		System.out.println("Buffalo Bill points at a board on the wall.");
		Thread.sleep(500);
		System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║            ~ The Oasis Outpost ~            ║");
        System.out.println("║          ~ Gear Up for the West! ~          ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║                 ITEMS FOR SALE:             ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║  1. 1 pound of Food    - 25 bucks           ║");
        System.out.println("║  2. 20 bullets         - 20 bucks           ║");
        System.out.println("║  3. 50 miles of gas    - 10 bucks           ║");
        System.out.println("║  4. Car repair kit     - 200 bucks          ║");
        System.out.println("║  5. Outlaw Shotgun     - 200 bucks          ║");
        System.out.println("║  6. Random Item        - 100 bucks          ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.println("To get an item type the corresponding number and then you can choose the amount of it(Not all items can be bought twice).");
        System.out.println("When you are finished type 0");
        while(true){
        	System.out.println("What item do you want to purchase?");
        	int choice=input.nextInt();
        	if(choice==0){
        		break;
        	}
        	System.out.println("How much do you want of that item?");
        	int amount=input.nextInt();
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
        }
        speak("Buffalo Bill", "See You later");
	}
	public static void main(String[] args) throws InterruptedException
	{
		welcome();
		oasisOutpost();



	}
}
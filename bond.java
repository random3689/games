import java.util.*;
import java.io.*;
public class bond
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to 007. You will have three actions that you can do.");
		System.out.println("To reload press r, to block press b, and to shoot press s.");
		System.out.println("reloading will add one bullet to your gun and can be infinitely added to.");
		System.out.println("Shooting can only be done if you have at least one bullet in your gun, and can kill the other player");
		System.out.println("Also shooting your gun will take away one bullet from your gun each time.");
		System.out.println("Finally, blocking will prevent any bullet that is shot at you.");
		int bullets=0;
		int botBullets=0;
		while(true){
			System.out.print("Pick an action:");
			String playerAction=input.next().toLowerCase();
			boolean pBlock=false;
			boolean pShoot=false;
			if(playerAction.equals("r")){
				bullets++;
			}
			else if(playerAction.equals("b")){
				pBlock=true;
			}
			else if(playerAction.equals("s")){
				if(bullets==0){
					System.out.println("Sorry, you don't have enough bullets");
					continue;
				}
				pShoot=true;
				bullets--;
			}
			else{
				System.out.println("Action not found");
				continue;
			}
			int choice=0;
			if(botBullets==0){
				choice=(int)(Math.random() * 2);

			}
			else{
				choice=(int)(Math.random() * 3);
			}
			if(choice==0){
				System.out.println("The computer chose to reload");
				if(pShoot==true){
					System.out.println("You won");
					break;
				}
				botBullets++;
			}
			else if(choice==1){
				System.out.println("The computer blocked");
			}
			else{
				System.out.println("the computer shot a bullet");
				if(pBlock==false&&pShoot==false){
					System.out.println("You lost");
					break;
				}
				botBullets--;
			}
		}

	}
}

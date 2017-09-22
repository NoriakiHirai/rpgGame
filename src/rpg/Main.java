package rpg;


import java.util.Scanner;

import rpg.user.User;
import rpg.user.UserNEE;
import rpg.user.UserTHI;
import rpg.user.UserType;
import rpg.user.UserWAR;
import rpg.user.UserWIZ;

public class Main {

	public static void main(String[] args) {

		User player = inputUser();
		printStatus(player);
		
		player.equipWeapon();
		player.equipArmor();
		
//		player.levelUp();
		printStatus(player);
	}

	static User inputUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("[U[ðì¬µÜ·");
		System.out.print("¼OF");
		String userName = sc.next();
		System.out.print("EÆ(1Ëím,2Ë@g¢,3Ë¯)F");
		int kariType = sc.nextInt();
		UserType userType = null;
		switch (kariType){
		case 1:
			userType = UserType.WARRIOR;
			break;
		case 2:
			userType = UserType.WIZARD;
			break;
		case 3:
			userType = UserType.THIEF;
			break;
		default:
			userType = UserType.NEET;
		}
		System.out.print("UÍF");
		String str = sc.next();
		System.out.print("f³F");
		String agi = sc.next();
		System.out.print("HPF");
		String hp = sc.next();
		System.out.println();
		User user = createUser(userName,userType,str,agi,hp);
		sc.close();
		return user;
	}

	static User createUser(
			String userName,
			UserType userType,
			String str,
			String agi,
			String hp){

		switch (userType){
		case WARRIOR:
			return new UserWAR(userName,userType,str,agi,hp);
		case WIZARD:
			return new UserWIZ(userName,userType,str,agi,hp);
		case THIEF:
			return new UserTHI(userName,userType,str,agi,hp);
		default:
			return new UserNEE(userName,userType,str,agi,hp);
		}
	}

	static void printStatus(User user){
		StringBuilder sb1 = new StringBuilder();
		sb1.append("¡").append(user.getUserName()).append("ÌXe[^X");
		System.out.println(sb1);
		StringBuilder sb2 = new StringBuilder();
		sb2.append("Êè¼:").append(user.getUserType()).append(user.getUserName());
		System.out.println(sb2);
		System.out.println("HPF" + user.getHp());
		System.out.println("UÍF" + user.getStr());
		System.out.println("f³F" + user.getAgi());
		System.out.println();
	}
}

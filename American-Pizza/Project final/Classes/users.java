package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class users {
	user userList[] = new user[100];
	static int userCount = 0;
	
	public users(){
		//reading the file and creating user objects to add them to the userList array
		try{
			File file = new File("Files/userdata.txt"); //location must be the path where the file is saved
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();  //name
					String line2 = sc.nextLine();  //password
					String line3 = sc.nextLine();  //gender
					String line4 = sc.nextLine();  //date of birth
					
					
					//printing them to cmd just to see if they are getting added to the list or not
				 	System.out.println(line1);
					System.out.println(line2);
					System.out.println(line3);

					
					//user u = new user("sadia","1234","Female","1/JAN/1990","Mirpur");
					user u = new user(line1,line2,line3);
					userList[userCount] = u; userCount++;
					System.out.println(userCount+"////////////////////////////");
				}
			sc.close();   //closing the file 		
		}catch(Exception ex){
			//System.out.println(ex);
			System.out.println("File not found.");
			return;
		}
	}
	
	
	public void addUser(user u){
		//adding the user to the userList array
		userList[userCount] = u;
		userCount++;
		
		//also adding them in file
		String userDetails=u.getName() + "\n" + u.getPassword() + "\n"+ u.getPhone() + "\n" + "\n";
		try{
			FileWriter fw = new FileWriter("Files/userdata.txt",true);
			fw.write(userDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);


		}
	}
}
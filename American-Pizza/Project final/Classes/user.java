package Classes;
import java.lang.*;

public class user{
	private String name;
	private String phone;
	private String passwrord;
	
	
	public user(String name, String passwrord,String phone){
		this.name = name;
		this.passwrord = passwrord;
		this.phone = phone;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String passwrord){
		this.passwrord = passwrord;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getName(){
		return name;
	}
	
	
	public String getPassword(){
		return passwrord;
	}
	public String getPhone(){
		return phone;
	};
}
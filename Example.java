package asses2;

import java.util.Scanner;

public class Example extends Customer {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Customer[] arr1=new Customer[10];
	Customer ob1=new Customer(1,"abc","ebhv",434);
	Customer ob2=new Customer(1,"abc","ebhv",434);
	Customer ob3=new Customer(1,"abc","ebhv",434);
	arr1[0]=ob1;
	arr1[1]=ob2;
	arr1[2]=ob3;
	
	System.out.println("enter id and password");
	
	String Id=sc.next();
	String pass=sc.next();
	
	if(Id.equals("ABCCust") && pass.equals("abc@123")){
		System.out.println("choice");
		int choice=sc.nextInt();
	switch(choice){
	case 1:
		System.out.println("id,name,email,mno");
		int id=sc.nextInt();
		String name=sc.next();
		String email=sc.next();
		int mno=sc.nextInt();
		Customer obj=new Customer(id,name,email,mno);
		arr1[arr1.length-1]=obj;
		break;
		
	case 2:	for(int i=0;i<arr1.length-1;i++)
	      {
		System.out.println("detais "+arr1[i].toString());
		
	     }
	break;
	
	case 3:
		System.out.println("id,name,email,mno");
		int id1=sc.nextInt();
		String name1=sc.next();
		String email1=sc.next();
		int mno1=sc.nextInt();
		
		for(int i=0;i<arr1.length-1;i++)
		{
			if(arr1[i].getEid()==id1)
			{
				arr1[i].setEid(id1);
				arr1[i].setEname(name1);
				arr1[i].setEmail(email1);
				arr1[i].setNo(mno1);
			}
		}
		break;
		
	case 4:
		System.out.println("id");
		int id2=sc.nextInt();
		for(int i=0;i<arr1.length-1;i++)
		{
			if(arr1[i].getEid()==id2)
			{
				arr1[i].setEid(0);
				arr1[i].setEname("");
				arr1[i].setEmail("");
				arr1[i].setNo(0);
			}
		}
		break;
		
		
	case 5:
		System.exit(0);
		break;
		
		
	}
		
		
	}
	
	
	
}
}

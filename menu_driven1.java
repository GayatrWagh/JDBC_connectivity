package jdbc_example;

import java.sql.*;
import java.util.*;

public class menu_driven1 {
	public static void main(String args[])
	{
		try (Scanner sc = new Scanner (System.in)) {
			int id;
			String name;
			String address;
			String sql;
			double per;
			
			
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gayatri","root","Gayatri@123");
				System.out.println("\n -----Connection Created-----");
				
				
				
				do {
					System.out.println("\n -----MENU-----\n");
					System.out.println("1. Insert Record");
					System.out.println("2. Delete Record");
					System.out.println("3. Update Record");
					System.out.println("4. View Record by id");
					System.out.println("5. View All Records");
					System.out.println("6. Exit");
					
					System.out.println("\n --Enter Your Choice--");
					int ch=sc.nextInt();
					
					switch(ch)
					{
					case 1:
						System.out.println("Enter roll no:");
						 id=sc.nextInt();
						System.out.println("Enter Name");
						name=sc.next();
						System.out.println("Enter address");
						 address=sc.next();
						System.out.println("Enter percentage");
						 per=sc.nextDouble();
						
						
						
						sql="insert into student values("+id+",'"+name+"','"+address+"',"+per+")";
						 Statement stmt=con.createStatement();
						int i=stmt.executeUpdate(sql);
						
						if(i>0)
							System.out.println("\n -----Record Inserted-----");
						else
							System.out.println("\n -----Record not inserted-----");
					
					break;
					
					
					
					case 2:
						System.out.println("Enter roll no:");
						id=sc.nextInt();
						
						
						 sql="delete from student where id="+id+"";
						
						 stmt=con.createStatement();
					      i=stmt.executeUpdate(sql);
						if(i>0)
							System.out.println("\n -----Record Deleted-----");
						else
							System.out.println("\n -----Record not Deleted-----");
						
						
						break;
						
					case 3:
						
						System.out.println("Enter roll no:");
						id=sc.nextInt();
						System.out.println("Enter Name");
						name=sc.next();
						System.out.println("Enter address");
						address=sc.next();
						System.out.println("Enter percentage");
						per=sc.nextDouble();
						
						  sql="update student set name='"+name+"',address='"+address+"',per="+per+" where id="+id+" ";
						 stmt=con.createStatement();
					       i=stmt.executeUpdate(sql);
						   if(i>0)
							System.out.println("\n -----Record Updated-----");
						else
							System.out.println("\n -----Record not Updated-----");
						
						break;
						
					case 4:
						System.out.println("Enter roll no:");
						id=sc.nextInt();
						
						sql="select * from student where id="+id+" ";
						stmt=con.createStatement();
						ResultSet  rs=stmt.executeQuery(sql);
						while(rs.next()) 
						{
							System.out.println("\n" +rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4));
							
						}
						break;
						
					case 5:
						sql="select * from student";
						 stmt=con.createStatement();
						 rs=stmt.executeQuery(sql);
						while(rs.next())
							System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4));
						break;
						
					case 6:
						System.exit(0);
						
						
						
						default:
							System.out.println("\n -----Invalid Choice!!...Please Enter Valid Choice-----");
						
					}
					
				
			}
				while(true);
				
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

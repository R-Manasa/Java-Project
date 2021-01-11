//package formattedoutput;
import java.util.*;
import java.io.*;
public class Bankingsystem{
public static void main(String[] args)throws IOException {
int i,num;
int choice=0,option;
float amount,balance=0;
int accno,mobno;
String name;
int searchaccno=0;
boolean flag=true;
boolean quit = false;
int snum;
BufferedReader br = new BufferedReader
(new InputStreamReader(System.in));
System.out.println("\n\t\t\tBANKING SYSTEM");
while(flag)
{
System.out.println("\n Menu");
System.out.println("1. Create coustomer File");
System.out.println("2. Search by acc no");
System.out.println("3. Generate Report");
System.out.println("4. Quit");
System.out.print("Enter your choice: ");
choice= Integer.parseInt(br.readLine());
switch(choice){

case 1:
// Create a file.
FileWriter fout = new FileWriter("test.txt");
//Read data from Keyboard
System.out.println("How many records? ");
num= Integer.parseInt(br.readLine());
for(i=0;i<num;i++)
{
System.out.println("enter accno:");
accno = Integer.parseInt(br.readLine());
System.out.println("Enter name:");
name=br.readLine();
System.out.println("enter mobno:");
mobno = Integer.parseInt(br.readLine());
System.out.println("\n");//print blankline
// Write to file.
do
{
System.out.println("\n1.deposit\n 2.withdrawl\n 3.balance ");
System.out.println("option:");
option=Integer.parseInt(br.readLine());
if(option==1)
{
Scanner in = new Scanner(System.in);
System.out.println("enter amount to be deposit");
amount =in.nextFloat();
if (amount <= 0)
System.out.println("Can't deposit nonpositive amount.");

else {
balance += amount;;
System.out.println("$" + amount + " has been deposited.");
}
}
if(option==2)
{
Scanner in = new Scanner(System.in);
System.out.println("enter amount to be withdraw");
amount= in.nextFloat();
if (amount <= 0 || amount > balance)
System.out.println("Withdrawal can't be completed.");
else {
balance =balance-amount;
System.out.println("$" + amount + " has been withdrawn.");
}
}
if(option==3)
{

System.out.println("Your balance: $" + balance);
break;
}

} while (!quit);
Formatter fmt1 = new Formatter();
fmt1.format("%10d\n%10s \n%10d\n",accno,name,mobno);
fout.write(fmt1+"\r\012");

}
fout.write("EOF");
fout.close();
System.out.println("File is created");
break;
case 2: snum=0;
System.out.print("enter search Id: ");
searchaccno = Integer.parseInt(br.readLine());
//Read data from file
FileReader fin1 = new FileReader("test.txt");
Scanner sc1 = new Scanner(fin1);
while(sc1.hasNextInt())
{
accno = sc1.nextInt();
name = sc1.next();
mobno= sc1.nextInt();
if(accno==searchaccno)
{
//Display formatted output
++snum;//increment serial number
Formatter fmt2 = new Formatter();
fmt2.format("%10d.\taccno.: %10d",snum,accno);
Formatter fmt3 = new Formatter();
fmt3.format
("\tName: %10s mob no: %2d",name,mobno);
System.out.println(fmt2);
System.out.println(fmt3);
System.out.println("Your balance: $" + balance);

}
}
name = sc1.next();
if(name.equals("EOF"))
System.out.println("Search is completed");
else
System.out.println("File format error.");
fin1.close();
break;
case 3:snum=0;
System.out.println("\t\t\t details of customers");
//Read data from file
FileReader fin2 = new FileReader("test.txt");
Scanner sc2 = new Scanner(fin2);
while(sc2.hasNextInt())
{
accno = sc2.nextInt();
name = sc2.next();
mobno= sc2.nextInt();

//Display formatted output
++snum;//increment serial number
Formatter fmt2 = new Formatter();
fmt2.format("%10d.\taccnoo.: %10d",snum,accno);
Formatter fmt3 = new Formatter();
fmt3.format
("\tName: %10s mobno: %2d",name,mobno);
System.out.println(fmt2);

System.out.println(fmt3);
System.out.println("Your balance: $" + balance);
}
System.out.println("End of list");
fin2.close();
break;
case 4: flag=false;
break;
default:System.out.println("Wrong Choice!!");
}
}
System.out.println("Program is over");
}
}
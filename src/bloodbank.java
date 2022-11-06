import java.sql.*;
import java.util.Scanner;

public class bloodbank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice, donorage;
        String donorname,donoraddress, donorphone,donorbloodgroup;



        while(true){
            System.out.println("Donor Management App");
            System.out.println("1. Add Donor");
            System.out.println("2. View All Donor");
            System.out.println("3. Search for a Donor");
            System.out.println("4. Update a Donor");
            System.out.println("5. Delete a Donor");
            System.out.println("6. Exit ");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Add Donor");
                    System.out.println("Enter the Donor name: ");
                    donorname = input.next();
                    System.out.println("Enter Donor's Phone: ");
                    donorphone = input.next();
                    System.out.println("Enter the Address: ");
                    donoraddress = input.next();
                    System.out.println("Enter the Blood Group: ");
                    donorbloodgroup = input.next();
                    System.out.println("Enter the Age: ");
                    donorage = input.nextInt();


                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root","");
                        String sql = "INSERT INTO `donors`( `name`, `phone`, `address`, `bloodgroup`, `age`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,donorname);
                        stmt.setString(2,donorphone);
                        stmt.setString(3,donoraddress);
                        stmt.setString(4,donorbloodgroup);
                        stmt.setInt(5,donorage);
                        stmt.executeUpdate();
                        System.out.println("Data Inserted Successfully\n");


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;

                case 2:
                    System.out.println("View All Donors");
                    break;


                case 3:
                    System.out.println("Search for an Donors");

                    break;
                case 4:
                    System.out.println("Update a Donor");

                    break;
                case 5:
                    System.out.println("Delete a Donor");

                    break;


                case 6:
                    System.out.println("Exited Menu");
                    System.exit(0);






            }

        }
    }
}

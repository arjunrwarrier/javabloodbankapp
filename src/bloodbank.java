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
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb","root","");
                        String sql ="SELECT  `name`, `phone`, `address`, `bloodgroup`, `age` FROM `donors`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            String fetchDonorName = rs.getString("name");
                            String fetchDonorPhone = rs.getString("phone");
                            String fetchDonorAddress = rs.getString("address");
                            String fetchBloodGroup = rs.getString("bloodgroup");
                            String fetchDonorAge = rs.getString("age");

                            System.out.println("Donor Name: "+fetchDonorName);
                            System.out.println("Donor's Phone: "+fetchDonorPhone);
                            System.out.println("Donor's Address: "+fetchDonorAddress);
                            System.out.println("Donor's bloodgroup: "+fetchBloodGroup);
                            System.out.println("Donor's Age: "+fetchDonorAge+"\n");

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;


                case 3:
                    System.out.println("Search for an Donors");
                    System.out.println("Enter the Donor's Name: ");
                    donorname = input.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                        String sql = "SELECT `phone`, `address`, `bloodgroup`, `age` FROM `donors` WHERE `name` = '"+donorname+"'";

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){

                            String fetchDonorPhone = rs.getString("phone");
                            String fetchDonorAddress = rs.getString("address");
                            String fetchBloodGroup = rs.getString("bloodgroup");
                            String fetchDonorAge = rs.getString("age");

                            System.out.println("Donor's Phone: "+fetchDonorPhone);
                            System.out.println("Donor's Address: "+fetchDonorAddress);
                            System.out.println("Donor's bloodgroup: "+fetchBloodGroup);
                            System.out.println("Donor's Age: "+fetchDonorAge+"\n");

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }


                    break;
                case 4:
                    System.out.println("Update a Donor");
                    System.out.println("Enter the name: ");
                    donorname = input.next();
                    System.out.println("Enter Donor's Phone to update: ");
                    donorphone = input.next();
                    System.out.println("Enter the Address to update: ");
                    donoraddress = input.next();
                    System.out.println("Enter the Blood Group to update: ");
                    donorbloodgroup = input.next();
                    System.out.println("Enter the Age to update: ");
                    donorage = input.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                        String sql = "UPDATE `donors` SET `phone`='"+donorphone+"',`address`='"+donoraddress+"',`bloodgroup`='"+donorbloodgroup+"',`age`='"+donorage+"' WHERE `name` = '" + donorname+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Donor details updated successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                case 5:
                    System.out.println("Delete a Donor");
                    System.out.println("Enter the donor name: ");
                    donorname = input.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                        String sql = "DELETE FROM `donors` WHERE `name`= '" + donorname+"'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Donor data deleted successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;


                case 6:
                    System.out.println("Exited Menu");
                    System.exit(0);






            }

        }
    }
}

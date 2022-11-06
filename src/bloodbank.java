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

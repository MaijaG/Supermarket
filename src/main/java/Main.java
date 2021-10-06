import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Supermarket supermarket;

    public static void main(String[] args) {
        Main main = new Main();
        supermarket = new Supermarket();
        Scanner scanner = new Scanner(System.in);
        String selectActivity;
        User user = new User("ou", "owner@owner.ow", "op", 0, "Owner");
        supermarket.addUser(user);

        User userone = new User("sr", "sales@sales.ow", "sp", 0, "Sales represenative");
        User usertwo = new User("b", "buyer@buyer", "bp", 0, "Buyer");
        supermarket.addUser(userone);
        supermarket.addUser(usertwo);


        do {
            System.out.println("Please select activity: ");
            System.out.println("1 - Enter user name and password to log in. \n" +
                    "2 - Register new user. \n" +
                    "Quit - exit");
            selectActivity = scanner.nextLine();
            switch (selectActivity) {
                case "1":
                    User menuUser = supermarket.findUser();
                    if (menuUser != null) {
                        if (menuUser.getType().equals("Owner")) {
                            String selectActivityOwner;
                            do {
                                System.out.println("\nPlease select activity as an owner: ");
                                System.out.println("1 - add new user new owner. \n " +
                                        "2- add new sales representative. \n " +
                                        "3- add new buyer. \n " +
                                        "4 - add new product. \n " +
                                        "5- check sales report. \n " +
                                        "Quit");
                                selectActivityOwner = scanner.nextLine();
                                switch (selectActivityOwner) {
                                    case "1":
                                        main.registerUser("Owner");
                                        break;
                                    case "2":
                                        main.registerUser("Sales representative");
                                        break;
                                    case "3":
                                        main.registerUser("Buyer");
                                        break;
                                    case "4":
                                        supermarket.addProduct(menuUser);
                                        break;
                                    case "5":
                                        supermarket.salesReport();
                                        break;
                                    case "6":
                                        supermarket.viewProduct();
                                        break;
                                }
                            }while (!selectActivityOwner.equals("Quit")) ;
                        }
                        if (menuUser.getType().equals("Sales representative")) {
                            String selectActivityRepresenaative;
                            do {
                                System.out.println("Pleas select activity as sales represenatative: ");
                                System.out.println("1 - view sales report. \n" +
                                        "Quit - log out.");
                                selectActivityRepresenaative = scanner.nextLine();
                                switch (selectActivityRepresenaative) {
                                    case "1":
                                        supermarket.salesReport();
                                        break;
                                }
                            } while (!selectActivityRepresenaative.equals("Quit")) ;
                        }
                        if (menuUser.getType().equals("Buyer")) {
                            String selectActivvityBuyer;
                            do {

                                System.out.println("Please select activity as a buyer: ");
                                System.out.println("1 - view products. \n" +
                                        "2 - Buy products. \n" +
                                        "3 - Chek user balance. \n" +
                                        " Quit - log out.");
                                selectActivvityBuyer = scanner.nextLine();
                                switch (selectActivvityBuyer) {
                                    case "1":
                                        supermarket.viewProduct();
                                        break;
                                    case "2":
                                        supermarket.sellProduct(menuUser);
                                        break;
                                    case "3":
                                        System.out.println(menuUser);
                                }
                            }while (!selectActivvityBuyer.equals("Quit"));
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case "2":
                    main.registerUser("Buyer");
               break;
            }
        } while (!selectActivity.equals("Quit"));

    }

    public void registerUser(String userType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert user name: ");
        String userName = scanner.nextLine();
        System.out.println("Please insert e-mail: ");
        String email = scanner.nextLine();
        System.out.println("Please insert password: ");
        String password = scanner.nextLine();
        System.out.println("Please insert your balance:");
        int userBalance = scanner.nextInt();
        User user = new User(userName, email, password, userBalance, userType);
        supermarket.addUser(user);

    }

}

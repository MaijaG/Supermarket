import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {
    private ArrayList<Products> products;
    private ArrayList<User> userList;
    private ArrayList<Sales> sales;
    private static double totalMoneySpent;
    private static double totalMoneyEarned;
    Scanner scanner = new Scanner(System.in);

    Supermarket() {
        products = new ArrayList<>();
        userList = new ArrayList<>();
        sales = new ArrayList<>();
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public ArrayList<User> getUser() {
        return userList;
    }

    public void setUser(ArrayList<User> userList) {
        this.userList = userList;
    }

    public static double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public static void setTotalMoneySpent(double totalMoneySpent) {
        Supermarket.totalMoneySpent = totalMoneySpent;
    }

    public static double getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static void setTotalMoneyEarned(double totalMoneyEarned) {
        Supermarket.totalMoneyEarned = totalMoneyEarned;
    }

    public void addProduct(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product name to add! ");
        String productNameToAdd = scanner.nextLine();
        System.out.println("Please enter product quantity to add!");
        int productCountToADD = scanner.nextInt();
        System.out.println("Please enter product price to buy!");
        double productPriceBuy = scanner.nextDouble();
        System.out.println("Please enter product price to sell!");
        double productPriceSell = scanner.nextDouble();
        System.out.println("Please enter product weight");
        int productWeight = scanner.nextInt();
        Products myProducts = new Products(productNameToAdd, productCountToADD, productPriceBuy, productPriceSell, productWeight);
        int idx = -1;
        for (Products products1 : this.products) {
            if (productNameToAdd.equals(products1.name)) {
                idx = this.products.indexOf(products1);
                products1.setTotalNumber(products1.totalNumber + productCountToADD);
                products1.setWeight(products1.weight + productWeight);
                this.products.set(idx, products1);
                totalMoneySpent += (products1.priceBuy * productCountToADD);
                System.out.println("Product --- " + products + "--- added!");
            }
        }
        if (idx == -1) {
            this.products.add(myProducts);
            totalMoneySpent += (myProducts.priceBuy * productCountToADD);
            System.out.println("Product --- " + products + "--- added!");
            System.out.println("Total money spent: " + totalMoneySpent);
        }
    }

    public void sellProduct(User user) {
        Scanner scanner = new Scanner(System.in);
        viewProduct();
        System.out.println("Please insert product name to buy: ");
        String productName = scanner.nextLine();
        System.out.println("Please insert number of --- " + productName + " --- to buy.");
        int productCount = scanner.nextInt();
        boolean isProductFound = false;
        for (Products products : this.products) {
            if (productName.equals(products.getName()) && productCount <= products.getTotalNumber()) {
                isProductFound = true;
                if ((products.priceSell * productCount) <= user.getUserBalance()) {
                    int idx = this.products.indexOf(products);
                    products.totalNumber -= productCount;
                    user.setUserBalance(user.getUserBalance() - (productCount * products.priceSell));
                    this.products.set(idx, products);
                    this.sales.add(new Sales(productCount, products, user));
                    totalMoneyEarned += (productCount * products.priceSell);
                    System.out.println("Product sold: " + productName);
                } else {
                    System.out.println("Insufficient funds. Please try again!");
                }
            }
            if (!isProductFound) {
                System.out.println("Product not found! Please try again");
            }
        }

    }

    public void viewProduct() {
        System.out.println("Product list:");
        for (Products products : this.products) {
            System.out.println(products);
        }
    }

    public void salesReport() {
        int salesCount = 0;
        double productsSold = 0;
        double earnedMoney = 0;
        for (Sales sales : this.sales) {
            salesCount += sales.getProductCount();
            System.out.println("\n Products sold: " + sales);
        }
        System.out.println(salesCount + " Items sold");
        earnedMoney = totalMoneyEarned - totalMoneySpent;
        System.out.println("Money earned: " + earnedMoney);
    }

    public User findUser() {
        System.out.println("Insert user name! ");
        String findUserByName = scanner.nextLine();
        System.out.println("Insert User password!");
        String findUserByPassword = scanner.nextLine();
        for (User user : userList) {
            if ((user.getUserName().equals(findUserByName)) &&
                    user.getPassword().equals(findUserByPassword)) {
                System.out.println("User found " + user.getUserName());
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
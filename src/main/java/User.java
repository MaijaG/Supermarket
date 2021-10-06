public class User {
    private String userName;
    private String userType;
    private String email;
    private String password;
    private double userBalance;

    User(String userName, String email, String password, double userBalance, String userType) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userBalance = userBalance;
        this.userType = userType;
    }

    public String toString() {
        return getUserName() + " balance is: " + getUserBalance() + ".";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return userType;
    }

    public void setType(String type) {
        this.userType = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }
}

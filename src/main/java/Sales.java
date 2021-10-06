public class Sales {
private int productCount;
private Products products;
private User user;

Sales ( int productCount, Products products, User user){
    this.productCount = productCount;
    this.products = products;
    this.user = user;
}

public String toString() {
    return "User " + user.getUserName() + " bought " +  productCount + " items of " + products.getName() + ". Items price: " + products.priceSell;
}

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

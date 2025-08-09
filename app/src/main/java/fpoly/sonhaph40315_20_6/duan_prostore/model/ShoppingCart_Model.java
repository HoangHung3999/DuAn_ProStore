package fpoly.sonhaph40315_20_6.duan_prostore.model;

import java.io.Serializable;

public class ShoppingCart_Model implements Serializable {
    private int shoppingCart_Image;
    private int shoppingCart_Id;

    private String shoppingCart_Name;
    private int shoppingCart_Price;

    public ShoppingCart_Model(int shoppingCart_Image, int shoppingCart_Id, String shoppingCart_Name, int shoppingCart_Price) {
        this.shoppingCart_Image = shoppingCart_Image;
        this.shoppingCart_Id = shoppingCart_Id;
        this.shoppingCart_Name = shoppingCart_Name;
        this.shoppingCart_Price = shoppingCart_Price;
    }

    public int getShoppingCart_Image() {
        return shoppingCart_Image;
    }

    public void setShoppingCart_Image(int shoppingCart_Image) {
        this.shoppingCart_Image = shoppingCart_Image;
    }

    public int getShoppingCart_Id() {
        return shoppingCart_Id;
    }

    public void setShoppingCart_Id(int shoppingCart_Id) {
        this.shoppingCart_Id = shoppingCart_Id;
    }

    public String getShoppingCart_Name() {
        return shoppingCart_Name;
    }

    public void setShoppingCart_Name(String shoppingCart_Name) {
        this.shoppingCart_Name = shoppingCart_Name;
    }

    public int getShoppingCart_Price() {
        return shoppingCart_Price;
    }

    public void setShoppingCart_Price(int shoppingCart_Price) {
        this.shoppingCart_Price = shoppingCart_Price;
    }

    @Override
    public String toString() {
        return "CartModel{" +
                "shoppingCart_Image=" + shoppingCart_Image +
                ", shoppingCart_Id=" + shoppingCart_Id +
                ", shoppingCart_Name='" + shoppingCart_Name + '\'' +
                ", shoppingCart_Price=" + shoppingCart_Price +
                '}';
    }
}

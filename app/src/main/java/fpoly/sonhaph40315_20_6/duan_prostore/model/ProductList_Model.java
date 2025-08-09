package fpoly.sonhaph40315_20_6.duan_prostore.model;

import java.io.Serializable;

public class ProductList_Model implements Serializable {
    private int productList_Id;
    private int productList_Image;
    private String productList_Name;
    private int productList_Price;
    private int productList_quantitySold;

    public ProductList_Model(int productList_Id, int productList_Image, String productList_Name, int productList_Price, int productList_quantitySold) {
        this.productList_Id = productList_Id;
        this.productList_Image = productList_Image;
        this.productList_Name = productList_Name;
        this.productList_Price = productList_Price;
        this.productList_quantitySold = productList_quantitySold;
    }

    public int getProductList_Id() {
        return productList_Id;
    }

    public void setProductList_Id(int productList_Id) {
        this.productList_Id = productList_Id;
    }

    public int getProductList_Image() {
        return productList_Image;
    }

    public void setProductList_Image(int productList_Image) {
        this.productList_Image = productList_Image;
    }

    public String getProductList_Name() {
        return productList_Name;
    }

    public void setProductList_Name(String productList_Name) {
        this.productList_Name = productList_Name;
    }

    public int getProductList_Price() {
        return productList_Price;
    }

    public void setProductList_Price(int productList_Price) {
        this.productList_Price = productList_Price;
    }

    public int getProductList_quantitySold() {
        return productList_quantitySold;
    }

    public void setProductList_quantitySold(int productList_quantitySold) {
        this.productList_quantitySold = productList_quantitySold;
    }

    @Override
    public String toString() {
        return "ProductList_Model{" +
                "productList_Id=" + productList_Id +
                ", productList_Image=" + productList_Image +
                ", productList_Name='" + productList_Name + '\'' +
                ", productList_Price=" + productList_Price +
                ", productList_quantitySold=" + productList_quantitySold +
                '}';
    }

}

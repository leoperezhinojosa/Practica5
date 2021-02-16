package modelo;

public class Product {

    // Atributos
    private String title;
    private String description;
    private String productStatus;
    private boolean sell;
    private float price;
    private boolean confirmSale;

    // Constructor
    public Product(String title, String description, String productStatus, float price, boolean confirmSale) {
        this.title = title;
        this.description = description;
        this.productStatus = productStatus;
        this.price = price;
        this.confirmSale = false;
    }

    public Product() {

    }


    // Getter & Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isConfirmSale() {
        return confirmSale;
    }

    public void setConfirmSale(boolean confirmSale) {
        this.confirmSale = confirmSale;
    }

    // OTROS METODOS:



    // To String
    @Override
    public String toString() {
        return "     --------------------------------------------------" +
                "\n    |    - Producto: " + title +
                "\n    |    - Descripcion: " + description +
                "\n    |    - Estado: " + productStatus +
                "\n    |    - Precio: " + price + " euros. " +
                "\n     --------------------------------------------------";
    }
}

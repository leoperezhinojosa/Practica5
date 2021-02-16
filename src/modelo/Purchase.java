package modelo;

import java.util.Date;

public class Purchase {

    // Atributos
    private int idPurchase;
    private String sellerEmail;
    private int finalPurchasePrice;
    private Date operationPurchaseDate;
    private int noteSeller;
    private String commentOfBuyer;

    // Constructor
    public Purchase(int idPurchase, String sellerEmail, int finalPurchasePrice, Date operationPurchaseDate, int noteSeller, String commentOfBuyer) {
        this.idPurchase = idPurchase;
        this.sellerEmail = sellerEmail;
        this.finalPurchasePrice = finalPurchasePrice;
        this.operationPurchaseDate = operationPurchaseDate;
        this.noteSeller = noteSeller;
        this.commentOfBuyer = commentOfBuyer;
    }

    public Purchase() {

    }


    // Getter & Setter
    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public int getFinalPurchasePrice() {
        return finalPurchasePrice;
    }

    public void setFinalPurchasePrice(int finalPurchasePrice) {
        this.finalPurchasePrice = finalPurchasePrice;
    }

    public Date getOperationPurchaseDate() {
        return operationPurchaseDate;
    }

    public void setOperationPurchaseDate(Date operationPurchaseDate) {
        this.operationPurchaseDate = operationPurchaseDate;
    }

    public int getNoteSeller() {
        return noteSeller;
    }

    public void setNoteSeller(int noteSeller) {
        this.noteSeller = noteSeller;
    }

    public String getCommentOfBuyer() {
        return commentOfBuyer;
    }

    public void setCommentOfBuyer(String commentOfBuyer) {
        this.commentOfBuyer = commentOfBuyer;
    }

    // Otros metodos


    // To String
    @Override
    public String toString() {
        return "     --------------------------------------------------" +
                "\n    |    - Precio Final: " + finalPurchasePrice +
                "\n    |    - Comprador: " + sellerEmail +
                "\n    |    - Fecha de la operacion:" + operationPurchaseDate +
                "\n    |    - Puntuacion: " + noteSeller +
                "\n    |    - Valoracion adicional: " + commentOfBuyer +
                "\n     --------------------------------------------------";

    }
}


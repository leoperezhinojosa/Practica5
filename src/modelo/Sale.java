package modelo;

import java.util.Date;

public class Sale {
    // Atributos
    private int idSale;
    private String buyerEmail;
    private int finalSalePrice;
    private Date operationSaleDate;
    private int noteBuyer;
    private String commentOfSeller;

    // Constructor
    public Sale(int idSale, String buyerEmail, int finalSalePrice, Date operationSaleDate, int noteBuyer, String commentOfSeller) {
        this.idSale = idSale;
        this.buyerEmail = buyerEmail;
        this.finalSalePrice = finalSalePrice;
        this.operationSaleDate = operationSaleDate;
        this.noteBuyer = noteBuyer;
        this.commentOfSeller = commentOfSeller;
    }

    public Sale() {

    }


    // Getter & Setter
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public int getFinalSalePrice() {
        return finalSalePrice;
    }

    public void setFinalSalePrice(int finalSalePrice) {
        this.finalSalePrice = finalSalePrice;
    }

    public Date getOperationSaleDate() {
        return operationSaleDate;
    }

    public void setOperationSaleDate(Date operationSaleDate) {
        this.operationSaleDate = operationSaleDate;
    }

    public int getNoteBuyer() {
        return noteBuyer;
    }

    public void setNoteBuyer(int noteBuyer) {
        this.noteBuyer = noteBuyer;
    }

    public String getCommentOfSeller() {
        return commentOfSeller;
    }

    public void setCommentOfSeller(String commentOfSeller) {
        this.commentOfSeller = commentOfSeller;
    }

    // To String
    @Override
    public String toString() {
        return "     --------------------------------------------------" +
                "\n    |    - Precio Final: " + finalSalePrice +
                "\n    |    - Vendedor: " + buyerEmail +
                "\n    |    - Fecha de la operacion de Compra:" + operationSaleDate +
                "\n    |    - Puntuacion: " + noteBuyer +
                "\n    |    - Valoracion adicional: " + commentOfSeller +
                "\n     --------------------------------------------------";

    }
}

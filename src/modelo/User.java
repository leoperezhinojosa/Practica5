package modelo;

import modelo.Product;
import modelo.Purchase;
import modelo.Sale;

public class User {

    // Atributos
    private String email;
    private String pass;
    private String name;
    private String surname;
    private String postcode;
    private String country;
    private String dni;
    private String city;
    private boolean purchaseNotice1;  // Mensajes al vendedor de: comprador recibido para completar la venta
    private boolean purchaseNotice2;
    private Product product1;
    private Product product2;
    private Sale sale1;
    private Sale sale2;
    private Purchase Purchase1;
    private Purchase Purchase2;
    private String token;


    // Constructor
    public User(String email, String pass, String name, String surname, String postcode, String country, String dni, String city, String purchaseNotice1, boolean purchaseNotice2) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.postcode = postcode;
        this.country = country;
        this.dni = dni;
        this.city = city;
        this.purchaseNotice1 = false;
        this.purchaseNotice2 = false;
        this.product1 = null;
        this.product2 = null;
        this.sale1 = null;
        this.sale2 = null;
        this.Purchase1 = null;
        this.Purchase2 = null;
        this.token = generateToken();
    }

    public User() {
        this.token = generateToken();
    }


    // Getter & Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { // Cambiar el email. ¿Eliminar?
        this.email = email;
    }

    public String getPass() { // Dar la contraseña. ¿Eliminar? ¿Crear metodo?
        return pass;
    }

    public void setPass(String pass) { // Cambiar la contraseña. ¿Eliminar? ¿Crear metodo?
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public Product getProduct2() {
        return product2;
    }

    public void setProduct2(Product product2) {
        this.product2 = product2;
    }

    public boolean isPurchaseNotice1() {
        return purchaseNotice1;
    }

    public void setPurchaseNotice1(boolean purchaseNotice1) {
        this.purchaseNotice1 = purchaseNotice1;
    }

    public boolean isPurchaseNotice2() {
        return purchaseNotice2;
    }

    public void setPurchaseNotice2(boolean purchaseNotice2) {
        this.purchaseNotice2 = purchaseNotice2;
    }

    public Sale getSale1() {
        return sale1;
    }

    public void setSale1(Sale sale1) {
        this.sale1 = sale1;
    }

    public Sale getSale2() {
        return sale2;
    }

    public void setSale2(Sale sale2) {
        this.sale2 = sale2;
    }

    public Purchase getPurchase1() {
        return Purchase1;
    }

    public void setPurchase1(Purchase purchase1) {
        Purchase1 = purchase1;
    }

    public Purchase getPurchase2() {
        return Purchase2;
    }

    public void setPurchase2(Purchase purchase2) {
        Purchase2 = purchase2;
    }

    public boolean login(String userLog, String passLog) {
        return userLog.equals(email) && passLog.equals(pass);
    }


    public String getToken() { return token; }

    public void setToken(String token) { this.token = generateToken(); }

    // Otros Métodos
    // Login


    public static String generateToken() {
        int selec;
        StringBuilder Token = new StringBuilder();

        for (int i = 0; i < 6 ; i++) {


            selec = (int) ((Math.random() * 39) +1);

            switch (selec) {

                case 1 -> Token.append("*");
                case 2 -> Token.append("-");
                case 3 -> Token.append("=");
                case 4 -> Token.append(".");
                case 5 -> Token.append("|");
                case 6 -> Token.append("@");
                case 7 -> Token.append("a");
                case 8 -> Token.append("b");
                case 9 -> Token.append("c");
                case 10 -> Token.append("d");
                case 11 -> Token.append("e");
                case 12 -> Token.append("f");
                case 13 -> Token.append("g");
                case 14 -> Token.append("h");
                case 15 -> Token.append("i");
                case 16 -> Token.append("j");
                case 17 -> Token.append("k");
                case 18 -> Token.append("l");
                case 19 -> Token.append("m");
                case 20 -> Token.append("o");
                case 21 -> Token.append("p");
                case 22 -> Token.append("q");
                case 23 -> Token.append("r");
                case 24 -> Token.append("s");
                case 25 -> Token.append("t");
                case 26 -> Token.append("u");
                case 27 -> Token.append("w");
                case 28 -> Token.append("x");
                case 29 -> Token.append("y");
                case 30 -> Token.append("z");
                case 31 -> Token.append("1");
                case 32 -> Token.append("2");
                case 33 -> Token.append("3");
                case 34 -> Token.append("4");
                case 35 -> Token.append("5");
                case 36 -> Token.append("6");
                case 37 -> Token.append("7");
                case 38 -> Token.append("8");
                case 39 -> Token.append("9");
            }
        }
        return Token.toString().toUpperCase();
    }




    // TO STRING
    @Override
    public String toString() {
        return "     --------------------------------------------------" +
                "\n    |    - Email: " + email +
                "\n    |    - Nombre: " + name +
                "\n    |    - Apellido: " + surname +
                "\n    |    - Codigo Postal: " + postcode +
                "\n    |    - Pais: " + country +
                "\n    |    - DNI: " + dni +
                "\n    |    - Ciudad: " + city +
                "\n     --------------------------------------------------";

    }



}

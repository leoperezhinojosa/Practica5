import com.sun.jdi.connect.Transport;
import modelo.Product;
import modelo.Sale;
import modelo.User;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        var s = new Scanner(System.in);

        String change;
        boolean login;
        String loginUser;
        String loginPass;

        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm - dd/MM/yyyy");

        String askOptionTurnOff = "";
        boolean optionTurnOff = false;
        String askChangeUser = "";
        boolean turnOff;
        String askTurnOff = "";
        int menuUser = 0;
        String optionSale = "";
        boolean optionSaleTrue;
        String option = "";
        boolean optionChoose = false;
        String questionSale = "";
        boolean questionSaleTrue = false;
        String confirmSale = "";
        String cancelSale = "";
        boolean cancelSalePass = false;

        int optionMenuStatus = 0;
        turnOff = false;
        boolean saleMade1 = false;
        boolean saleMade2 = false;
        boolean purchaseMade = false;
        int selectDeleteProduct = 0;


        // USUARIOS
        User user1 = new User("jose@mail.com", "12345", "Jose", "Castillo",
                "23006", "España", "12345678Q", "Jaen", null, false);
        User user2 = new User("leo@mail.com", "12345", "Leo", "Perez",
                "23004", "España", "26044458V", "Jaen", null, false);
        // Usuario auxiliar2
        User actualUser = new User(null, null, null, null,
                null, null, null, null, null, false);


        turnOff = false;
        login = false;
        int menuIntroduction = 0;


        System.out.println();
        System.out.println();
        System.out.println("     .     _   ___      .    __    _  _______ .___    ___   .___    ___   .___ ");
        System.out.println("     /     | .'   \\    /|    |\\   |  '   /    /   \\ .'   `. /   \\ .'   `. /   \\");
        System.out.println("     |     | |        /  \\   | \\  |      |    |__-' |     | |,_-' |     | |,_-'");
        System.out.println("     |     | |       /---'\\  |  \\ |      |    |  \\  |     | |     |     | |    ");
        System.out.println("     /---/ /  `.__,,'      \\ |   \\|      /    /   \\  `.__.' /      `.__.' /    ");
        System.out.println();
        System.out.println();
        System.out.println("            ----------------------------------------------------------- ");
        System.out.println();
        System.out.println("                             ¡Bienvenido a LicantroPoP! ");
        System.out.println();
        System.out.println("                          - Compra y vende tus articulos ");
        System.out.println("                                  al mejor precio ");
        System.out.println("                              y con total seguridad - ");
        System.out.println();
        System.out.println("            ----------------------------------------------------------- ");
        System.out.println();


        do {
            try {
                String registrarse = "";
                System.out.println("Necesitas registrarte?(S/N)");
                registrarse = s.nextLine();

                if ("S".equalsIgnoreCase(registrarse)) {                // Registro de usuario
                    if (user1 == null) {
                        user1 = registraUsuario();
                        /*enviaTocken(user1.getEmail(), user1.getToken());
                        System.out.print("Escriba el codigo enviado aqui: ");
                        String check = s.nextLine();
                        if (check.equals(user1.getToken())) {
                            logintoken = true;
                        } else {
                            System.out.println("Ha introducido un codigo incorrecto");
                            user1 = null;
                        }*/
                    } else if (user2 == null) {
                        user2 = registraUsuario();
                     /*   enviaTocken(user2.getEmail(), user2.getToken());
                        System.out.print("Escriba el codigo enviado aqui: ");
                        String check = s.nextLine();
                        if (check.equals(user2.getToken())) {
                            logintoken = true;

                        } else System.out.println("Ha introducido un codigo incorrecto");
                    } else {
                        System.out.println("Estan todos los usuarios completos");
                        user2 = null;*/
                    }
                } else {
                    System.out.println();
                    System.out.println();
                    System.out.println("    LOGIN: ");
                    System.out.println();
                    System.out.print("    * Introducir email: ");
                    // loginUser = null;
                    loginUser = s.nextLine();
                    System.out.println();
                    System.out.print("    * Introducir clave: ");
                    //loginPass = null;
                    loginPass = s.nextLine();
                    System.out.println();


                    if (user1 != null) {
                        if (user1.login(loginUser, loginPass)) {
                            actualUser = user1;
                            break;
                        } else if (user2 != null) {
                            if (user2.login(loginUser, loginPass)) {
                                actualUser = user2;
                                break;
                            }
                        }
                    }

                }

                // TODO: 31/01/2021 Haciendo envio de token


            } catch (Exception e) {
                System.out.println();
                System.out.println("      - Opcion Incorrecta -");
                System.out.println("    - Vuelve a introduce los datos - ");
                System.out.println();
                e.printStackTrace();
            }
        }
        while (!login);


        while (!turnOff) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("==================================================================");
            System.out.println();
            System.out.println("                       - MENU DE USUARIO - ");
            System.out.println();
            System.out.println("    1 - Mostrar mi perfil de usuario");
            System.out.println("    2 - Cambiar datos personales");
            System.out.println("    3 - Ver mis productos en venta");
            System.out.println("    4 - Poner a la venta un nuevo producto");
            System.out.println("    5 - Cerrar la venta de un producto / quitarlo de la venta");
            if ((actualUser.isPurchaseNotice1()) || (actualUser.isPurchaseNotice2())) {
                System.out.println("      # Aviso: ¡Comprador disponible! # ");
            }
            System.out.println("    6 - Ver todos los productos en venta de la aplicacion");
            System.out.println("    7 - Ver mi historico de ventas");
            System.out.println("    8 - Ver mi historico de compras");
            System.out.println("    9 - Salir");
            System.out.println();
            System.out.println("==================================================================");
            menuUser = 0;

            do {
                try {
                    System.out.println();
                    System.out.print("    * Introducir opcion: ");
                    menuUser = Integer.parseInt(s.nextLine());
                } catch (Exception e) {
                    System.out.println();
                    System.out.println("    - Opcion Incorrecta (1-9) - ");
                }
            } while (menuUser < 1 || menuUser > 9);

            switch (menuUser) {

                // Mostrar perfil
                case 1:
                    System.out.println();
                    System.out.println();
                    System.out.println("    1 - Mostrar perfil -");
                    System.out.println();
                    System.out.println(actualUser);
                    System.out.println();
                    System.out.print("    * Menu -> Pulsa INTRO: ");
                    s.nextLine();
                    break;

                // Cambiar datos
                case 2:
                    do {
                        System.out.println();
                        System.out.println();
                        System.out.println("    2 - Cambiar datos personales -");
                        System.out.println();
                        System.out.println("     ------------- DATOS ACTUALES --------------");
                        System.out.println("    |    Nombre (N): " + actualUser.getName());
                        System.out.println("    |    Apellido (A): " + actualUser.getSurname());
                        System.out.println("    |    DNI (D): " + actualUser.getDni());
                        System.out.println("    |    Ciudad (C): " + actualUser.getCity() + "   Pais (P): " + actualUser.getCountry());
                        System.out.println("    |    Codigo postal (CP): " + actualUser.getPostcode());
                        System.out.println("     -------------------------------------------");
                        System.out.println();
                        System.out.println("    'Salir' -> Volver al Menu Usuario ");
                        System.out.print("    * Escribe el dato a cambiar (o su abreviatura): ");
                        change = s.nextLine();

                        switch (change.toLowerCase()) {

                            case "nombre", "n":
                                System.out.println();
                                System.out.println("    - Nombre: " + actualUser.getName());
                                System.out.print("    * Cambiar a: ");
                                actualUser.setName(s.nextLine());
                                System.out.println();
                                break;

                            case "apellido", "a":
                                System.out.println();
                                System.out.println("    - Apellido: " + actualUser.getSurname());
                                System.out.print("    * Cambiar a: ");
                                actualUser.setSurname(s.nextLine());
                                System.out.println();
                                break;

                            case "dni", "d":
                                System.out.println();
                                System.out.println("    - DNI: " + actualUser.getDni());
                                System.out.print("    * Cambiar a: ");
                                actualUser.setDni(s.nextLine());
                                System.out.println();
                                break;

                            case "ciudad", "c":
                                System.out.println();
                                System.out.println("    - Ciudad: " + actualUser.getCity());
                                System.out.print("    * Cambiar a: ");
                                actualUser.setCity(s.nextLine());
                                System.out.println();
                                break;

                            case "pais", "p":
                                System.out.println();
                                System.out.println("    - Pais: " + actualUser.getCountry());
                                System.out.print("    * Cambiar a: ");
                                actualUser.setCountry(s.nextLine());
                                System.out.println();
                                break;

                            case "codigo postal", "cp", "c p":
                                System.out.println();
                                System.out.println("    - Codigo postal: " + actualUser.getPostcode());
                                System.out.print("    * Cambiar a: ");
                                actualUser.setPostcode(s.nextLine());
                                System.out.println();
                                break;

                            case "salir":
                                System.out.println();
                                System.out.print("    * Menu -> Pulsa INTRO: ");
                                s.nextLine();
                                break;

                            default:
                                System.out.println();
                                System.out.println("    - OPCION INCORRECTA - ");
                                System.out.println();
                                System.out.print("    * Menu Datos -> Pulsa INTRO: ");
                                s.nextLine();
                                break;
                        }
                    } while (!change.equalsIgnoreCase("salir"));
                    break;

                // Mis ventas
                case 3:
                    System.out.println();
                    System.out.println();
                    System.out.println("    3 - En venta: Mis productos - ");
                    System.out.println();
                    if ((actualUser.getProduct1() == null) && (actualUser.getProduct2() == null)) {
                        System.out.println("     ------------------------------------");
                        System.out.println("    |  - No tienes productos en venta -  |");
                        System.out.println("     ------------------------------------");
                        System.out.println();
                    } else {
                        if (actualUser.getProduct1() != null) {
                            System.out.println("      - Venta A: ");
                            System.out.println(actualUser.getProduct1());
                            System.out.println();
                        }
                        if (actualUser.getProduct2() != null) {
                            System.out.println("      - Venta B: ");
                            System.out.println(actualUser.getProduct2());
                            System.out.println();
                        }
                    }
                    System.out.println();
                    System.out.print("    * Menu -> Pulsa INTRO: ");
                    s.nextLine();
                    break;

                case 4:
                    System.out.println();
                    System.out.println();
                    System.out.println("    4 - Registro: Nuevo producto en venta - ");

                    // Cambiar para hacer pruebas
                    if ((actualUser.getProduct1() != null) && (actualUser.getProduct2() != null)) {
                        System.out.println();
                        System.out.println("      ----------------------------------- ");
                        System.out.println("     |   - Oferta de Ventas completa -   |");
                        System.out.println("     |                ----               |");
                        System.out.println("     |      Para añadir un producto,     |");
                        System.out.println("     |     vende o elimina uno o mas     |");
                        System.out.println("     |    de tus articulos existentes    |");
                        System.out.println("      ----------------------------------- ");
                        System.out.println("     |        ¡O adquiere PREMIUM!       |");
                        System.out.println("     |      (En oferta a 3€/articulo)    |");
                        System.out.println("      ----------------------------------- ");
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("         -------------------------------  ");
                        System.out.println("        |  - Nuevo producto en venta -  | ");
                        System.out.println("         -------------------------------  ");
                        System.out.println();

                        // Creacion PRODUCTO 1
                        Product product1 = new Product();
                        if (actualUser.getProduct1() == null) {

                            //Nombre
                            System.out.println("    ------------------------------------------- ");
                            System.out.print("      * Nombre del producto: ");
                            product1.setTitle(s.nextLine());

                            // Descripcion
                            System.out.println("    ------------------------------------------- ");
                            System.out.print("      * Descripcion del producto: ");
                            product1.setDescription(s.nextLine());

                            // Estado
                            do {
                                try {
                                    System.out.println("    ------------------------------------------- ");
                                    System.out.println("    - Estado del producto: ");
                                    System.out.println("           1 - Nuevo ");
                                    System.out.println("           2 - Como nuevo ");
                                    System.out.println("           3 - Usado ");
                                    System.out.println("           4 - Reformado ");
                                    System.out.println("           5 - Desguace / No funciona ");
                                    System.out.println();
                                    System.out.print("    * Indicar opcion correspondiente (1-5): ");
                                    optionMenuStatus = Integer.parseInt(s.nextLine());
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("    - Opcion incorrecta (1-5) - ");
                                    System.out.println();
                                }
                            } while ((optionMenuStatus <= 0) || (optionMenuStatus >= 6));


                            switch (optionMenuStatus) {
                                case 1 -> product1.setProductStatus("Nuevo");
                                case 2 -> product1.setProductStatus("Como nuevo");
                                case 3 -> product1.setProductStatus("Usado");
                                case 4 -> product1.setProductStatus("Reformado");
                                case 5 -> product1.setProductStatus("Desguace / No funciona");
                            }

                            // Precio
                            do {
                                try {
                                    System.out.println("    ------------------------------------------- ");
                                    System.out.print("    * Precio venta del producto: ");
                                    product1.setPrice(Float.parseFloat(s.nextLine()));
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("   - Error: Introducir precio en numeros -");
                                }
                            } while (product1.getPrice() < 0);

                            actualUser.setProduct1(product1);
                            System.out.println("     ------------------------------------------ ");
                            System.out.println("    |  - ¡Enhorabuena! Nuevo producto listo -  |");
                            System.out.println("     ------------------------------------------ ");
                            System.out.println();
                            System.out.println(product1);
                            System.out.println();
                        } else {


                            // Creacion PRODUCTO 2
                            Product product2 = new Product();
                            if (actualUser.getProduct2() == null) {

                                //Nombre
                                System.out.println("    ------------------------------------------- ");
                                System.out.print("    * Nombre del producto: ");
                                product2.setTitle(s.nextLine());

                                // Descripcion
                                System.out.println("    ------------------------------------------- ");
                                System.out.print("    * Descripcion del producto: ");
                                product2.setDescription(s.nextLine());

                                // Estado
                                do {
                                    try {
                                        System.out.println("    ------------------------------------------- ");
                                        System.out.println("    - Estado del producto: ");
                                        System.out.println("           1 - Nuevo ");
                                        System.out.println("           2 - Como nuevo ");
                                        System.out.println("           3 - Usado ");
                                        System.out.println("           4 - Reformado ");
                                        System.out.println("           5 - Desguace / No funciona ");
                                        System.out.println();
                                        System.out.print("    * Indicar opcion correspondiente (1-5): ");
                                        optionMenuStatus = Integer.parseInt(s.nextLine());
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("    - Opcion incorrecta (1-5) - ");
                                        System.out.println();
                                    }
                                } while ((optionMenuStatus <= 0) || (optionMenuStatus >= 6));


                                switch (optionMenuStatus) {
                                    case 1:
                                        product2.setProductStatus("Nuevo");
                                        break;
                                    case 2:
                                        product2.setProductStatus("Como nuevo");
                                        break;
                                    case 3:
                                        product2.setProductStatus("Usado");
                                        break;
                                    case 4:
                                        product2.setProductStatus("Reformado");
                                        break;
                                    case 5:
                                        product2.setProductStatus("Desguace / No funciona");
                                        break;
                                }

                                // Precio
                                do {
                                    try {
                                        System.out.println("    ------------------------------------------- ");
                                        System.out.print("    * Precio venta del producto: ");
                                        product2.setPrice(Float.parseFloat(s.nextLine()));
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("    - Error: Introducir precio en numeros -");
                                    }
                                } while (product1.getPrice() < 0);

                                actualUser.setProduct2(product2);
                                System.out.println("     ------------------------------------------ ");
                                System.out.println("    |  - ¡Enhorabuena! Nuevo producto listo -  |");
                                System.out.println("     ------------------------------------------ ");
                                System.out.println();
                                System.out.println(product2);
                                System.out.println();
                            }
                        }
                    }
                    System.out.print("    * Menu -> Pulsa INTRO: ");
                    s.nextLine();
                    break;

                // 1 - Pedir 1 de las 2 opciones
                // 2 - Pedir 1 de los 2 productos del usuario
                // 3 - comprobacion del producto y si está a null
                case 5:

                    do {
                        optionSaleTrue = false;
                        System.out.println();
                        System.out.println("    5 - Cerrar venta / Cancelar producto en venta - ");
                        System.out.println();
                        System.out.println("     --------------------------------- ");
                        System.out.println("      A -> Cerrar venta                ");
                        System.out.println("      B -> Cancelar venta              ");
                        System.out.println("           ----------------------      ");
                        System.out.println("      S -> Salir al menu principal     ");
                        System.out.println("     --------------------------------- ");
                        System.out.println();
                        System.out.print("     * Escoger opcion: ");
                        optionSale = s.nextLine();
                        if ((optionSale.equalsIgnoreCase("a")) || (optionSale.equalsIgnoreCase("b"))
                                || optionSale.equalsIgnoreCase("s")) {
                            optionSaleTrue = true;
                        }
                    } while (!optionSaleTrue);

                    switch (optionSale) {

                        // TODO: 08/12/2020 - Crear la venta y confirmación

                        // Guardar el comprador
                        // Puntuacion posterior

                        // Venta
                        case "a", "A":
                            System.out.println();
                            System.out.println("     ------------------- ");
                            System.out.println("     - Finalizar venta - ");
                            System.out.println("     ------------------- ");
                            System.out.println();
                            if ((!actualUser.isPurchaseNotice1()) && (!actualUser.isPurchaseNotice2())) {
                                System.out.println();
                                System.out.println("     ---------------------------------------------  ");
                                System.out.println("    |  - Tus productos aun no tienen comprador -  | ");
                                System.out.println("     ---------------------------------------------  ");
                                System.out.println();
                            } else {
                                // TODO: 12/12/2020 Completa todas las opciones de "completar compra"
                                // Mandar aviso de confirmacion o cancelacion de compra a comprador
                                if (user2 == actualUser) {
                                    // Pregunta confirmacion venta 3
                                    if (actualUser.isPurchaseNotice1()) {
                                        boolean confirmSaleTrue;
                                        System.out.println();
                                        System.out.println("    - El usuario " + user1.getEmail() + " quiere comprar el producto: \n" + user2.getProduct1());
                                        do {
                                            confirmSaleTrue = false;
                                            System.out.println();
                                            System.out.print("    * ¿Aceptar la compra? (S/N): ");
                                            confirmSale = s.nextLine();
                                            if ((confirmSale.equalsIgnoreCase("s") || (confirmSale.equalsIgnoreCase("n")))) {
                                                confirmSaleTrue = true;
                                            }
                                        } while (!confirmSaleTrue);
                                        // Confirmacion venta 3
                                        if (confirmSale.equalsIgnoreCase("s")) {
                                            System.out.println();
                                            System.out.println("    - ¡Enhorabuena! Su producto " + user2.getProduct1().getTitle()
                                                    + (" se ha vendido correctamente -"));
                                            // TODO: 12/12/2020 Comenzar desde aqui los historicos de compra y venta, guardar producto y pedir puntuacion: 1ºvendedor, 2ºcomprador

                                            // Creacion Historico venta 3 usuario 2
                                            Sale sale1 = new Sale();

                                            if (actualUser.getSale1() == null) {
                                                sale1.setFinalSalePrice((int) user2.getProduct1().getPrice());
                                                sale1.setBuyerEmail(user2.getEmail());
                                                // Fecha Calendario
                                                sale1.setOperationSaleDate(sdf.getCalendar().getTime());
                                                System.out.println("    - Para finalizar la venta: ");
                                                System.out.println();
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                try {
                                                    System.out.print("    * ¿Cual es su valoracion del comprador? (De 1 a 5 estrellas): ");
                                                    // TODO: 31/01/2021
                                                    user2.getSale1().setNoteBuyer(Integer.parseInt(s.nextLine()));
                                                } catch (NullPointerException ignored) {
                                                    System.out.println("falla");
                                                }
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                try {
                                                    System.out.print("    * Comentario adicional sobre el comprador: ");
                                                    user2.getSale1().setCommentOfSeller(s.nextLine());
                                                    saleMade2 = true;
                                                } catch (NullPointerException ignored) {
                                                    System.out.println("falla");
                                                }
                                                System.out.println();
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println("     - ¡Operacion de venta terminada! -  ");
                                                System.out.println("                    ---                  ");
                                                System.out.println("      - Historico ventas actualizado -   ");
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println();
                                            }
                                        } else {
                                            do {
                                                System.out.println();
                                                System.out.println("    - Compra NO ACEPTADA - ");
                                                System.out.print("    * ¿Borrar la oferta del comprador? (S/N): ");
                                                cancelSale = s.nextLine();
                                                if ((cancelSale.equalsIgnoreCase("s")) || (cancelSale.equalsIgnoreCase("n")))
                                                    cancelSalePass = true;
                                            } while (!cancelSalePass);

                                            if (cancelSale.equalsIgnoreCase("s")) {
                                                System.out.println();
                                                System.out.println("    - Oferta eliminada - ");
                                                actualUser.setPurchaseNotice1(false);
                                            }
                                        }
                                    }
                                    // Pregunta confirmacion venta 4
                                    if (actualUser.isPurchaseNotice2()) {
                                        boolean confirmSaleTrue;
                                        System.out.println();
                                        System.out.println("    - El usuario " + user1.getEmail() + " quiere comprar el producto: \n" + user2.getProduct2());
                                        do {
                                            confirmSaleTrue = false;
                                            System.out.println();
                                            System.out.print("    * ¿Aceptar la compra? (S/N): ");
                                            confirmSale = s.nextLine();
                                            if ((confirmSale.equalsIgnoreCase("s") || (confirmSale.equalsIgnoreCase("n")))) {
                                                confirmSaleTrue = true;
                                            }
                                        } while (!confirmSaleTrue);
                                        // Confirmacion venta 4
                                        if (confirmSale.equalsIgnoreCase("s")) {
                                            System.out.println("    - ¡Enhorabuena! Su producto " + user2.getProduct2().getTitle()
                                                    + (" se ha vendido correctamente -"));

                                            // Creacion Historico venta 4 usuario 2
                                            Sale sale2 = new Sale();

                                            if (actualUser.getSale2() == null) {
                                                sale2.setFinalSalePrice((int) user2.getProduct2().getPrice());
                                                sale2.setBuyerEmail(user2.getEmail());
                                                // Fecha Calendario
                                                sale2.setOperationSaleDate(sdf.getCalendar().getTime());
                                                System.out.println("    - Para finalizar la venta: ");
                                                System.out.println();
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                System.out.print("    * ¿Cual es su valoracion del comprador? (De 1 a 5 estrellas): ");
                                                user2.getSale2().setNoteBuyer(0); // TODO: 31/01/2021
                                                user2.getSale2().setNoteBuyer(Integer.parseInt(s.nextLine()));
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                System.out.print("    * Comentario adicional sobre el comprador: ");
                                                user2.getSale2().setCommentOfSeller(s.nextLine());
                                                saleMade2 = true;
                                                System.out.println();
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println("     - ¡Operacion de venta terminada! -  ");
                                                System.out.println("                    ---                  ");
                                                System.out.println("      - Historico ventas actualizado -   ");
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println();
                                            }
                                        } else {
                                            do {
                                                System.out.println();
                                                System.out.println("    - Compra NO ACEPTADA - ");
                                                System.out.print("    * ¿Borrar la oferta del comprador? (S/N): ");
                                                cancelSale = s.nextLine();
                                                if ((cancelSale.equalsIgnoreCase("s")) || (cancelSale.equalsIgnoreCase("n")))
                                                    cancelSalePass = true;
                                            } while (!cancelSalePass);

                                            if (cancelSale.equalsIgnoreCase("s")) {
                                                System.out.println();
                                                System.out.println("    - Oferta eliminada - ");
                                                actualUser.setPurchaseNotice2(false);

                                            }
                                        }
                                    }
                                    user2 = actualUser;
                                }
                                if (user1 == actualUser) {
                                    // Pregunta confirmacion venta 1
                                    if (actualUser.isPurchaseNotice1()) {
                                        boolean confirmSaleTrue;
                                        System.out.println();
                                        System.out.println("    - El usuario " + user2.getEmail() + " quiere comprar el producto: \n" + user1.getProduct1());
                                        do {
                                            confirmSaleTrue = false;
                                            System.out.println();
                                            System.out.print("    * ¿Aceptar la compra? (S/N): ");
                                            confirmSale = s.nextLine();
                                            if ((confirmSale.equalsIgnoreCase("s") || (confirmSale.equalsIgnoreCase("n")))) {
                                                confirmSaleTrue = true;
                                            }
                                        } while (!confirmSaleTrue);
                                        // Confirmacion venta 1
                                        if (confirmSale.equalsIgnoreCase("s")) {
                                            System.out.println("    - ¡Enhorabuena! Su producto " + user1.getProduct1().getTitle()
                                                    + (" se ha vendido correctamente -"));

                                            // Creacion Historico venta 1 usuario 1
                                            Sale sale1 = new Sale();

                                            if (actualUser.getSale1() == null) {
                                                sale1.setFinalSalePrice((int) user1.getProduct1().getPrice());
                                                sale1.setBuyerEmail(user1.getEmail());
                                                // Fecha Calendario
                                                sale1.setOperationSaleDate(sdf.getCalendar().getTime());
                                                System.out.println("    - Para finalizar la venta: ");
                                                System.out.println();
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                System.out.print("    * ¿Cual es su valoracion del comprador? (De 1 a 5 estrellas): ");
                                                user1.getSale1().setNoteBuyer(0); // TODO: 31/01/2021
                                                user1.getSale1().setNoteBuyer(Integer.parseInt(s.nextLine()));
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                System.out.print("    * Comentario adicional sobre el comprador: ");
                                                user2.getSale1().setCommentOfSeller(s.nextLine());
                                                saleMade1 = true;
                                                System.out.println();
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println("     - ¡Operacion de venta terminada! -  ");
                                                System.out.println("                    ---                  ");
                                                System.out.println("      - Historico ventas actualizado -   ");
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println();
                                            }
                                        } else {
                                            do {
                                                System.out.println();
                                                System.out.println("    - Compra NO ACEPTADA - ");
                                                System.out.print("    * ¿Borrar la oferta del comprador? (S/N): ");
                                                cancelSale = s.nextLine();
                                                if ((cancelSale.equalsIgnoreCase("s")) || (cancelSale.equalsIgnoreCase("n")))
                                                    cancelSalePass = true;
                                            } while (!cancelSalePass);

                                            if (cancelSale.equalsIgnoreCase("s")) {
                                                System.out.println();
                                                System.out.println("    - Oferta eliminada - ");
                                                actualUser.setPurchaseNotice1(false);
                                            }
                                        }

                                    }
                                    // Pregunta confirmacion venta 2
                                    if (actualUser.isPurchaseNotice2()) {
                                        boolean confirmSaleTrue;
                                        System.out.println();
                                        System.out.println("    - El usuario " + user2.getEmail() + " quiere comprar el producto: \n" + user1.getProduct2());
                                        do {
                                            confirmSaleTrue = false;
                                            System.out.println();
                                            System.out.print("    * ¿Aceptar la compra? (S/N): ");
                                            confirmSale = s.nextLine();
                                            if ((confirmSale.equalsIgnoreCase("s") || (confirmSale.equalsIgnoreCase("n")))) {
                                                confirmSaleTrue = true;
                                            }
                                        } while (!confirmSaleTrue);
                                        // Confirmacion venta 4
                                        if (confirmSale.equalsIgnoreCase("s")) {
                                            System.out.println("    - ¡Enhorabuena! Su producto " + user1.getProduct2().getTitle()
                                                    + (" se ha vendido correctamente -"));

                                            // Creacion Historico venta 1 usuario 1
                                            Sale sale2 = new Sale();

                                            if (actualUser.getSale1() == null) {
                                                sale2.setFinalSalePrice((int) user1.getProduct2().getPrice());
                                                sale2.setBuyerEmail(user1.getEmail());
                                                // Fecha Calendario
                                                sale2.setOperationSaleDate(sdf.getCalendar().getTime());
                                                System.out.println("    - Para finalizar la venta: ");
                                                System.out.println();
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                System.out.print("    * ¿Cual es su valoracion del comprador? (De 1 a 5 estrellas): ");
                                                user1.getSale2().setNoteBuyer(0); // TODO: 31/01/2021
                                                user1.getSale2().setNoteBuyer(Integer.parseInt(s.nextLine()));
                                                System.out.println("    ---------------------------------------------------------------- ");
                                                System.out.print("    * Comentario adicional sobre el comprador: ");
                                                user1.getSale2().setCommentOfSeller(s.nextLine());
                                                saleMade1 = true;
                                                System.out.println();
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println("     - ¡Operacion de venta terminada! -  ");
                                                System.out.println("                    ---                  ");
                                                System.out.println("      - Historico ventas actualizado -   ");
                                                System.out.println("    ------------------------------------ ");
                                                System.out.println();
                                            }
                                        } else {
                                            do {
                                                System.out.println();
                                                System.out.println("    - Compra NO ACEPTADA - ");
                                                System.out.print("    * ¿Borrar la oferta del comprador? (S/N): ");
                                                cancelSale = s.nextLine();
                                                if ((cancelSale.equalsIgnoreCase("s")) || (cancelSale.equalsIgnoreCase("n")))
                                                    cancelSalePass = true;
                                            } while (cancelSalePass);

                                            if (cancelSale.equalsIgnoreCase("s")) {
                                                System.out.println();
                                                System.out.println("    - Oferta eliminada - ");
                                                actualUser.setPurchaseNotice2(false);
                                            }
                                        }
                                    }
                                    user1 = actualUser;
                                }
                                System.out.println();
                                System.out.print("    * Menu -> Pulsa INTRO: ");
                                s.nextLine();
                            }
                            break;

                        // Cancelacion
                        case "b", "B":
                            System.out.println();
                            System.out.println("     ------------------------------ ");
                            System.out.println("     - Cancelar producto en venta - ");
                            System.out.println("     ------------------------------ ");
                            System.out.println();
                            if ((actualUser.getProduct1() == null) && (actualUser.getProduct2() == null)) {
                                System.out.println();
                                System.out.println("       - No hay ningun producto - ");
                                System.out.println();
                            } else {
                                System.out.println("         1 ");
                                if (actualUser.getProduct1() == null) {
                                    System.out.println("         # Espacio de venta VACIO # ");
                                } else {
                                    System.out.println(actualUser.getProduct1());
                                }
                                System.out.println();
                                System.out.println("         2 ");
                                if (actualUser.getProduct2() == null) {
                                    System.out.println("         # Espacio de venta VACIO # ");
                                } else {
                                    System.out.println(actualUser.getProduct2());
                                }
                                System.out.println();
                                System.out.println("         3 -> SALIR SIN CANCELAR ");

                                do {
                                    try {
                                        System.out.println();
                                        System.out.println("     -------------------------------------------------------- ");
                                        System.out.println("     - ATENCION: Un producto cancelado no puede recuperarse - ");
                                        System.out.println("     -------------------------------------------------------- ");
                                        System.out.print("     * ¿Que producto desea cancelar? (1-2) (Salir -> 3): ");
                                        selectDeleteProduct = Integer.parseInt(s.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("    - Error: Opcion no valida - ");
                                    }
                                } while ((selectDeleteProduct <= 0) || (selectDeleteProduct >= 4));

                                switch (selectDeleteProduct) {

                                    case 1:
                                        actualUser.setProduct1(null);
                                        System.out.println();
                                        System.out.println("    - Producto 1 CANCELADO - ");
                                        System.out.println();
                                        System.out.println("     - Espacio 1 disponible ");
                                        System.out.println("        para nueva venta - ");
                                        break;

                                    case 2:
                                        actualUser.setProduct2(null);
                                        System.out.println();
                                        System.out.println("    - Producto 2 CANCELADO - ");
                                        System.out.println();
                                        System.out.println("     - Espacio 2 disponible ");
                                        System.out.println("        para nueva venta - ");
                                        break;

                                    case 3:
                                        System.out.println();
                                        System.out.println("    - Sin cancelacion de productos -  ");
                                        break;

                                }
                            }
                            System.out.println();
                            System.out.print("    * Menu -> Pulsa INTRO: ");
                            s.nextLine();
                            break;

                        case "s", "S":
                            System.out.println();
                            System.out.print("    * Menu -> Pulsa INTRO: ");
                            s.nextLine();
                            break;
                    }
                    break;

                // TODO: 08/12/2020 - Terminar venta
                case 6:
                    System.out.println();
                    System.out.println();
                    System.out.println("    6 - Venta: TODOS LOS PRODUCTOS - ");
                    System.out.println();
                    System.out.println("    =================================");
                    System.out.println("    ---------------------------------");
                    System.out.println("     - Vendedor: " + user1.getEmail());
                    System.out.println("    ---------------------------------");
                    System.out.println((user1.getProduct1() != null) ? "     - Opcion 1 - \n" +
                            user1.getProduct1() : "     - Opcion 1 -> Espacio vacio ");
                    System.out.println((user1.getProduct2() != null) ? "     - Opcion 2 - \n" +
                            user1.getProduct2() : "     - Opcion 2 -> Espacio vacio ");
                    System.out.println("    ---------------------------------");
                    System.out.println("    =================================");
                    System.out.println();
                    System.out.println();
                    System.out.println("    =================================");
                    System.out.println("    ---------------------------------");
                    System.out.println("     - Vendedor: " + user2.getEmail());
                    System.out.println("    ---------------------------------");
                    System.out.println((user2.getProduct1() != null) ? "     - Opcion 3 - \n" + user2.getProduct1() :
                            "     - Opcion 3 -> Espacio vacio ");
                    System.out.println((user2.getProduct2() != null) ? "     - Opcion 4 - \n" + user2.getProduct2() :
                            "     - Opcion 4 -> Espacio vacio ");
                    System.out.println("    ---------------------------------");
                    System.out.println("    =================================");
                    System.out.println();

                    // Compras Usuario 1
                    if (actualUser != user2) {
                        if ((user2.getProduct1() == null) && (user2.getProduct2() == null)) {
                            System.out.println();
                            System.out.println("    - Aun no hay productos disponibles para comprar - ");
                            System.out.println("        - ¡Suerte en la venta de sus productos! -");
                            System.out.println();
                            System.out.println();
                            System.out.print("    * Menu -> Pulsa INTRO: ");
                            s.nextLine();
                        } else {
                            System.out.println("    - Productos disponibles para " + user1.getName() + " " + user1.getSurname() + ": ");
                            System.out.print((user2.getProduct1() != null) ? "      3 -> " +
                                    user2.getProduct1().getTitle() + "\n" : "");
                            System.out.println((user2.getProduct2() != null) ? "      4 -> " +
                                    user2.getProduct2().getTitle() : "");
                            System.out.println();

                            do {
                                try {
                                    System.out.print("    * Marque el producto que desea comprar(");
                                    if (user2.getProduct1() != null) System.out.print("3");
                                    if ((user2.getProduct1() != null) && (user2.getProduct2() != null))
                                        System.out.print("-");
                                    if (user2.getProduct2() != null) System.out.print("4");
                                    System.out.print(") (S -> Salir sin comprar): ");
                                    option = s.nextLine();
                                } catch (Exception e) {
                                    System.out.println("    - Opcion incorrecta - ");
                                }
                                if ((option.equalsIgnoreCase("3")) || (option.equalsIgnoreCase("4"))
                                        || (option.equalsIgnoreCase("s"))) optionChoose = true;
                            } while (!optionChoose);

                            // Compra producto 3
                            try {
                                if ((user2.getProduct1() == null) && (option.equalsIgnoreCase("3"))) {
                                    System.out.println("    - Opcion incorrecta: Producto 3 vacio - ");
                                } else {
                                    if (option.equalsIgnoreCase("3")) {
                                        System.out.println(user2.getProduct1());
                                        do {
                                            System.out.print("    * ¿Confirmar la compra de " + user2.getProduct1().getTitle() + "?(S/N): ");
                                            questionSale = s.nextLine();
                                            if ((questionSale.equalsIgnoreCase("s")) || (questionSale.equalsIgnoreCase("n"))) {
                                                questionSaleTrue = true;
                                            }
                                        } while (!questionSaleTrue);
                                        if (questionSale.equalsIgnoreCase("s")) {
                                            user2.setPurchaseNotice1(true);
                                            System.out.println();
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println("          - ¡Oferta de compra enviada! -       ");
                                            System.out.println("    - Esperando confirmacion del vendedor... - ");
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("    - Opcion incorrecta: producto 3 vacio - ");
                            }
                            // if (questionSaleTrue3) {
                            System.out.println();
                            System.out.print("    * Menu -> Pulsa INTRO: ");
                            s.nextLine();

                            // Compra producto 4
                            try {
                                if ((user2.getProduct2() == null) && (option.equalsIgnoreCase("4"))) {
                                    System.out.println("    - Opcion incorrecta: Producto 4 vacio - ");
                                } else {
                                    if (option.equalsIgnoreCase("4")) {
                                        System.out.println(user2.getProduct2());
                                        do {
                                            System.out.print("    * ¿Confirmar la compra de " + user2.getProduct2().getTitle() + "?(S/N): ");
                                            questionSale = s.nextLine();
                                            if ((questionSale.equalsIgnoreCase("s")) || (questionSale.equalsIgnoreCase("n"))) {
                                                questionSaleTrue = true;
                                            }
                                        } while (!questionSaleTrue);
                                        if (questionSale.equalsIgnoreCase("s")) {
                                            user2.setPurchaseNotice2(true);
                                            System.out.println();
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println("          - ¡Oferta de compra enviada! -       ");
                                            System.out.println("    - Esperando confirmacion del vendedor... - ");
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("    - Opcion incorrecta: producto 4 vacio - ");
                            }
                        }
                    }

                    // Compras Usuario 2
                    if (actualUser != user1) {
                        if ((user1.getProduct1() == null) && (user1.getProduct2() == null)) {
                            System.out.println();
                            System.out.println("    - Aun no hay productos disponibles para comprar - ");
                            System.out.println("        - ¡Suerte en la venta de sus productos! -");
                            System.out.println();
                        } else {
                            System.out.println("    - Productos disponibles para " + user2.getName() + " " + user2.getSurname() + ": ");
                            System.out.print((user1.getProduct1() != null) ? "      1 -> " +
                                    user1.getProduct1().getTitle() + "\n" : "");
                            System.out.println((user1.getProduct2() != null) ? "      2 -> " +
                                    user1.getProduct2().getTitle() : "");
                            System.out.println();

                            do {
                                try {
                                    System.out.print("    * Marque el producto que desea comprar(");
                                    if (user1.getProduct1() != null) System.out.print("1");
                                    if ((user1.getProduct1() != null) && (user1.getProduct2() != null))
                                        System.out.print("-");
                                    if (user1.getProduct2() != null) System.out.print("2");
                                    System.out.print(") (S -> Salir sin comprar): ");
                                    option = s.nextLine();
                                } catch (Exception e) {
                                    System.out.println("    - Opcion incorrecta - ");
                                }
                                if ((option.equalsIgnoreCase("1")) || (option.equalsIgnoreCase("2"))
                                        || (option.equalsIgnoreCase("s"))) optionChoose = true;
                            } while (!optionChoose);

                            // Compra producto 1
                            try {
                                if ((user1.getProduct1() == null) && (option.equalsIgnoreCase("1"))) {
                                    System.out.println("    - Opcion incorrecta: Producto 1 vacio - ");
                                } else {
                                    if (option.equalsIgnoreCase("1")) {
                                        System.out.println(user1.getProduct1());
                                        do {
                                            System.out.print("    * ¿Confirmar la compra de " + user1.getProduct1().getTitle() + "?(S/N): ");
                                            questionSale = s.nextLine();
                                            if ((questionSale.equalsIgnoreCase("s")) || (questionSale.equalsIgnoreCase("n"))) {
                                                questionSaleTrue = true;
                                            }
                                        } while (!questionSaleTrue);
                                        if (questionSale.equalsIgnoreCase("s")) {
                                            user1.setPurchaseNotice1(true);
                                            System.out.println();
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println("          - ¡Oferta de compra enviada! -       ");
                                            System.out.println("    - Esperando confirmacion del vendedor... - ");
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("    - Opcion incorrecta: producto 1 vacio - ");
                            }

                            // Compra producto 2
                            try {
                                if ((user1.getProduct2() == null) && (option.equalsIgnoreCase("2"))) {
                                    System.out.println("    - Opcion incorrecta: Producto 2 vacio - ");
                                } else {
                                    if (option.equalsIgnoreCase("2")) {
                                        System.out.println(user1.getProduct2());
                                        do {
                                            System.out.print("    * ¿Confirmar la compra de " + user1.getProduct2().getTitle() + "?(S/N): ");
                                            questionSale = s.nextLine();
                                            if ((questionSale.equalsIgnoreCase("s")) || (questionSale.equalsIgnoreCase("n"))) {
                                                questionSaleTrue = true;
                                            }
                                        } while (!questionSaleTrue);
                                        if (questionSale.equalsIgnoreCase("s")) {
                                            user1.setPurchaseNotice2(true);
                                            System.out.println();
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println("          - ¡Oferta de compra enviada! -       ");
                                            System.out.println("    - Esperando confirmacion del vendedor... - ");
                                            System.out.println("    ------------------------------------------ ");
                                            System.out.println();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("    - Opcion incorrecta: producto 2 vacio - ");
                            }
                        }
                        System.out.println();
                        System.out.print("    * Menu -> Pulsa INTRO: ");
                        s.nextLine();
                    }
                    break;
                // TODO: 08/12/2020 - Terminar historicos de venta y compra
                case 7:
                    System.out.println();
                    System.out.println("    7 - Ventas: Historico - ");
                    System.out.println();
                    System.out.println("      - Vendedor: " + actualUser.getName() + " " + actualUser.getSurname());
                    System.out.println();
                    if (!saleMade1) {
                        System.out.println("      - Aún no se ha completado ninguna venta - ");
                        System.out.println();
                    } else {
                        if (actualUser.getEmail().equals(user1.getEmail())) {
                            System.out.println();
                            System.out.println("          - Producto: ");
                            System.out.println();
                            System.out.println(user1.getSale1());
                            System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("          - Comprador: " + user1.getName() + " " + user1.getSurname());
                            System.out.println();
                            System.out.println("          - Producto: ");
                            System.out.println();
                        }
                    }
                    break;

                case 8:
                    System.out.println();
                    System.out.println("    8 - Compras: Historico - ");
                    System.out.println();
                    if (!purchaseMade) {
                        System.out.println("     - Aún no se ha realizado ninguna compra - ");
                        System.out.println();
                    } else {
                        System.out.println();
                        if (actualUser.getEmail().equals(user1.getEmail())) {
                            System.out.println();
                            System.out.println("      - Producto adquirido - ");
                            System.out.println();
                        }
                        if (actualUser.getEmail().equals(user2.getEmail())) {
                            System.out.println();
                            System.out.println("      - Producto adquirido - ");
                            System.out.println();
                        }
                    }
                    break;

                case 9:
                    System.out.println();
                    System.out.println("    9 - Salir - ");
                    System.out.println();
                    System.out.println("      A - Cambiar de usuario - ");
                    System.out.println("      B - Apagar el programa - ");
                    System.out.println();

                    do {
                        try {
                            System.out.println();
                            System.out.print("      * ¿Que desea? (A/B): ");
                            askOptionTurnOff = s.nextLine();
                            if ((askOptionTurnOff.equalsIgnoreCase("a")) ||
                                    (askOptionTurnOff.equalsIgnoreCase("b"))) {
                                optionTurnOff = true;
                            }
                        } catch (Exception e) {
                            System.out.println("     - Opcion incorrecta - ");
                        }
                    } while (!optionTurnOff);

                    switch (askOptionTurnOff) {

                        // Cambiar de usuario
                        case "a", "A":
                            System.out.println();
                            System.out.print("    * ¿Cambiar de Usuario (S/N)?: ");
                            askChangeUser = s.nextLine();

                            if (!askChangeUser.equalsIgnoreCase("s")) {
                                System.out.println();
                                System.out.print("    * Menu -> Pulsa INTRO: ");
                                s.nextLine();
                            } else {
                                try {
                                    do {
                                        System.out.println();
                                        System.out.println();
                                        System.out.println("    LOGIN: ");
                                        System.out.println();
                                        System.out.print("    * Introducir email: ");
                                        loginUser = s.nextLine();
                                        System.out.println();
                                        System.out.print("    * Introducir clave: ");
                                        loginPass = s.nextLine();
                                        System.out.println();
                                        login = user1.login(loginUser, loginPass);
                                        if (login) {
                                            actualUser = user1;
                                            break;
                                        }
                                        login = user2.login(loginUser, loginPass);
                                        if (login) {
                                            actualUser = user2;
                                        }
                                    } while (!login);
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("      - Opcion Incorrecta -");
                                    System.out.println("    - Introduce email/clave - ");
                                    System.out.println();
                                }
                            }
                            break;

                        // Apagar
                        case "b", "B":
                            System.out.println();
                            System.out.print("    * ¿Apagar el programa (S/N)?: ");
                            askTurnOff = s.nextLine();

                            if (!askTurnOff.equalsIgnoreCase("s")) {
                                System.out.println();
                                System.out.println("            ------------------  ");
                                System.out.println("           - Apagar cancelado - ");
                                System.out.println("            ------------------  ");
                                System.out.println();
                                System.out.print("    * Menu -> Pulsa INTRO: ");
                                s.nextLine();
                            } else {
                                System.out.println();
                                System.out.println("            -------------  ");
                                System.out.println("           - Apagando... - ");
                                System.out.println("            -------------  ");
                                System.out.println();
                                turnOff = true;
                            }
                            break;
                    }
            }
        }
    }


    public static void menu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==================================================================");
        System.out.println();
        System.out.println("                       - MENU DE USUARIO - ");
        System.out.println();
        System.out.println("    1 - Mostrar mi  ");
        System.out.println("    2 - Cambiar datos personales");
        System.out.println("    3 - Ver mis productos en venta");
        System.out.println("    4 - Poner a la venta un nuevo producto");
        System.out.println("    5 - Cerrar la venta de un producto / quitarlo de la venta");
        if ((actualUser.isPurchaseNotice1()) || (actualUser.isPurchaseNotice2())) {
            System.out.println("      # Aviso: ¡Comprador disponible! # ");
        }
        System.out.println("    6 - Ver todos los productos en venta de la aplicacion");
        System.out.println("    7 - Ver mi historico de ventas");
        System.out.println("    8 - Ver mi historico de compras");
        System.out.println("    9 - Salir");
        System.out.println();
        System.out.println("==================================================================");
    }

    public static User registraUsuario() {
        var s = new Scanner(System.in);
        User user = new User();
        System.out.print("Introduce el correo ");
        user.setEmail(s.nextLine());
        System.out.println();

        System.out.print("Introduce la contraseña: ");
        System.out.println();
        user.setPass(s.nextLine());
        System.out.println();

        System.out.print("Introduce el nombre: ");
        user.setName(s.nextLine());
        System.out.println();

        System.out.print("Introduce los apellidos: ");
        System.out.println();
        user.setSurname(s.nextLine());
        System.out.println();

        System.out.print("Introduce el dni: ");
        System.out.println();
        user.setDni(s.nextLine());
        System.out.println();

        System.out.print("Introduce el numbre de tu ciudad: ");
        System.out.println();
        user.setCity(s.nextLine());
        System.out.println();

        System.out.print("Intruduce el pais donde vives: ");
        System.out.println();
        user.setCountry(s.nextLine());
        System.out.println();

        System.out.print("Introduce tu codigo postal:");
        System.out.println();
        user.setPostcode(s.nextLine());
        System.out.println();

        return user;
    }

      /*  User user = new User();
        System.out.print("Introduce el correo ");
        user.setEmail("josemanuel6201@hotmail.com");
        //user.setEmail(s.nextLine());
        System.out.println();

        System.out.print("Introduce la contraseña: ");
        System.out.println();
        user.setPass("12345");
        //user.setPass(s.nextLine());
        System.out.println();

        System.out.print("Introduce el nombre: ");
        user.setName("Jose");
        //user.setName(s.nextLine());
        System.out.println();

        System.out.print("Introduce los apellidos: ");
        System.out.println();
        user.setSurname("castillo");
        //user.setSurname(s.nextLine());
        System.out.println();
        System.out.print("Introduce el dni: ");
        System.out.println();
        user.setDni("asdf");
        //user.setDni(s.nextLine());
        System.out.println();

        System.out.print("Introduce el numbre de tu ciudad: ");
        System.out.println();
        user.setCity("Jaen");
        //user.setCity(s.nextLine());
        System.out.println();

        System.out.print("Intruduce el pais donde vives: ");
        System.out.println();
        user.setCountry("España");
        //user.setCountry(s.nextLine());
        System.out.println();

        System.out.println("Introduce tu codigo postal:");
        System.out.println();
        user.setCountry("23006");
        //user.setPostcode(s.nextLine());
        System.out.println();

        return user;
    }*/

    public static void showDates() {
        System.out.println();
        System.out.println();
        System.out.println("    2 - Cambiar datos personales -");
        System.out.println();
        System.out.println("     ------------- DATOS ACTUALES --------------");
        System.out.println("    |    Nombre (N): " + actualUser.getName());
        System.out.println("    |    Apellido (A): " + actualUser.getSurname());
        System.out.println("    |    DNI (D): " + actualUser.getDni());
        System.out.println("    |    Ciudad (C): " + actualUser.getCity() + "   Pais (P): " + actualUser.getCountry());
        System.out.println("    |    Codigo postal (CP): " + actualUser.getPostcode());
        System.out.println("     -------------------------------------------");
        System.out.println();
        System.out.println("    'Salir' -> Volver al Menu Usuario ");
        System.out.print("    * Escribe el dato a cambiar (o su abreviatura): ");
    }

    private static void enviaTocken(String email, String token) {

        String asunto;
        asunto = "Codigo para entrar en LicantroPOP";
        if (enviaMail(email, token, asunto)) {
            System.out.println("Se ha enviado un codigo a su Email para verificar cuenta, ");
        } else System.out.println("Fallo al enviar el mensaje para token");
    }

    static boolean enviaMail(String destino, String mensaje, String asunto) {
        boolean envio = false;
        //guardamos la direccion que va a remitir el mensaje
        String emisor = "licantropop@licantropop.com";
        String username = "dam2@carlosprofe.es";//usuario para el server del correo
        String password = "Olivo.2021"; //contraseña del usuario del correo
        //host del servidor
        String host = "SSL0.OVH.NET";
        //Creamos nuestras variables para las propiedades de datos de nuestro servido de correo;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        //obtenemos la sesion de nuestro servidor de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            //Creamos el mensaje de correo por defecto
            Message message = new MimeMessage(session);
            //En el mensaje, establecemos el emisor con los datos pasados a la función
            message.setFrom(new InternetAddress(emisor));
            //En el mensaje establecemos el receptor.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));
            //Establecemos el asunto
            message.setSubject(asunto);
            //Añadimos el contenido al mensaje
            message.setContent(mensaje, "text/html; charset=utf-8");
            //Envio el mensaje
            Transport.send(message);
            envio = true;
        } catch (Exception e) {// si entra aqui es porque ha fallado
            throw new RuntimeException(e);
        }
        return envio;
    }
}
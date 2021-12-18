package prima_problema;

@SuppressWarnings("unused")
class ExceptiiElev extends Exception {

    static String NOTA_GRESITA = "Nota nu este in intervalul [1-10]!";
    static String CLASA_GRESITA = "Clasa nu este in intervalul [0-12]!";

    ExceptiiElev(String mesajExceptie) {
        super(mesajExceptie);
    }

}

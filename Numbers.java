public class Numbers {

    private static String[] unidadesMay = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static String[] unidadesMin = new String[unidadesMay.length];
    private static String[] decenasMay = {
            "Ten","Eleven","Twelve","Thirteen","Fourteen",
            "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static String[] decenasMin = new String[decenasMay.length];
    private static String[] decenasMay1 = {"","Twenty","Thirty","Forty","Fifty",
            "Sixty","Seventy","Eighty","Ninety"};
    private static String[] decenasMin1 = new String[decenasMay1.length];


    public static String say(long n) {
        // Hacemos un for que recorra el array de unidadesMin
        for (int i = 0; i < unidadesMay.length; i++) {
            String actual = unidadesMay[i];
            unidadesMin[i] = actual.toLowerCase();
        }
        return getThousands((int) n);
    }


    public static long words(String s) {
        return 0;
    }

    static String getUnidades(int n){
        return n == 0 ? "Zero" : unidadesMay[n-1];
    }

    static String getDecenas(int n){
        String resultado = "";
        int unidades = n % 10;
        int decenas = n / 10;
        // Comprobamos si las decenas son igual a 0
        if (decenas == 0) {
            // Devolvemos las unidades en minusculas
            return getUnidades(unidades).toLowerCase();
        }
        if (decenas == 1){
            resultado += decenasMay[unidades];
            return resultado;
        } else {
            resultado += decenasMay1[decenas-1];
        }
        if (unidades == 0){
            return resultado;
        } else {
            resultado += "-" + unidadesMin[unidades-1];
        }
        return resultado;
    }

    static String getCentenas(int n){
        String resultado = "";
        int decenas = n % 100;
        int centenas = n / 100;
        if (centenas == 0){
            return getDecenas(decenas).toLowerCase();
        }
        // Cogemos las unidades y le añadimos la palabra hundred
        resultado += getUnidades(centenas) + " hundred";
        // Si las decenas son igual a 0 devolveremos el resultado
        if (decenas == 0) {
            return resultado;
        }

        return resultado + " and " + getDecenas(decenas).toLowerCase();
    }

    static String getThousands(int n){
        String resultado = "";
        int centenas = n % 1000;
        int thousand = n / 1000;
        resultado += getCentenas(thousand) + " thousand";
        resultado = resultado.substring(0,1).toUpperCase() + resultado.substring(1, resultado.length());
        if (centenas == 0){
            return resultado;
        }
        if (centenas < 100){
            return resultado + " " + getDecenas(centenas).toLowerCase();
        }
        return resultado + " " + getCentenas(centenas).toLowerCase();
    }


    public static void main(String[] args) {
        long n = 2300;
        System.out.println(say(n));
    }
}
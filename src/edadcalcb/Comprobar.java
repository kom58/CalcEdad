
/* CLASE: Comprobar                             Version 0.2.5

    Métodos:
            boolean esEnteroPositivo (String)   Comprueba entero positivo o cero
                                                con control de errores
                                                try { ... } catch (Exception e) { ... }
                                                Ojo captura cualquier tipo de excepción

            boolean esEntero (String)           Comprueba entero con control de errores
                                                try { ... } catch (Exception e) { ... }
                                                Ojo captura cualquier tipo de excepción

            boolean esEnteroNegativo (String)   Comprueba entero negativo con control
                                                de errores try/catch (Exception e)

            boolean esDoble (String)            ...

            boolean esDoblePositivo (String)    ...

            boolean esDobleNegativo (String)    ...

            boolean esFecha (String d,m,a)      Comprueba validez de la fecha con control
                                                de errores try/catch (Exception e)

 */


package edadcalcb;


public class Comprobar {

    public boolean esEnteroPositivo(String tt) {         // esEnteroPositivo ++++++++++++++++++++++

        boolean correcto = false;
        int n;

        try {
            n = Integer.parseInt(tt);
        } catch (Exception e) {
            return false;
        }

        if (n >= 0) {
            correcto = true;
        }

        return correcto;
    }


    public boolean esEntero(String tt) {                    // esEntero ++++++++++++++++++++++++++

        boolean correcto = false;
        int n;

        try {
            n = Integer.parseInt(tt);
        } catch (Exception e) {
            return false;
        }

        if (n == n * 1) {
            correcto = true;
        }

        return correcto;
    }


    public boolean esEnteroNegativo(String tt) {            // esEnteroNegativo ++++++++++++++++++

        boolean correcto = false;
        int n;

        try {
            n = Integer.parseInt(tt);
        } catch (Exception e) {
            return false;
        }

        if (n < 0) {
            correcto = true;
        }

        return correcto;

    }


    public boolean esFecha(String dd, String mm, String aaaa) {        // esFecha ++++++++++++++++

        boolean correcto = true;
        int d, m, a;

        try {
            d = Integer.parseInt(dd);
        } catch (Exception e) {
            return false;
        }
        try {
            m = Integer.parseInt(mm);
        } catch (Exception e) {
            return false;
        }
        try {
            a = Integer.parseInt(aaaa);
        } catch (Exception e) {
            return false;
        }

        if (d < 1 || d > 31) {
            return false;
        }                  // Comprueba dias

        if (m < 1 || m > 12) {
            return false;
        }                  // Comprueba meses

        if (m == 2) {                                         // Comprueba bisiesto
            if (a % 100 == 0 && !(a % 400 == 0)) {
                if (d > 28) {
                    return false;
                }
            }
            if (a % 4 == 0) {
                if (d > 29) {
                    return false;
                }
            } else {
                if (d > 28) {
                    return false;
                }
            }
        }

        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {           // Meses de 31 días
            if (d > 31) {
                return false;
            }
        }

        if (m == 4 || m == 6 || m == 9 || m == 11) {                                   // Meses de 30 días
            if (d > 30) {
                return false;
            }
        }

        if (a < 0) {
            return false;
        }                            // Comprueba años

        return correcto;

    }
}

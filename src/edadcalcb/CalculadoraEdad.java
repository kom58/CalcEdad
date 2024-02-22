package edadcalcb;

public class CalculadoraEdad {
    int contadord=0;
    int hora=0;
    int conta=0;

                     // Devuelve la edad en años de una persona
    public int ano(int anoNac, int anoAct, int mesNac, int mesAct, int diaNac, int diaAct){
        int edadAnos = anoAct - anoNac;
        if (mesNac > mesAct) {
            edadAnos--;
        }
        if ((mesNac == mesAct) && (diaNac > diaAct)) {
            edadAnos--;
        }
        return edadAnos;
    }

                    // Devuelve la edad en meses de una persona
    public int mes(int anoNac, int anoAct, int mesNac, int mesAct, int diaNac, int diaAct) {
        int edadAnos = ano(anoNac, anoAct, mesNac, mesAct, diaNac, diaAct);
        int edadMeses = edadAnos * 12;
        int meses = 0;

        // Calculamos el números de meses transcurrido desde el último cumpleaños
        if (mesNac < mesAct) {	// El cumpleaños ya ha ocurrido en el año actual
            meses = mesAct - mesNac;
        }
        if (mesNac > mesAct) {	// Aún no ha cumplido los años en el año actual
            meses = (12 - mesNac) + mesAct;
        }

        // Ajustamos el pico de meses mirando si ya ha llegado el "cumplemeses" o no
        if (diaNac > diaAct)
            meses--;	// Aún no ha llegado el "cumplemeses", así que quitamos un mes

        edadMeses = edadMeses + meses;
        return edadMeses;
    }

                    // Devuelve la edad en días de una persona
    public int dia(int anoNac, int anoAct, int mesNac, int mesAct, int diaNac, int diaAct){

        int[] mesr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int quitar = 0;
        int edadDias = 0;

        for (int i = anoNac; i <= anoAct; i++){
            if (esBisiesto(i) == true){
                edadDias = edadDias+366;
            }
            if (esBisiesto(i) == false){
                edadDias = edadDias+365;
            }
        }
        for (int i = 1; i < mesNac; i++){	//para saber los dias del año en el que naciste
            quitar = quitar + mesr[i];
            if (esBisiesto(anoNac) && (i == 2))
                quitar++;
        }
        quitar = quitar + diaNac;

        for (int i = 12; i > mesAct; i--){	//para saber los dias del año actual
            quitar = quitar + mesr[i];
            if (esBisiesto(anoAct) && (i == 2))
                quitar++;
        }
        quitar = quitar + (mesr[mesAct] - diaAct);

        edadDias = edadDias-quitar;
        return edadDias;
    }

    // Devuelve la edad en horas de una persona
    public int hora(int anoNac, int anoAct, int mesNac, int mesAct, int diaNac, int diaAct) {
        int h = dia(anoNac, anoAct, mesNac, mesAct, diaNac, diaAct) * 24;
        return h;
    }

                    // Devuelve la edad en minutos de una persona
    public int minuto(int anoNac, int anoAct, int mesNac, int mesAct, int diaNac, int diaAct) {
        int m = hora(anoNac, anoAct, mesNac, mesAct, diaNac, diaAct) * 60;
        return m;
    }

                    // Devuelve la edad en segundos de una persona
    public int segundo(int anoNac, int anoAct, int mesNac, int mesAct, int diaNac, int diaAct) {
        int s = minuto(anoNac, anoAct, mesNac, mesAct, diaNac, diaAct) * 60;
        return s;
    }


                    // Determina si un año es bisiesto o no
                    // Devuelve true si el año a es bisiesto y false en caso contrario
    public boolean esBisiesto(int a) {

        boolean bisiesto = false;

        if (a % 4 == 0) bisiesto = true;
        if (a % 100 == 0) bisiesto = false;
        if (a % 400 == 0) bisiesto = true;

        return bisiesto;
    }
}
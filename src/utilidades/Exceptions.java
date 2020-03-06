package utilidades;
public class Exceptions {

    public static int validateDay() {
        boolean comprobacion = true;
        int dia = 0;
        do {
            dia = comprobarInt();
            comprobacion = true;
            try {
                if (dia < 0) {
                    throw new RuntimeException("NO EXISTEN DIAS NEGATIVOS");
                }
                if (dia > 31) {
                    throw new RuntimeException("NO EXISTEN DIAS MAYORES DE 31 EN UN MES");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce un dia valido");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return dia;
    }

    public static int validateMonth(int dia) {
        boolean comprobacion = true;
        int mes = 0;
        do {
            mes = comprobarInt();
            comprobacion = true;
            try {
                if (mes > 0) {
                    if (mes < 13) {
                        if (dia > 28) {
                            if (dia == 29 || dia == 30) {
                                if (mes == 2) {
                                    throw new RuntimeException("ESTE DIA PARA ESTE MES NO EXISTE");
                                }
                            }
                            if (dia == 31) {
                                if (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                                    throw new RuntimeException("ESTE DIA PARA ESTE MES NO EXISTE");
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("ESTE MES NO ESISTE");
                    }
                } else {
                    throw new RuntimeException("NO EXISTEN MESES NEGATIVOS");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce una mes valido");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return mes;
    }

    public static int validateYear() {
        boolean comprobacion = true;
        int ano = 0;
        do {
            ano = comprobarInt();
            comprobacion = true;
            try {
                if (ano < 0) {
                    throw new RuntimeException("NO EXISTEN AÑOS NEGATIVOS");
                }
                if (ano > 2019) {
                    throw new RuntimeException("ESTAMOS EN EL 2019");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce una año valido");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return ano;
    }

    public static int validateDays() {
        boolean comprobacion = true;
        int dias = 0;
        int i = 0;
        do {
            dias = comprobarInt();
            comprobacion = true;
            try {
                if (dias > 630) {
                    i = 1;
                    throw new RuntimeException("NO PUEDE SER MAYOR DE 630");
                }
                if (dias < 0) {
                    i = 2;
                    throw new RuntimeException("NO PUEDEN A VER PASADO DIAS NEGATIVOS");
                }
                if (dias % 45 != 0) {
                    i = 3;
                    throw new RuntimeException("LOS DIAS TIENEN QUE SER UN MULTIPLO DE 45");
                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce dias menores de 630, mayores de de 0 o multiplo de 45");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return dias;
    }

    public static int validatePeso() {
        boolean comprobacion = true;
        int peso = 0;
        do {
            peso = comprobarInt();
            comprobacion = true;
            try {
                if (peso < 0) {
                    throw new RuntimeException("NO PUEDE TENER UN PESO NEGATIVO");
                }
                if (peso > 60) {
                    throw new RuntimeException("NO PUEDE TENER UN PESO MAYOR DE 60 GRAMOS");

                }
            } catch (RuntimeException ex) {
                System.out.println("Introduce peso entre 0 y 60 gramos");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return peso;
    }

    public static float validateTemp() {
        boolean comprobacion = true;
        float temp = 0;
        do {
            temp = comprobarFloat();
            comprobacion = true;
            try {
                if (temp < 10) {
                    throw new RuntimeException("NO PUEDE TENER UNA TEMPERATURA MENOR DE 10º");
                }
                if (temp > 50) {
                    throw new RuntimeException("NO PUEDE TENER UNA TEMPERATURA MAYOR DE 50º");
                }

            } catch (RuntimeException ex) {
                System.out.println("Introduce una temperatura entre 10 y 50 grados");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return temp;
    }

    public static int comprobarInt() {
        int entero = 0;
        boolean comprobacion = true;
        String leido;
        do {
            leido = Utilidades.leer();
            comprobacion = true;
            try {
                entero = Integer.parseInt(leido);
            } catch (NumberFormatException ex) {
                System.out.println("Introduce un numero entero");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return entero;

    }

    public static float comprobarFloat() {
        float f = 0;
        boolean comprobacion = true;
        String leido;
        do {
            leido = Utilidades.leer();
            comprobacion = true;
            try {
                f = Float.parseFloat(leido);
            } catch (NumberFormatException ex) {
                System.out.println("Introduce un numero real");
                comprobacion = false;
            }
        } while (comprobacion == false);
        return f;

    }

    public static boolean comprobarPorcentaje(float m, float h) {
        boolean comprobar = false;
        if (m + h == 100) {
            comprobar = true;
        }
        return comprobar;
    }

    public static boolean comprobarMenos100(float m) {
        boolean comprobar = false;
        if (m <= 100) {
            comprobar = true;
        }
        return comprobar;
    }
}

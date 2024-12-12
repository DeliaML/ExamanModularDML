import java.time.Year;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void menu() {
        Scanner in = new Scanner(System.in);
        //para que entres por defecto en el menu
        char res = 'q';

        //para que solo salgas si quieres salir
        while (res != 'd') {
            //enseño el menu
            System.out.println("(a) Mayores de edad");
            System.out.println("(b) Calculadora de ingresos de canal de Youtube");
            System.out.println("(c) Cálculo horario");
            System.out.println("(d) Salir");
            //pido el caracter
            res = in.next().charAt(0);

            switch (res) {

                case 'a':

                    System.out.println("Dime cuantas edades quieres introducir");
                    int numedad = in.nextInt();
                    //pido la edad y la envío a la función
                    int mayor = mayorEdad(numedad);
                    //enseño por pantalla el resultado
                    System.out.println("Hay " + mayor + " mayores de edad");

                    break;

                case 'b':

                    //para que entre la primera vez en el bucle
                    String tema = "a";
                    //para que los nextLine después de otros next funcionen bien
                    String lol;
                    lol = in.nextLine();
                    //para eliminar warnings
                    System.out.println(lol);
                    int visitas;
                    //para un bucle que utilizar más adelante
                    int con = 0;
                    //cantidad de dinero por video
                    double video;
                    //cantidad de dinero del canal
                    double dinero = 0;
                    //para que solo salga del bucle si escribe Salir cuando le pregunte por el tema
                    while (!Objects.equals(tema, "Salir")) {
                        System.out.println("Escribe Salir para salir");
                        System.out.println("Introduce el tema del video");
                        tema = in.nextLine();
                        //perdón :(, no me salia de otra forma
                        if (Objects.equals(tema, "Salir")) con = 5;
                        if (Objects.equals(tema, "ASMR")) con = 5;
                        if (Objects.equals(tema, "Deportes")) con = 5;
                        if (Objects.equals(tema, "Animales")) con = 5;
                        if (Objects.equals(tema, "Tecnología")) con = 5;
                        if (Objects.equals(tema, "Bebés")) con = 5;
                        //para asegurarme de que escribe un tema valido
                        while (con != 5) {
                            con = 0;
                            if (!Objects.equals(tema, "Salir")) con ++;
                            if (!Objects.equals(tema, "ASMR")) con ++;
                            if (!Objects.equals(tema, "Deportes")) con ++;
                            if (!Objects.equals(tema, "Animales")) con ++;
                            if (!Objects.equals(tema, "Tecnología")) con ++;
                            if (!Objects.equals(tema, "Bebés")) con ++;
                            System.out.println("Escribe Salir para salir");
                            System.out.println("Los temas validos son ASMR, Deportes, Animales, Tecnología y Bebés");
                            System.out.println("Si a la primera no sale prueba otra vez");
                            tema = in.nextLine();
                        }
                        //para que no calcule el próximo video si ha escrito Salir
                        if (!Objects.equals(tema, "Salir")) {
                            System.out.println("Introduce las visitas del video");
                            visitas = in.nextInt();
                            //para asegurarme de que no escribe un número negativo
                            while (visitas < 0) {
                                System.out.println("Introduce un número valido");
                                visitas = in.nextInt();
                            }
                            lol = in.nextLine();
                            System.out.println(lol);
                            //calcula el dinero de ese video
                            video = ingresosVideo(tema, visitas);
                            //y se lo envía a la que calcula el dinero en total del canal
                            dinero = ingresosCanal(dinero, video);
                        }
                    }

                    //le enseño por pantalla el resultado
                    System.out.println("Los ingresos del Canal son " + dinero + " euros");

                    break;

                case 'c':

                    System.out.println("Introduce una hora");
                    int hora = in.nextInt();
                    //para asegurarme de que escribe una hora valida
                    while (hora < 1 || hora > 12) {
                        System.out.println("Introduce una hora valida");
                        hora = in.nextInt();
                    }
                    System.out.println("Introduce los minutos");
                    int minutos = in.nextInt();
                    //para asegurarme de que escribe minutos validos
                    while (minutos < 0 || minutos >= 60) {
                        System.out.println("Introduce minutos validos");
                        minutos = in.nextInt();
                    }
                    System.out.println("Introduce AM o PM");
                    //para que funcione el nextLine correctamente
                    String xd = in.nextLine();
                    //para eliminar warnings
                    System.out.println(xd);
                    String m = in.nextLine();
                    //para asegurarme de que escribe AM o PM
                    while (!Objects.equals(m, "AM") && !Objects.equals(m, "PM")) {
                        System.out.println("Asegurate de que has escrito AM o PM bien");
                        m = in.nextLine();
                    }
                    System.out.println("Introduce un huso horario");
                    int huso = in.nextInt();
                    //para asegurarme de que escribe un huso horario valido
                    while (huso < -11 || huso > 12) {
                        System.out.println("el huso horario tiene que ser entre -11 y 12");
                        huso = in.nextInt();
                    }
                    //le envio los datos al procedimiento
                    husoHora(hora, minutos, m, huso);

                    break;

                case 'd':

                    System.out.println("Adios");

                    break;

                default:

                    System.out.println("introduce a, b, c o d");
            }
        }
    }

    public static int mayorEdad(int num) {
        Scanner in = new Scanner(System.in);
        int year = Year.now().getValue();
        int cont = 0;

        for (int birthyear; num > 0; num --) {
            System.out.println("Dime el año de nacimiento");
            birthyear = in.nextInt();
            //si es mayor de edad se suma uno al contador
            if ((year - birthyear) >= 18) {
                cont ++;
            }
        }
        //le devuelvo el número de edades mayores de edad
        return cont;
    }

    public static double ingresosVideo(String subject, int views) {

        double money;
        //formula de dinero dependiendo de la temática
        if (Objects.equals(subject, "ASMR") || Objects.equals(subject, "Deportes")) {
            money = 0.1 * views / 1000;
        } else if (Objects.equals(subject, "Bebés")) {
            money = 0.5 * views / 1000;
        } else money = 0.2 * views / 1000;
        //le devuelvo el dinero del video
        return money;
    }

    public static double ingresosCanal(double num, double suma) {
        num = num + suma;
        //suma el video anterior más el total de videos y lo devuelve
        return num;
    }

    public static void husoHora(int hour, int minutes, String m, int huso) {

        //suma o resta las horas por el huso dependiendo de si el huso es positivo o negativo
        hour = hour + huso;
        //para cambiar de AM a PM o de PM a AM si hace falta
        if (Objects.equals(m, "AM")) {
            if (hour > 12) {
                hour = hour - 12;
            } else if (hour <= 0) {
                hour = hour + 12;
            }
            m = "PM";
        } else if (Objects.equals(m, "PM")) {
            if (hour > 12) {
                hour = hour - 12;
            } else if (hour <= 0) {
                hour = hour + 12;
            }
            m = "AM";
        }
        //le enseño el resultado por pantalla
        if (minutes < 10) System.out.println(hour + ":0" + minutes + " " + m);
        else System.out.println(hour + ":" + minutes + " " + m);
    }

    public static void main(String[] args) {
        //para enseñar el menu
        menu();
    }
}
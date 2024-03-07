import java.util.ArrayList;
import java.util.Scanner;

class Paciente {
    String nombre;
    int edad;
    double temperatura;
    double presionArterial;

    public Paciente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.temperatura = 0.0;
        this.presionArterial = 0.0;
    }

    public void registrarTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void registrarPresionArterial(double presionArterial) {
        this.presionArterial = presionArterial;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Presión Arterial: " + presionArterial);
    }
}

class Enfermero {
    public void registrarTemperatura(Paciente paciente, double temperatura) {
        paciente.registrarTemperatura(temperatura);
    }

    public void registrarPresionArterial(Paciente paciente, double presionArterial) {
        paciente.registrarPresionArterial(presionArterial);
    }
}

public class GestionEnfermeria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Enfermero enfermero = new Enfermero();

        while (true) {
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Registrar datos vitales de un paciente");
            System.out.println("3. Mostrar datos de un paciente");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del paciente: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese edad del paciente: ");
                    int edad = scanner.nextInt();
                    Paciente nuevoPaciente = new Paciente(nombre, edad);
                    pacientes.add(nuevoPaciente);
                    break;
                case 2:
                    System.out.print("Ingrese índice del paciente: ");
                    int indice = scanner.nextInt();
                    Paciente pacienteSeleccionado = pacientes.get(indice);
                    System.out.print("Ingrese temperatura: ");
                    double temperatura = scanner.nextDouble();
                    enfermero.registrarTemperatura(pacienteSeleccionado, temperatura);
                    System.out.print("Ingrese presión arterial: ");
                    double presionArterial = scanner.nextDouble();
                    enfermero.registrarPresionArterial(pacienteSeleccionado, presionArterial);
                    break;
                case 3:
                    System.out.print("Ingrese índice del paciente: ");
                    int index = scanner.nextInt();
                    Paciente paciente = pacientes.get(index);
                    paciente.mostrarDatos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}


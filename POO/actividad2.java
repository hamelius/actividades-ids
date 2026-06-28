/**
 * Universidad Ciudadana de Nuevo León
 * Materia: Programación Orientada a Objetos
 * Tutor: Gustavo Alfredo Valdés González
 * Alumno: Alfredo Hamelius Rodríguez
 * Matrícula: 98942
 * Actividad 2: Desarrollo de una aplicación simple en línea
 */

// Clase que representa a un Estudiante
class Estudiante {
    String nombre;
    int edad;
    double promedio;

    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " | Edad: " + edad + " | Promedio: " + promedio);
    }

    public boolean verificarAprobacion() {
        return this.promedio >= 6.0;
    }
}

public class Main {
    // Método para mostrar los datos académicos de la entrega
    public static void imprimirEncabezado() {
        System.out.println("====================================================");
        System.out.println("UNIVERSIDAD CIUDADANA DE NUEVO LEÓN");
        System.out.println("Materia: Programación Orientada a Objetos");
        System.out.println("Tutor: Gustavo Alfredo Valdés González");
        System.out.println("Alumno: Alfredo Hamelius Rodríguez | Matrícula: 98942");
        System.out.println("Actividad 2: Desarrollo de una aplicación simple");
        System.out.println("====================================================\n");
    }

    public static void main(String[] args) {
        // Llamada al encabezado
        imprimirEncabezado();

        // Instanciación de objetos
        Estudiante est1 = new Estudiante("Alfredo Hamelius", 25, 9.8);
        Estudiante est2 = new Estudiante("Ana López", 22, 5.5);

        System.out.println("--- Reporte de Estudiantes ---");
        est1.mostrarInfo();
        System.out.println("¿Aprobó? " + (est1.verificarAprobacion() ? "Sí" : "No"));

        System.out.println("-----------------------------");
        
        est2.mostrarInfo();
        System.out.println("¿Aprobó? " + (est2.verificarAprobacion() ? "Sí" : "No"));
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Encabezado de identificación
        System.out.println("==================================================");
        System.out.println("Universidad Ciudadana de Nuevo León");
        System.out.println("Programación Orientada a Objetos.");
        System.out.println("Actividad 4.");
        System.out.println("Alumno: Alfredo Hamelius Rodriguez");
        System.out.println("Matrícula: 98942");
        System.out.println("==================================================\n");

        // Demostración de Polimorfismo: Una lista del tipo de la clase abstracta (Producto)
        // que almacena objetos de distintas subclases.
        List<Producto> inventario = new ArrayList<>();

        // Instanciación de objetos de las subclases
        inventario.add(new Electronico("E01", "Laptop Gamer", 18500.0, 5, 24));
        inventario.add(new Alimento("A01", "Café Grano 1kg", 220.0, 30, "12/2027"));
        inventario.add(new Ropa("R01", "Chaqueta de Mezclilla", 850.0, 15, "G", "Denim"));

        System.out.println("=== 1. ESTADO DEL INVENTARIO (POLIMORFISMO EN ACCIÓN) ===");
        // Al invocar mostrarDetalles(), Java ejecuta automáticamente 
        // el método correspondiente a cada subclase de forma dinámica.
        for (Producto producto : inventario) {
            producto.mostrarDetalles();
            System.out.println("Categoría interna: " + producto.obtenerCategoria());
            System.out.println("--------------------------------------------------");
        }

        System.out.println("\n=== 2. APLICANDO PROMOCIÓN (USO DE INTERFAZ) ===");
        // Aplicamos un 15% de descuento a todos los productos de forma uniforme
        for (Producto producto : inventario) {
            double precioAnterior = producto.getPrecio();
            producto.aplicarDescuento(15.0);
            System.out.println("Producto: " + producto.getNombre() + 
                               " | Precio anterior: $" + precioAnterior + 
                               " | Precio con 15% desc: $" + producto.getPrecio());
        }
    }
}

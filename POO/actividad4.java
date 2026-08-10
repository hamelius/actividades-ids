import java.util.ArrayList;
import java.util.List;

// Interfaz para aplicar descuentos
interface IDescuento {
    double aplicarDescuento(double porcentaje);
}

// Clase abstracta Producto
abstract class Producto implements IDescuento {
    protected String codigo;
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public abstract void mostrarDetalles();
    public abstract String obtenerCategoria();

    @Override
    public double aplicarDescuento(double porcentaje) {
        this.precio -= this.precio * (porcentaje / 100);
        return this.precio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
}

// Subclase Electrónico
class Electronico extends Producto {
    private int mesesGarantia;

    public Electronico(String codigo, String nombre, double precio, int stock, int mesesGarantia) {
        super(codigo, nombre, precio, stock);
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Electrónico] Código: " + codigo + " | Nombre: " + nombre + 
                           " | Precio: $" + precio + " | Stock: " + stock + 
                           " | Garantía: " + mesesGarantia + " meses");
    }

    @Override
    public String obtenerCategoria() {
        return "Electrónica";
    }
}

// Subclase Alimento
class Alimento extends Producto {
    private String fechaCaducidad;

    public Alimento(String codigo, String nombre, double precio, int stock, String fechaCaducidad) {
        super(codigo, nombre, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Alimento] Código: " + codigo + " | Nombre: " + nombre + 
                           " | Precio: $" + precio + " | Stock: " + stock + 
                           " | Caducidad: " + fechaCaducidad);
    }

    @Override
    public String obtenerCategoria() {
        return "Alimentos y Perecederos";
    }
}

// Subclase Ropa
class Ropa extends Producto {
    private String talla;
    private String material;

    public Ropa(String codigo, String nombre, double precio, int stock, String talla, String material) {
        super(codigo, nombre, precio, stock);
        this.talla = talla;
        this.material = material;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("[Ropa] Código: " + codigo + " | Nombre: " + nombre + 
                           " | Precio: $" + precio + " | Stock: " + stock + 
                           " | Talla: " + talla + " | Material: " + material);
    }

    @Override
    public String obtenerCategoria() {
        return "Textil y Moda";
    }
}

// Clase Principal
public class Main {
    public static void main(String[] args) {
        // Encabezado personal solicitado
        System.out.println("Universidad Ciudadana de Nuevo León");
        System.out.println("Programación Orientada a Objetos.");
        System.out.println("Actividad 4.");
        System.out.println("Alumno: Alfredo Hamelius Rodriguez");
        System.out.println("Matrícula: 98942\n");
        System.out.println("==================================================\n");

        List<Producto> inventario = new ArrayList<>();

        inventario.add(new Electronico("E01", "Laptop Gamer", 18500.0, 5, 24));
        inventario.add(new Alimento("A01", "Café Grano 1kg", 220.0, 30, "12/2027"));
        inventario.add(new Ropa("R01", "Chaqueta de Mezclilla", 850.0, 15, "G", "Denim"));

        System.out.println("=== 1. ESTADO DEL INVENTARIO (POLIMORFISMO EN ACCIÓN) ===");
        for (Producto producto : inventario) {
            producto.mostrarDetalles();
            System.out.println("Categoría interna: " + producto.obtenerCategoria());
            System.out.println("--------------------------------------------------");
        }

        System.out.println("\n=== 2. APLICANDO PROMOCIÓN (USO DE INTERFAZ) ===");
        for (Producto producto : inventario) {
            double precioAnterior = producto.getPrecio();
            producto.aplicarDescuento(15.0);
            System.out.println("Producto: " + producto.getNombre() + 
                               " | Precio anterior: $" + precioAnterior + 
                               " | Precio con 15% desc: $" + producto.getPrecio());
        }
    }
}

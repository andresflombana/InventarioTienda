
package alosemo.gestordeinventario;
import java.util.ArrayList;
import java.util.Scanner;
import alosemo.gestordeinventario.Inventario;
/**
 * @author Andrés Lombana y Sebastián Moreno
 */
public class Tienda {
    ArrayList<Inventario> miInventario = new ArrayList<>();
    Scanner lector = new Scanner(System.in);

    public Tienda() {
        miInventario = new ArrayList<>();
        lector = new Scanner(System.in);
    }

    public static void ordenarInventarioPorCantidad(ArrayList<Inventario> inventario) {
        int n = inventario.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inventario.get(j).getCantidad() > inventario.get(j + 1).getCantidad()) {
                    Inventario temp = inventario.get(j);
                    inventario.set(j, inventario.get(j + 1));
                    inventario.set(j + 1, temp);
                }
            }
        }
    }

    public void eliminarProducto(int idProducto) {
        System.out.println("Ingrese nuevamente id para poder eliminar");
        int idEliminar = lector.nextInt();
        lector.nextLine(); // Consumir el salto de línea

        // Verificar si el producto existe en el inventario
        boolean encontrado = false;
        for (Inventario p : miInventario) {
            if (p.getIdProducto() == idEliminar) {
                encontrado = true;
                break;
            }
        }

        // Si el producto existe, pedir confirmación antes de eliminarlo
        if (encontrado) {
            System.out.println("¿Está seguro de eliminar este producto? (S/N)");
            String confirmacion = lector.nextLine().toUpperCase();

            if (confirmacion.equals("S")) {
                for (Inventario p : miInventario) {
                    if (p.getIdProducto() == idEliminar) {
                        miInventario.remove(p);
                        System.out.println("Producto eliminado con éxito");
                        return;
                    }
                }
            } else if (confirmacion.equals("N")) {
                System.out.println("Operación cancelada. El producto no fue eliminado.");
            } else {
                System.out.println("Opción no válida. Operación cancelada.");
            }
        } else {
            System.out.println("El producto no se encontró en el inventario");
        }
    }

    public void agregarProducto(int idProducto, int precio, String producto, int cantidad) {
        Inventario nuevoProducto = new Inventario(idProducto, precio, producto, cantidad);
        miInventario.add(nuevoProducto);
        System.out.println("Producto agregado con éxito");
    }

    public void mostrarInventario() {
        for (Inventario producto : miInventario) {
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Producto: " + producto.getProducto());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("-------------------");
        }
    }

    public void ordenarInventarioPorCantidad() {
        ordenarInventarioPorCantidad(miInventario);
        System.out.println("Inventario ordenado por cantidad");
    }

    private void eliminarProducto() {
        System.out.println("Ingrese el ID del producto a eliminar:");
        int idEliminar = lector.nextInt();
        eliminarProducto(idEliminar);
    }

    public void ejecutar() {
        boolean activo = true;
        while (activo) {
            System.out.println("Ingrese la opción deseada:");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Mostrar inventario de productos");
            System.out.println("3. Ordenar inventario por cantidad");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");

            int opcion = lector.nextInt();
            lector.nextLine(); // Consumir el salto de línea después de leer un número

            switch (opcion) {
                case 1:
                    System.out.println("AGREGAR NUEVO PRODUCTO");
                    System.out.println("Ingrese el ID del producto:");
                    int idProducto = lector.nextInt();
                    lector.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese el nombre del producto:");
                    String producto = lector.nextLine();
                    System.out.println("Ingrese el precio del producto:");
                    int precio = lector.nextInt();
                    System.out.println("Ingrese la cantidad del producto:");
                    int cantidad = lector.nextInt();
                    agregarProducto(idProducto, precio, producto, cantidad);
                    break;
                case 2:
                    System.out.println("MOSTRAR INVENTARIO DE PRODUCTOS");
                    mostrarInventario();
                    break;
                case 3:
                    System.out.println("ORDENAR INVENTARIO POR CANTIDAD");
                    ordenarInventarioPorCantidad();
                    break;
                case 4:
                    System.out.println("ELIMINAR PRODUCTO");
                    eliminarProducto();
                    break;
                case 5:
                    activo = false;
                    System.out.println("PROGRAMA TERMINADO");
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
            }
        }
        lector.close();
    }

    public static void main(String[] args) {
        Tienda miTienda = new Tienda();
        miTienda.ejecutar();
    }
}

import controller.TiendaController;
import controller.ProductoController;
import controller.ClienteController;
import controller.CompraController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int MenuPrincipal, OpcionTiendas, OpcionProductos,OpcionClientes,OpcionCompras;
        do {
            MenuPrincipal=Integer.parseInt(JOptionPane.showInputDialog("""
                    MENU PRINCIPAL
                    1. Administrar tiendas
                    2. Administrar productos
                    3. Administrar clientes
                    4. Administrar compras
                    5. Salir
                    """));
            switch (MenuPrincipal) {
                case 1:
                    do {
                        OpcionTiendas = Integer.parseInt(JOptionPane.showInputDialog("""
                                MENU TIENDAS
                                1. Crear tienda
                                2. Listar tiendas
                                3. Actualizar tiendas
                                4. Eliminar tiendas
                                5. Volver al Menu Principal
                                """));
                        switch (OpcionTiendas) {
                            case 1:
                                TiendaController.create();
                                break;
                            case 2:
                                TiendaController.read();
                                break;
                            case 3:
                                TiendaController.update();
                                break;
                            case 4:
                                TiendaController.delete();
                                break;
                        }
                    } while (OpcionTiendas !=5);
                    break;
                case 2:
                    do {
                        OpcionProductos = Integer.parseInt(JOptionPane.showInputDialog("""
                                MENU PRODUCTOS
                                1. Crear producto
                                2. Listar productos
                                3. Actualizar producto
                                4. Eliminar producto
                                5. Volver al menu principal
                                """));
                        switch (OpcionProductos) {
                            case 1:
                                ProductoController.create();
                                break;
                            case 2:
                                ProductoController.read();
                                break;
                            case 3:
                                ProductoController.update();
                                break;
                            case 4:
                                ProductoController.delete();
                                break;
                        }
                    } while (OpcionProductos !=5);
                    break;
                case 3:
                    do {
                        OpcionClientes = Integer.parseInt(JOptionPane.showInputDialog("""
                                MENU CLIENTE:
                                1. Crear cliente
                                2. Listar clientes
                                3. Actualizar clientes
                                4. Eliminar cliente
                                5. Volver al menu principal
                                """));
                        switch (OpcionClientes){
                            case 1:
                                ClienteController.create();
                                break;
                            case 2:
                                ClienteController.read();
                                break;
                            case 3:
                                ClienteController.update();
                                break;
                            case 4:
                                ClienteController.delete();
                                break;
                        }
                    } while (OpcionClientes != 5);
                    break;
                case 4:
                    do {
                        OpcionCompras = Integer.parseInt(JOptionPane.showInputDialog("""
                                MENU COMPRAS:
                                1. Crear compra
                                2. Listar compras
                                3. Actualizar compra
                                4. Eliminar compra
                                5. Volver al menu principal
                                """));
                        switch (OpcionCompras){
                            case 1:
                                CompraController.create();
                                break;
                            case 2:
                                CompraController.getAll();
                                break;
                            case 3:
                                CompraController.update();
                                break;
                            case 4:
                                CompraController.delete();
                                break;
                        }
                    } while (OpcionCompras != 5);
                    break;
            }
        } while (MenuPrincipal !=5);
    }
}
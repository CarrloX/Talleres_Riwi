import controller.AvionController;
import controller.PasajeroController;
import controller.ReservacionController;
import controller.VueloController;
import entity.Avion;
import entity.Reservacion;
import model.PasajeroModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int MenuPrincipal=0, OpcionAviones=0, OpcionPasajeros=0,OpcionReservaciones=0,OpcionVuelos=0;
        do {
            MenuPrincipal=Integer.parseInt(JOptionPane.showInputDialog("""
                    MENU PRINCIPAL
                    1. Administrar Aviones
                    2. Administrar Pasajeros
                    3. Administrar Reservaciones
                    4. Administrar Vuelos
                    5. Salir
                    """));
            switch (MenuPrincipal) {
                case 1:
                    do {
                        OpcionAviones = Integer.parseInt(JOptionPane.showInputDialog("""
                                AVIONES MENU
                                1. Crear avion
                                2. Listar aviones
                                3. Actualizar aviones
                                4. Eliminar aviones
                                5. Volver al Menu Principal
                                """));
                        switch (OpcionAviones) {
                            case 1:
                                AvionController.create();
                                break;
                            case 2:
                                AvionController.read();
                                break;
                            case 3:
                                AvionController.update();
                                break;
                            case 4:
                                AvionController.delete();
                                break;
                        }
                    } while (OpcionAviones !=5);
                    break;
                case 2:
                    do {
                        OpcionPasajeros = Integer.parseInt(JOptionPane.showInputDialog("""
                                PASAJEROS MENU
                                1. Crear pasajero
                                2. Listar pasajeros
                                3. Actualizar pasajero
                                4. Eliminar pasajero
                                5. Volver al menu principal
                                """));
                        switch (OpcionPasajeros) {
                            case 1:
                                PasajeroController.create();
                                break;
                            case 2:
                                PasajeroController.read();
                                break;
                            case 3:
                                PasajeroController.update();
                                break;
                            case 4:
                                PasajeroController.delete();
                                break;
                        }
                    } while (OpcionPasajeros !=5);
                    break;
                case 3:
                    do {
                        OpcionReservaciones = Integer.parseInt(JOptionPane.showInputDialog("""
                                RESERVACIONES MENU:
                                1. Crear reservacion
                                2. Listar reservaciones
                                3. Actualizar reservacion
                                4. Eliminar reservacion
                                5. Volver al menu principal
                                """));
                        switch (OpcionReservaciones){
                            case 1:
                                ReservacionController.create();
                                break;
                            case 2:
                                ReservacionController.getAll();
                                break;
                            case 3:
                                ReservacionController.update();
                                break;
                            case 4:
                                ReservacionController.delete();
                                break;
                        }
                    } while (OpcionReservaciones != 5);
                    break;
                case 4:
                    do {
                        OpcionVuelos = Integer.parseInt(JOptionPane.showInputDialog("""
                                VUELOS MENU:
                                1. Crear vuelo
                                2. Listar vuelos
                                3. Actualizar vuelo
                                4. Eliminar vuelo
                                5. Volver al menu principal
                                """));
                        switch (OpcionVuelos){
                            case 1:
                                VueloController.create();
                                break;
                            case 2:
                                VueloController.read();
                                break;
                            case 3:
                                VueloController.update();
                                break;
                            case 4:
                                VueloController.delete();
                                break;
                        }
                    } while (OpcionVuelos != 5);
                    break;
            }
        } while (MenuPrincipal !=5);
    }
}
import controller.CoderController;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        CoderController objCoderController = new CoderController();
        String option= "";
        do {
            option= JOptionPane.showInputDialog("""
                    MENU
                    1.list coder
                    2.insert coder
                    3.update coder
                    4.delete coder
                    5.get by name
                    6.exit
                    
                    choose an option:
                    """);
            switch (option){
                case "1"://list all coders
                    objCoderController.getAll();
                    break;

                case "2"://insert coder
                    objCoderController.create();
                    break;

                case "3"://update coder
                    objCoderController.update();
                    break;

                case "4"://delete coder
                    objCoderController.delete();
                    break;

                case "5"://get by name
                    objCoderController.getByName();
                    break;
            }
        }while(option.equals("6"));
    }
}
import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clienteRMI {

    public static void main(String[] args){

        try {

            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
            String nom = nombre;

            Registry rmii = LocateRegistry.getRegistry("192.168.1.102", 1005);

            chatServidor servidor = (chatServidor) rmii.lookup("Chat");
            new Thread(new implementacionClienteChat(nom,servidor)).start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}

package uni.isw.cc341project;

import uni.isw.pe.controller.VentaController;
import uni.isw.pe.view.VentaView;

public class CC341Project {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            VentaView view = new VentaView();
            new VentaController(view);
            view.setVisible(true);
            view.setLocationRelativeTo(null);
        });
    }
}

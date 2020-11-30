
package controlador;

import Serializado.Alerta;
import static controlador.Data.medicos;
import static controlador.Data.puestosAsignados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.Medico;
import modelo.Puesto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PuestoController implements Initializable,Ventana {
    
    public static int turno =1 ;
    
    @FXML
    private Button btnCrearPuesto;
    @FXML
    private ComboBox cbMedico;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMedico.getItems().addAll(medicos);
    }  

    
    @Override
     public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) btnCrearPuesto.getScene().getWindow();
        stage.close();
    }  
    @FXML
    void guardarPuesto(ActionEvent event) {
        if (validate(cbMedico)) {
            Alerta.mostrarAlerta("No hay ninguna seleccion","Verifique su seleccion", Alert.AlertType.ERROR);
        }
        else{
        Medico med = (Medico) cbMedico.getValue();
        Puesto puesto = new Puesto(turno, med);
        turno++;
        medicos.remove(med);
        cbMedico.getItems().remove(med);
        puestosAsignados.add(puesto);
        Alerta.Confirmar("Puesto asignado", Alert.AlertType.CONFIRMATION);
        }
    }
    
    public boolean validate(ComboBox c) {
        return c.getValue() == null;
    }
}

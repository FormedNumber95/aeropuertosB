package es.aketzagonzalez.aeropuertosB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Persona;

public class tablaPersonasController {

    @FXML
    private Button btnAniadir;

    @FXML
    private TableColumn<Persona, String> idTablaApellido;

    @FXML
    private TableColumn<Persona, Integer> idTablaEdad;

    @FXML
    private TableColumn<Persona, String> idTablaNombre;

    @FXML
    private TableView<Persona> tablaPersonas;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    void aniadirPersona(ActionEvent event) {
    	String error="";
    	String nombre=txtNombre.getText();
    	String apellidos=txtApellidos.getText();
    	int edad=-1;
    	boolean existe=false;
    	if(txtNombre.getText().isEmpty()) {
    		error+="El campo nombre es obligatorio\n";
    	}
    	if(txtApellidos.getText().isEmpty()) {
    		error+="El campo apellidos es obligatorio\n";
    	}
    	if(txtEdad.getText().isEmpty()) {
    		error+="El campo edad es obligatoiro\n";
    	}else {
	    	try {
	    		edad=Integer.parseInt(txtEdad.getText());
	    		if(edad<=0) {
	    			throw new Exception();
	    		}
	    	}catch(NumberFormatException e) {
	    		error+="La edad debe ser un numero entero\n";
	    	}catch(Exception e) {
	    		error+="La edad debe ser superior a 0\n";
	    	}
    	}
    	Persona p=new Persona(nombre, apellidos, edad);
    	for(Persona per:tablaPersonas.getItems()){
    		if(per.equals(p)) {
    			existe=true;
    		}
    	}
    	Alert al=new Alert(AlertType.INFORMATION);
    	al.setHeaderText(null);
    	if(!existe&&error.equals("")) {
    		tablaPersonas.getItems().add(p);
    	}
    	
    	if(error.equals("")&&!existe) {
    		al.setContentText("Persona añadida correctamente");
    	}else {
    		if(error.equals("")){
    			al.setAlertType(AlertType.WARNING);
    			error="La persona ya estaba en la lista";
    		}else {
    			al.setAlertType(AlertType.ERROR);
    		}
    		al.setContentText(error);
    	}
    	al.showAndWait();
    }
    
    @FXML
    private void initialize() {
    	idTablaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	idTablaApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
    	idTablaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
    }

}

package br.com.fiap;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.fiap.model.Cadastro;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PrimaryController{

    @FXML private TextField textFieldTitulo;
    @FXML private TextField textFieldDescricao; 
    @FXML private TextField textFieldCategoria;
    @FXML private DatePicker datePickerData;
    
    
    private List<Cadastro> lista = new ArrayList<>();

    private void validarCadastro() throws Exception{

        try {
            String titulo = textFieldTitulo.getText();
            String descricao = textFieldDescricao.getText();
            String categoria = textFieldCategoria.getText();
            String data = datePickerData.getValue().toString();
            

            lista.add(carregarDadosFormulario(titulo, descricao, categoria, data));
            mensagemSucesso("Tarefa cadastrada com sucesso.");
        } catch (NumberFormatException e) {
            mensagemErro("Tarefa nao cadastrada.");
        } 
    }

    private void mensagemSucesso(String string) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.showAndWait();
}
    
    private void mensagemErro(String string) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.showAndWait();
}
    private Cadastro carregarDadosFormulario(String titulo, String descricao, String categoria, String data) {
        return new Cadastro(
            textFieldTitulo.getText(), 
            textFieldDescricao.getText(), 
            textFieldCategoria.getText(), 
            datePickerData.getValue().toString());
        }
   
    public void initialize(URL url, ResourceBundle rb) throws Exception {
        validarCadastro();
    }

    public void verTarefas() throws IOException{
        App.setRoot("secondary");
    }

    public void voltarCadastro() throws IOException{
        App.setRoot("primary");
    }
}

    
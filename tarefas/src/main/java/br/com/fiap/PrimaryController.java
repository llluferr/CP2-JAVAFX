package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Cadastro;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField textFieldTitulo;
    @FXML private TextField textFieldDescricao; 
    @FXML private TextField textFieldCategoria;
    @FXML private DatePicker datePickerData;

    private List<Cadastro> lista = new ArrayList<Cadastro>(); 

    public void salvar(){
        String titulo = textFieldTitulo.getText();
        String descricao = textFieldDescricao.getText();
        String categoria = textFieldDescricao.getText();
        String data = datePickerData.getValue().toString();

        Cadastro cadastro = new Cadastro(titulo, descricao, categoria, data);
        lista.add(cadastro);
    }
}

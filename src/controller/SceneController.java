package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	//Chuyen sang Scene Queue
	public void ChangeQueue(ActionEvent event) throws IOException {
		//lay stage
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		// tao ra loader de load LinearSeach.fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/Queue.fxml"));
		Parent queue = loader.load();
		Scene scene = new Scene(queue,1100,700);
		stage.setScene(scene);
		stage.setTitle("Queue");
	}
	public void ChangeHashTable(ActionEvent event) throws IOException {
		//lay stage
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		// tao ra loader de load LinearSeach.fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/HashTable.fxml"));
		Parent hashtable = loader.load();
		Scene scene = new Scene(hashtable,1100,700);
		stage.setScene(scene);
		stage.setTitle("HashTable");
	}

}
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
		Scene scene = new Scene(queue,800,400);
		//scene.getStylesheets().add(getClass().getResource("../view/Queue.css").toExternalForm());
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
		Scene scene = new Scene(hashtable,800,600);
		//scene.getStylesheets().add(getClass().getResource("../view/HashTable.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("HashTable");
	}
	public void ChangeArrayList(ActionEvent event) throws IOException {
		//lay stage
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		// tao ra loader de load LinearSeach.fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/ArrayList.fxml"));
		Parent arrayList = loader.load();
		Scene scene = new Scene(arrayList,800,450);
		//scene.getStylesheets().add(getClass().getResource("../view/ArrayList.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("ArrayList");
	}

}
package queue;

import java.io.IOException;
import java.util.ArrayList;

//import javafx.animation.FadeTransition;
//import javafx.animation.FillTransition;

//import com.sun.org.apache.bcel.internal.classfile.Node;

//import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.util.Duration;
//import shape.CircleK;
import shape.Square;

public class QueueController {
	@FXML
	private AnchorPane paneShow;
	@FXML
	private TextField sizeTextField;
	@FXML
	private TextField valueTextField;
	@FXML
	private TextField ketqua;
	
	int size;
	int x=40,y=100;
	
	//Square newSq = new Square();
	ArrayList<Square> arraySq = new ArrayList<Square>();
	ArrayList<Square> arraySq2 = new ArrayList<Square>();
	
	public void ArrayInput(ActionEvent event) {
		String strArray = sizeTextField.getText();
		size = Integer.parseInt(strArray);
		if(size<11) {
			for(int i=0;i<size;i++) {
				Square newSq = new Square(x,y);
				arraySq.add(newSq);
				x+=70;
			}
			for(Square square: arraySq) {
				System.out.println(square.getXx());
			}
			for(Square square: arraySq) {
				StackPane stackPane = new StackPane();
				stackPane.getChildren().addAll(square);
				stackPane.setLayoutX(square.getXx());
				stackPane.setLayoutY(square.getYy());
				paneShow.getChildren().add(stackPane);
			}
		}
		
	}
	
	public void Enqueue(ActionEvent event) {
		if(arraySq2.size()<11) {
			String strvalue = valueTextField.getText();
			
			valueTextField.clear();
			Square enValue = new Square(strvalue,40+70*(arraySq2.size()),y);
			arraySq2.add(arraySq2.size(),enValue);
			//enValue.changeBackGround(Color.RED);
		    StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(enValue, enValue.getText());
			stackPane.setLayoutX(enValue.getXx());
			stackPane.setLayoutY(enValue.getYy());
			
			paneShow.getChildren().add(stackPane);
			ketqua.setText("Thêm thành công !! " );
			
		}else ketqua.setText(" Hàng đợi đã đầy, không thể thêm !! " );
		
	}
	
	
	int i=0;
	public void Dequeue(ActionEvent event) {
		if(arraySq2.size()!= 0 && i != arraySq2.size()) {
			arraySq2.get(i).delete();
			i++;
			StackPane stackPane = new StackPane();
			paneShow.getChildren().add(stackPane);
			ketqua.setText("Xóa thành công !!");
		}else ketqua.setText("Hàng đợi rỗng, không thể xóa !!");
	}
	
	//tro ve scene truoc
	public void goBack(ActionEvent event) throws IOException{
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		//tao ra loader de load 
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/MainScene.fxml"));
		Parent mainScene = loader.load();
		Scene scene = new Scene(mainScene);
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		stage.setTitle("OOP PROJECT");
		stage.setScene(scene);
	}
	
}

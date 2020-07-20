// Main application class that loads and displays the AddressBook's GUI.
package ch29.ex29_02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddressBook extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("AddressBook.fxml"));
      
      Scene scene = new Scene(root);
      stage.setTitle("Address Book");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}

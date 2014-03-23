
package customoneventfilter;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;


public class FXMLDocumentController  {
    
        
    @FXML
    private void filterKeyTyped(KeyEvent event) {
            char ar[] = event.getCharacter().toCharArray();
            char ch = ar[event.getCharacter().toCharArray().length - 1];
            if (!(ch >= '0' && ch <= '9' || ch=='.')) {
                System.out.println("The char you entered is not a number");
                event.consume();
            }

    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.BIN;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 *
 * @author AHMET
 */
public class config {
    public static void AnchorPaneConst(Region region , double top, double right, double bottom, double left){
        
        AnchorPane.setTopAnchor(region,top);
        AnchorPane.setRightAnchor(region, right);
        AnchorPane.setBottomAnchor(region, bottom);
        AnchorPane.setLeftAnchor(region, left);
       
        
    }
}

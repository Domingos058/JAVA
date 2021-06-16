/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author tecnicos
 */
public class Func {
    
     public void displayImg(int width, int height, String imagePath,JLabel label)
        {
            ImageIcon imgicon = new ImageIcon(getClass().getResource(imagePath));
            Image img = imgicon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        }
    
}

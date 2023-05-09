/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Pichau
 */
public class ButtonDelete extends DefaultTableCellRenderer{

    public ButtonDelete(String delete) {
    }
 
     @Override
     public Component getTableCellRendererComponent(JTable table, Object value,
     boolean isSelected, boolean hasFocus, int row, int column) {
         
          JLabel label;
          label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          label.setHorizontalAlignment(CENTER);
          label.setIcon(new javax.swing.ImageIcon(getClass()
                  .getResource("/resources/delete.png")));
      
          return label;
     }
    
}
   

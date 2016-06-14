package java1.Gui;

import java1.Components.AutoEntity;import java1.Components.DetailEntity;
import javax.swing.*;

class Table extends JTable {

    String [][] table(DetailEntity details)
    {
        String[][] table = new String[details.getPropertyEntity().size()][2];
        for(int i = 0; i<details.getPropertyEntity().size(); i++)
        {
            table[i][0] = details.getPropertyEntity().get(i).getName();
            table[i][1] = details.getPropertyEntity().get(i).getValue();
        }
        return table;
    }
    String [][] table1(AutoEntity auto)
    {
        return new String[][]{{auto.getName(),auto.getMark(),auto.getModel()}};
    }

}

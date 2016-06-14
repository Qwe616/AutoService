package java1;

import java1.Gui.CreateGui;

import javax.swing.*;
import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String url = null;
        url = getUrl();
        if (url != null && !Objects.equals(url, "")){
            DBWorked.url = url;
        }
        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new CreateGui().setVisible(true));
    }
    private static String getUrl() {
        File f = new File("url.txt");
        try {
        BufferedReader fin = new BufferedReader(new FileReader(f));
            return fin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "jdbc:sqlserver://193.124.67.40:1433;databaseName=AutoService";
        }
    }
}


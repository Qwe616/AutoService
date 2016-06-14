package java1.Gui;

import java1.Components.AutoEntity;
import java1.Components.DetailEntity;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

class Tree extends JFrame {
    private DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("Автомобили");

    DefaultMutableTreeNode CreateTree(List<AutoEntity> cars) {
        for (AutoEntity car : cars) {
            DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode(car);
            for (DetailEntity detail : car.getDetails()) {
                DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode(detail);
                treeNode2.add(treeNode3);
            }
            treeNode1.add(treeNode2);
        }
        return treeNode1;
    }
}



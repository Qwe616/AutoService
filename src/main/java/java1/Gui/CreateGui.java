package java1.Gui;

import java1.Components.AutoEntity;
import java1.Components.DetailEntity;
import java1.Components.PropertyEntity;
import java1.Data.Cars.CarsRepository;
import java1.Data.Details;
import java1.Data.Properties;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import javax.swing.tree.*;
import java.awt.event.*;
import java.util.List;

public class CreateGui extends JFrame {
    private List<AutoEntity> cars;
    public CreateGui() {
        cars = CarsRepository.getInstance().getAll();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        JSplitPane jSplitPane1 = new JSplitPane();
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JPanel jPanel2 = new JPanel();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenu jMenu4 = new JMenu();
        JMenuItem jMenuItem4 = new JMenuItem();
        JMenuItem jMenuItem5 = new JMenuItem();
        JMenuItem jMenuItem6 = new JMenuItem();
        JMenu jMenu5 = new JMenu();
        JMenuItem jMenuItem7 = new JMenuItem();
        JMenuItem jMenuItem8 = new JMenuItem();
        JPopupMenu.Separator jSeparator1 = new JPopupMenu.Separator();
        JMenuItem jMenuItem3 = new JMenuItem();
        JMenu jMenu2 = new JMenu();
        JMenu jMenu3 = new JMenu();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jTree1 = new JTree();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Автосервис");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(560, 600));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        jSplitPane1.setDividerLocation(240);
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 408));

        jTree1.setModel(new DefaultTreeModel(new Tree().CreateTree(cars)));
        jTree1.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree1.addTreeSelectionListener(this::jTree1ValueChanged);
        jScrollPane1.setViewportView(jTree1);
        jButton2.setText("Удалить");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(28, 28, 28))
                        .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);
        jButton1.setText("Добавить");
        jButton1.addActionListener(this::jButton1ActionPerformedAuto);
        jButton3.setText("Сохранить");
        jButton3.setVisible(false);
        jButton4.setText("Удалить");
        jButton4.setVisible(false);
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING,
                                GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                        .addComponent(jButton4)
                                        .addGap(47, 47, 47))
        );

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addContainerGap())

        );
        jSplitPane1.setRightComponent(jPanel2);
        getContentPane().add(jSplitPane1);
        jMenu1.setText("Файл");
        jMenu4.setText("Добавить");
        jMenuItem4.setText("Автомобиль");
        jMenu4.add(jMenuItem4);
        jMenuItem5.setText("Деталь");
        jMenu4.add(jMenuItem5);
        jMenuItem6.setText("Свойство");
        jMenu4.add(jMenuItem6);
        jMenu1.add(jMenu4);
        jMenu5.setText("Редактировать");
        jMenuItem7.setText("Автомобиль");
        jMenu5.add(jMenuItem7);
        jMenuItem8.setText("Деталь автомобиля");
        jMenu5.add(jMenuItem8);
        jMenu1.add(jMenu5);
        jMenu1.add(jSeparator1);
        jMenuItem3.setText("Выход");
        jMenu1.add(jMenuItem3);
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Справка");
        jMenuBar1.add(jMenu2);
        jMenu3.setText("Помощь");
        jMenuBar1.add(jMenu3);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>

    private boolean validate(String s) {
        s = s.trim();

        boolean isWhiteSpace = true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                isWhiteSpace = false;
                break;
            }
        }
        return !isWhiteSpace;
    }

    private void jButton1ActionPerformedAuto(ActionEvent e) {
        AutoEntity car = new AutoEntity();
        String Name;
        String Mark = null;
        String Model = null;
        String name = JOptionPane.showInputDialog(null, "Введите имя автомобиля", "Добавить",
                      JOptionPane.INFORMATION_MESSAGE);
        if (name != null && validate(name)) {
            Name = name.trim();
            car.setName(Name);
            Mark = JOptionPane.showInputDialog(null, "Введите марку автомобиля", "Марка",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (Mark != null && validate(Mark)) {
            Mark = Mark.trim();
            car.setMark(Mark);
            Model = JOptionPane.showInputDialog(null, "Введите модель автомобиля", "Модель",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (Model != null && validate(Model)) {
            Model = Model.trim();
            car.setModel(Model);
            CarsRepository.getInstance().addCar(car);
            ((DefaultMutableTreeNode) jTree1.getModel().getRoot()).add(new DefaultMutableTreeNode(car));
            ((DefaultTreeModel) jTree1.getModel()).reload();
        }
    }

    private void jButton1ActionPerformedDetail(ActionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        AutoEntity car = (AutoEntity) node.getUserObject();
        DetailEntity detailEntity = new DetailEntity();
        String NameDetail = JOptionPane.showInputDialog(null, "Введите название детали", "Добавление детали",
                JOptionPane.INFORMATION_MESSAGE);
        if (NameDetail != null && validate(NameDetail)) {
            if (Details.getInstance().bustDetailCar(car, NameDetail) != null) {
                JOptionPane.showMessageDialog(null, "Эта деталь уже присутствует");
            } else if (Details.getInstance().bustDetailCar(car, NameDetail) == null &&
                    Details.getInstance().bustDetailInList(NameDetail) != null) {
                detailEntity.setId(Details.getInstance().bustDetailInList(NameDetail).getId());
                detailEntity.setName(Details.getInstance().bustDetailInList(NameDetail).getName());
                Details.getInstance().addDetailsCar(car, detailEntity);
                node.add(new DefaultMutableTreeNode(detailEntity));
                JOptionPane.showMessageDialog(null, "Деталь присутствует в базе и была добавленна в машину", "Готово",
                        JOptionPane.INFORMATION_MESSAGE);
                ((DefaultTreeModel) jTree1.getModel()).reload();
            } else if (Details.getInstance().bustDetailCar(car, NameDetail) == null &&
                    Details.getInstance().bustDetailInList(NameDetail) == null) {
                detailEntity.setName(NameDetail);
                Details.getInstance().addDetail(detailEntity);
                DetailEntity detail = new DetailEntity();
                detail.setName(detailEntity.getName());
                detail.setId(detailEntity.getId());
                Details.getInstance().addDetailsCar
                        (car, detail);
                node.add(new DefaultMutableTreeNode
                        (detail));
             JOptionPane.showMessageDialog
                        (null, "Деталь отсутствует в базе, она была добавленна в базу и в машину", "Готово",
                                JOptionPane.INFORMATION_MESSAGE);
                ((DefaultTreeModel) jTree1.getModel()).reload();
            }
        }
    }

    private void jButton1ActionPerformedProperty(ActionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                jTree1.getLastSelectedPathComponent();
        DefaultMutableTreeNode father = (DefaultMutableTreeNode) node.getParent();
        AutoEntity car = (AutoEntity) father.getUserObject();
        PropertyEntity propertyEntity = new PropertyEntity();
        DetailEntity detail = (DetailEntity) node.getUserObject();
        String Name = JOptionPane.showInputDialog(null, "Введите свойство", "Добавить",
                JOptionPane.INFORMATION_MESSAGE);
        if (Name != null && validate(Name)) {
            if (Properties.getInstance().bustPropertyDetailCar(detail, Name) != null) {
                JOptionPane.showMessageDialog(null, "Это свойство уже присутствует", "Ошибка",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (Properties.getInstance().bustPropertyDetailCar(detail, Name) == null &&
                    Properties.getInstance().bustPropertyInList(Name) != null) {
                propertyEntity.setName(Properties.getInstance().bustPropertyInList(Name).getName());
                propertyEntity.setId(Properties.getInstance().bustPropertyInList(Name).getId());
                Properties.getInstance().addPropertyDetail
                        (car, detail, propertyEntity);
                JOptionPane.showMessageDialog(null, "Свойство присутствует в базе и было добавленно в деталь",
                        "Готово", JOptionPane.INFORMATION_MESSAGE);
                ((DefaultTreeModel) jTree1.getModel()).reload();
                jTable1 = new JTable() {
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }};
                String[][] table= new Table().table(detail);
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        table,
                        new String [] {"Свойство", "Значение"}
                ));
                jScrollPane2.setViewportView(jTable1);
            } else if (Properties.getInstance().bustPropertyDetailCar(detail, Name) == null &&
                    Properties.getInstance().bustPropertyInList(Name) == null) {
                propertyEntity.setName(Name);
                Properties.getInstance().addPropertyList(propertyEntity);
                PropertyEntity propertyEntityInsert = new PropertyEntity();
                propertyEntityInsert.setName(propertyEntity.getName());
                propertyEntityInsert.setId(propertyEntity.getId());
                Properties.getInstance().addPropertyDetail
                        (car, detail, propertyEntity);
                JOptionPane.showMessageDialog(null, "Свойство отсутсвует в базе, оно было добавленно в базу и в деталь",
                        "Готово", JOptionPane.INFORMATION_MESSAGE);
                jTable1 = new JTable() {
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }};
                String[][] table= new Table().table(detail);
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        table,
                        new String [] {"Свойство", "Значение"}
                ));
                jScrollPane2.setViewportView(jTable1);
            }
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        if (JOptionPane.showOptionDialog(
                null,
                "Вы уверены что хотите удалить этот объект?",
                "Удалить",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Да", "Нет"},
                "Да") == JOptionPane.YES_OPTION) {
            DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
            DefaultTreeModel mode = (DefaultTreeModel) jTree1.getModel();
            if (selectNode != null && selectNode.getUserObject() instanceof AutoEntity) {
                CarsRepository.getInstance().deleteCar((AutoEntity) selectNode.getUserObject());
                JOptionPane.showMessageDialog(null, "Автомобиль удален", "Готово", JOptionPane.INFORMATION_MESSAGE);
            } else if (selectNode != null && selectNode.getUserObject() instanceof DetailEntity) {
                DefaultMutableTreeNode father = (DefaultMutableTreeNode) selectNode.getParent();
                AutoEntity car = (AutoEntity) father.getUserObject();
                Details.getInstance().deleteDetailCar(car, (DetailEntity) selectNode.getUserObject());
                JOptionPane.showMessageDialog(null, "Деталь удалена", "Готово", JOptionPane.INFORMATION_MESSAGE);
            }
            mode.removeNodeFromParent(selectNode);
            ((DefaultTreeModel) jTree1.getModel()).reload();
        }
    }

    private void jTree1ValueChanged(TreeSelectionEvent evt) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                jTree1.getLastSelectedPathComponent();
        if (node != null && node.getUserObject() instanceof AutoEntity) {
            AutoEntity car = (AutoEntity) node.getUserObject();
            String[][] table= new Table().table1(car);
            jTable1 = new JTable() {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return true;
                }};
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    table,
                    new String [] {"Имя","Марка","Модель"}
            ));
            jScrollPane2.setViewportView(jTable1);
            for (ActionListener act : jButton1.getActionListeners()) {
                jButton1.removeActionListener(act);
            }
            for (ActionListener act : jButton2.getActionListeners()) {
                jButton2.removeActionListener(act);
            }
            for (ActionListener act : jButton3.getActionListeners()) {

                jButton3.removeActionListener(act);
            }
            jButton1.addActionListener(this::jButton1ActionPerformedDetail);
            jButton2.addActionListener(this::jButton2ActionPerformed);
            jButton3.addActionListener(this::jButton3ActionPerformedAuto);
            jButton3.setVisible(true);
            jButton4.setVisible(false);
        }

        else if (node != null && node.getUserObject() instanceof DetailEntity) {
            DetailEntity detail = (DetailEntity) node.getUserObject();
            jTable1 = new JTable() {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnIndex != 0;
                }};
            String[][] table= new Table().table(detail);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    table,
                    new String [] {"Свойство", "Значение"}
            ));
            jScrollPane2.setViewportView(jTable1);
            for (ActionListener act : jButton1.getActionListeners()) {
                jButton1.removeActionListener(act);
            }
            for (ActionListener act : jButton2.getActionListeners()) {
                jButton2.removeActionListener(act);
            }
            for (ActionListener act : jButton3.getActionListeners()) {
                jButton3.removeActionListener(act);
            }

            jButton1.addActionListener(this::jButton1ActionPerformedProperty);
            jButton2.addActionListener(this::jButton2ActionPerformed);
            jButton3.addActionListener(this::jButton3ActionPerformedProperty);
            jButton3.setVisible(true);
            jButton4.setVisible(true);
        }
        else {
            jButton4.setVisible(false);
            jButton3.setVisible(false);
            jScrollPane2.setViewportView(null);
            for (ActionListener act : jButton1.getActionListeners()) {
                jButton1.removeActionListener(act);
            }
            for (ActionListener act : jButton2.getActionListeners()) {
                jButton2.removeActionListener(act);
            }
            jButton1.addActionListener(this::jButton1ActionPerformedAuto);
        }
    }

    private void jButton3ActionPerformedProperty(ActionEvent evt) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                jTree1.getLastSelectedPathComponent();
        DefaultMutableTreeNode father = (DefaultMutableTreeNode) node.getParent();
        AutoEntity car = (AutoEntity) father.getUserObject();
        DetailEntity detailEntity = (DetailEntity) node.getUserObject();
        String Name = (String) jTable1.getValueAt(jTable1.getSelectedRow(),1);
        Properties.getInstance().updateProperty(car, detailEntity,jTable1.getSelectedRow(),Name);
        jTable1.setValueAt(jTable1.getValueAt(jTable1.getSelectedRow(),1), jTable1.getSelectedRow(),1);
    }

    private void jButton3ActionPerformedAuto(ActionEvent evt)
    {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                jTree1.getLastSelectedPathComponent();
        AutoEntity car = (AutoEntity) node.getUserObject();

        if(jTable1.getSelectedColumn()==0)
        {
            String Name = (String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
            CarsRepository.getInstance().updateCar(car,Name,"Name");
            car.setName(Name);
        }
        else if(jTable1.getSelectedColumn()==1)
        {
            String Mark = (String) jTable1.getValueAt(jTable1.getSelectedRow(),1);
            CarsRepository.getInstance().updateCar(car,Mark,"Mark");
            car.setMark(Mark);
        }
        else if(jTable1.getSelectedColumn()==2)
        {
            String Model = (String) jTable1.getValueAt(jTable1.getSelectedRow(),2);
            CarsRepository.getInstance().updateCar(car,Model,"Model");
            car.setModel(Model);
        }
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                jTree1.getLastSelectedPathComponent();
        DetailEntity detail = (DetailEntity) node.getUserObject();
        Object value;
        TableModel model = jTable1.getModel();
        try {
            value = model.getValueAt(jTable1.getSelectedRow(),0);
            if (JOptionPane.showOptionDialog(
                    null,
                    "Вы уверены что хотите удалить это свойство?",
                    "Удалить",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Да", "Нет"},
                    "Да") == JOptionPane.YES_OPTION) {
                Properties.getInstance().deleteProperty(detail,value);
                JOptionPane.showMessageDialog(null, "Свойство удалено", "Готово", JOptionPane.INFORMATION_MESSAGE);
                jTable1 = new JTable() {
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnIndex != 0;
                    }};
                String[][] table= new Table().table(detail);
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        table,
                        new String [] {"Свойство", "Значение"}
                ));
                jScrollPane2.setViewportView(jTable1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Вы не выбрали свойство которое нужно удалить",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTree jTree1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
}

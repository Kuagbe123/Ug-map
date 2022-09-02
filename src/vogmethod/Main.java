package vogmethod;


import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import static java.util.Arrays.stream;
import java.util.concurrent.Future;

public class Main extends javax.swing.JFrame {

 
    static String[] Sourcelocation;
    static String[] Destinationlocation;
    static int[][] costs;
    static int[] supply;
    static int[] demand;
    static int nRows;
    static int nCols;

    int[] _supply;
    int[] _demand;
    int _nRows;
    int _nCols;

    static boolean[] rowDone;
    static boolean[] colDone;
    static int[][] result;

    static ExecutorService es;

    
    public Main() {
        initComponents();

    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        InputTab1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        destinationPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
      
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DestinationTable = new javax.swing.JTable();
        AddDestination = new javax.swing.JButton();
        RemoveDestination = new javax.swing.JButton();
        sourcePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SourceTable = new javax.swing.JTable();
        AddSource = new javax.swing.JButton();
        RemoveSource = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        costsTable = new javax.swing.JTable();
        CalculateB = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        exitButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ResultsTable = new javax.swing.JTable();
        ResultsLabel = new javax.swing.JLabel();
        exittButton = new javax.swing.JButton();
        BackCostB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTabbedPane1.setEnabled(false);

        jSplitPane1.setDividerLocation(353);
       

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Desinations");
    

        jLabel4.setText("Starting point distance(2-100):");

        DestinationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"legonHall",  new Long(1200)},
                {"nightMarket",  new Long(100)},
                {"akuafoHall",  new Long(1100)},
                {"voltaHall",  new Long(1300)},
                {"cc",  new Long(1100)},
                {"ugcs",  new Long(2000)},
                {"JQB",  new Long(700)},
                {"balmeLibrary",  new Long(1100)},
                {"greatHall",  new Long(2400)}

            },
            new String [] {
                "Startpoint", "distance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DestinationTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(DestinationTable);
        if (DestinationTable.getColumnModel().getColumnCount() > 0) {
            DestinationTable.getColumnModel().getColumn(0).setResizable(false);
            DestinationTable.getColumnModel().getColumn(1).setResizable(false);
        }

        AddDestination.setText("add");
        AddDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDestinationActionPerformed(evt);
            }
        });

        RemoveDestination.setText("remove");
        RemoveDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveDestinationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout destinationPanelLayout = new javax.swing.GroupLayout(destinationPanel);
        destinationPanel.setLayout(destinationPanelLayout);
        destinationPanelLayout.setHorizontalGroup(
            destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(destinationPanelLayout.createSequentialGroup()
                    	
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(RemoveDestination)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddDestination))
                    .addGroup(destinationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        destinationPanelLayout.setVerticalGroup(
            destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AddDestination)
                    .addComponent(RemoveDestination))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(destinationPanel);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("source");
       

        jLabel2.setText("source disance (2-100):");

        SourceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            	 {"legonHall",  new Long(1200)},
                 {"nightMarket",  new Long(100)},
                 {"akuafoHall",  new Long(1100)},
                 {"voltaHall",  new Long(1300)},
                 {"cc",  new Long(1100)},
                 {"ugcs",  new Long(2000)},
                 {"JQB",  new Long(700)},
                 {"balmeLibrary",  new Long(1100)},
                 {"greatHall",  new Long(2400)}

            },
            new String [] {
                "Soure", "disance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        SourceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(SourceTable);
        if (SourceTable.getColumnModel().getColumnCount() > 0) {
            SourceTable.getColumnModel().getColumn(0).setResizable(false);
            SourceTable.getColumnModel().getColumn(1).setResizable(false);
        }

        AddSource.setText("add");
        AddSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSourceActionPerformed(evt);
            }
        });

        RemoveSource.setText("remove");
        RemoveSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveSourceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sourcePanelLayout = new javax.swing.GroupLayout(sourcePanel);
        sourcePanel.setLayout(sourcePanelLayout);
        sourcePanelLayout.setHorizontalGroup(
            sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sourcePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(sourcePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(RemoveSource)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddSource))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        sourcePanelLayout.setVerticalGroup(
            sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AddSource)
                    .addComponent(RemoveSource))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(sourcePanel);

        Next.setText("next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        exitButton.setText("Result");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InputTab1Layout = new javax.swing.GroupLayout(InputTab1);
        InputTab1.setLayout(InputTab1Layout);
        InputTab1Layout.setHorizontalGroup(
            InputTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InputTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1)
                    .addGroup(InputTab1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        InputTab1Layout.setVerticalGroup(
            InputTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Next)
                    .addComponent(exitButton))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Source and destination", InputTab1);

        costsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(costsTable);

        CalculateB.setText("Calculate");
        CalculateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateBActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        exitButton2.setText("results");
        exitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(exitButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalculateB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalculateB)
                    .addComponent(BackButton)
                    .addComponent(exitButton2)))
        );

        jTabbedPane1.addTab("Cost entry", jPanel1);

        jScrollPane4.setEnabled(false);

        ResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(ResultsTable);

        ResultsLabel.setText("Total cost:");

        exittButton.setText("Results");
        exittButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exittButtonActionPerformed(evt);
            }
        });

        BackCostB.setText("Back");
        BackCostB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackCostBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ResultsLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackCostB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exittButton)
                .addGap(301, 301, 301))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResultsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exittButton)
                    .addComponent(BackCostB))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Results", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void AddSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSourceActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) SourceTable.getModel();
        tableModel.addRow(new Object[]{"source", "1"});
      
    }//GEN-LAST:event_AddSourceActionPerformed

    private void RemoveSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveSourceActionPerformed
        if (SourceTable.getSelectedRow() != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) SourceTable.getModel();
            tableModel.removeRow(SourceTable.getSelectedRow());
        }
    }//GEN-LAST:event_RemoveSourceActionPerformed

    private void RemoveDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveDestinationActionPerformed
        if (DestinationTable.getSelectedRow() != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) DestinationTable.getModel();
            tableModel.removeRow(DestinationTable.getSelectedRow());
        }
    }//GEN-LAST:event_RemoveDestinationActionPerformed

    private void AddDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDestinationActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) DestinationTable.getModel();
        tableModel.addRow(new Object[]{"Startpoint", "33"});
    }
    

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) SourceTable.getModel();
        _nRows = tableModel.getRowCount();
        Sourcelocation = new String[_nRows];
        _supply = new int[_nRows];
        for (int i = 0; i < _nRows; i++) {
            if (Long.parseLong(tableModel.getValueAt(i, 1).toString()) < 1) {
                infoBox("Quantity  positive","error");
                return;
            }
            Sourcelocation[i] = tableModel.getValueAt(i, 0).toString();
            _supply[i] = Integer.parseInt(tableModel.getValueAt(i, 1).toString());
        }
        tableModel = (DefaultTableModel) DestinationTable.getModel();
        _nCols = tableModel.getRowCount();
        Destinationlocation = new String[_nCols];
        _demand = new int[_nCols];
        for (int i = 0; i < _nCols; i++) {
            if (Long.parseLong(tableModel.getValueAt(i, 1).toString()) < 1) {
                infoBox("Quantity positive","error");
                return;
            }
            Destinationlocation[i] = tableModel.getValueAt(i, 0).toString();
            _demand[i] = Integer.parseInt(tableModel.getValueAt(i, 1).toString());
        }

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col != 0;
            }
        };

        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        tableModel.addColumn("Source\\Destination");

        for (String key : Destinationlocation) {
            tableModel.addColumn(key);
        }

        for (String key : Sourcelocation) {
            List<Object> rowData = new LinkedList<>();
    
       
            rowData.add(key);
            for (int j = 0; j < Destinationlocation.length; j++) {
                rowData.add("1");
            }
  
            
            
         
            tableModel.addRow(rowData.toArray());
        }

        costsTable.setModel(tableModel);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_NextActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void exitButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButton2ActionPerformed

    private void CalculateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateBActionPerformed
        nRows = _nRows;
        nCols = _nCols;
        demand = new int[nCols];
        supply = new int[nRows];

        for (int i = 0; i < nCols; i++) {
            demand[i] = _demand[i];
        }
        for (int i = 0; i < nRows; i++) {
            supply[i] = _supply[i];
        }

        DefaultTableModel tableModel = (DefaultTableModel) costsTable.getModel();
        es = Executors.newFixedThreadPool(2);
        costs = new int[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                try {
                    int val = Integer.parseInt(tableModel.getValueAt(i, j + 1).toString());
                    if (val < 0) {
                        throw new NumberFormatException();
                    }
                    costs[i][j] = val;
                } catch (NumberFormatException e) {
                    infoBox("Please check values Entered", "Erro!");
                    return;
                }
            }
        }

        rowDone = new boolean[nRows];
        colDone = new boolean[nCols];
        result = new int[nRows][nCols];

        int supplyLeft = stream(supply).sum();
        int totalCost = 0;

        try {
            while (supplyLeft > 0) {
                int[] cell = nextCell();
                int r = cell[0];
                int c = cell[1];

                int quantity = Math.min(demand[c], supply[r]);
                demand[c] -= quantity;
                if (demand[c] == 0) {
                    colDone[c] = true;
                }

                supply[r] -= quantity;
                if (supply[r] == 0) {
                    rowDone[r] = true;
                }

                result[r][c] = quantity;
                supplyLeft -= quantity;

                totalCost += quantity * costs[r][c];
            }
        } catch (Exception e) {
            infoBox("Please check values", "Error!");
            return;
        }

//        stream(result).forEach(a -> System.out.println(Arrays.toString(a)));
//        System.out.println("Total cost: " + lCost);
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        tableModel.addColumn("Source\\Destination");

        for (int i = 0; i < nCols; i++) {
            tableModel.addColumn(Destinationlocation[i]);
        }

        tableModel.addColumn("Supply quantities");

        for (int i = 0; i < nRows; i++) {
            List<Object> rowData = new LinkedList<>();
            rowData.add(Sourcelocation[i]);
            for (int j = 0; j < nCols; j++) {
                rowData.add(String.valueOf(result[i][j]));
            }
            rowData.add(String.valueOf(_supply[i]));
            tableModel.addRow(rowData.toArray());
        }

        List<Object> rowData = new LinkedList<>();
        rowData.add("Demand quantities");
        for (int j = 0; j < nCols; j++) {
            rowData.add(String.valueOf(_demand[j]));
        }
        tableModel.addRow(rowData.toArray());

        ResultsTable.setModel(tableModel);
        ResultsLabel.setText("Total cost = " + totalCost);
       
        es.shutdown();
        jTabbedPane1.setSelectedIndex(2);
    }

    private void exittButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exittButtonActionPerformed
        System.exit(0);
    }

    private void BackCostBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackCostBActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    static int[] nextCell() throws Exception {
        Future<int[]> f1 = es.submit(() -> maxPenalty(nRows, nCols, true));
        Future<int[]> f2 = es.submit(() -> maxPenalty(nCols, nRows, false));

        int[] res1 = f1.get();
        int[] res2 = f2.get();

        if (res1[3] == res2[3]) {
            return res1[2] < res2[2] ? res1 : res2;
        }

        return (res1[3] > res2[3]) ? res2 : res1;
    }

    static int[] diff(int j, int len, boolean isRow) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int minP = -1;
        for (int i = 0; i < len; i++) {
            if (isRow ? colDone[i] : rowDone[i]) {
                continue;
            }
            int c = isRow ? costs[j][i] : costs[i][j];
            if (c < min1) {
                min2 = min1;
                min1 = c;
                minP = i;
            } else if (c < min2) {
                min2 = c;
            }
        }
        return new int[]{min2 - min1, min1, minP};
    }

    static int[] maxPenalty(int len1, int len2, boolean isRow) {
        int md = Integer.MIN_VALUE;
        int pc = -1, pm = -1, mc = -1;
        for (int i = 0; i < len1; i++) {
            if (isRow ? rowDone[i] : colDone[i]) {
                continue;
            }
            int[] res = diff(i, len2, isRow);
            if (res[0] > md) {
                md = res[0];  // maximum difference
                pm = i;       // pos of max difference
                mc = res[1];  // minimum cost
                pc = res[2];  // pos of minimum cost
            }
        }
        return isRow ? new int[]{pm, pc, mc, md} : new int[]{pc, pm, mc, md};
    }

    private static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

  
    private javax.swing.JButton BackCostB;
    private javax.swing.JPanel InputTab1;
    private javax.swing.JLabel ResultsLabel;
    private javax.swing.JPanel destinationPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitButton2;
    private javax.swing.JButton exittButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton AddDestination;
    private javax.swing.JButton RemoveDestination;
    private javax.swing.JTable DestinationTable;
    private javax.swing.JButton CalculateB;
    private javax.swing.JButton Next;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton AddSource;
    private javax.swing.JButton RemoveSource;
    private javax.swing.JTable SourceTable;
    private javax.swing.JTable costsTable;
    private javax.swing.JTable ResultsTable;
    private javax.swing.JPanel sourcePanel;

}


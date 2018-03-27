/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu.simulation;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Norwin Ygay
 */
public class MainUI extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        jPanel2.setVisible(false);
    }

    public void FIFO(){
        model2 = (DefaultTableModel)core1.getModel();
        //CPU Process starts
        int count=0;
        
        while(queues.getRowCount() != 0 && count < 1){
            Functions f = new Functions();
            Object[] rowData = new Object[4];
            final int time;
            
            f=getPop();
            rowData[0] = f.getProcessName();
            rowData[1] = f.getPriority();
            rowData[2] = f.getETA();
            rowData[3] = f.getType();
            model2.addRow(rowData);
            
            time=f.getETA();
            //This is where threading for core 1;
            //System.out.println(time);
             Thread one = new Thread(){
                 public void run(){
                     try {
                         //model2.addRow(rowData);
                         Thread.sleep(time * 1000);
                         model2.removeRow(0);
                         this.interrupt();
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             };
             one.start();
             //JOptionPane.showMessageDialog(this, "Process Done!");
             count++;             
            
            }
            //System.out
            
        }
    
    public void priority(){
        model2 = (DefaultTableModel)core1.getModel();
        DefaultTableModel modelq = (DefaultTableModel)queues.getModel();
        Functions f=new Functions();
        int smaller=0;
        int count =0;
        
        while(queues.getRowCount() != 0 && count < 1){
            final int time;
            for(int x=0;x<queues.getRowCount();x++){
                if(Integer.parseInt(queues.getValueAt(x, 2).toString()) < Integer.parseInt(queues.getValueAt(smaller, 2).toString())){
                    smaller=x;
                }
            }
            Object[] rowData = new Object[4];
            
//            f=getPop();
//            rowData[0] = f.getProcessName();
//            rowData[1] = f.getPriority();
//            rowData[2] = f.getETA();
//            rowData[3] = f.getType();
//            model2.addRow(rowData);
//            
            rowData[0] = queues.getValueAt(smaller, 0);
            rowData[1] = queues.getValueAt(smaller, 1);
            rowData[2] = queues.getValueAt(smaller, 2);
            rowData[3] = queues.getValueAt(smaller, 3);
            model2.addRow(rowData);
            modelq.removeRow(smaller);
            smaller=0;
            
            time=Integer.parseInt(rowData[2].toString());
            //This is where threading for core 1;
            //System.out.println(time);
             Thread one = new Thread(){
                 public void run(){
                     try {
                         //model2.addRow(rowData);
                         Thread.sleep(time * 1000);
                         model2.removeRow(0);
                         this.interrupt();
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             };
             one.start();
             count++;
        }
    }
    
    public void RR(){
        model2 = (DefaultTableModel)core1.getModel();
        int count =0;
        //CPU Process starts
        
        while(queues.getRowCount() != 0 && count <=2){
            Functions f = new Functions();
            Object[] rowData = new Object[4];
            final int time;
            
            f=getPop();
            rowData[0] = f.getProcessName();
            rowData[1] = f.getPriority();
            rowData[2] = f.getETA();
            rowData[3] = f.getType();
            model2.addRow(rowData);
            
            time=f.getETA();
            //This is where threading for core 1;
            //System.out.println(time);
             Thread one = new Thread(){
                 public void run(){
                     try {
                         //model2.addRow(rowData);
                         Thread.sleep(time * 1000);
                         model2.removeRow(0);
                         this.interrupt();
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             };
             one.start();
             //JOptionPane.showMessageDialog(this, "Process Done!");
             
            count++;
        }
    }
    
    public void SJF(){
        model2 = (DefaultTableModel)core1.getModel();
        DefaultTableModel modelq = (DefaultTableModel)queues.getModel();
        Functions f=new Functions();
        int smaller=0;
        int count =0;
        
        while(queues.getRowCount() != 0 && count < 1){
            final int time;
            for(int x=0;x<queues.getRowCount();x++){
                if(Integer.parseInt(queues.getValueAt(x, 2).toString()) < Integer.parseInt(queues.getValueAt(smaller, 2).toString())){
                    smaller=x;
                }
            }
            Object[] rowData = new Object[4];
            
//            f=getPop();
//            rowData[0] = f.getProcessName();
//            rowData[1] = f.getPriority();
//            rowData[2] = f.getETA();
//            rowData[3] = f.getType();
//            model2.addRow(rowData);
//            
            rowData[0] = queues.getValueAt(smaller, 0);
            rowData[1] = queues.getValueAt(smaller, 1);
            rowData[2] = queues.getValueAt(smaller, 2);
            rowData[3] = queues.getValueAt(smaller, 3);
            model2.addRow(rowData);
            modelq.removeRow(smaller);
            smaller=0;
            
            time=Integer.parseInt(rowData[2].toString());
            //This is where threading for core 1;
            //System.out.println(time);
             Thread one = new Thread(){
                 public void run(){
                     try {
                         //model2.addRow(rowData);
                         Thread.sleep(time * 1000);
                         model2.removeRow(0);
                         this.interrupt();
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             };
             one.start();
             count++;
        }
    }
    
    public void lottery(){
        model2 = (DefaultTableModel)core1.getModel();
        DefaultTableModel modelq = (DefaultTableModel)queues.getModel();
        Functions f=new Functions();
        Random rand = new Random();
        int max = queues.getRowCount();
        int selected;
        int count =0;
        
        while(queues.getRowCount() != 0 && count < 1){
            final int time;
            selected = (int) rand.nextInt(max);
            Object[] rowData = new Object[4];
            
//            f=getPop();
//            rowData[0] = f.getProcessName();
//            rowData[1] = f.getPriority();
//            rowData[2] = f.getETA();
//            rowData[3] = f.getType();
//            model2.addRow(rowData);
//            
            rowData[0] = queues.getValueAt(selected, 0);
            rowData[1] = queues.getValueAt(selected, 1);
            rowData[2] = queues.getValueAt(selected, 2);
            rowData[3] = queues.getValueAt(selected, 3);
            model2.addRow(rowData);
            modelq.removeRow(selected);
            selected=0;
            
            time=Integer.parseInt(rowData[2].toString());
            //This is where threading for core 1;
            //System.out.println(time);
             Thread one = new Thread(){
                 public void run(){
                     try {
                         //model2.addRow(rowData);
                         Thread.sleep(time * 1000);
                         model2.removeRow(0);
                         this.interrupt();
                     } catch (InterruptedException ex) {
                         Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             };
             one.start();
             count++;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pFIFO = new javax.swing.JRadioButton();
        pRoundRobin = new javax.swing.JRadioButton();
        pSJF = new javax.swing.JRadioButton();
        pPriority = new javax.swing.JRadioButton();
        pMFQ = new javax.swing.JRadioButton();
        pLottery = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Processes = new javax.swing.JTable();
        addProcess = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        core1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        queues = new javax.swing.JTable();
        queueAll = new javax.swing.JButton();
        start = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        processText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        priorityText = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        addToList = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        etaText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        typeText = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);

        jTextField6.setEditable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel1.setText("CPU Utilization");

        jLabel2.setText("Through Put");

        jLabel3.setText("Turnaround Time");

        jLabel4.setText("Wait Time");

        jLabel5.setText("Response Time");

        jLabel6.setText("Fairness");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Policies");

        pFIFO.setSelected(true);
        pFIFO.setText("FIFO");
        pFIFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFIFOActionPerformed(evt);
            }
        });

        pRoundRobin.setText("Round Robin");
        pRoundRobin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pRoundRobinActionPerformed(evt);
            }
        });

        pSJF.setText("Shortest Job First");
        pSJF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pSJFActionPerformed(evt);
            }
        });

        pPriority.setText("Priority Scheduling");
        pPriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pPriorityActionPerformed(evt);
            }
        });

        pMFQ.setText("Multilevel Feedback Queues");
        pMFQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pMFQActionPerformed(evt);
            }
        });

        pLottery.setText("Lottery Scheduling");
        pLottery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pLotteryActionPerformed(evt);
            }
        });

        Processes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Process Name", "Priority", "Estimated Time To Be Processed(s)", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Processes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Processes);

        addProcess.setText("Add Process");
        addProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProcessActionPerformed(evt);
            }
        });

        core1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Process", "Priority", "ETA", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        core1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(core1);
        if (core1.getColumnModel().getColumnCount() > 0) {
            core1.getColumnModel().getColumn(0).setResizable(false);
            core1.getColumnModel().getColumn(1).setResizable(false);
            core1.getColumnModel().getColumn(2).setResizable(false);
            core1.getColumnModel().getColumn(3).setResizable(false);
        }

        queues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Process", "Priority", "ETA", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        queues.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(queues);
        if (queues.getColumnModel().getColumnCount() > 0) {
            queues.getColumnModel().getColumn(0).setResizable(false);
            queues.getColumnModel().getColumn(1).setResizable(false);
            queues.getColumnModel().getColumn(2).setResizable(false);
            queues.getColumnModel().getColumn(3).setResizable(false);
        }

        queueAll.setText("Queue All Process");
        queueAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queueAllActionPerformed(evt);
            }
        });

        start.setText("Start Simulate");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Core 1");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Process Queues");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pMFQ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pLottery)
                                        .addComponent(addProcess))
                                    .addGap(44, 44, 44)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(41, 41, 41)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(58, 58, 58)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(47, 47, 47)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(pSJF)
                                                    .addComponent(pPriority)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pFIFO)
                                            .addComponent(pRoundRobin))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel6)
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(queueAll)
                        .addGap(33, 33, 33)
                        .addComponent(start)))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pFIFO)
                            .addComponent(pMFQ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pRoundRobin)
                            .addComponent(pLottery)
                            .addComponent(pPriority))
                        .addGap(31, 31, 31)
                        .addComponent(addProcess)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pSJF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(queueAll)
                            .addComponent(start))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Add Process");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Process Name");

        processText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                processTextInputMethodTextChanged(evt);
            }
        });
        processText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processTextActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Priority");

        priorityText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        clear.setText("Clear");
        clear.setMaximumSize(new java.awt.Dimension(77, 77));
        clear.setPreferredSize(new java.awt.Dimension(110, 25));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        addToList.setText("Add Process");
        addToList.setPreferredSize(new java.awt.Dimension(110, 25));
        addToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(110, 25));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("ETA(s)");

        etaText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Type");

        typeText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pre-emptive", "Non-Preemptive" }));
        typeText.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addToList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(67, 67, 67)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priorityText)
                            .addComponent(processText)
                            .addComponent(typeText, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etaText, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etaText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(182, 182, 182)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(182, 182, 182)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(180, 180, 180)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(180, 180, 180)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        if(pFIFO.isSelected()){
            FIFO();
        }else if(pPriority.isSelected()){
            priority();
        }else if(pRoundRobin.isSelected()){
            RR();
        }else if(pSJF.isSelected()){
            SJF();
        }else if(pLottery.isSelected()){
            lottery();
        }
    }//GEN-LAST:event_startActionPerformed

    private void queueAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queueAllActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel)queues.getModel();
        
        for(int row = 0; row < Processes.getRowCount(); row++){
            Object[] rowData = new Object[4];
            rowData[0] = Processes.getValueAt(row, 0);
            rowData[1] = Processes.getValueAt(row, 1);
            rowData[2] = Processes.getValueAt(row, 2);
            rowData[3] = Processes.getValueAt(row, 3);
            model.addRow(rowData);
        }
        //public void start();
        
    }//GEN-LAST:event_queueAllActionPerformed

    private void addProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProcessActionPerformed
        // TODO add your handling code here:
        this.jPanel1.setVisible(false);
        this.jPanel2.setVisible(true);
    }//GEN-LAST:event_addProcessActionPerformed

    private void pLotteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pLotteryActionPerformed
        // TODO add your handling code here:
        if(pLottery.isSelected()){
            pFIFO.setSelected(false);
            pMFQ.setSelected(false);
            pPriority.setSelected(false);
            pRoundRobin.setSelected(false);
            pSJF.setSelected(false);
        }
    }//GEN-LAST:event_pLotteryActionPerformed

    private void pMFQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pMFQActionPerformed
        // TODO add your handling code here:
        if(pMFQ.isSelected()){
            pLottery.setSelected(false);
            pFIFO.setSelected(false);
            pPriority.setSelected(false);
            pRoundRobin.setSelected(false);
            pSJF.setSelected(false);
        }
    }//GEN-LAST:event_pMFQActionPerformed

    private void pPriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pPriorityActionPerformed
        // TODO add your handling code here:
        if(pPriority.isSelected()){
            pLottery.setSelected(false);
            pMFQ.setSelected(false);
            pFIFO.setSelected(false);
            pRoundRobin.setSelected(false);
            pSJF.setSelected(false);
        }
    }//GEN-LAST:event_pPriorityActionPerformed

    private void pSJFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pSJFActionPerformed
        // TODO add your handling code here:
        if(pSJF.isSelected()){
            pLottery.setSelected(false);
            pMFQ.setSelected(false);
            pPriority.setSelected(false);
            pRoundRobin.setSelected(false);
            pFIFO.setSelected(false);
        }
    }//GEN-LAST:event_pSJFActionPerformed

    private void pRoundRobinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pRoundRobinActionPerformed
        // TODO add your handling code here:
        if(pRoundRobin.isSelected()){
            pLottery.setSelected(false);
            pMFQ.setSelected(false);
            pPriority.setSelected(false);
            pFIFO.setSelected(false);
            pSJF.setSelected(false);
        }
    }//GEN-LAST:event_pRoundRobinActionPerformed

    private void pFIFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFIFOActionPerformed
        // TODO add your handling code here:
        if(pFIFO.isSelected()){
            pLottery.setSelected(false);
            pMFQ.setSelected(false);
            pPriority.setSelected(false);
            pRoundRobin.setSelected(false);
            pSJF.setSelected(false);
        }
    }//GEN-LAST:event_pFIFOActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyPressed

    private void processTextInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_processTextInputMethodTextChanged

    }//GEN-LAST:event_processTextInputMethodTextChanged

    private void processTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_processTextActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        processText.setText("");
        priorityText.setText("");
        etaText.setText("");
        typeText.setSelectedIndex(-1);

    }//GEN-LAST:event_clearActionPerformed

    private void addToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListActionPerformed
        model = (DefaultTableModel) Processes.getModel();
        if(processText.getText().isEmpty() || priorityText.getText().isEmpty() || etaText.getText().isEmpty() || (typeText.getSelectedIndex() == -1)){
            JOptionPane.showMessageDialog(this, "Field/s Must Not Empty");

        }else{
            Object[] obj = new Object[4];

            obj[0] = processText.getText();
            obj[1] = priorityText.getText();
            obj[2] = etaText.getText();
            obj[3] = typeText.getSelectedItem();
            model.addRow(obj);
            JOptionPane.showMessageDialog(this, "Process Added!");
            clearActionPerformed(evt);
        }
    }//GEN-LAST:event_addToListActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.jPanel2.setVisible(false);
        this.jPanel1.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void typeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }
    
    public Functions getPop (){
        model = (DefaultTableModel)queues.getModel();
        Functions ret = new Functions();
        ret.setProcessName(model.getValueAt(0, 0).toString());
        ret.setPriority(Integer.parseInt(model.getValueAt(0, 1).toString()));
        ret.setETA(Integer.parseInt(model.getValueAt(0, 2).toString()));
        ret.setType(model.getValueAt(0, 3).toString());
        model.removeRow(0);
        return ret;
    }
  
    public MainUI(Object[] obj){
        initComponents();
        
        DefaultTableModel toProcess = (DefaultTableModel)Processes.getModel();
        toProcess.addRow(obj);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Processes;
    private javax.swing.JButton addProcess;
    private javax.swing.JButton addToList;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JTable core1;
    private javax.swing.JTextField etaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton pFIFO;
    private javax.swing.JRadioButton pLottery;
    private javax.swing.JRadioButton pMFQ;
    private javax.swing.JRadioButton pPriority;
    private javax.swing.JRadioButton pRoundRobin;
    private javax.swing.JRadioButton pSJF;
    private javax.swing.JTextField priorityText;
    private javax.swing.JTextField processText;
    private javax.swing.JButton queueAll;
    private javax.swing.JTable queues;
    private javax.swing.JButton start;
    private javax.swing.JComboBox<String> typeText;
    // End of variables declaration//GEN-END:variables
}

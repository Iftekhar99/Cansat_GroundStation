/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import gnu.io.CommPortIdentifier;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author iftekharulalam
 */
public class NewJFrame extends javax.swing.JFrame {

    String myPort = "";
    int myStart;
    ArduinoSerial sensorData = new ArduinoSerial(myPort);

    DataOutputStream out = null;

    FileWriter fw = null;
    BufferedWriter bw = null;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
//        try {
//            //--for file setting
//            fw = new FileWriter("Data.csv", true);
//            bw = new BufferedWriter(fw);
//            String s = "TeamID,MissionTime,Altitude,Pressure,Temp,Voltage,GPSTIme,AirSpeed,SoftState";
//            bw.write(s);
//            bw.write("\n");
//
//            bw.close();
//        } catch (IOException ex) {
//            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        //--for file setting
//        //---Altitude
//        XYSeries seriesAl = new XYSeries("Altitude");
//        XYSeriesCollection datasetAl = new XYSeriesCollection(seriesAl);
//        JFreeChart chartAl = ChartFactory.createXYLineChart(
//                "Altitude",
//                "Time",
//                "Altitude",
//                datasetAl
//        );
//
//        ChartPanel chartPanelAL = new ChartPanel(chartAl);
//        chartPanelAL.setPreferredSize(new java.awt.Dimension(300, 300));
//
//        altitudeGraph.add(chartPanelAL);
//
//        altitudeGraph.validate();
//
//        chartPanelAL.setVisible(true);
//
//        altitudeGraph.setVisible(true);
////--altitude
////--tempGraph
//        XYSeries seriesTemp = new XYSeries("Temparature");
//        XYSeriesCollection datasetTemp = new XYSeriesCollection(seriesTemp);
//        JFreeChart chartTemp = ChartFactory.createXYLineChart(
//                "Temp",
//                "Time",
//                "Temp",
//                datasetTemp
//        );
//
//        ChartPanel chartPanelTemp = new ChartPanel(chartTemp);
//        chartPanelTemp.setPreferredSize(new java.awt.Dimension(300, 300));
//
//        tempGraph.add(chartPanelTemp);
//
//        tempGraph.validate();
//
//        chartPanelTemp.setVisible(true);
//
//        tempGraph.setVisible(true);
//
////--temp Graph
////voltageGraph
//        XYSeries seriesVolt = new XYSeries("Voltage");
//        XYSeriesCollection datasetVolt = new XYSeriesCollection(seriesVolt);
//        JFreeChart chartVolt = ChartFactory.createXYLineChart(
//                "Voltage",
//                "Time",
//                "Voltage",
//                datasetVolt
//        );
//
//        ChartPanel chartPanelVolt = new ChartPanel(chartVolt);
//        chartPanelVolt.setPreferredSize(new java.awt.Dimension(300, 300));
//
//        voltageGraph.add(chartPanelVolt);
//
//        voltageGraph.validate();
//
//        chartPanelVolt.setVisible(true);
//
//        voltageGraph.setVisible(true);
//
////--voltageGraph
////pressureGraph
//        XYSeries seriesPressure = new XYSeries("Pressure");
//        XYSeriesCollection datasetPressure = new XYSeriesCollection(seriesPressure);
//        JFreeChart chartPressure = ChartFactory.createXYLineChart(
//                "Pressure",
//                "Time",
//                "Pressure",
//                datasetPressure
//        );
//
//        ChartPanel chartPanelPressure = new ChartPanel(chartPressure);
//        chartPanelPressure.setPreferredSize(new java.awt.Dimension(300, 300));
//
//        pressureGraph.add(chartPanelPressure);
//
//        pressureGraph.validate();
//
//        chartPanelPressure.setVisible(true);
//
//        pressureGraph.setVisible(true);
//
////--PressureGraph
////AirSpeedGraph
//        XYSeries seriesAirSpeed = new XYSeries("AirSpeed");
//        XYSeriesCollection datasetAirSpeed = new XYSeriesCollection(seriesAirSpeed);
//        JFreeChart chartAirSpeed = ChartFactory.createXYLineChart(
//                "AirSpeed",
//                "Time",
//                "AirSpeed",
//                datasetAirSpeed
//        );
//
//        ChartPanel chartPanelAirSpeed = new ChartPanel(chartAirSpeed);
//        chartPanelAirSpeed.setPreferredSize(new java.awt.Dimension(300, 300));
//
//        airSpeedGraph.add(chartPanelAirSpeed);
//
//        airSpeedGraph.validate();
//
//        chartPanelAirSpeed.setVisible(true);
//
//        airSpeedGraph.setVisible(true);
//
////--AirSpeedGraph
////       ArduinoSerial sensorData = new ArduinoSerial(myPort);
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                //  ArduinoSerial sensorData = new ArduinoSerial(myPort);
//                sensorData.initialize();
//                while (true) {
//
//                    try {
//                        Thread.sleep(1000);
//                        fw = new FileWriter("Data.csv", true);
//
//                        bw = new BufferedWriter(fw);
//                        String s = sensorData.read();
//                        bw.write(s);
//                        bw.write("\n");
//
//                        bw.close();
//                        //--------
//
//                        //--------
//                        String dataArray[] = s.split(",");
//                        System.out.println(s);
//                        System.out.println(dataArray.length);
//                        teamIDLabel.setText(dataArray[0]);
//                        missionTimeLabel.setText(dataArray[1]);
//                        altitudeLabel.setText(dataArray[2]);
//                        pressureLabel.setText(dataArray[3]);
//                        tempLabel.setText(dataArray[4]);
//                        voltageLabel.setText(dataArray[5]);
//                        gpsTimeLabel.setText(dataArray[6]);
//                        airSpeedLabel.setText(dataArray[7]);
//                        softStateLabel.setText(dataArray[8]);
//                        //-------
//                        seriesAl.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
//                        seriesTemp.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
//                        seriesPressure.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
//                        seriesAirSpeed.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
//                        seriesVolt.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
//
//                        altitudeGraph.repaint();
//                        tempGraph.repaint();
//                        voltageGraph.repaint();
//                        pressureGraph.repaint();
//                        airSpeedGraph.repaint();
//
//                        //-------
//                    } catch (Exception e) {
//                        //System.out.println(e);
//                    }
//
//                }
//
//            }
//
//        };
//
//        t.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teamNameLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        teamIDLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        missionTimeLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        altitudeLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tempLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pressureLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        voltageLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        gpsTimeLabel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        softStateLabel = new javax.swing.JLabel();
        altitudeGraph = new javax.swing.JPanel();
        tempGraph = new javax.swing.JPanel();
        voltageGraph = new javax.swing.JPanel();
        pressureGraph = new javax.swing.JPanel();
        portListo = new javax.swing.JComboBox<>();
        startButton = new javax.swing.JButton();
        scanButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CanSat GroundStation");
        setName("CanSat GroundStation"); // NOI18N
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teamNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        teamNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamNameLabel.setText("FabSat Ground Station");
        getContentPane().add(teamNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Team ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        teamIDLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        teamIDLabel.setText("N/A");
        getContentPane().add(teamIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 30));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Mission TIme:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        missionTimeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        missionTimeLabel.setText("N/A");
        getContentPane().add(missionTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Altitude:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        altitudeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        altitudeLabel.setText("N/A");
        getContentPane().add(altitudeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("Temp:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        tempLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tempLabel.setText("N/A");
        getContentPane().add(tempLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("Pressure:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        pressureLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        pressureLabel.setText("N/A");
        getContentPane().add(pressureLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel14.setText("Voltage :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        voltageLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        voltageLabel.setText("N/A");
        getContentPane().add(voltageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setText("GPS TIme:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        gpsTimeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        gpsTimeLabel.setText("N/A");
        getContentPane().add(gpsTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel20.setText("Softwear State: ");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        softStateLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        softStateLabel.setText("N/A");
        getContentPane().add(softStateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        altitudeGraph.setLayout(new java.awt.BorderLayout());
        getContentPane().add(altitudeGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 300, 230));

        tempGraph.setLayout(new java.awt.BorderLayout());
        getContentPane().add(tempGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 300, 230));

        voltageGraph.setLayout(new java.awt.BorderLayout());
        getContentPane().add(voltageGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 300, 230));

        pressureGraph.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pressureGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 300, 230));

        getContentPane().add(portListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 270, -1));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 270, 50));

        scanButton.setText("Scan");
        scanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanButtonActionPerformed(evt);
            }
        });
        getContentPane().add(scanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 270, 40));

        jLabel1.setText("m");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel2.setText("*C");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel3.setText("V");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel5.setText("Pa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        getAccessibleContext().setAccessibleName("CanSat_GroundStation");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanButtonActionPerformed
        // TODO add your handling code here:
        portListo.removeAll();
        
        Enumeration portList=null;
        
              portList = CommPortIdentifier.getPortIdentifiers();
        //portListo.addItem(CommPortIdentifier.getPortIdentifiers().toString());
        //System.out.println(portList.hasMoreElements());
        
        while (portList.hasMoreElements()) {
            // System.out.println("Has more elements");
            CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
//               if (portId.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
//                    System.out.println(portId.getName());
//               }
//               else{
//                    System.out.println(portId.getName());
//               }
            portListo.addItem(portId.getName());

        }


    }//GEN-LAST:event_scanButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        myPort = portListo.getSelectedItem().toString();
        try {
            //--for file setting
            fw = new FileWriter("Data.csv", true);
            bw = new BufferedWriter(fw);
            String s = "TeamID,MissionTime,Altitude,Pressure,Temp,Voltage,GPSTIme,SoftState";
            bw.write(s);
            bw.write("\n");

            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--for file setting
        //---Altitude
        XYSeries seriesAl = new XYSeries("Altitude");
        XYSeriesCollection datasetAl = new XYSeriesCollection(seriesAl);
        JFreeChart chartAl = ChartFactory.createXYLineChart(
                "Altitude",
                "Time",
                "Altitude",
                datasetAl
        );

        ChartPanel chartPanelAL = new ChartPanel(chartAl);
        chartPanelAL.setPreferredSize(new java.awt.Dimension(300, 300));

        altitudeGraph.add(chartPanelAL);

        altitudeGraph.validate();

        chartPanelAL.setVisible(true);

        altitudeGraph.setVisible(true);
//--altitude
//--tempGraph
        XYSeries seriesTemp = new XYSeries("Temparature");
        XYSeriesCollection datasetTemp = new XYSeriesCollection(seriesTemp);
        JFreeChart chartTemp = ChartFactory.createXYLineChart(
                "Temp",
                "Time",
                "Temp",
                datasetTemp
        );

        ChartPanel chartPanelTemp = new ChartPanel(chartTemp);
        chartPanelTemp.setPreferredSize(new java.awt.Dimension(300, 300));

        tempGraph.add(chartPanelTemp);

        tempGraph.validate();

        chartPanelTemp.setVisible(true);

        tempGraph.setVisible(true);

//--temp Graph
//voltageGraph
        XYSeries seriesVolt = new XYSeries("Voltage");
        XYSeriesCollection datasetVolt = new XYSeriesCollection(seriesVolt);
        JFreeChart chartVolt = ChartFactory.createXYLineChart(
                "Voltage",
                "Time",
                "Voltage",
                datasetVolt
        );

        ChartPanel chartPanelVolt = new ChartPanel(chartVolt);
        chartPanelVolt.setPreferredSize(new java.awt.Dimension(300, 300));

        voltageGraph.add(chartPanelVolt);

        voltageGraph.validate();

        chartPanelVolt.setVisible(true);

        voltageGraph.setVisible(true);

//--voltageGraph
//pressureGraph
        XYSeries seriesPressure = new XYSeries("Pressure");
        XYSeriesCollection datasetPressure = new XYSeriesCollection(seriesPressure);
        JFreeChart chartPressure = ChartFactory.createXYLineChart(
                "Pressure",
                "Time",
                "Pressure",
                datasetPressure
        );

        ChartPanel chartPanelPressure = new ChartPanel(chartPressure);
        chartPanelPressure.setPreferredSize(new java.awt.Dimension(300, 300));

        pressureGraph.add(chartPanelPressure);

        pressureGraph.validate();

        chartPanelPressure.setVisible(true);

        pressureGraph.setVisible(true);

//--PressureGraph

       ArduinoSerial sensorData = new ArduinoSerial(myPort);
        Thread t = new Thread() {
            @Override
            public void run() {
                //  ArduinoSerial sensorData = new ArduinoSerial(myPort);
                sensorData.initialize();
                while (true) {

                    try {
                        Thread.sleep(1000);
                        fw = new FileWriter("Data.csv", true);

                        bw = new BufferedWriter(fw);
                        String s = sensorData.read();
                        bw.write(s);
                        bw.write("\n");

                        bw.close();
                        //--------

                        //--------
                        String dataArray[] = s.split(",");
                        System.out.println(s);
                        System.out.println(dataArray.length);
                        teamIDLabel.setText(dataArray[0]);
                        missionTimeLabel.setText(dataArray[1]);
                        altitudeLabel.setText(dataArray[2]);
                        pressureLabel.setText(dataArray[3]);
                        tempLabel.setText(dataArray[4]);
                        voltageLabel.setText(dataArray[5]);
                        gpsTimeLabel.setText(dataArray[6]);
                        softStateLabel.setText(dataArray[8]);
                        //-------
                        seriesAl.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesTemp.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesPressure.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesVolt.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));

                        altitudeGraph.repaint();
                        tempGraph.repaint();
                        voltageGraph.repaint();
                        pressureGraph.repaint();

                        //-------
                    } catch (Exception e) {
                        //System.out.println(e);
                    }

                }

            }

        };

        t.start();

        
        
        

    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel altitudeGraph;
    private javax.swing.JLabel altitudeLabel;
    private javax.swing.JLabel gpsTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel missionTimeLabel;
    private javax.swing.JComboBox<String> portListo;
    private javax.swing.JPanel pressureGraph;
    private javax.swing.JLabel pressureLabel;
    private javax.swing.JButton scanButton;
    private javax.swing.JLabel softStateLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel teamIDLabel;
    private javax.swing.JLabel teamNameLabel;
    private javax.swing.JPanel tempGraph;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JPanel voltageGraph;
    private javax.swing.JLabel voltageLabel;
    // End of variables declaration//GEN-END:variables
}

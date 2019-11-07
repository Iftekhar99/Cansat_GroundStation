/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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

    DataOutputStream out = null;

    FileWriter fw = null;
    BufferedWriter bw = null;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        try {
            //--for file setting
            fw = new FileWriter("Data.csv", true);
            bw = new BufferedWriter(fw);
            String s = "TeamID,MissionTime,Altitude,Pressure,Temp,Voltage,GPSTIme,AirSpeed,SoftState";
            bw.write(s);
            bw.write("\n");

            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--for file setting
        //---Altitude
        XYSeries seriesAl = new XYSeries("");
        XYSeriesCollection datasetAl = new XYSeriesCollection(seriesAl);
        JFreeChart chartAl = ChartFactory.createXYLineChart(
                "Altitude",
                "Time",
                "",
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
        chartPanelTemp.setPreferredSize(new java.awt.Dimension(300, 300));

        pressureGraph.add(chartPanelPressure);

        pressureGraph.validate();

        chartPanelPressure.setVisible(true);

        pressureGraph.setVisible(true);

//--PressureGraph
//AirSpeedGraph
        XYSeries seriesAirSpeed = new XYSeries("AirSpeed");
        XYSeriesCollection datasetAirSpeed = new XYSeriesCollection(seriesAirSpeed);
        JFreeChart chartAirSpeed = ChartFactory.createXYLineChart(
                "AirSpeed",
                "Time",
                "AirSpeed",
                datasetAirSpeed
        );

        ChartPanel chartPanelAirSpeed = new ChartPanel(chartAirSpeed);
        chartPanelAirSpeed.setPreferredSize(new java.awt.Dimension(300, 300));

        airSpeedGraph.add(chartPanelAirSpeed);

        airSpeedGraph.validate();

        chartPanelAirSpeed.setVisible(true);

        airSpeedGraph.setVisible(true);



//--AirSpeedGraph

        ArduinoSerial sensorData = new ArduinoSerial("/dev/tty.usbmodem14101");
        Thread t = new Thread() {
            @Override
            public void run() {
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
                        airSpeedLabel.setText(dataArray[7]);
                        softStateLabel.setText(dataArray[8]);
                        //-------
                        seriesAl.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesTemp.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesPressure.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesAirSpeed.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));
                        seriesVolt.add(Integer.parseInt(dataArray[2]), Integer.parseInt(dataArray[3]));

                        altitudeGraph.repaint();
                        tempGraph.repaint();
                        voltageGraph.repaint();
                        pressureGraph.repaint();
                        airSpeedGraph.repaint();

                        //-------
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }

            }

        };

        t.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        jLabel18 = new javax.swing.JLabel();
        airSpeedLabel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        softStateLabel = new javax.swing.JLabel();
        altitudeGraph = new javax.swing.JPanel();
        tempGraph = new javax.swing.JPanel();
        voltageGraph = new javax.swing.JPanel();
        pressureGraph = new javax.swing.JPanel();
        airSpeedGraph = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Team Name:");

        teamNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamNameLabel.setText("FabSat");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Team ID:");

        teamIDLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        teamIDLabel.setText("N/A");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Mission TIme:");

        missionTimeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        missionTimeLabel.setText("N/A");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Altitude:");

        altitudeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        altitudeLabel.setText("N/A");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("Temp:");

        tempLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tempLabel.setText("N/A");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("Pressure:");

        pressureLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        pressureLabel.setText("N/A");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel14.setText("Voltage :");

        voltageLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        voltageLabel.setText("N/A");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setText("GPS TIme:");

        gpsTimeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        gpsTimeLabel.setText("N/A");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setText("Air Speed:");

        airSpeedLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        airSpeedLabel.setText("N/A");

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel20.setText("Softwear State: ");

        softStateLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        softStateLabel.setText("N/A");

        altitudeGraph.setSize(new java.awt.Dimension(300, 300));
        altitudeGraph.setLayout(new java.awt.BorderLayout());

        tempGraph.setSize(new java.awt.Dimension(300, 300));
        tempGraph.setLayout(new java.awt.BorderLayout());

        voltageGraph.setSize(new java.awt.Dimension(300, 300));
        voltageGraph.setLayout(new java.awt.BorderLayout());

        pressureGraph.setSize(new java.awt.Dimension(300, 300));
        pressureGraph.setLayout(new java.awt.BorderLayout());

        airSpeedGraph.setSize(new java.awt.Dimension(300, 300));
        airSpeedGraph.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(teamNameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(altitudeGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(voltageGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pressureGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(airSpeedGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(airSpeedLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(softStateLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(teamIDLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(tempLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(voltageLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(pressureLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(gpsTimeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(14, 14, 14)
                        .addComponent(altitudeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(missionTimeLabel)))
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(tempGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(935, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(teamNameLabel)
                    .addComponent(jLabel4)
                    .addComponent(teamIDLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(altitudeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tempLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(voltageLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(softStateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(gpsTimeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(missionTimeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pressureLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(voltageGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altitudeGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(airSpeedLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(airSpeedGraph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pressureGraph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(354, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(tempGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(615, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel airSpeedGraph;
    private javax.swing.JLabel airSpeedLabel;
    private javax.swing.JPanel altitudeGraph;
    private javax.swing.JLabel altitudeLabel;
    private javax.swing.JLabel gpsTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel missionTimeLabel;
    private javax.swing.JPanel pressureGraph;
    private javax.swing.JLabel pressureLabel;
    private javax.swing.JLabel softStateLabel;
    private javax.swing.JLabel teamIDLabel;
    private javax.swing.JLabel teamNameLabel;
    private javax.swing.JPanel tempGraph;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JPanel voltageGraph;
    private javax.swing.JLabel voltageLabel;
    // End of variables declaration//GEN-END:variables
}

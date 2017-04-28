/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neuroph.netbeans.main;

import java.awt.BorderLayout;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.neuroph.core.data.DataSet;
import org.neuroph.util.DataSetStatistics;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.neuroph.netbeans.main//DataSetStat//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "DataSetStatTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "org.neuroph.netbeans.main.DataSetStatTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_DataSetStatAction",
        preferredID = "DataSetStatTopComponent"
)
@Messages({
    "CTL_DataSetStatAction=DataSetStat",
    "CTL_DataSetStatTopComponent=Dataset statistics",
    "HINT_DataSetStatTopComponent=This is a dataset statistics visualization"
})
public final class DataSetStatTopComponent extends TopComponent {

    private DataSetStatistics statistics;

    private boolean initialized = false;

    public DataSetStatTopComponent() {
        initComponents();
        setName(Bundle.CTL_DataSetStatTopComponent());
        setToolTipText(Bundle.HINT_DataSetStatTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graph = new javax.swing.JPanel();
        statisticsComboBox = new javax.swing.JComboBox<>();
        columnsComboBox = new javax.swing.JComboBox<>();
        histogramCheckBox = new javax.swing.JCheckBox();
        histogramBinsComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout graphLayout = new javax.swing.GroupLayout(graph);
        graph.setLayout(graphLayout);
        graphLayout.setHorizontalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        graphLayout.setVerticalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        statisticsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statisticsComboBoxItemStateChanged(evt);
            }
        });

        columnsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnsComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(histogramCheckBox, org.openide.util.NbBundle.getMessage(DataSetStatTopComponent.class, "DataSetStatTopComponent.histogramCheckBox.text")); // NOI18N
        histogramCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramCheckBoxActionPerformed(evt);
            }
        });

        histogramBinsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramBinsComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(DataSetStatTopComponent.class, "DataSetStatTopComponent.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DataSetStatTopComponent.class, "DataSetStatTopComponent.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(histogramCheckBox)
                    .addComponent(columnsComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 107, Short.MAX_VALUE)
                    .addComponent(statisticsComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(histogramBinsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statisticsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(histogramCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(histogramBinsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 249, Short.MAX_VALUE))
            .addComponent(graph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statisticsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statisticsComboBoxItemStateChanged
        if (initialized) {
            refreshChart();
        }
    }//GEN-LAST:event_statisticsComboBoxItemStateChanged

    private void columnsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnsComboBoxActionPerformed
        if (initialized) {
            refreshChart();
        }
    }//GEN-LAST:event_columnsComboBoxActionPerformed

    private void histogramCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histogramCheckBoxActionPerformed
        if (initialized) {
            refreshChart();
        }
    }//GEN-LAST:event_histogramCheckBoxActionPerformed

    private void histogramBinsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histogramBinsComboBoxActionPerformed
        if (initialized) {
            refreshChart();
        }
    }//GEN-LAST:event_histogramBinsComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> columnsComboBox;
    private javax.swing.JPanel graph;
    private javax.swing.JComboBox<String> histogramBinsComboBox;
    private javax.swing.JCheckBox histogramCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> statisticsComboBox;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    /**
     * Setup statistic and show chart for min statistic.
     *
     * @param statistics Dataset statistics.
     */
    public void openChart(DataSetStatistics statistics) {
        this.statistics = statistics;
        DataSet dataSet = statistics.getDataSet();
        this.resetDataSetColumnNames(dataSet);
        graph.setLayout(new BorderLayout());

        setComboBoxStatistics();
        setComboBoxColumns();
        setComboBoxHistogramBins();

        initialized = true;

        refreshChart();
    }

    /**
     * Refreshes chart panel for selected statistic.
     *
     */
    private void refreshChart() {
        boolean isHistogram = histogramCheckBox.isSelected();
        JFreeChart chart;
        if (isHistogram) {
            statisticsComboBox.setEnabled(false);
            columnsComboBox.setEnabled(true);
            histogramBinsComboBox.setEnabled(true);
            chart = this.createHistogramChart(createHistogramDataSet());
        } else {
            statisticsComboBox.setEnabled(true);
            columnsComboBox.setEnabled(false);
            histogramBinsComboBox.setEnabled(false);
            String statistic = statisticsComboBox.getSelectedItem().toString();
            chart = this.createBarChart(createBarChartDataSet(statistic));
        }

        ChartPanel chartPanel = new ChartPanel(chart);
        graph.removeAll();
        graph.add(chartPanel);
        graph.validate();
    }

    /**
     * Creates bar chart for given dataset.
     *
     * @param chartDataset Dataset to create bar chart from.
     * @return Created bar chart.
     */
    private JFreeChart createBarChart(DefaultCategoryDataset chartDataset) {
        String title = "Dataset statistic";
        String xAxis = "Statistics";
        String yAxis = "Value";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean legend = true;
        boolean toolTips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createBarChart(title, xAxis, yAxis,
                chartDataset, orientation, legend, toolTips, urls);

        return chart;
    }

    /**
     * Creates histogram chart for given dataset.
     *
     * @param chartDataset Dataset to create histogram chart.
     * @return Created histogram chart.
     */
    private JFreeChart createHistogramChart(HistogramDataset chartDataset) {
        String title = "Dataset statistic";
        String xAxis = "Statistics";
        String yAxis = "Value";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean legend = true;
        boolean toolTips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createHistogram(title, xAxis, yAxis,
                chartDataset, orientation, legend, toolTips, urls);

        return chart;
    }

    /**
     * Returns data set for given statistic.
     *
     * @param statistic Statistic for which to provide dataset.
     * @return Dataset for given statistic.
     */
    private DefaultCategoryDataset createBarChartDataSet(String statistic) {
        DefaultCategoryDataset chartDataset = new DefaultCategoryDataset();
        String[] columnNames = statistics.getDataSet().getColumnNames();
        double[] values;

        switch (statistic) {
            case DataSetStatistics.MIN:
                values = statistics.getMin();
                break;
            case DataSetStatistics.MAX:
                values = statistics.getMax();
                break;
            case DataSetStatistics.MEAN:
                values = statistics.getMean();
                break;
            case DataSetStatistics.SUM:
                values = statistics.getSum();
                break;
            case DataSetStatistics.STD_DEV:
                values = statistics.getStdDev();
                break;
            case DataSetStatistics.VAR:
                values = statistics.getVar();
                break;
            case DataSetStatistics.FREQ:
                values = statistics.getFrequency();
                break;
            default:
                values = statistics.getMean();
                break;
        }
        this.chartDataSetAddValues(chartDataset, values, statistic, columnNames);
        return chartDataset;
    }

    /**
     * Returns data set for give column index.
     *
     * @return Dataset for give column index.
     */
    private HistogramDataset createHistogramDataSet() {
        int columnIndex = Integer.parseInt(columnsComboBox.getSelectedItem().toString());
        int binsCount = Integer.parseInt(histogramBinsComboBox.getSelectedItem().toString());
        HistogramDataset chartDataset = new HistogramDataset();
        DataSet dataSet = statistics.getDataSet();
        int rowCount = dataSet.getRows().size();
        double[] values = new double[rowCount];

        for (int i = 0; i < rowCount; i++) {
            double[] row = dataSet.getRowAt(i).toArray();
            values[i] = row[columnIndex];
        }

        chartDataset.addSeries(dataSet.getColumnName(columnIndex), values, binsCount);
        return chartDataset;
    }

    /**
     * Fills dataset with provided values and keys.
     *
     * @param chartDataset Dataset to fill.
     * @param values Values to add to dataset.
     * @param key Column key for dataset.
     * @param columnNames Row keys for dataset.
     */
    private void chartDataSetAddValues(DefaultCategoryDataset chartDataset, double[] values, String key, String[] columnNames) {
        for (int i = 0; i < values.length; i++) {
            chartDataset.addValue(values[i], columnNames[i], key);
        }
    }

    /**
     * Resets column names where column names are null.
     *
     * @param dataSet Dataset on which to reset column names.
     */
    private void resetDataSetColumnNames(DataSet dataSet) {
        int inputSize = dataSet.getInputSize();
        int outputSize = dataSet.getOutputSize();
        for (int i = 0; i < inputSize; i++) {
            if (dataSet.getColumnName(i) == null) {
                dataSet.setColumnName(i, "Input" + (i + 1));
            }
        }
        for (int i = 0; i < outputSize; i++) {
            if (dataSet.getColumnName(inputSize + i) == null) {
                dataSet.setColumnName(inputSize + i, "Output" + (i + 1));
            }
        }
    }

    /**
     * Sets statistics combo box values.
     */
    private void setComboBoxStatistics() {
        statisticsComboBox.addItem(DataSetStatistics.MIN);
        statisticsComboBox.addItem(DataSetStatistics.MAX);
        statisticsComboBox.addItem(DataSetStatistics.MEAN);
        statisticsComboBox.addItem(DataSetStatistics.SUM);
        statisticsComboBox.addItem(DataSetStatistics.STD_DEV);
        statisticsComboBox.addItem(DataSetStatistics.VAR);
        statisticsComboBox.addItem(DataSetStatistics.FREQ);
    }

    /**
     * Sets column index combo box values.
     */
    private void setComboBoxColumns() {
        DataSet dataSet = statistics.getDataSet();
        int inputSize = dataSet.getInputSize();
        int outputSize = dataSet.getOutputSize();
        for (int i = 0; i < inputSize + outputSize; i++) {
            columnsComboBox.addItem(String.valueOf(i));
        }
    }

    /**
     * Sets histogram bins combo box values.
     */
    private void setComboBoxHistogramBins() {
        for (int i = 10; i <= 50; i += 10) {
            histogramBinsComboBox.addItem(String.valueOf(i));
        }
    }
}

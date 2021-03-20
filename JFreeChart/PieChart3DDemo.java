import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;


public class PieChart3DDemo extends ApplicationFrame {


private static final long serialVersionUID = 1L;

	public PieChart3DDemo(final String title) {

        super(title);
        final PieDataset dataset = createSampleDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 360));
        setContentPane(chartPanel);

    }
    

    private PieDataset createSampleDataset() {
        
        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Java", new Double(100));
        result.setValue("Visual Basic", new Double(100));
        result.setValue("C/C++", new Double(300));
        result.setValue("PHP", new Double(32.5));
        result.setValue("Perl", new Double(250));
        return result;
        
    }
    
    private JFreeChart createChart(final PieDataset dataset) {
        
        final JFreeChart chart = ChartFactory.createPieChart3D(
            "Pie Chart 3D Demo 3",  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("No data to display");
        plot.setLabelGenerator(null);
        return chart;
        
    }
    
    public static void main(final String[] args) {

        final PieChart3DDemo demo = new PieChart3DDemo("Pie Chart 3D Demo 3");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

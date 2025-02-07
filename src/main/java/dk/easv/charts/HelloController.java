package dk.easv.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private LineChart<Number, Number> chart;
    @FXML private Button btn;
    @FXML private PieChart pieChart;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void drawChartAction(ActionEvent event) {
        chart.getData().clear();
        //NumberAxis xAxis = new NumberAxis();
        //NumberAxis yAxis = new NumberAxis();
        Axis<Number> xAxis = chart.getXAxis();
        xAxis.setLabel("day");
        Axis<Number> yAxis = chart.getYAxis();
        yAxis.setLabel("drinks");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Drinks sold at EASV");
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("Drinks sold City centre");
        for (int i = 0; i <= 31; i++) {
            Random ran  = new Random();
            Number a = ran.nextInt(300);
            series.getData().add(new XYChart.Data<Number, Number>(i, a));
        }
        for (int i = 1; i <= 31; i++) {
            Random ran  = new Random();
            Number a = ran.nextInt(1000);
            series2.getData().add(new XYChart.Data<Number, Number>(i, a));
        }
        chart.getData().add(series);
        chart.getData().add(series2);

        // PIE CHART SETUP
        Random ran = new Random();
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Monday", ran.nextInt(100)+10),
                new PieChart.Data("Tuesday", ran.nextInt(100)+10),
                new PieChart.Data("Wednesday", ran.nextInt(100)+10),
                new PieChart.Data("Thursday", ran.nextInt(100)+10),
                new PieChart.Data("Friday", ran.nextInt(200)+10),
                new PieChart.Data("Saturday", ran.nextInt(300)+10),
                new PieChart.Data("Sunday", ran.nextInt(50)+10)

        );
        pieChart.setData(pieData);
    }
}
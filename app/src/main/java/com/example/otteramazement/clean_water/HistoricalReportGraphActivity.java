package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.NumberFormat;

/**
 * Created by Violet on 3/14/2017.
 */

public class HistoricalReportGraphActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report_graph);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF");
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Papyrus-LET-Bold.ttf");

        //setting fonts

        TextView title = (TextView) findViewById(R.id.historicalGraph_title);
        title.setTypeface(font);


        ImageView backButton = (ImageView) findViewById(R.id.historicalGraph_backbutton_imageView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getBaseContext(), HistoricalReportChoiceActivity.class);
                startActivity(backIntent);
            }
        });



        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Month");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Contaminate/Virus PPM");
//        graph.getViewport().setScrollable(true);
//        graph.getViewport().setScrollableY(true);
//        graph.getViewport().setScalable(true);
//        graph.getViewport().setScalableY(true);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.BOTH);

//        NumberFormat nf = NumberFormat.getInstance();
//        nf.setMaximumFractionDigits(0);
//        nf.setMinimumIntegerDigits(1);
//        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf, nf));

//        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//        staticLabelsFormatter.setHorizontalLabels(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
//        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        String[] horizantalAxisForm = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        StaticLabelsFormatter staticLabelsFormatter2 = new StaticLabelsFormatter(graph);
        staticLabelsFormatter2.setHorizontalLabels(horizantalAxisForm);
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter2);
        graph.getGridLabelRenderer().setNumHorizontalLabels(12);

        DataPoint[] valuesp = new DataPoint[WaterReportList.historicalReportList.size()];
        DataPoint[] valuesl = new DataPoint[WaterReportList.historicalReportList.size()];
        int index = 0;

        for(HistoricalReport report: WaterReportList.historicalReportList){

            int month = report.monthDate();
            int cont = report.getContaminant();
            DataPoint dp = new DataPoint(month, cont);
            valuesp[index] = dp;
            valuesl[index] = dp;
            index++;

        }

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(valuesp);
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(valuesl);


//        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, -2),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
        series2.setColor(Color.GREEN);
        graph.addSeries(series2);

//        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, -2),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
        graph.addSeries(series);
        series.setShape(PointsGraphSeries.Shape.POINT);


    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }
}

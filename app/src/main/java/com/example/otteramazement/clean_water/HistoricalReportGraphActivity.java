package com.example.otteramazement.clean_water;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

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
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.BOTH);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(1);
        graph.getViewport().setMaxX(13);

        graph.getViewport().setScrollable(true);

        DataPoint[] valuesp = new DataPoint[WaterReportList.historicalReportList.size()];
        DataPoint[] valuesl = new DataPoint[WaterReportList.historicalReportList.size()];
        int index = 0;

        for(HistoricalReport report: WaterReportList.historicalReportList){

            int monthPoint = report.monthDate();
            double cont = report.getContaminant();
            DataPoint dp = new DataPoint(monthPoint, cont);
            valuesp[index] = dp;
            valuesl[index] = dp;
            index++;

        }

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(valuesp);
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(valuesl);

        series2.setColor(Color.GREEN);
        graph.addSeries(series2);

        graph.addSeries(series);
        series.setShape(PointsGraphSeries.Shape.POINT);


    }

    @Override
    protected void onPause() {
        super.onPause();
        System.gc();
    }
}

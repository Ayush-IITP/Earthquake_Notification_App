package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hp on 12-03-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquakeinfo> {


    public EarthquakeAdapter(@NonNull Context context,@NonNull List<Earthquakeinfo> earthquakes) {
        super(context,0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemview = convertView;
        if(listitemview==null){
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.single_scrap_view,parent,false);
        }
        Earthquakeinfo earthquakeinfo = getItem(position);
        TextView magnitudeView = (TextView) listitemview.findViewById(R.id.tv1) ;
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(Double.parseDouble(earthquakeinfo.getmMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        TextView tv1 = (TextView)listitemview.findViewById(R.id.tv1);
        tv1.setText(earthquakeinfo.getmMagnitude());
        TextView tv2 = (TextView)listitemview.findViewById(R.id.tv2);
        tv2.setText(earthquakeinfo.getmMlocation());
        TextView tv3 = (TextView)listitemview.findViewById(R.id.tv3);
        tv3.setText(earthquakeinfo.getmDate());
        return listitemview;
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}

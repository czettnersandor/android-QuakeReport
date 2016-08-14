package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sandor on 14/08/16.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, int resource, List<Earthquake> earthquakes) {
        super(context, resource, earthquakes);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;

        // Create listViewItem if it's null. It happens when it's not recycled
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_listitem, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitude = (TextView) listViewItem.findViewById(R.id.magnitude);
        TextView location = (TextView) listViewItem.findViewById(R.id.location);
        TextView city = (TextView) listViewItem.findViewById(R.id.city);
        TextView date = (TextView) listViewItem.findViewById(R.id.date);
        TextView time = (TextView) listViewItem.findViewById(R.id.time);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magnitude.setText(String.format("%1$,.1f", currentEarthquake.getMagnitude()));

        String locationString =  currentEarthquake.getLocation();
        String[] locationParts = locationString.split("(?<= of )");

        if (locationParts.length >= 2) {
            location.setText(locationParts[0]);
            city.setText(locationParts[1].trim());
        } else {
            location.setText("");
            city.setText(locationParts[0].trim());
        }

        Date dateObject = new Date(currentEarthquake.getDate());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String dateToDisplay = dateFormatter.format(dateObject);
        String timeToDisplay = timeFormatter.format(dateObject);
        date.setText(dateToDisplay);
        time.setText(timeToDisplay);

        return listViewItem;
    }

    protected int getMagnitudeColor(double magnitude) {
        int magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
        if (magnitude >= 10) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        } else if (magnitude >= 9) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
        } else if (magnitude >= 8) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
        } else if (magnitude >= 7) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
        } else if (magnitude >= 6) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
        } else if (magnitude >= 5) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
        } else if (magnitude >= 4) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
        } else if (magnitude >= 3) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
        } else if (magnitude >= 2) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
        } else if (magnitude >= 0) {
            magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
        }
        return magnitudeColor;
    }
}

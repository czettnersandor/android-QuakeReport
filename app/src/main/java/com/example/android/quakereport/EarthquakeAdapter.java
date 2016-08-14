package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        Earthquake currentEartquake = getItem(position);

        TextView magnitude = (TextView) listViewItem.findViewById(R.id.magnitude);
        TextView city = (TextView) listViewItem.findViewById(R.id.city);
        TextView date = (TextView) listViewItem.findViewById(R.id.date);

        magnitude.setText(String.format("%1$,.2f", currentEartquake.getMagnitude()));
        city.setText(currentEartquake.getCity());
        date.setText(currentEartquake.getDate());

        return listViewItem;
    }
}

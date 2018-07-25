package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<MovieType> movieTypes;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieType> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieTypes = objects;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        ImageView ivRated = rowView.findViewById(R.id.imageView3);

        MovieType currentItem = movieTypes.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getYear() + "-" + currentItem.getGenre());


        if (currentItem.getRated().equalsIgnoreCase("g")) {
            ivRated.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRated().equalsIgnoreCase("pg")) {
            ivRated.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRated().equalsIgnoreCase("pg13")) {
            ivRated.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRated().equalsIgnoreCase("nc16")) {
            ivRated.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRated().equalsIgnoreCase("m18")) {
            ivRated.setImageResource(R.drawable.rating_m18);
        } else {
            ivRated.setImageResource(R.drawable.rating_r21);
        }
        return rowView;
    }
}

package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView tvTitle = findViewById(R.id.textViewTitle);
        TextView tvYear = findViewById(R.id.textViewDate);
        TextView tvDescription = findViewById(R.id.textViewDescription);
        TextView tvWatchOn = findViewById(R.id.textViewWatchedOn);
        TextView tvTheatre = findViewById(R.id.textViewInTheatre);
        ImageView ivRated = findViewById(R.id.imageView2);


        Intent intentRecieved = getIntent();
        String title = intentRecieved.getStringExtra("title");
        String year = intentRecieved.getStringExtra("year");
        String genre = intentRecieved.getStringExtra("genre");
        String theatre = intentRecieved.getStringExtra("theatre");
        String description = intentRecieved.getStringExtra("description");
        String date = intentRecieved.getStringExtra("date");
        String rated = intentRecieved.getStringExtra("rated");

        tvTitle.setText(title);
        tvYear.setText(year+" - "+genre);
        tvDescription.setText(description);
        tvTheatre.setText("In theatre: " + theatre);
        tvWatchOn.setText("Watch on: " + date);


        if (rated.equalsIgnoreCase("g") ){
            ivRated.setImageResource(R.drawable.rating_g);
        } else if (rated.equalsIgnoreCase("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        } else if (rated.equalsIgnoreCase("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        } else if (rated.equalsIgnoreCase("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        } else if (rated.equalsIgnoreCase("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        } else if (rated.equalsIgnoreCase("r21")){
            ivRated.setImageResource(R.drawable.rating_r21);
        }




    }
}

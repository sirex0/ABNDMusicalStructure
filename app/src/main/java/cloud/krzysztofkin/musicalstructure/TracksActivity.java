package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {
    ArrayList<Track> tracksOnList;
    Button playButton;
    Button albumButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracks_activity);
        Intent incomingIntent = getIntent();
        tracksOnList = incomingIntent.getParcelableArrayListExtra("tracksOnList");
        TracksAdapter adapter = new TracksAdapter(this, tracksOnList);
        ListView tracksListView = findViewById(R.id.track_list);
        tracksListView.setAdapter(adapter);
        playButton = findViewById(R.id.play_button);
        albumButton = findViewById(R.id.album_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(TracksActivity.this, PlayerActivity.class);
                playIntent.putParcelableArrayListExtra("tracksOnList", tracksOnList);
                startActivity(playIntent);
            }
        });
        albumButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(TracksActivity.this, MainActivity.class);
                startActivity(albumIntent);
            }
        });
    }
}

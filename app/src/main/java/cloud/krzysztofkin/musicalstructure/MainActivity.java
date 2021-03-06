package cloud.krzysztofkin.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    Button tracksButton;
    Button playButton;
    Tracks discography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create discography with sample data
        discography = new Tracks();
        discography.addSampleData(21, 5);
        AlbumAdapter adapter = new AlbumAdapter(this, discography);
        GridView albumGridView = findViewById(R.id.album_grid);
        albumGridView.setAdapter(adapter);
        tracksButton = findViewById(R.id.tracks_button);
        tracksButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent tracksIntent = new Intent(MainActivity.this, TracksActivity.class);
                tracksIntent.putParcelableArrayListExtra("tracksOnList", discography);
                startActivity(tracksIntent);
            }
        });
        playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playIntent.putParcelableArrayListExtra("tracksOnList", discography);
                startActivity(playIntent);
            }
        });
    }
}

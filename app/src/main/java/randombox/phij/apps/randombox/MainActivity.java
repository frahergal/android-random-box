package randombox.phij.apps.randombox;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import util.RAEDailyWorld;

public class MainActivity extends AppCompatActivity {

    private TextView mRaeDailyWorldText;
    private TextView mRaeDailyWorldDefinitionText;
    private Button mRaeDailyWorldUrlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        // Text views
        mRaeDailyWorldText = findViewById(R.id.rae_daily_world);
        mRaeDailyWorldDefinitionText = findViewById(R.id.rae_daily_world_definition);

        // Buttons
        mRaeDailyWorldUrlButton = findViewById(R.id.rae_daily_world_url_btn);

        // Daily World
        final RAEDailyWorld rae = new RAEDailyWorld();
        mRaeDailyWorldText.setText(rae.getDailyWorld());
        mRaeDailyWorldUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = rae.getDailyWorldUrl();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
}

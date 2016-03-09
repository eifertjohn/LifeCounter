package john.lifecounter;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String PLAYER_ONE_LIFE = "firstLife";
    static final String PLAYER_TWO_LIFE = "secondLife";

    Button btnFirstIncrease, btnFirstDecrease, btnSecondIncrease, btnSecondDecrease;
    Button btnNewGame;
    int playerFirstLife, playerSecondLife;

    TextView txtFirstLife, txtSecondLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFirstLife = (TextView)findViewById(R.id.txtFirstLife);
        txtSecondLife = (TextView)findViewById(R.id.txtSecondLife);

        btnFirstDecrease = (Button) findViewById(R.id.btnFirstDecrease);
        btnFirstIncrease = (Button) findViewById(R.id.btnFirstIncrease);
        btnSecondDecrease = (Button) findViewById(R.id.btnSecondDecrease);
        btnSecondIncrease = (Button) findViewById(R.id.btnSecondIncrease);

        btnNewGame = (Button) findViewById(R.id.btnNewGame);

        btnFirstDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerFirstLife -=1;
                updateLife();
            }
        });

        btnFirstIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerFirstLife += 1;
                updateLife();
            }
        });

        btnSecondDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerSecondLife-=1;
                updateLife();
            }
        });

        btnSecondIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerSecondLife +=1;
                updateLife();
            }
        });

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                updateLife();
            }
        });

        txtFirstLife = (TextView)findViewById(R.id.txtFirstLife);
        txtSecondLife = (TextView)findViewById(R.id.txtSecondLife);

        newGame();
        updateLife();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void newGame(){
        playerFirstLife = 20;
        playerSecondLife = 20;
    }

    private void updateLife(){
        txtFirstLife.setText(String.valueOf(playerFirstLife));
        txtSecondLife.setText(String.valueOf(playerSecondLife));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(PLAYER_ONE_LIFE, playerFirstLife);
        savedInstanceState.putInt(PLAYER_TWO_LIFE, playerSecondLife);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        playerFirstLife = savedInstanceState.getInt(PLAYER_ONE_LIFE);
        playerSecondLife = savedInstanceState.getInt(PLAYER_TWO_LIFE);
        updateLife();
    }
}

package com.example.salim_000.mohamedsalim_reaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class multiplayerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final playerManager players = new playerManager();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_screen);
        int buttonsNumber = 2;

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            buttonsNumber = extras.getInt("EXTRA_NUMBER_BUTTONS");
        }

        LinearLayout multiplayerGrid = (LinearLayout) findViewById(R.id.multiplayerGrid);

        for(int i = 0; i < buttonsNumber; i++)
        {
            Button newButton = new Button(this);
            newButton.setId(View.generateViewId());
            newButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
            final int finalButtonsNumber = buttonsNumber;
            final int finalI = i;
            newButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    players.updatePlayers(finalI +1, finalButtonsNumber);
                    AlertDialog.Builder endBuilder = new AlertDialog.Builder(multiplayerScreen.this);
                    endBuilder.setMessage("The winner is Player " + (finalI+1));
                    endBuilder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    Dialog endDialog = endBuilder.create();
                    endDialog.show();
                }
            });
            newButton.setText("Player " + (finalI + 1));
            multiplayerGrid.addView(newButton);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multiplayer_screen, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

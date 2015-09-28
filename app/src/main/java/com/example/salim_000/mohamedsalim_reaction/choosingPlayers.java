package com.example.salim_000.mohamedsalim_reaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class choosingPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_players);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choosing_players, menu);
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

    public void create2Buttons(View view){
        Intent intent = new Intent(this, multiplayerScreen.class);
        startActivity(intent);
    }

    public void create3Buttons(View view){
        Intent intent = new Intent(this, multiplayerScreen.class);
        startActivity(intent);
    }

    public void create4Buttons(View view){
        Intent intent = new Intent(this, multiplayerScreen.class);
        startActivity(intent);
    }
}

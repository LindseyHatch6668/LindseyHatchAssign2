package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class LindseyActivity extends AppCompatActivity {
    private Menu menu;
    String store = " ";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lindseyactivity);
        ActionBar actionBar = getActionBar();
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LindseyActivity.this, HatchActivity1.class);
                intent.putExtra("key", store);
                startActivity(intent);
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.lindseyradioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                MenuItem menuItem = menu.findItem(R.id.pizza);
                RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
                RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
                if (rb1.isChecked()) {
                    store = getString(R.string.pizza_pizza);
                    menuItem.setIcon(R.drawable.pizzapizza);
                }
                else if(rb2.isChecked()) {
                    store = getString(R.string.dominos_pizza);
                    menuItem.setIcon(R.drawable.dominos);
                }
                else if(rb3.isChecked()) {
                    store = getString(R.string.pizza_hut);
                    menuItem.setIcon(R.drawable.pizzahut);
                }
                else {
                    store = "default";
                    menuItem.setIcon(R.drawable.pizza);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Uri url2;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.lindseyhelp:
                Uri url = Uri.parse(getString(R.string.help_link));
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, url);
                startActivity(launchBrowser);
                return true;
            case R.id.pizza:
                if (store.equalsIgnoreCase(getString(R.string.pizza_hut))) {
                    url2 = Uri.parse(getString(R.string.pizza_hut_link));
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else if(store.equalsIgnoreCase(getString(R.string.pizza_pizza))) {
                    url2 = Uri.parse(getString(R.string.pizza_pizza_link));
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else if(store.equalsIgnoreCase(getString(R.string.dominos_pizza))) {
                    url2 = Uri.parse(getString(R.string.dominos_link));
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.select_store), Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.name:
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), R.string.screen_snackbar, Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
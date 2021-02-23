package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HatchActivity1 extends AppCompatActivity {
    private Menu menu;
    Button button;
    public static String storeMenu;
    final static String DEFAULT_VALUE = "Default";
    public static String style = DEFAULT_VALUE;
    public static String size = DEFAULT_VALUE;
    public static String cheese = DEFAULT_VALUE;
    public static String blackOlives = DEFAULT_VALUE;
    public static String redPepper = DEFAULT_VALUE;
    public static String greenPepper = DEFAULT_VALUE;
    public static String pepperoni = DEFAULT_VALUE;
    public static boolean statusBool = false;
    public static boolean toppingsBool = false;
    public static boolean sizeBool = false;
    public static boolean styleBool = false;
    public static ArrayList<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hatchactivity1);
        Intent intent;
        intent = getIntent();

        String inputText = intent.getStringExtra("key");
        String store = inputText;
        storeMenu = store;
        TextView textView;
        textView = (TextView) findViewById(R.id.lindseytextView);
        textView.setText(String.valueOf(inputText));

        // Selects the style of pizza
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton4);
                if (rb1.isChecked()) {
                    style = getString(R.string.thin_crust_text);
                }
                else if(rb2.isChecked()) {
                    style = getString(R.string.thick_crust_text);
                }
            }
        });

        // Selects the size of pizza
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroupSize);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton5);
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton6);
                RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton7);
                if (rb1.isChecked()) {
                   size = getString(R.string.small_text);
                }
                else if(rb2.isChecked()) {
                    size = getString(R.string.medium_text);
                }
                else if(rb2.isChecked()) {
                    size = getString(R.string.large_text);
                }
            }
        });

        // Selects the toppings for the pizza
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                   cheese = getString(R.string.cheese_text);
                }
            }
        });

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topping1;
                if(((CheckBox)v).isChecked())
                {
                    pepperoni = getString(R.string.pepperoni_text);
                }
            }
        });

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    blackOlives = getString(R.string.black_olives_text);
                }
            }
        });

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    greenPepper = getString(R.string.green_pepper_text);
                }
            }
        });

        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    redPepper = getString(R.string.red_pepper_text);
                }
            }
        });

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (checkStatus()) {
                    values.add(store);
                    values.add(size);
                    values.add(style);
                    Intent intent = new Intent(HatchActivity1.this, HatchActivity2.class);
                    intent.putExtra("key", values);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.select_options), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.pizza);
        if(storeMenu.equalsIgnoreCase(getString(R.string.pizza_pizza_text))) {
            menuItem.setIcon(R.drawable.pizzapizza);
        } else if(storeMenu.equalsIgnoreCase(getString(R.string.dominos_pizza_text))) {
            menuItem.setIcon(R.drawable.dominos);
        } else if(storeMenu.equalsIgnoreCase(getString(R.string.pizza_hut_text))) {
            menuItem.setIcon(R.drawable.pizzahut);
        } else {
            menuItem.setIcon(R.drawable.pizza);
        }
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
                if (storeMenu.equalsIgnoreCase(getString(R.string.pizza_hut))) {
                    url2 = Uri.parse(getString(R.string.pizza_hut_link));
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else if(storeMenu.equalsIgnoreCase(getString(R.string.pizza_pizza))) {
                    url2 = Uri.parse(getString(R.string.pizza_pizza_link));
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else if(storeMenu.equalsIgnoreCase(getString(R.string.dominos_pizza))) {
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
            case android.R.id.home:
                Intent intent = new Intent(HatchActivity1.this, LindseyActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Resets all the values when the screen is resumed
        statusBool = false;
        toppingsBool = false;
        sizeBool = false;
        styleBool = false;
        style = DEFAULT_VALUE;
        size = DEFAULT_VALUE;
        cheese = DEFAULT_VALUE;
        blackOlives = DEFAULT_VALUE;
        redPepper = DEFAULT_VALUE;
        greenPepper = DEFAULT_VALUE;
        pepperoni = DEFAULT_VALUE;
    }
    // Function checks the status of all the selections and makes sure everything has been selected
    public static boolean checkStatus() {
        if(!redPepper.equalsIgnoreCase(DEFAULT_VALUE)) {
            toppingsBool = true;
            values.add(redPepper);
        }
        if(!greenPepper.equalsIgnoreCase(DEFAULT_VALUE)) {
            toppingsBool = true;
            values.add(greenPepper);
        }
        if(!blackOlives.equalsIgnoreCase(DEFAULT_VALUE)) {
            toppingsBool = true;
            values.add(blackOlives);
        }
        if(!pepperoni.equalsIgnoreCase(DEFAULT_VALUE)) {
            toppingsBool = true;
            values.add(pepperoni);
        }
        if(!cheese.equalsIgnoreCase(DEFAULT_VALUE)) {
            toppingsBool = true;
            values.add(cheese);
        }

        if(!size.equalsIgnoreCase(DEFAULT_VALUE)) {
            sizeBool = true;
        }
        if(!style.equalsIgnoreCase(DEFAULT_VALUE)) {
            styleBool = true;
        }
        if(toppingsBool && styleBool && sizeBool) {
            statusBool = true;
        }
        return statusBool;
    }
}
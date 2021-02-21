package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class HatchActivity2 extends AppCompatActivity {
    public static String storeMenu;
    private Menu menu;
    final static String DEFAULT_VALUE = "Default";
    public static String name = DEFAULT_VALUE;
    public static String phone = DEFAULT_VALUE;
    public static String address = DEFAULT_VALUE;
    public static String creditCard = DEFAULT_VALUE;
    public static String province = DEFAULT_VALUE;
    Button button;
    Spinner spin;
    EditText phoneText, addressText, creditCardText, nameText;
    Intent intent;
    ArrayList<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch2);
        ArrayList<String> passed = (ArrayList) getIntent().getSerializableExtra("key");
        int x = passed.size();
        storeMenu = passed.get(x-1);
        button = findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nameText = (EditText) findViewById(R.id.lindseynameEdit);
                name = nameText.getText().toString();

                phoneText = (EditText) findViewById(R.id.phoneEnter);
                phone = phoneText.getText().toString();

                addressText = (EditText) findViewById(R.id.addressEnter);
                address = addressText.getText().toString();

                creditCardText= (EditText) findViewById(R.id.lindseyPaymentEnter);
                creditCard = creditCardText.getText().toString();

                spin = (Spinner)findViewById(R.id.select_province);
                TextView textView = (TextView)spin.getSelectedView();
                province = textView.getText().toString();

                if(name.length()>=3 && creditCard.length() == 16 && !address.equalsIgnoreCase(DEFAULT_VALUE) && phone.length() == 10 && !province.equalsIgnoreCase(DEFAULT_VALUE)) {
                    int x = passed.size();
                    values.add(name);
                    values.add(creditCard);
                    values.add(address);
                    values.add(phone);
                    values.add(province);
                    values.add(passed.get(x-3));
                    values.add(passed.get(x-2));
                    values.add(passed.get(x-1));
                    intent = new Intent(HatchActivity2.this, HatchActivity3.class);
                    intent.putExtra("key", values);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please review info and try again", Toast.LENGTH_LONG).show();
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
        if(storeMenu.equalsIgnoreCase("pizza pizza")) {
            menuItem.setIcon(R.drawable.pizzapizza);
        } else if(storeMenu.equalsIgnoreCase("domino's Pizza")) {
            menuItem.setIcon(R.drawable.dominos);
        } else if(storeMenu.equalsIgnoreCase("pizza hut")) {
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
                Uri url = Uri.parse("https://stackoverflow.com/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, url);
                startActivity(launchBrowser);
                return true;
            case R.id.pizza:
                if (storeMenu.equalsIgnoreCase("pizza hut")) {
                    url2 = Uri.parse("https://www.pizzahut.ca/");
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else if(storeMenu.equalsIgnoreCase("pizza pizza")) {
                    url2 = Uri.parse("https://www.pizzapizza.ca/store/1/delivery");
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else if(storeMenu.equalsIgnoreCase("Domino's Pizza")) {
                    url2 = Uri.parse("https://www.dominos.ca/en/");
                    Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, url2);
                    startActivity(launchBrowser2);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select a store first", Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.name:
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), R.string.screen_snackbar, Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            case android.R.id.home:
                Intent intent = new Intent(HatchActivity2.this, LindseyActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Resets all the values when the screen is resumed
        phone = DEFAULT_VALUE;
        province = DEFAULT_VALUE;
        address = DEFAULT_VALUE;
        creditCard = DEFAULT_VALUE;
    }
}
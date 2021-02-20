package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class HatchActivity2 extends AppCompatActivity {
    final static String DEFAULT_VALUE = "Default";
    public static String name = DEFAULT_VALUE;
    public static String phone = DEFAULT_VALUE;
    public static String address = DEFAULT_VALUE;
    public static String creditCard = DEFAULT_VALUE;
    public static String province = DEFAULT_VALUE;
    Button button;
    Spinner spin;
    EditText phoneText, addressText, creditCardText, nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch2);
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
                    Log.d("Set", "Values set");
                } else {
                    Toast.makeText(getApplicationContext(), "Please review info and try again", Toast.LENGTH_LONG).show();
                }
            }
        });
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
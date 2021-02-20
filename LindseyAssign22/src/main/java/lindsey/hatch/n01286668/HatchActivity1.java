package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HatchActivity1 extends AppCompatActivity {
    Button button;
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
        setContentView(R.layout.activity_hatch1);
        Intent intent;
        intent = getIntent();

        String inputText = intent.getStringExtra("key");
        String store = inputText;
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
                    style = "Thin Crust";
                }
                else if(rb2.isChecked()) {
                    style = "Thick Crust";
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
                   size = "Small";
                }
                else if(rb2.isChecked()) {
                    size = "Medium";
                }
                else if(rb2.isChecked()) {
                    size = "Large";
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
                   cheese = "Cheese";
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
                    pepperoni = "Pepperoni";
                }
            }
        });

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    blackOlives = "Black Olives";
                }
            }
        });

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    greenPepper = "Green Pepper";
                }
            }
        });

        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    redPepper = "Red Pepper";
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
                    Toast.makeText(getApplicationContext(), "Select options", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
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
    public static String style = "Default";
    public static String size = "Default";
    public static String cheese = "Default";
    public static String blackOlives = "Default";
    public static String redPepper = "Default";
    public static String greenPepper = "Default";
    public static String pepperoni = "Default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch1);
        ArrayList<String> toppings = new ArrayList<>();
        Intent intent;
        intent = getIntent();

        String inputText = intent.getStringExtra("key");
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
                    Intent intent = new Intent(HatchActivity1.this, LindseyActivity.class);
                    intent.putExtra("key", toppings);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Select options", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Function checks the status of all the selections and makes sure everything has been selected
    public static boolean checkStatus() {
        boolean statusBool = false;
        boolean toppingsBool = false;
        boolean sizeBool = false;
        boolean styleBool = false;
        if(!redPepper.equalsIgnoreCase("Default")) {
            toppingsBool = true;
        }
        if(!greenPepper.equalsIgnoreCase("Default")) {
            toppingsBool = true;
        }
        if(!blackOlives.equalsIgnoreCase("Default")) {
            toppingsBool = true;
        }
        if(!pepperoni.equalsIgnoreCase("Default")) {
            toppingsBool = true;
        }
        if(!cheese.equalsIgnoreCase("Default")) {
            toppingsBool = true;
        }

        if(!size.equalsIgnoreCase("Default")) {
            sizeBool = true;
        }
        if(!style.equalsIgnoreCase("Default")) {
            styleBool = true;
        }
        if(toppingsBool==true && styleBool==true && sizeBool==true) {
            statusBool = true;
        }
        return statusBool;
    }
}
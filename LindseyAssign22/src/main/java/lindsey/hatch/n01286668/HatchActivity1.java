package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HatchActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch1);
        ArrayList<String> order = new ArrayList<>();
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
                    order.add("Thin Crust");
                }
                else if(rb2.isChecked()) {
                    order.add("Thick Crust");
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
                    order.add("Small");
                }
                else if(rb2.isChecked()) {
                    order.add("Medium");
                }
                else if(rb2.isChecked()) {
                    order.add("Large");
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
                    order.add("Cheese");
                }
            }
        });

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    order.add("Pepperoni");
                }
            }
        });

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    order.add("Black Olives");
                }
            }
        });

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    order.add("Green Pepper");
                }
            }
        });

        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    order.add("Red Pepper");
                }
            }
        });
    }
}
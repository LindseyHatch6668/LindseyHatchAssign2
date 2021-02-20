package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HatchActivity3 extends AppCompatActivity {
    TextView nameText, phoneText, addressText, creditText, provinceText, sizeText, styleText, storeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch3);
        ArrayList<String> values = (ArrayList<String>) getIntent().getSerializableExtra("key");
        nameText = findViewById(R.id.reviewName);
        nameText.setText(String.valueOf(values.get(0)));

        creditText = findViewById(R.id.reviewCredit);
        creditText.setText(String.valueOf(values.get(1)));

        addressText = findViewById(R.id.reviewAddress);
        addressText.setText(String.valueOf(values.get(2)));

        phoneText = findViewById(R.id.reviewPhone);
        phoneText.setText(String.valueOf(values.get(3)));

        provinceText = findViewById(R.id.reviewProvince);
        provinceText.setText(String.valueOf(values.get(4)));

        storeText = findViewById(R.id.reviewStore);
        storeText.setText(String.valueOf(values.get(5)));

        sizeText = findViewById(R.id.reviewSize);
        sizeText.setText(String.valueOf(values.get(6)));

        styleText = findViewById(R.id.reviewStyle);
        styleText.setText(String.valueOf(values.get(7)));
    }
}
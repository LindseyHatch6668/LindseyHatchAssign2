package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HatchActivity2 extends AppCompatActivity {
    String[] provinces = {"Alberta",
            "British Columbia",
            "Manitoba",
            "New Brunswick",
            "Northwest Territories",
            "Nova Scotia",
            "Nunavut",
            "Ontario",
            "Prince Edward Island",
            "Quebec",
            "Saskatchewan",
            "Yukon"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch2);
    }
}
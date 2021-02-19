package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HatchActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatch1);

        Intent intent;
        intent = getIntent();

        String inputText = intent.getStringExtra("key");
        TextView textView;
        textView = (TextView) findViewById(R.id.lindseytextView);
        textView.setText(String.valueOf(inputText));
    }
}
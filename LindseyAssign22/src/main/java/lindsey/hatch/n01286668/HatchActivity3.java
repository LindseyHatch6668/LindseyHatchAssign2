package lindsey.hatch.n01286668;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HatchActivity3 extends AppCompatActivity {
    TextView nameText, phoneText, addressText, creditText, provinceText, sizeText, styleText, storeText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hatchactivity3);
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

        button = (Button)findViewById(R.id.confirmOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle(R.string.your_order);
                alertDialogBuilder
                        .setMessage(getString(R.string.pickup_confirm))
                        .setCancelable(false)
                        .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                setContentView(R.layout.lindseyactivity);
                            }
                        })
                        .setNegativeButton(R.string.review, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), getString(R.string.review_selections),
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
    }
}
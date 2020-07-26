package apps.goingcrazy.mathsucks;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.DragEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView tipPercent = findViewById(R.id.tipPercentValue), tipValue = findViewById(R.id.tip), totalBill = findViewById(R.id.totalBillValue);
        final EditText billInput = findViewById(R.id.editBillText);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        Button calcButton = findViewById(R.id.calculateButton);
        tipPercent.setText(seekBar.getProgress() + "%");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tipPercent.setText(seekBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        calcButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              try{
                  float billValue = Float.parseFloat(billInput.getText().toString());
                  float tipPercent = seekBar.getProgress()/(float) 100;
                  float tip = billValue * tipPercent;
                  float totalBillValue = tip + billValue;

                  tipValue.setText("$"+ String.format(Locale.ENGLISH, "%.2f", tip));
                  totalBill.setText("$"+ String.format(Locale.ENGLISH, "%.2f", totalBillValue));


              } catch(NumberFormatException e){
                  System.out.println("Converstion Error");
              }
          }
        }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
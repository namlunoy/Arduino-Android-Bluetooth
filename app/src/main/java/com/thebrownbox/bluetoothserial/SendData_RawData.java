package com.thebrownbox.bluetoothserial;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SendData_RawData extends AppCompatActivity {
    private TextView txtData;

    public void clickSend(View v){
        //Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
        SendData.myBluetooth.send(txtData.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data__raw_data);

        txtData = (TextView) findViewById(R.id.txtData);

        MyHelper.showBanner(this,R.id.adView_raw);


        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
        // Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();
    }



}

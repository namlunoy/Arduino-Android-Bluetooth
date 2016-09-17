package com.thebrownbox.bluetoothserial;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SendData_LED extends AppCompatActivity {
    private boolean isClickToOn = true;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data__led);
        button = (Button)findViewById(R.id.button_led);
        button.setBackgroundColor(Color.rgb(0,255,0));
        // Load an ad into the AdMob banner view.
        MyHelper.showBanner(this,R.id.adView_led);
        SendData.myBluetooth.send("0");
    }



    public void clickOn(View v){
        if(isClickToOn){
            button.setText("OFF (0)");
            button.setBackgroundColor(Color.rgb(255,0,0));
            SendData.myBluetooth.send("1");
        }else{
            button.setText("ON (1)");
            button.setBackgroundColor(Color.rgb(0,255,0));
            SendData.myBluetooth.send("0");
        }

        isClickToOn = !isClickToOn;
    }

}

package com.thebrownbox.bluetoothserial;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class SendData_RGB extends AppCompatActivity {

    class RgbButton{
        public RgbButton(Button button, char c){
            this.button = button;
            this.isOn = false;
            this.colorOff = Color.GRAY;
            switch (c){
                case 'R':
                    color = Color.rgb(255,0,0);
                    txtOn = "RED - R";
                    ON = "R";
                    OFF = "r";
                    txtOff = "red - r";
                    break;
                case 'G':
                    ON = "G";
                    OFF = "g";
                    txtOn = "GREEN - G";
                    txtOff = "green - g";
                    color = Color.rgb(0,255,0);
                    break;
                case 'B':
                    ON = "B";
                    OFF = "b";
                    txtOn = "BLUE - B";
                    txtOff = "blue - b";
                    color = Color.rgb(0,0,255);
                    break;
            }

            off();
            this.button.setTextColor(Color.WHITE);
        }
        public Button button;
        public boolean isOn = false;
        private char c;
        private String ON;
        private String OFF;
        private int color;
        private int colorOff;
        private String txtOn;
        private String txtOff;

        public void doSwitch(){
            if(isOn){
                // Turn off
                off();
            }else{
                // Turn on
                on();
            }
        }

        private void off(){
            isOn = false;
            this.button.setBackgroundColor(color);
            this.button.setText(txtOn);
            SendData.myBluetooth.send(OFF);
        }

        private void on(){
            isOn = true;
            this.button.setBackgroundColor(colorOff);
            this.button.setText(txtOff);
            SendData.myBluetooth.send(ON);
        }
    }

    private Button btRed;
    private Button btGreen;
    private Button btBlue;

    private Map<Integer, RgbButton> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data__rgb);

        // Load an ad into the AdMob banner view.
        MyHelper.showBanner(this, R.id.adView_rgb);
        map = new HashMap<>();

        btBlue = (Button) findViewById(R.id.bt_blue);
        btGreen = (Button) findViewById(R.id.bt_green);
        btRed = (Button) findViewById(R.id.bt_red);

        map.put(R.id.bt_blue, new RgbButton(btBlue,'B'));
        map.put(R.id.bt_green, new RgbButton(btGreen,'G'));
        map.put(R.id.bt_red, new RgbButton(btRed,'R'));
    }

    public void onClick(View v) {
        RgbButton bt = map.get(v.getId());
        if(bt != null){
           bt.doSwitch();
        }
    }
}

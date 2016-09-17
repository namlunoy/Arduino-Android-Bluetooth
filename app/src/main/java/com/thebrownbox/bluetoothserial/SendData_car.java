package com.thebrownbox.bluetoothserial;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SendData_car extends AppCompatActivity {
    class CarButton implements View.OnTouchListener {
        private Button button;
        private String signal;
        private String OFF = "-";
        private MyBluetooth bluetooth;

        public CarButton(Button button, String signal, MyBluetooth bluetooth) {
            this.button = button;
            this.signal = signal;
            this.bluetooth = bluetooth;
            this.button.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    bluetooth.send(signal);
                    break;
                case MotionEvent.ACTION_UP:
                    bluetooth.send(OFF);
                    break;
            }
            return false;
        }
    }

    private List<CarButton> carButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data_car);

        MyHelper.showBanner(this, R.id.adView_car);
        carButtons = new ArrayList<>();
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_q), "Q", SendData.myBluetooth));
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_w), "W", SendData.myBluetooth));
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_e), "E", SendData.myBluetooth));

        carButtons.add(new CarButton((Button) findViewById(R.id.bt_a), "A", SendData.myBluetooth));
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_s), "S", SendData.myBluetooth));
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_d), "D", SendData.myBluetooth));

        carButtons.add(new CarButton((Button) findViewById(R.id.bt_z), "Z", SendData.myBluetooth));
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_x), "X", SendData.myBluetooth));
        carButtons.add(new CarButton((Button) findViewById(R.id.bt_c), "C", SendData.myBluetooth));
    }

}

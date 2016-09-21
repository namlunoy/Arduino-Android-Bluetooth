package com.thebrownbox.bluetoothserial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SendData extends AppCompatActivity {

    private ListView listView;
    private ArrayList controls;
    public static MyBluetooth myBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_data);
        myBluetooth = new MyBluetooth(getApplicationContext(), MainActivity.bluetoothAdapter, MainActivity.selectedDevice);
        MyHelper.showBanner(this,R.id.adView_senddata);
        controls = new ArrayList<>();
        controls.add("Send data");
        controls.add("LED Controller");
        controls.add("LED RGB Controller");
        controls.add("Car Controller");
        controls.add("Customize your own");

        listView = (ListView) findViewById(R.id.listViewControl);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, controls);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent(getApplicationContext(), SendData_RawData.class);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), SendData_LED.class);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), SendData_RGB.class);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), SendData_car.class);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), Customize.class);
                        break;
                    default:
                        break;
                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        myBluetooth.close();
        super.onDestroy();
    }
}

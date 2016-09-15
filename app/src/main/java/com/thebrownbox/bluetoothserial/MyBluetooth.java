package com.thebrownbox.bluetoothserial;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by hoangcong on 9/16/16.
 */
public class MyBluetooth {
    private Context context;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice bluetoothDevice;
    private BluetoothSocket bluetoothSocket;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    public MyBluetooth(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        this.bluetoothAdapter = bluetoothAdapter;
        this.bluetoothDevice = bluetoothDevice;
        this.context = context;

        try {
            this.bluetoothSocket = this.bluetoothDevice.createInsecureRfcommSocketToServiceRecord(MY_UUID);
            this.bluetoothSocket.connect();

        }catch (Exception ex){
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(context,"FAILED: "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void send(String data){
        try {
            OutputStream outputStream = this.bluetoothSocket.getOutputStream();
            outputStream.write(data.getBytes());
        }catch (Exception ex){
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(context,"FAILED: "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void connect(){
        try {
            bluetoothSocket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            bluetoothSocket.close();
        } catch (IOException e) {
            Toast.makeText(context,"FAILED: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}

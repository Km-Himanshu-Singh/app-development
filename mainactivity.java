package com.example.wifi_turn_on_off;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw=(Switch)findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    mywifiControl(true);
                    Toast.makeText(MainActivity.this,"Wifi On",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mywifiControl(false);
                    Toast.makeText(MainActivity.this,"Wifi Off",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void mywifiControl(boolean b) {
        WifiManager wifiobj=(WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if((b==true) && !(wifiobj.isWifiEnabled()))
        {
            wifiobj.setWifiEnabled(true);
        }
        else if ((b==false ) &&wifiobj.isWifiEnabled())
        {
            wifiobj.setWifiEnabled(false);
        }
    }
}

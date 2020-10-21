package com.aj.android.chromeversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String package_name="com.android.chrome";
    private ImageView icon;
    private TextView name_text,version_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_text= findViewById(R.id.app_name);
        version_text= findViewById(R.id.version);
        icon= findViewById(R.id.imageView);
        try {
            Drawable img=getPackageManager().getApplicationIcon(package_name);
            PackageInfo pinfo =getPackageManager().getPackageInfo(package_name,0);
            String name= (String) getPackageManager().getApplicationLabel(pinfo.applicationInfo);
            String version=pinfo.versionName;
            icon.setImageDrawable(img);
            name_text.setText(name);
            version_text.setText(version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
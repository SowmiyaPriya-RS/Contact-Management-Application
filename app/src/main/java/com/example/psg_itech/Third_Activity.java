package com.example.psg_itech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Third_Activity extends AppCompatActivity {

    ImageButton bt_call, whats, sms, mail;
    private TextView tvtittle, tvdesignation, tvdepartment, tvqualification;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);

        tvtittle = (TextView) findViewById(R.id.txtname);
        tvdesignation = (TextView) findViewById(R.id.txtdesi);
        tvdepartment = (TextView) findViewById(R.id.txtdept);
        tvqualification = (TextView) findViewById(R.id.txtquali);
        img = (ImageView) findViewById(R.id.txtimage);

        bt_call = findViewById(R.id.bt_call);
        whats = findViewById(R.id.whats);
        sms = findViewById(R.id.sms);
        mail = findViewById(R.id.mail);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String designation = intent.getExtras().getString("designation");
        String department = intent.getExtras().getString("department");
        String qualification = intent.getExtras().getString("qualification");
        String contact = intent.getExtras().getString("contact");
        String email = intent.getExtras().getString("email");
        String image = intent.getExtras().getString("image");

        tvtittle.setText(name);
        tvdesignation.setText(designation);
        tvdepartment.setText(department);
        tvqualification.setText(qualification);

        Glide.with(this).load(image).into(img);

        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(contact);
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail(email);
            }
        });

        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsapp(contact);
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message(contact);
            }
        });

    }

    public void call(String phoneNumber)
    {
        String s = "tel:" + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(s));
        startActivity(intent);
    }

    public void mail(String address) {
        String add = address;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + add));
        intent.putExtra(Intent.EXTRA_EMAIL, add);
        startActivity(intent);

    }

    public void message(String phoneNumber) {
        String number = phoneNumber;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("smsto:"));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address" , new String (number));
        startActivity(intent);

    }

    public void whatsapp(String phoneNumber) {
        String number = phoneNumber;
        boolean installed = isAppInstalled("com.whatsapp");
        if (installed) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+91" + number + "&text="));
            intent.setPackage("com.whatsapp");
            startActivity(intent);
        } else {
            System.out.println("failed");
        }
    }

    public boolean isAppInstalled(String url) {
        PackageManager packageManager = getApplicationContext().getPackageManager();
        boolean installed;
        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
}
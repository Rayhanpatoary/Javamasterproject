package com.example.rayhanpatoary.learnjavabangla;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        set_dashboard();


        LinearLayout item1 = findViewById(R.id.item1);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_basic_java_activity();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    void start_basic_java_activity(){
        Intent intent = new Intent(MainActivity.this,basic_java.class);
        startActivity(intent);
    }
    private void set_dashboard() {
        set_item1();
        set_item2();
        set_item3();
        set_item4();
        set_item5();

    }

    private void set_item1() {

        LinearLayout item1 = findViewById(R.id.item1);
        TextView item1text1 = (TextView)item1.findViewById(R.id.text1);
        item1text1.setText("ব্যাসিক জাভা প্রোগ্রামিং");
        item1text1.setBackgroundResource(R.drawable.basic_image);
        TextView item1text2 = (TextView)item1.findViewById(R.id.text2);
        item1text2.setText("Variable , if else ,Loop , array etc");

    }


    private void set_item2() {

        LinearLayout item2 = findViewById(R.id.item2);
        TextView item2text1 = (TextView)item2.findViewById(R.id.text1);
        item2text1.setText("অবজেক্ট ওরিয়েন্টেড প্রোগ্রামিং ");
        item2text1.setBackgroundResource(R.drawable.oop_image);;
        TextView item2text2 = (TextView)item2.findViewById(R.id.text2);
        item2text2.setText("Inheritance , Interface , Polymorphysom ,Encapsolation");
    }
    private void set_item3() {
        LinearLayout item3 = findViewById(R.id.item3);
        TextView item3text1 = (TextView)item3.findViewById(R.id.text1);
        item3text1.setText("এডভান্স জাভা");
        item3text1.setBackgroundResource(R.drawable.advance_java);;
        TextView item3text2 = (TextView)item3.findViewById(R.id.text2);
        item3text2.setText("Exeption Hadling, import i/o");
    }
    @SuppressLint("ResourceAsColor")
    private void set_item4() {
        LinearLayout item4 = findViewById(R.id.item4);
        TextView item4text1 = (TextView)item4.findViewById(R.id.text1);
        item4text1.setText("জাভার বিভিন্ন ফ্রেমওয়ার্ক পরিচিতি");
        item4text1.setBackgroundResource(R.drawable.java_frameworks);

        TextView item4text2 = (TextView)item4.findViewById(R.id.text2);
        item4text2.setText("Spring Boot , Spring MVC,GWT, JSF, Play framework etc");
    }
    private void set_item5() {
        LinearLayout item5 = findViewById(R.id.item5);
        TextView item5text1 = (TextView)item5.findViewById(R.id.text1);
        item5text1.setText("জাভা সার্টিফিকেশন এক্সাম");
        item5text1.setBackgroundResource(R.drawable.certification);

        TextView item5text2 = (TextView)item5.findViewById(R.id.text2);
        item5text2.setText("Oracle (APEX)");
    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            // Handle the camera action
        } else if (id == R.id.nav_instruction) {



        } else if (id == R.id.nav_codeing_Zone) {

        } else if (id == R.id.nav_progress) {

        }
        else if(id == R.id.nav_about_developer){

        }
        else if (id == R.id.nav_send_feedback) {


        } else if (id == R.id.nav_community) {
            Intent fb_group = getOpenFacebookIntent(MainActivity.this);
            startActivity(fb_group);

        }
        else  if(id == R.id.nav_share){
            show_share_options();

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void show_share_options() {


            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));


    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://group/1582442718522576"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/জাভার-মাস্টার-743906392616446/?modal=admin_todo_tour"));
        }
    }

}

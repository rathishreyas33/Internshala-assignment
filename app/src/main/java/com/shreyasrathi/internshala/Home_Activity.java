package com.shreyasrathi.internshala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.shreyasrathi.internshala.model.User;
import com.shreyasrathi.internshala.ui.main.SectionsPagerAdapter;

public class Home_Activity extends AppCompatActivity implements fragment1.onFragmentBtnSelected,fragment2.onFragmentButtonSelected, NavigationView.OnNavigationItemSelectedListener{

    private User user;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    TextView tvloggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        tvloggedUser = headerView.findViewById(R.id.loggedUserName);
        Intent i= getIntent();
        if(!i.getStringExtra("User").equals(""))
        {
            tvloggedUser.setText(i.getStringExtra("User"));
        }
        //user = (User) getIntent().getSerializableExtra("User");

        //if (user != null){
          //  tvloggedUser.setText(user.getEmail());
        //}

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //naviation menu enable item clicking
        navigationView.setNavigationItemSelectedListener(this);
        //
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    @Override
    public void onButtonSelectedCall() {
        Intent obj = new Intent(Intent.ACTION_DIAL);
        String a = "9123456789";
        obj.setData(Uri.parse("tel:+91"+a));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions

            return;
        }
        startActivity(obj);

    }

    @Override
    public void onButtonSelectedMail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:abcde@xyz.com"));
        startActivity(emailIntent);

    }

    @Override
    public void onButtonClickedGallery() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId()==R.id.log_out){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
        return true;
    }

}

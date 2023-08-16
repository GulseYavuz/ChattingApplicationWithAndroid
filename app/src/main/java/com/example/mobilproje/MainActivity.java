package com.example.mobilproje;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView);
        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Clinique");
        setSupportActionBar(toolbar);

        bottomNav = findViewById(R.id.bottomNav);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(bottomNav, navHostFragment.getNavController());
        NavigationUI.setupWithNavController(navigationView, navHostFragment.getNavController());

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar,0,0);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        View baslik = navigationView.inflateHeaderView(R.layout.navigation_baslik);
        TextView textViewBaslik = baslik.findViewById(R.id.textViewBaslik);
        textViewBaslik.setText("Merhaba");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
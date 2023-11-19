package com.example.easyreach;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyreach.Helperclass.CategoriesAdapter;
import com.example.easyreach.Helperclass.CategoriesHelperClass;
import com.example.easyreach.Helperclass.FeaturedAdapter;
import com.example.easyreach.Helperclass.FeaturedHelperClass;
import com.example.easyreach.Helperclass.MostviwedAdapter;
import com.example.easyreach.Helperclass.MostviwedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity  {
    RecyclerView featuredRecycler;
    RecyclerView mostviwedRecycler, categoriesRecycler;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageButton service, repairs, edu, elec;

    RecyclerView.Adapter adapter;
    private Toolbar supportActionBar;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();

        mostviwedRecycler = findViewById(R.id.mostviewd_recycler);
        mostviwedRecycler();

        categoriesRecycler = findViewById(R.id.categories_Recycler);
        categoriesRecycler();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);



        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        // hide or show
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        service = findViewById(R.id.service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, services.class);
                startActivity(intent);
                finish();
            }
        });

        repairs=findViewById(R.id.repairs);
        repairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, repairs.class);
                startActivity(intent);
                finish();
            }
        });
        edu=findViewById(R.id.edu);
        edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, education.class);
                startActivity(intent);
                finish();
            }
        });

        elec=findViewById(R.id.elec);
        elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, repairs.class);
                startActivity(intent);
                finish();
            }
        });





    }


    private void categoriesRecycler() {


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.img3, "Delivery Services"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.img2, "Electrical services"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.img1, "Different services"));

        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }

    private void mostviwedRecycler() {
        mostviwedRecycler.setHasFixedSize(true);
        mostviwedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostviwedHelperClass> mostviwedLocations = new ArrayList<>();
        mostviwedLocations.add(new MostviwedHelperClass(R.drawable.img3, "DELIVERY SERVICES", "Swift and secure deliveries, bringing convenience to your doorstep "));
        mostviwedLocations.add(new MostviwedHelperClass(R.drawable.img1, "CLEANING SERVICE", "Spotless spaces, simplified. Elevate hygiene with our cleaning service."));
        mostviwedLocations.add(new MostviwedHelperClass(R.drawable.img2, "ELECTRICAL SERVICE", "Safe, reliable electrical solutions for your peace of mind."));

        adapter = new MostviwedAdapter(mostviwedLocations);
        mostviwedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.img2, "ELECTRICAL REPAIR", "Safe, reliable electrical solutions for your peace of mind."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.img1, "CLEANING SERVICE", "Spotless spaces, simplified. Elevate hygiene "));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.img3, "DELIVERY SERVICE", "Swift and secure deliveries, bringing convenience to your doorstep"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



}
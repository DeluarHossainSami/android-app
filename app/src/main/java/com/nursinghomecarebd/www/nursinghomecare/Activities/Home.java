package com.nursinghomecarebd.www.nursinghomecare.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nursinghomecarebd.www.nursinghomecare.R;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CardView doctorCard, nurseCard, babyCard, oxygenCard, medicalCard; //new add
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ini


        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        doctorCard = (CardView) findViewById(R.id.Doctor_cardId);//new add
        nurseCard = (CardView) findViewById(R.id.Nurse_cardId);//new add
        babyCard = (CardView) findViewById(R.id.Baby_cardId);//new add
        oxygenCard = (CardView) findViewById(R.id.Oxygen_cardId);//new add
        medicalCard = (CardView) findViewById(R.id.Medical_cardId);//new add

        doctorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Home.this, "Doctor selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DoctorActivity.class);
                startActivity(intent);

            }
        });

        nurseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Home.this, "Nurse selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);

            }
        });

        babyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Baby selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), BabyActivity.class);
                startActivity(intent);
            }
        });

        oxygenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Oxygen selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), OxygenActivity.class);
                startActivity(intent);
            }
        });
        medicalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Medical selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MedicalActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Feedback.class);
                startActivity(intent);
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        updateNavHeader();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Toast.makeText(Home.this, "Setting selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Feedback.class);
            startActivity(intent);

            return true;
        } else if (id == R.id.action_callId) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:01719661366"));
            startActivity(intent);

        } else if (id == R.id.action_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "Nursing Home Care App";
            String body = "This is very helpful to home care service.";
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "share with"));
            return true;
        } else if (id == R.id.action_feedback) {
            Intent intent = new Intent(getApplicationContext(), Feedback.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //clear stack
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);


        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_policy) {
            Intent intent = new Intent(getApplicationContext(), PrivacyActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_conditions) {

            Intent intent = new Intent(getApplicationContext(), TermActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_about_us) {

            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_contract) {
            Intent intent = new Intent(getApplicationContext(), ContractActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_location) {
            Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {

            FirebaseAuth.getInstance().signOut();
            Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginActivity);
            finish();


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateNavHeader() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.nav_username);
        TextView navUserMail = headerView.findViewById(R.id.nav_user_mail);
        ImageView navUserPhot = headerView.findViewById(R.id.nav_user_photo);

        navUserMail.setText(currentUser.getEmail());

        navUsername.setText(currentUser.getDisplayName());


        //now we will use Glide to load user image
        // first we need to import the library


        Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhot);


    }


}


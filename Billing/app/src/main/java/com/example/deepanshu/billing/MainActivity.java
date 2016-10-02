package com.example.deepanshu.billing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Button b ;
    CheckBox cb1 ;CheckBox cb2 ;CheckBox cb3 ;CheckBox cb4 ;
    TextView output ;
    EditText qsand , qpizza ,qchow , qhb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        b = (Button) findViewById(R.id.button) ;
        output  = (TextView) findViewById(R.id.total);
        cb1 = (CheckBox) findViewById(R.id.cbsand) ;cb2 = (CheckBox) findViewById(R.id.cbpizza) ;
        cb3 = (CheckBox) findViewById(R.id.cbhb) ;cb4 = (CheckBox) findViewById(R.id.cbchow) ;
        qsand = (EditText) findViewById(R.id.tsand) ;
        qpizza = (EditText) findViewById(R.id.tpizza) ;
        qchow = (EditText) findViewById(R.id.tchow) ;
        qhb = (EditText) findViewById(R.id.thb) ;

        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                int amount = 0 ;
                int qofsand = Integer.parseInt(qsand.getText().toString()) ;
                int qofpizza = Integer.parseInt(qpizza.getText().toString()) ;
                int qofhb = Integer.parseInt(qhb.getText().toString()) ;
                int qofchow = Integer.parseInt(qchow.getText().toString()) ;

                if(cb1.isChecked()){
                    amount+=60*qofsand;
                    //output.setText(Integer.toString(amount));
                }
                if(cb2.isChecked()){
                    amount+=200*qofpizza ;
                    //output.setText(Integer.toString(amount));
                }
                if(cb3.isChecked()){
                    amount+=80*qofhb ;
                    //output.setText(Integer.toString(amount));
                }
                if(cb4.isChecked()){
                    amount+=100*qofchow ;
                    //output.setText(Integer.toString(amount));
                }
                    /*int a1 = Integer.parseInt(nu1.getText().toString()) ;
                    int b1 = Integer.parseInt(nu2.getText().toString()) ;
                    int res = a1 +b1 ;*/
                output.setText("Rs. "+Integer.toString(amount));

            }
        });





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Coding..... .", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        int id = item.getItemId();

        /*if (id == R.id.@+id/navi_bill) {
            // Handle the camera action

        } else */if (id == R.id.nav_price) {
            Intent intent = new Intent(this, EditPrice.class);
            startActivity(intent);
        } else if (id == R.id.nav_contacts) {
            Intent intent = new Intent(this,Contact.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

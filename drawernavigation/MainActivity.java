package com.solution.drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
ImageButton imageButton;
NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idfind();
    }

    private void idfind() {
        drawerLayout=findViewById(R.id.drawer);
       imageButton=findViewById(R.id.meat);

        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new FirstFragments()).commit();
                        Toast.makeText(MainActivity.this, "First", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item2:
                      getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new SecondFragments()).commit();
                        Toast.makeText(MainActivity.this, "Second", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.item3:
                      getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,new ThirdFragments()).commit();
                        Toast.makeText(MainActivity.this, "Third", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                }
        });
        drawerLayout.closeDrawer(GravityCompat.START);
//if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//    imageButton.setTextOn("Off");
//}
//else
//    toggle.setTextOn("Off");
  }
}
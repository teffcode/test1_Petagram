package com.coursera.tefa.appmascotas;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.coursera.tefa.appmascotas.R;
import com.coursera.tefa.appmascotas.menu.ActivityMenuContacto;
import com.coursera.tefa.appmascotas.menu.ScrollingActivityMenuAcercaDe;
import com.coursera.tefa.appmascotas.Activity_Secundaria;

public class ActivityPrincipal extends AppCompatActivity {

    /*ArrayList<Contacto> contactos;
  private RecyclerView listaContactos;
  public ContactoAdapter adapter;*/
    private Toolbar toolbar;
   // private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

       // setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("  "+"Petagram");
            getSupportActionBar().setIcon(R.drawable.cat_footprint_52);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        getMenuInflater().inflate(R.menu.menu_opciones_contacto_acercade, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.Star:

                Intent intent = new Intent(this, Activity_Secundaria.class);
                startActivity(intent);

                break;

            case R.id.menuContacto:

                Intent intent_1 = new Intent(this, ActivityMenuContacto.class);
                startActivity(intent_1);

                break;

            case R.id.menuAcercaDe:

                Intent intent_2 = new Intent(this, ScrollingActivityMenuAcercaDe.class);
                startActivity(intent_2);

                break;
        }

        return super.onOptionsItemSelected(item);
    }


}

package com.example.alanflores.menusapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //Hold click
    private Button buttonMenuContextual;
    private Button buttonMenuPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMenuContextual = (Button) findViewById(R.id.button_menu_contextual);
        buttonMenuPopUp = (Button) findViewById(R.id.button_menu_popup);

        registerForContextMenu(buttonMenuContextual);
        buttonMenuPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menuPopUp = new PopupMenu(MainActivity.this,v);
                menuPopUp.setOnMenuItemClickListener(eventoPopUp);
                MenuInflater inflater = menuPopUp.getMenuInflater();
                inflater.inflate(R.menu.menu_main, menuPopUp.getMenu());
                menuPopUp.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add(menu.NONE, 100, menu.NONE, "Cerrar App");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add(menu.NONE, 100, menu.NONE, "Cerrar App");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.contactos){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(intent);
        }else if(id == R.id.llamar){
            //You can call whe you want
            //Intent intent = new Intent(Intent.ACTION_ANSWER, Uri.parse("tel:5555555"));
            //automatically
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5555555"));
            startActivity(intent);
        }else if(id == R.id.ver_mapa){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.50,-96.90"));
            startActivity(intent);
        }else if(id == R.id.navegar){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://omnius.com.mx"));
            startActivity(intent);
        }if(id == 100){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.contactos){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(intent);
        }else if(id == R.id.llamar){
            //You can call whe you want
            //Intent intent = new Intent(Intent.ACTION_ANSWER, Uri.parse("tel:5555555"));
            //automatically
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5555555"));
            startActivity(intent);
        }else if(id == R.id.ver_mapa){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.50,-96.90"));
            startActivity(intent);
        }else if(id == R.id.navegar){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://omnius.com.mx"));
            startActivity(intent);
        }if(id == 100){
            finish();
        }
        return super.onContextItemSelected(item);
    }

    private PopupMenu.OnMenuItemClickListener eventoPopUp = new PopupMenu.OnMenuItemClickListener(){
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.contactos){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(intent);
            }else if(id == R.id.llamar){
                //You can call whe you want
                //Intent intent = new Intent(Intent.ACTION_ANSWER, Uri.parse("tel:5555555"));
                //automatically
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5555555"));
                startActivity(intent);
            }else if(id == R.id.ver_mapa){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.50,-96.90"));
                startActivity(intent);
            }else if(id == R.id.navegar){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://omnius.com.mx"));
                startActivity(intent);
            }

            return false;
        }
    };
}

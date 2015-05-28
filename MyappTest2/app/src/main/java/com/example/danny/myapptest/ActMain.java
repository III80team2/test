package com.example.danny.myapptest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;


public class ActMain extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InicialComponent();

        new Thread(new Runnable(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    try{
                        Calendar calendar=Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        setTitle(simpleDateFormat.format(calendar.getTime()));
                        Thread.sleep(1000);

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
    private static final int MENU_Login = Menu.FIRST;
    //private static final int MENU_Add = Menu.FIRST + 1;
    private static final int MENU_About = Menu.FIRST + 1;
    private static final int MENU_exit = Menu.FIRST + 2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


            menu.add(0, MENU_Login, 0, "登入");
           // menu.add(0, MENU_Add, 0,"註冊");
            menu.add(0, MENU_About, 0, "關於我們");
            menu.add(0, MENU_exit, 0,"離開本系統");

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch(item.getItemId()) {
            case MENU_Login:
//撰寫點選此選單要執行的功能，例如：變更標題列...
                Intent intent = new Intent(ActMain.this,LoginMain.class);
                startActivity(intent);
                break;


            case MENU_exit :
//結束此程式
                new AlertDialog.Builder(ActMain.this)
                        .setTitle("離開本系統")
                        .setMessage("是否確定?")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,int which) {

                                finish();

                            }
                        })
                        .setNegativeButton("取消",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,int which)
                                    {

                                    }
                                }).show();


                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }


    View.OnClickListener btnlogin_click=new View.OnClickListener(){
        public void onClick(View arg0) {

            Intent intent = new Intent(ActMain.this,LoginMain.class);
            startActivity(intent);
        }
    };

    View.OnClickListener btnMap_click=new View.OnClickListener(){
        public void onClick(View arg0) {

            Uri uri = Uri.parse("geo:22.638692,120.397787,3a,75y,343.8h,71.11t");	//經緯度
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };

    View.OnClickListener btnSc_click=new View.OnClickListener(){
        public void onClick(View arg0) {

            Intent intent1 = new Intent(ActMain.this,ActTodo.class);
            startActivity(intent1);

        }
    };


   //----離開對話框
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(ActMain.this)
                    .setTitle("離開本系統")
                    .setMessage("是否確定?")

                    .setPositiveButton("確定",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    finish();
                                }
                            })
                    .setNegativeButton("取消",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {


                                }

                            }).show();
        }

        return true;

    }


    private void InicialComponent()
    {

        btnlogin = (ImageButton) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(btnlogin_click);

        btnMap = (ImageButton) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(btnMap_click);

        btnSc = (ImageButton) findViewById(R.id.btnSc);
        btnSc.setOnClickListener(btnSc_click);

        textTime1 = (EditText)findViewById(R.id.txtId);

    }


    EditText textTime1;


    ImageButton btnSc;
    ImageButton btnMap;
    ImageButton btnlogin;

}

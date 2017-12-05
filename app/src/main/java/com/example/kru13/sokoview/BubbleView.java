package com.example.kru13.sokoview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Gastovsky on 01.12.2017.
 */

public class BubbleView extends View {

    Bitmap b3;
    Bitmap b4;
    Bitmap[] bmp;
    int kostka1bmp=0;
    int kostka2bmp=0;

    //Player[] ac=new Player[5];

    Player play1=new Player();
    Player play2=new Player();
    int player1x=600;
    int player1y=615;
    int player2x=605;
    int player2y=615;

    int activeplayer=1;

    int player1pos=0;
    int player2pos=0;
    private int diameter;
    private int x;
    private int y;
    private ShapeDrawable bubble;

    Handler handler = new Handler();


    float x1=0;
    float y1=0;

    public BubbleView(Context context) {
        super(context);
        init(context);
        //createBubble();
    }
    public BubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        //createBubble();
    }

    public BubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        //createBubble();
    }



    private void animation(int player, int rychlost){
        if(activeplayer==1){
            for(int i=0;i<98;i++) {
                player1x -= 1;
                Log.d("lol","EEEE");

            }
        }
    }

    private void kostka1(int cislo){
        if(cislo==1){
            kostka1bmp=0;
        }
        else if(cislo==2){
            kostka1bmp=1;
        }
        else if(cislo==3){
            kostka1bmp=2;
        }
        else if(cislo==4){
            kostka1bmp=3;
        }
        else if(cislo==5){
            kostka1bmp=4;
        }
        else if(cislo==6){
            kostka1bmp=5;
        }
        invalidate();
    }

    private void kostka2(int cislo){
        if(cislo==1){
            kostka2bmp=0;
        }
        else if(cislo==2){
            kostka2bmp=1;
        }
        else if(cislo==3){
            kostka2bmp=2;
        }
        else if(cislo==4){
            kostka2bmp=3;
        }
        else if(cislo==5){
            kostka2bmp=4;
        }
        else if(cislo==6){
            kostka2bmp=5;
        }
        invalidate();
    }

    private void pohyb() {
        int random=random();
        kostka1(random);
        int random2=random();
        kostka2(random2);
        for(int i=0;i<random+random2;i++){
            player1pos+=1;
            if(player1pos<=6){
                //Toast.makeText(getContext(), "LOL"+player1pos,Toast.LENGTH_SHORT).show();
                player1x-=98;
            }

            if(player1pos>=7&&player1pos<13){
                //Toast.makeText(getContext(), player1pos,Toast.LENGTH_SHORT).show();
                player1y-=98;
            }
            if(player1pos>=13&&player1pos<19){
                //Toast.makeText(getContext(), player1pos,Toast.LENGTH_SHORT).show();
                player1x+=98;
            }
            if(player1pos>=19){
                //Toast.makeText(getContext(), player1pos,Toast.LENGTH_SHORT).show();
                player1y+=98;
            }
            if (player1pos==24){
                player1pos=0;
            }
            invalidate();
        }
        if(activeplayer==1){
            activeplayer=2;
        }
        else activeplayer=1;

        //player1y+=50;

    }

    public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:{
                x1=touchevent.getX();
                y1=touchevent.getY();
                //Toast.makeText(getContext(), "x: " +x1 + ":y:"+y1,Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "x: "+play1.hodnota(),Toast.LENGTH_SHORT).show();
                break;
            }
            case MotionEvent.ACTION_UP:{
                pohyb();
                break;
            }
        }
        return true;
    }

    private int random(){
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        return n;
    }

    void init(Context context) {
        bmp = new Bitmap[6];

        bmp[0] = BitmapFactory.decodeResource(getResources(), R.drawable.k1);
        bmp[1] = BitmapFactory.decodeResource(getResources(), R.drawable.k2);
        bmp[2] = BitmapFactory.decodeResource(getResources(), R.drawable.k3);
        bmp[3] = BitmapFactory.decodeResource(getResources(), R.drawable.k4);
        bmp[4] = BitmapFactory.decodeResource(getResources(), R.drawable.k5);
        bmp[5] = BitmapFactory.decodeResource(getResources(), R.drawable.k6);

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //bubble.draw(canvas);
        Paint paint = new Paint();

        paint.setColor(Color.RED);
       /* canvas.drawCircle(player1x, player1y, 20, paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(player2x, player2y, 20, paint);*/
        /*canvas.drawBitmap(bmp[1], null,
                new Rect(100,100,100,100), null);*/
        Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.klobouk);
        paint.setColor(Color.RED);
        canvas.drawBitmap(b, player1x, player1y, paint);
        Bitmap b2=BitmapFactory.decodeResource(getResources(), R.drawable.zehlicka);
        paint.setColor(Color.RED);
        canvas.drawBitmap(b2, player2x, player2y, paint);
        b3=BitmapFactory.decodeResource(getResources(), R.drawable.k1);
        //paint.setColor(Color.RED);
        canvas.drawBitmap(bmp[kostka1bmp], 800, 500, paint);
        b4=BitmapFactory.decodeResource(getResources(), R.drawable.k1);
        //paint.setColor(Color.RED);
        canvas.drawBitmap(bmp[kostka2bmp], 1000, 500, paint);
    }
    protected void move(float f, float g) {
        x = (int) (x + f);
        y = (int) (y + g);

        if(f>11||f<8) {
            Toast.makeText(getContext(), "x: " + g + " f " + f, Toast.LENGTH_SHORT).show();
            //player1x+=random();
            pohyb();
        }


    }
}

package com.example.lili.emptyactivity.dessin;

import android.content.Context;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Rect;

/**
 * Created by lili on 31/10/2017.
 */

public class CustomView extends View {
    private Rect rectangle;
    private Paint paint;
    private Frome [] tabForms;

    public CustomView(Context context, Frome[] tabForms) {
        super(context);
        this.tabForms = tabForms;
        paint=new Paint();
        paint.setColor(Color.BLUE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);
        for(Frome form : tabForms)
        {
            form.afficher(canvas);
        }
    }

}

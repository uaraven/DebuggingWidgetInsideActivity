package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RemoteViews;

public class MyActivity extends Activity {
    private LinearLayout widgetHolder;
    private View widgetView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        widgetHolder = (LinearLayout) findViewById(R.id.widget_view);
    }

    public void onInflateClick(View v) {
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.widget);
        views.setImageViewResource(R.id.image, R.drawable.img1);
        views.setTextViewText(R.id.text, "Widget created");
        widgetView = views.apply(this, null);
        widgetHolder.addView(widgetView);
    }

    public void onUpdateClick(View v) {
        onUpdateWidget(0);
    }

    public void onUpdateWidget(int widgetId) {
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.widget);
        views.setImageViewResource(R.id.image, R.drawable.img2);
        views.setTextViewText(R.id.text, "Widget updated");

        // Tell the AppWidgetManager to perform an update on the current app widget
        updateWidget(widgetId, views);
    }

    private void updateWidget(int widgetId, RemoteViews views) {
        views.reapply(this, widgetView);
        // appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}

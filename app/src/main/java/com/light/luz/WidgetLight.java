package com.light.luz;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.RemoteViews;

/**
 * Do the widget function. It turn on/off the light since the widget interface.
 * @author juanma
 *
 */
public class WidgetLight extends AppWidgetProvider {

	public static String ACTION_WIDGET_RECEIVER_LIGHT = "ActionReceiverWidgetLight";
    private static final String ACTION_LIGHT = "com.light.luz.action.LIGHT";

    private static boolean serviceRunning = false;
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		// Actualizar el widget
		final int N = appWidgetIds.length;
		for (int i=0; i<N; i++) {
	        int appWidgetId = appWidgetIds[i];
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
					R.layout.widget);
			
			Intent active = new Intent(context, WidgetLight.class);
			active.setAction(ACTION_WIDGET_RECEIVER_LIGHT);
	
			PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context,appWidgetId, active,  PendingIntent.FLAG_UPDATE_CURRENT);
			remoteViews.setOnClickPendingIntent(R.id.light_img,actionPendingIntent);
			
			appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {

		try{
            // Create an transparent instent
            if (intent.getAction().equals(ACTION_WIDGET_RECEIVER_LIGHT)) {
                Intent transIntent = new Intent(context, MainTransparentActivity.class);
                transIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(transIntent);
            }
         }catch(Exception e){
            //Control error
         }
		super.onReceive(context, intent);
	}
}
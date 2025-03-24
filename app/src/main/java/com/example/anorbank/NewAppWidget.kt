package com.example.anorbank

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [NewAppWidgetConfigureActivity]
 */
class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

@SuppressLint("RemoteViewLayout")
internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    val createPendingIntent = { intent: Intent ->
        PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
    }

    val callIntent = getCallIntent(context, "+998555030000")
    views.setOnClickPendingIntent(R.id.img_call, createPendingIntent(callIntent))

    val telegramIntent = getTelegramIntent()
    views.setOnClickPendingIntent(R.id.img_tg, createPendingIntent(telegramIntent))

    val webUrl = "https://www.anorbank.uz/"
    val webIntent = getWebUrlIntent(webUrl)
    views.setOnClickPendingIntent(R.id.img_web, createPendingIntent(webIntent))

    appWidgetManager.updateAppWidget(appWidgetId, views)
}

fun getCallIntent(context: Context, phoneNumber: String): Intent {
    return Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
}
fun getCallIntent(phoneNumber: String): Intent {
    return Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
}

fun getTelegramIntent(): Intent {
    return Intent(Intent.ACTION_VIEW, Uri.parse("tg://https://t.me/AnorBankSupportBot"))
}

fun getWebUrlIntent(webUrl: String): Intent {
    return Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
}
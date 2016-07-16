

/* inserir o package aqui */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

import java.util.Random;

public class NotificationUtil {
    public static void create(Context context,
                              CharSequence title,
                              CharSequence mensagem,
                              Intent intent){

        Notification notification = null;

        Random aleatorio = new Random();
        int id = aleatorio.nextInt(1000);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, id, intent, PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title)
                .setContentText(mensagem)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        notification = builder.build();

        NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        id = aleatorio.nextInt(1000);

        manager.notify(id, notification);

    }
}

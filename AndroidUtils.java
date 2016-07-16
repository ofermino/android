package ofermino.com.projetoajudemeaajudar;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by root on 06/07/16.
 */
public class AndroidUtils {

    private static AlertDialog alertDialog;

    public static boolean isNetWorkAvailable(Context context){

        try{
            ConnectivityManager connectivity = (ConnectivityManager)
            context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectivity == null){
                return  false;
            }else{
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if(info != null){
                    for(int i = 0; i < info.length; i++){
                        if(info[i].getState() == NetworkInfo.State.CONNECTED){
                            return  true;

                        }
                    }
                }

            }
        }catch (SecurityException e){

            alertDialog(context,e.getClass().getSimpleName(),e.getMessage());
        }
        return false;
    }

    private static void alertDialog(Context context, String simpleName, String message) {
        alertDialog(context, simpleName, message);
    }


}

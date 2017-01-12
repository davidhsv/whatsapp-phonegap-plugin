package mobi.moica.whatsapp;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class Whatsapp extends CordovaPlugin {
    public static final String ACTION_WHATSAPP_SEND = "send";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_WHATSAPP_SEND.equals(action)) {
                   String send_to = args.getString(0);
             
                   Intent sendIntent = new Intent("android.intent.action.MAIN");
                   sendIntent.setComponent(new  ComponentName("com.whatsapp","com.whatsapp.Conversation"));
                   sendIntent.putExtra("jid", send_to +"@s.whatsapp.net");
                   this.cordova.getActivity().startActivity(sendIntent);
             
                   callbackContext.success();
                   return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
}

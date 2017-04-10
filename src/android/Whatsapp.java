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
             
                   this.cordova.getActivity().startActivity(new Intent("android.intent.action.VIEW",
                        Uri.parse("https://api.whatsapp.com/send?phone=" + destionationNumber)));

                    try {
                        View currentFocus = getCurrentFocus();
                        if (currentFocus != null) {
                            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                        }
                        callbackContext.success();
                        return true;
                    } catch (Exception e2) {
                        callbackContext.success();
                        return true;
                    }
                   
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

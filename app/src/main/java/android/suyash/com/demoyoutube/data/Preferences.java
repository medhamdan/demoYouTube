package android.suyash.com.demoyoutube.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    SharedPreferences preferences;
    Context ctx;


    public Preferences(Context prefscontext) {
        // super();
        this.ctx = prefscontext;
        preferences = prefscontext.getSharedPreferences("android.suyash",
                Context.MODE_PRIVATE);
    }

    public void saveEmailId(String emailId) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PreferenceNames.emailID, emailId);
        editor.commit();
    }

    /**
     * retrieves PrivacyPolicy
     */
    public String getEmailId() {
        return preferences.getString(PreferenceNames.emailID, "");
    }

    public interface PreferenceNames {
        String emailID = "emailID";

    }

}

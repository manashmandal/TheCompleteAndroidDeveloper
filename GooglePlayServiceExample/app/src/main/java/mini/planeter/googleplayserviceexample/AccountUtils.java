package mini.planeter.googleplayserviceexample;

/**
 * Created by Manash on 2/6/2016.
 */

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthUtil;

public class AccountUtils {

    private static final String KEY_ACCOUNT_NAME = "account_name";

    private static String currentUser = null;

    public static Account getGoogleAccountByName(Context context, String accountName){
        if (accountName != null){
            AccountManager accountManager = AccountManager.get(context);
            Account[] accounts = accountManager.getAccountsByType(GoogleAuthUtil
                    .GOOGLE_ACCOUNT_TYPE);
            for (Account account : accounts){
                if (accountName.equals(account.name)){
                    return account;
                }
            }
        }
        return null;
    }

    public static String getAccountName(Context context){
        if (currentUser != null){
            return currentUser;
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences
                (context);
        return sharedPreferences.getString(KEY_ACCOUNT_NAME, null);
    }

    public static void setAccountName(Context context, String accountName){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        editor.putString(KEY_ACCOUNT_NAME, accountName);
        editor.apply();
        currentUser = accountName;
    }

    public static void removeAccount(Context context){

    }
}

package trabalhocompmovel.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import trabalhocompmovel.di.ApplicationContext;
import trabalhocompmovel.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName){
        this.mPrefs = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE);
    }

    //Adds information about user preferences
}

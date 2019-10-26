package trabalhocompmovel.data.db;

import android.content.Context;
import android.content.SharedPreferences;

import trabalhocompmovel.data.db.DbHelper;
import trabalhocompmovel.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDbHelper implements DbHelper {

    private Context mContext;
    private SharedPreferences sharedPreferences;

    @Inject
    public AppDbHelper(@ApplicationContext Context context){
        this.mContext = context;
    }

}

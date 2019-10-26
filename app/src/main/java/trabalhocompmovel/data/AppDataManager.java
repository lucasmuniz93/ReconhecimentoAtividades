package trabalhocompmovel.data;

import trabalhocompmovel.data.db.DbHelper;

import javax.inject.Inject;


import trabalhocompmovel.data.international.StringHelper;
import trabalhocompmovel.data.network.ApiHelper;
import trabalhocompmovel.data.prefs.PreferencesHelper;

public class AppDataManager implements DataManager{

    DbHelper mDbHelper;
    StringHelper mStringHelper;
    ApiHelper mApiHelper;
    PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(DbHelper dbHelper, StringHelper stringHelper,
                          ApiHelper apiHelper, PreferencesHelper preferencesHelper){

        this.mDbHelper = dbHelper;
        this.mStringHelper = stringHelper;
        this.mApiHelper = apiHelper;
        this.mPreferencesHelper = preferencesHelper;
    }


}

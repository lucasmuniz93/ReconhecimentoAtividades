package trabalhocompmovel.data;

import trabalhocompmovel.data.db.DbHelper;
import trabalhocompmovel.data.international.StringHelper;
import trabalhocompmovel.data.network.ApiHelper;
import trabalhocompmovel.data.prefs.PreferencesHelper;


public interface DataManager extends DbHelper, StringHelper, ApiHelper, PreferencesHelper {
    

}

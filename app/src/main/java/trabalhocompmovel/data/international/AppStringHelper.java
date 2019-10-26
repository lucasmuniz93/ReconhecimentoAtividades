package trabalhocompmovel.data.international;

import android.content.Context;

import trabalhocompmovel.di.ApplicationContext;

import javax.inject.Inject;


public class AppStringHelper implements StringHelper {

    private final Context mContext;

    @Inject
    public AppStringHelper(@ApplicationContext Context context){
        this.mContext = context;
    }

}

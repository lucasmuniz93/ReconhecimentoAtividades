package trabalhocompmovel.data.android;

import android.content.Context;

import trabalhocompmovel.data.android.Resolver;
import trabalhocompmovel.di.ApplicationContext;


import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AndroidResolver implements Resolver {

    private final Context mContext;

    @Inject
    public AndroidResolver(@ApplicationContext Context context){
        mContext = context;
    }

    //Adds information about user Android


}

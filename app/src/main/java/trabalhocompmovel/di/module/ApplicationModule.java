package trabalhocompmovel.di.module;

import android.app.Application;
import android.content.Context;

import trabalhocompmovel.data.AppDataManager;
import trabalhocompmovel.data.DataManager;
import trabalhocompmovel.data.android.AndroidResolver;
import trabalhocompmovel.data.android.Resolver;
import trabalhocompmovel.data.db.AppDbHelper;
import trabalhocompmovel.data.db.DbHelper;
import trabalhocompmovel.data.international.AppStringHelper;
import trabalhocompmovel.data.international.StringHelper;
import trabalhocompmovel.data.network.ApiHelper;
import trabalhocompmovel.data.network.AppApiHelper;
import trabalhocompmovel.data.prefs.AppPreferencesHelper;
import trabalhocompmovel.data.prefs.PreferencesHelper;
import trabalhocompmovel.di.ApplicationContext;
import trabalhocompmovel.di.PreferenceInfo;
import trabalhocompmovel.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context providesContext() {
        return mApplication;
    }


    @Provides
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper() {
        return new AppApiHelper();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    StringHelper providesStringHelper(AppStringHelper appStringHelper) {
        return appStringHelper;
    }

    @Provides
    @Singleton
    Resolver provideAndroidResolver(AndroidResolver androidResolver) {
        return androidResolver;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper (AppDbHelper appDbHelper){
        return appDbHelper;
    }




}

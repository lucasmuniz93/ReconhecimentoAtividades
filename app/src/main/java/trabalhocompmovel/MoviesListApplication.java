package trabalhocompmovel;

import android.app.Application;

import javax.inject.Inject;

import trabalhocompmovel.data.DataManager;
import trabalhocompmovel.di.component.ApplicationComponent;
import trabalhocompmovel.di.component.DaggerApplicationComponent;
import trabalhocompmovel.di.module.ApplicationModule;
import trabalhocompmovel.ui.base.BaseApplication;


public class MoviesListApplication extends Application implements BaseApplication {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;



    @Override
    public void onCreate() {
        super.onCreate();

        if(mApplicationComponent == null){
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
            mApplicationComponent.inject(MoviesListApplication.this);
        }

    }

    @Override
    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}

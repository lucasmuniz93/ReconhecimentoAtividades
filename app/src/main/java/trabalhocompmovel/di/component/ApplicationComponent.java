package trabalhocompmovel.di.component;

import android.app.Application;
import android.content.Context;


import trabalhocompmovel.RecognitionApplication;
import trabalhocompmovel.data.DataManager;
import trabalhocompmovel.di.ApplicationContext;
import trabalhocompmovel.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(RecognitionApplication app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();


}

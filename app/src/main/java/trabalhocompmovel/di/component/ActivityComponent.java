package trabalhocompmovel.di.component;

import dagger.Component;
import trabalhocompmovel.ui.main.coleta.ColetaActivity;
import trabalhocompmovel.ui.main.MainActivity;
import trabalhocompmovel.di.PerActivity;
import trabalhocompmovel.di.module.ActivityModule;
import trabalhocompmovel.ui.main.reconhecimentoActivity.ReconhecimentoActivity;



@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(ReconhecimentoActivity reconhecimentoActivity);

    void inject(ColetaActivity createAccountActivity);
}

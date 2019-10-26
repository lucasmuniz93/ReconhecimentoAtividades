package trabalhocompmovel.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import trabalhocompmovel.di.ActivityContext;
import trabalhocompmovel.di.PerActivity;
import trabalhocompmovel.ui.main.coleta.ColetaMvpPresenter;
import trabalhocompmovel.ui.main.coleta.ColetaMvpView;
import trabalhocompmovel.ui.main.coleta.ColetaPresenter;
import trabalhocompmovel.ui.main.MainMvpPresenter;
import trabalhocompmovel.ui.main.MainMvpView;
import trabalhocompmovel.ui.main.MainPresenter;
import trabalhocompmovel.ui.main.reconhecimentoActivity.ReconhecimentoMvpPresenter;
import trabalhocompmovel.ui.main.reconhecimentoActivity.ReconhecimentoMvpView;
import trabalhocompmovel.ui.main.reconhecimentoActivity.ReconhecimentoPresenter;
import trabalhocompmovel.utils.rx.AppSchedulerProvider;
import trabalhocompmovel.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;



@Module
public class ActivityModule {

    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity){
        this.mActivity = activity;
    }


    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> providesMainPresenter(
            MainPresenter<MainMvpView> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    ReconhecimentoMvpPresenter<ReconhecimentoMvpView> providesReconhecimentoPresenter(
            ReconhecimentoPresenter<ReconhecimentoMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ColetaMvpPresenter<ColetaMvpView> providesColetaPresenter(
            ColetaPresenter<ColetaMvpView> presenter) {
        return presenter;
    }

}

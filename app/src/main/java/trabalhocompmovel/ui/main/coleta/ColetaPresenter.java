package trabalhocompmovel.ui.main.coleta;

import trabalhocompmovel.data.DataManager;
import trabalhocompmovel.ui.base.BasePresenter;
import trabalhocompmovel.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ColetaPresenter<V extends ColetaMvpView> extends BasePresenter<V>
        implements ColetaMvpPresenter<V>{

    @Inject
    public ColetaPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}

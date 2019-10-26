package trabalhocompmovel.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import trabalhocompmovel.di.component.ActivityComponent;
import trabalhocompmovel.di.component.DaggerActivityComponent;
import trabalhocompmovel.di.module.ActivityModule;


public class BaseActivity extends AppCompatActivity implements MvpView {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getComponent())
                .build();

    }


    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


}

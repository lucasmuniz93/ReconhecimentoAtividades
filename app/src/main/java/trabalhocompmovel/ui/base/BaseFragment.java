package trabalhocompmovel.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import trabalhocompmovel.di.component.ActivityComponent;


public class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mActivity;


    protected ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getActivityComponent();
        }
        return null;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this.mActivity, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.mActivity, "No error message", Toast.LENGTH_SHORT).show();
        }
    }

}

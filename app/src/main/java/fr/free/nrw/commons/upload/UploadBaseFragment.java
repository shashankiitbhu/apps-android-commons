package fr.free.nrw.commons.upload;

import android.os.Bundle;

import android.os.Parcelable;
import androidx.annotation.Nullable;

import fr.free.nrw.commons.di.CommonsDaggerSupportFragment;

/**
 * The base fragment of the fragments in upload
 */
public class UploadBaseFragment extends CommonsDaggerSupportFragment {

    public Callback callback;
    public static final String CALLBACK = "callback";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null) {
            callback = savedInstanceState.getParcelable(CALLBACK);
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    protected void onBecameVisible() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        if(callback!=null){
            outState.putParcelable(CALLBACK,callback);
        }

    }
    public interface Callback extends Parcelable {

        void onNextButtonClicked(int index);

        void onPreviousButtonClicked(int index);

        void showProgress(boolean shouldShow);

        int getIndexInViewFlipper(UploadBaseFragment fragment);

        int getTotalNumberOfSteps();

        boolean isWLMUpload();
    }
}

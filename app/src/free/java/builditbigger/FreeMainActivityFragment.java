package builditbigger;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.R;

/**
 * So this class extends the main/java/buiditbigger/MainActivityFragment
 * but also includes the ad related functionality.
 * My guide: https://stackoverflow.com/questions/42878631/flavor-specific-code
 */
public class FreeMainActivityFragment extends MainActivityFragment {

    public FreeMainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

            AdView mAdView = (AdView) root.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);

            Log.d("free", "fragment created");

        return root;
    }
}

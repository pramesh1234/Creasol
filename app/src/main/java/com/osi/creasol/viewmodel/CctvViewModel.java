package com.osi.creasol.viewmodel;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.osi.creasol.fragment.CctvFragment;

public class CctvViewModel {
    CctvFragment cctvFragment;
    String videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    public CctvViewModel(CctvFragment cctvFragment) {
        this.cctvFragment = cctvFragment;
    }

    // TODO: Implement the ViewModel
    public void onClickCamera(View view) {
        //  CctvDetailFragment.addFragment((BaseActivity) cctvFragment.getActivity());
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse(videoUrl), "video/mp4");
        cctvFragment.startActivity(i);

    }
}

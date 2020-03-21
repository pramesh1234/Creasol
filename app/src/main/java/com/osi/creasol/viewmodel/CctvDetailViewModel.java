package com.osi.creasol.viewmodel;

import androidx.lifecycle.ViewModel;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.osi.creasol.fragment.CctvDetailFragment;

public class CctvDetailViewModel extends ViewModel {
    public SimpleExoPlayer mPlayer;
    public PlayerView mPlayerView;
    CctvDetailFragment cctvDetailFragment;

    public CctvDetailViewModel(CctvDetailFragment cctvDetailFragment) {
        this.cctvDetailFragment = cctvDetailFragment;
    }
}

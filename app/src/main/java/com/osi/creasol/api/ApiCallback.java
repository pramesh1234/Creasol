package com.osi.creasol.api;

import org.json.JSONException;

/**
 * Created by Gourav on 08-02-2017.
 */

public interface ApiCallback {
    void onResponse(Object o) throws JSONException;
    void onError(String error);
}

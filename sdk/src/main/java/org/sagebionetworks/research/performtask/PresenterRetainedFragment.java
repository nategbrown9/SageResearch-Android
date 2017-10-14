/*
 *    Copyright 2017 Sage Bionetworks
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.sagebionetworks.research.performtask;

import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.sagebionetworks.research.sdk.BaseContract;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by liujoshua on 10/11/2017.
 */

public class PresenterRetainedFragment<T extends BaseContract.BasePresenter> extends
        Fragment {
    private T presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
        if (presenter instanceof LifecycleObserver) {
            getLifecycle().addObserver((LifecycleObserver) presenter);
        }
    }
}

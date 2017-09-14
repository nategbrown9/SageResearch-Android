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

package org.sagebionetworks.research.sdk.task;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.sagebionetworks.research.sdk.AsyncAction;

import java.util.ArrayList;
import java.util.List;


public abstract class TaskBase implements Task {
    @NonNull
    private final String identifier;
    @Nullable
    private final Info info;
    @NonNull
    private final List<AsyncAction> asyncActions;

    public TaskBase(@NonNull String identifier, Info info) {
        this.identifier = identifier;
        this.info = info;
        asyncActions = new ArrayList<>();
    }

    @Override
    @NonNull
    public String getIdentifier() {
        return identifier;
    }

    @Override
    @Nullable
    public Info getInfo() {
        return info;
    }

    @Override
    @NonNull
    public List<AsyncAction> getAsyncActions() {
        return asyncActions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskBase task = (TaskBase) o;

        if (!identifier.equals(task.identifier)) return false;
        if (info != null ? !info.equals(task.info) : task.info != null) return false;
        return asyncActions.equals(task.asyncActions);

    }

    @Override
    public int hashCode() {
        int result = identifier.hashCode();
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + asyncActions.hashCode();
        return result;
    }
}


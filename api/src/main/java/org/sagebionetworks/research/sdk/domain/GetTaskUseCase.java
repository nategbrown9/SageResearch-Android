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

package org.sagebionetworks.research.sdk.domain;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.sagebionetworks.research.sdk.Duration;
import org.sagebionetworks.research.sdk.Schema;
import org.sagebionetworks.research.sdk.task.Task;

/**
 * Created by liujoshua on 10/11/2017.
 */

public class GetTaskUseCase implements UseCase<String, Task> {
    @Override
    public void execute(final String taskIdentifier, SuccessHandler<Task> successHandler,
                        FailureHandler
                                failureHandler) {
        Task t = new Task() {
            @NonNull
            @Override
            public String getIdentifier() {
                return taskIdentifier;
            }

            @Nullable
            @Override
            public Schema getSchema() {
                return null;
            }

            @Override
            public int getTitle() {
                return 0;
            }

            @Override
            public int getDetail() {
                return 0;
            }

            @Override
            public int getCopyright() {
                return 0;
            }

            @Nullable
            @Override
            public Duration getEstimatedDuration() {
                return null;
            }

            @Override
            public int getIcon() {
                return 0;
            }
        };
        if (successHandler != null) {
            successHandler.onSuccess(t);
        }
    }
}

/*
 * BSD 3-Clause License
 *
 * Copyright 2018  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sagebionetworks.research.app.inject;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.TypeAdapterFactory;

import org.sagebionetworks.research.app.MainActivity;
import org.sagebionetworks.research.app.ResearchStackDemoApplication;
import org.sagebionetworks.research.data.inject.DataModule;
import org.sagebionetworks.research.domain.result.interfaces.TaskResult;
import org.sagebionetworks.research.presentation.perform_task.TaskResultProcessingManager.TaskResultProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import io.reactivex.Completable;

@Module(includes = {AppTaskModule.class, DataModule.class},
        subcomponents = {MainActivitySubcomponent.class})
public abstract class ResearchStackDemoApplicationModule {
    @Binds
    public abstract Application provideApplication(ResearchStackDemoApplication app);

    @Binds
    public abstract Context provideApplicationContext(ResearchStackDemoApplication app);

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(
            MainActivitySubcomponent.Builder builder);

    @Provides
    @IntoSet
    static TypeAdapterFactory provideAutoValueTypeAdapter() {
        return AppAutoValueTypeAdapterFactory.create();
    }

    @Provides
    static List<TaskResultProcessor> providesTaskResultProcessors() {
        return Collections.singletonList(new TaskResultProcessor() {
            private final Logger logger = LoggerFactory.getLogger(getClass());

            @Override
            public Completable processTaskResult(TaskResult taskResult) {
                logger.info("processTaskResult called for taskResult: {}", taskResult);
                return Completable.complete();
            }
        });
    }
}

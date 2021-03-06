package org.sagebionetworks.research.mobile_ui.inject;

import org.sagebionetworks.research.presentation.perform_task.BoundServiceTaskResultManager;
import org.sagebionetworks.research.presentation.perform_task.BoundServiceTaskResultProcessingManager;
import org.sagebionetworks.research.presentation.perform_task.TaskResultManager;
import org.sagebionetworks.research.presentation.perform_task.TaskResultProcessingManager;
import org.sagebionetworks.research.presentation.perform_task.TaskResultProcessingManager.TaskResultProcessor;
import org.sagebionetworks.research.presentation.perform_task.TaskResultService;

import java.util.Set;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.Multibinds;

@Module
public abstract class TaskResultModule {
    @ContributesAndroidInjector
    abstract TaskResultService contributeRecorderService();

    @Binds
    abstract TaskResultManager provideTaskResultManager(BoundServiceTaskResultManager boundServiceTaskResultManager);

    @Binds
    abstract TaskResultProcessingManager provideTaskResultProcessingManager(
            BoundServiceTaskResultProcessingManager boundServiceTaskResultProcessingManager);

    @Multibinds
    abstract Set<TaskResultProcessor> provideTaskResultProcessors();
}

package com.nashss.se.projectsyncup.dependency;

import com.nashss.se.projectsyncup.activity.*;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the ProjectSyncUp Service.
 */
@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    /**
     * Provides the relevant activity.
     * @return CreateProjectActivity
     */
    CreateProjectActivity provideCreateProjectActivity();


    /**
     * Provides the relevant activity.
     * @return GetProjectActivity
     */
    GetProjectActivity provideGetProjectActivity();

    /**
     * Provides the relevant activity.
     * @return GetProjectActivity
     */
    AddTaskToProjectActivity provideAddTaskToProjectActvity();

    /**
     * Provides the relevant activity.
     * @return GetProjectTasksActivity
     */
    GetProjectTasksActivity provideGetProjectTasksActivity();

    /**
     * Provides the relevant activity.
     * @return RemoveTaskFromProjectActivity
     */
    DeleteTaskFromProjectActivity provideRemoveTaskFromProjectActivity();
}

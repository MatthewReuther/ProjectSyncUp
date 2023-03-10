package com.nashss.se.projectsyncup.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.nashss.se.projectsyncup.dynamodb.models.Task;

import java.util.List;

import static com.nashss.se.projectsyncup.utils.CollectionUtils.copyToList;


/**
 * CreateProjectRequest implementation representing a request to create a project.
 * This class is used to create an object with the required information for creating a project.
 * The object can then be passed to the service to create the project.
 *
 */
@JsonDeserialize(builder = CreateProjectRequest.Builder.class)
public class CreateProjectRequest {
    private final String projectName;
    private final String projectDescription;
    private final String projectStatus;
    private final String createdById;


    /**
     * Instantiates a new CreateProjectRequest object.
     * Private to enforce user to use Builder to create a new instance of CreateProjectRequest
     *
     * @param projectName        The name of the project
     * @param projectDescription The description of the project
     * @param createdById        The ID of the user who created the project
     */

    private CreateProjectRequest(String projectName, String projectDescription, String projectStatus,
                                 String createdById) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStatus = projectStatus;
        this.createdById = createdById;
    }

    /**
     * Returns the name of the project.
     *
     * @return The name of the project.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Returns the description of the project.
     *
     * @return The description of the project.
     */
    public String getProjectDescription() {
        return projectDescription;
    }

    /**
     * Returns the status of the project.
     *
     * @return The status of the project.
     */
    public String getProjectStatus() {
        return projectStatus;
    }

    /**
     * Returns the name of the person who created the project.
     *
     * @return The name of the person who created the project.
     */
    public String getCreatedById() {
        return createdById;
    }

    /**
     * Returns a list of tasks associated with the project.
     *
     * @return A list of tasks associated with the project.
     */
//    public List<String> getProjectTasks() {
//        return copyToList(projectTasks);
//    }

    /**
     * Returns a list of members associated with the project.
     *
     * @return A list of members associated with the project.
     */
//    public List<String> getProjectMembers() {
//        return copyToList(projectMembers);
//    }
    @Override
    public String toString() {
        return "CreateProjectRequest{" +
                "projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", createdById='" + createdById + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String projectName;
        private String projectDescription;
        private String projectStatus;
        private String createdById;
        private List<String> projectTasks;
        private List<String> projectMembers;

        public Builder withProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder withProjectDescription(String projectDescription) {
            this.projectDescription = projectDescription;
            return this;
        }

        public Builder withCreatedById(String createdById) {
            this.createdById = createdById;
            return this;
        }

        public Builder withProjectStatus(String projectStatus) {
            this.projectStatus = projectStatus;
            return this;
        }

        public Builder withProjectTasks(List<String> projectTasks) {
            this.projectTasks = copyToList(projectTasks);
            return this;
        }

        public Builder withProjectMembers(List<String> projectMembers) {
            this.projectMembers = copyToList(projectMembers);
            return this;
        }

        public CreateProjectRequest build() {
            return new CreateProjectRequest(projectName, projectDescription,
                    projectStatus, createdById);
        }

    }
}

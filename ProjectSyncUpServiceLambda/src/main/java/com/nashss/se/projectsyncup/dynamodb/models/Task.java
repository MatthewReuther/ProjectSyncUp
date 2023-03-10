package com.nashss.se.projectsyncup.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;


/**
 * Class represents a record in the Task in DynamoDB.
 */
@DynamoDBTable(tableName = "projectTasks")
public class Task {

    private String taskId;
    private String taskName;
    private String taskDescription;
    private String taskDueDate;
    private String createdById;
    private String taskAssignedUser;
    private String projectId;

    @DynamoDBHashKey(attributeName = "taskId")
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @DynamoDBRangeKey(attributeName = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @DynamoDBAttribute(attributeName = "taskName")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @DynamoDBAttribute(attributeName = "taskDescription")
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @DynamoDBAttribute(attributeName = "taskDueDate")
    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

//    @DynamoDBAttribute(attributeName = "createdById")
//    public String getCreatedById() {
//        return createdById;
//    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getTaskAssignedUser() {
        return taskAssignedUser;
    }

    @DynamoDBAttribute(attributeName = "taskAssignedUser")
    public void setTaskAssignedUser(String taskAssignedUser) {
        this.taskAssignedUser = taskAssignedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getTaskId().equals(task.getTaskId()) &&
                getProjectId().equals(task.getProjectId()) &&
                getTaskName().equals(task.getTaskName()) &&
                getTaskDescription().equals(task.getTaskDescription()) &&
                getTaskDueDate().equals(task.getTaskDueDate()) &&
//                getCreatedById().equals(task.getCreatedById()) &&
                getTaskAssignedUser().equals(task.getTaskAssignedUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskId(), getProjectId(), getTaskName(),
                getTaskDescription(), getTaskDueDate(), getTaskAssignedUser());
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskDueDate='" + taskDueDate + '\'' +
                ", taskAssignedUser=" + taskAssignedUser + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}

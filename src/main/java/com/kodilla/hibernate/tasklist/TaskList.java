package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TASKLISTS")
public final class TaskList {
    @Id
    @GeneratedValue
    @Column(name="ID", nullable = false, unique = true)
    private int id;

    @Column(name="LISTNAME", nullable = false, unique = true)
    private String listName;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Task> tasks = new ArrayList<>();

    public TaskList() {

    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "listName='" + listName + '\'' +
                '}';
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

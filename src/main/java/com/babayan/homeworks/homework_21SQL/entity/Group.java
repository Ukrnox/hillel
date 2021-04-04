package com.babayan.homeworks.homework_21SQL.entity;

import java.util.Objects;

public class Group {
    long id;
    private String name;
    private String description;

    public Group(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Group)) return false;
        final Group other = (Group) o;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final String this$name = this.getName();
        final String other$name = other.getName();
        if (!Objects.equals(this$name, other$name)) return false;
        final String this$description = this.getDescription();
        final String other$description = other.getDescription();
        return Objects.equals(this$description, other$description);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Group;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long id = this.getId();
        result = result * PRIME + (int) (id >>> 32 ^ id);
        final String $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final String $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }
}

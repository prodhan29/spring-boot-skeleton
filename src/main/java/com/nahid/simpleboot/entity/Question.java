package com.nahid.simpleboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question extends BaseEntity{

    public String name;

    public String hint;

    public String mandatory;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String seed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }
}

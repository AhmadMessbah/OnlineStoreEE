package com.store.onlinestore.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@MappedSuperclass
public class Base {

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH})
    private List<Attachment> attachmentList;

    private boolean deleted = false;


    public void addAttachment(Attachment attachment) {
        if (this.attachmentList == null) {
            this.attachmentList = new ArrayList<>();
        }
        attachmentList.add(attachment);
    }

    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }
}

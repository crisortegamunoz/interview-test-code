package com.cristianortega.interview.codetest.persistence.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class AuditableEntity {

    @Column(name = "created")
    @CreatedDate
    @JsonIgnore
    private LocalDateTime created;
    @Column(name = "modified")
    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime modified;

}
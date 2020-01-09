package com.store.store.entity;

import lombok.Data;

@Data
public class Complaint {
    Integer complaintId;
    Integer complainantId;
    String information;
    Integer becomplainantedId;
    Integer status;
    String RecordReason;
}
